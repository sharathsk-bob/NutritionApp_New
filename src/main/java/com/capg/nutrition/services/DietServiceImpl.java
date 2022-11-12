package com.capg.nutrition.services;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.nutrition.dto.DietPlanDTO;

import com.capg.nutrition.entity.DietPlan;

import com.capg.nutrition.exceptions.InvalidDataException;
import com.capg.nutrition.repository.DietPlanRepository;

@Service
@Transactional
public class DietServiceImpl implements DietService {
    private static final Logger logger = LogManager.getLogger(DietServiceImpl.class);
    
    @Autowired
    private DietPlanRepository dietPlanRepo;

//    public DietServiceImpl(DietPlanRepository dietPlanRepo) {
//        this.dietPlanRepo = dietPlanRepo;
//    }

    public List<DietPlanDTO>  listAllPlan()throws InvalidDataException{
    	Iterable<DietPlan> users = dietPlanRepo.findAll();
		List<DietPlanDTO> users2 = new ArrayList<>();
		users.forEach(user -> {
			DietPlanDTO cust = new DietPlanDTO(user.getId(),user.getFatRatio(),user.getCarbsRatio(),user.getFoodType(),user.getProteinRatio(),user.getSlots(),user.getTotal());
			users2.add(cust);
		});
		if (users2.isEmpty())
			throw new InvalidDataException("Service.USERS_NOT_FOUND");
		return users2;
    }

    public DietPlanDTO createDietPlan(DietPlanDTO dietPlanDTO) throws InvalidDataException  {
    	Optional<DietPlan> optionalDietPlanDTO = dietPlanRepo.findDietPlanByFoodType(dietPlanDTO.getFoodType());
		if(!optionalDietPlanDTO.isEmpty()) {
			throw new InvalidDataException("Service.DietPlanDTO_FOUND");
		}
		DietPlan c = new DietPlan();
		c.setCarbsRatio(dietPlanDTO.getCarbsRatio());;
		c.setFatRatio(dietPlanDTO.getFatRatio());
        c.setFoodType(dietPlanDTO.getFoodType()); 
        c.setProteinRatio(dietPlanDTO.getProteinRatio());
        c.setSlots(dietPlanDTO.getSlots());
        c.setTotal(dietPlanDTO.getTotal());
		dietPlanRepo.save(c);
		return dietPlanDTO;
    }

    public DietPlanDTO removeDietPlan(int dietPlanId) throws InvalidDataException{
        //logger.info("removeDietPlan method initiated");
        Optional<DietPlan> dietPlan = dietPlanRepo.findById(dietPlanId);
		DietPlan DietPlanDTO = dietPlan.orElseThrow(() -> new InvalidDataException("Service.DietPlanDTO_NOT_FOUND"));
		DietPlanDTO deletedDiet = new DietPlanDTO(DietPlanDTO.getId(),
				DietPlanDTO.getCarbsRatio(),
				DietPlanDTO.getFatRatio(),DietPlanDTO.getFoodType(),
                DietPlanDTO.getProteinRatio(), DietPlanDTO.getSlots(), 
                DietPlanDTO.getTotal());
		dietPlanRepo.deleteById(dietPlanId);
		return deletedDiet;
    }


@Transactional
public DietPlanDTO changeDietPlan(DietPlanDTO dietplanDTO) throws InvalidDataException
    {
        Optional<DietPlan> dietPlanDTO = dietPlanRepo.findById(dietplanDTO.getId());
		DietPlan c = dietPlanDTO.orElseThrow(() -> new InvalidDataException("Service.DietPlanDTO_NOT_FOUND"));
		c.setCarbsRatio(dietplanDTO.getCarbsRatio());;
		c.setFatRatio(dietplanDTO.getFatRatio());
        c.setFoodType(dietplanDTO.getFoodType()); 
        c.setProteinRatio(dietplanDTO.getProteinRatio());
        c.setSlots(dietplanDTO.getSlots());
        c.setTotal(dietplanDTO.getTotal());
		return dietplanDTO;
    }
}

