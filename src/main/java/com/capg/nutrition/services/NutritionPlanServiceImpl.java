package com.capg.nutrition.services;

import com.capg.nutrition.dto.NutritionPlanDTO;



import com.capg.nutrition.entity.NutritionPlan;
import com.capg.nutrition.exceptions.InvalidDataException;
import com.capg.nutrition.repository.NutritionPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//Description : This is Nutrition Plan Service Layer

@Service
public class NutritionPlanServiceImpl implements NutritionPlanService {
	@Autowired
	private NutritionPlanRepository iNutritionPlanRepository;

    //private final NutritionPlanRepository nutritionPlanRepository;

  //  public NutritionPlanServiceImpl(NutritionPlanRepository nutritionPlanRepository) {
  //      this.nutritionPlanRepository = nutritionPlanRepository;
  //  }

    /*
 * Description : This method shows existing Nutrition Plans :Input Parameter 
 *          
 */
    @Override
    public List<NutritionPlanDTO> getNutritionPlans() throws InvalidDataException{
        Iterable<NutritionPlan> users = iNutritionPlanRepository.findAll();
		List<NutritionPlanDTO> users2 = new ArrayList<>();
		users.forEach(user -> {
			NutritionPlanDTO cust = new NutritionPlanDTO(user.getId(),user.getName(),user.getPlanDescription(),user.getCreated_At(),user.getUpdated_At(),user.getPrice());
			users2.add(cust);
		});
		if (users2.isEmpty())
			throw new InvalidDataException("Service.USERS_NOT_FOUND");
		return users2;
    }

    
  //Description : This method Adds new NutritionPlan : Input Parameter
    
    @Override
    public NutritionPlan addNewNutritionPlan(NutritionPlan nutritionPlan)throws InvalidDataException {
       List<NutritionPlan> optionalUser = iNutritionPlanRepository.findUserByName(nutritionPlan.getName());
		if(!optionalUser.isEmpty()) {
			throw new InvalidDataException("Service.USER_FOUND");
		}
       NutritionPlan c = new NutritionPlan();
		c.setName(nutritionPlan.getName());
		c.setPlanDescription(nutritionPlan.getPlanDescription());
		c.setPrice(nutritionPlan.getPrice());
		c.setUpdated_At(nutritionPlan.getUpdated_At());
		c.setCreated_At(nutritionPlan.getCreated_At());
		NutritionPlan c2 = iNutritionPlanRepository.save(c);
		return c2;
    }

    /*
 * Description : This method removes existing ID :Input Parameter 
 *               Throws Exception if the ID is not found as NutritionPlanNotFoundException
 */

    @Override
    public NutritionPlanDTO deleteNutritionPlan(int nutritionPlanId) throws InvalidDataException {
    	Optional<NutritionPlan> user1 = iNutritionPlanRepository.findById(nutritionPlanId);
    	NutritionPlan user=user1.orElseThrow(() -> new InvalidDataException("Service.USER_NOT_FOUND"));
    	NutritionPlanDTO customer=new NutritionPlanDTO(user.getId(),user.getName(),user.getPlanDescription(),user.getCreated_At(),user.getUpdated_At()
    			,user.getPrice());
    	iNutritionPlanRepository.deleteById(nutritionPlanId);
		return customer;
    }

    
    /*
	 * Description : This method Updates existing Nutrition Plan by taking ID:Input Parameter 
	 *               Throws Exception if the ID is not found as NutritionPlanNotFoundException	
	 */
    
    @Override
    public NutritionPlanDTO updateNutritionPlan(NutritionPlanDTO nutritionPlan)throws InvalidDataException {
    	Optional<NutritionPlan> user1 = iNutritionPlanRepository.findById(nutritionPlan.getId());
    	NutritionPlan c = user1.orElseThrow(() -> new InvalidDataException("Service.USER_NOT_FOUND"));
		c.setName(nutritionPlan.getName());
		c.setPlanDescription(nutritionPlan.getPlanDescription());
		c.setPrice(nutritionPlan.getPrice());
		c.setUpdated_At(nutritionPlan.getUpdated_At());
		c.setCreated_At(nutritionPlan.getCreated_At());
		return nutritionPlan;
    }
}

