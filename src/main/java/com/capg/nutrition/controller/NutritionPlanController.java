package com.capg.nutrition.controller;

import com.capg.nutrition.dto.NutritionPlanDTO;




import com.capg.nutrition.entity.NutritionPlan;
import com.capg.nutrition.exceptions.InvalidDataException;
import com.capg.nutrition.services.NutritionPlanService;
import com.capg.nutrition.services.NutritionPlanServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

//Description : This is Nutrition Plan Controller

@RestController
@RequestMapping(path = "/capg/userinterface") 
@Validated
@CrossOrigin(origins="http://localhost:3000")
public class NutritionPlanController {

	@Autowired
    private NutritionPlanService inutritionService;

	@Autowired
	private Environment environment;

    /************************************************************************************
	 * Method: listAllPlans
	 * Description: It is used to show all Nutrition Plans  from nutrition_plan  table
<<<<<<< HEAD
<<<<<<< HEAD
	 * @returns flat :It returns nutrition_plan table with details
=======
	 * @returns plan :It returns nutrition_plan table with details
>>>>>>> e0dffda6e325ff7fdfcea9e50c4b59640758274b
=======
	 * @returns plan :It returns nutrition_plan table with details
>>>>>>> e0dffda6e325ff7fdfcea9e50c4b59640758274b
	 * @GetMapping: It is used to handle the HTTP GET requests matched.
	 *  
	 ************************************************************************************/
    @GetMapping(value="/getnutri")
    public ResponseEntity<List<NutritionPlanDTO>> getNutritionPlans() throws InvalidDataException{
   // throw new NutritionPlanApiRequestException("Oops cannot get all Nutrition Plans with custom exception");
    //throw new IllegalStateException("Oops cannot get all Nutrition Plans");
    	List<NutritionPlanDTO> userList = inutritionService. getNutritionPlans();
		return new ResponseEntity<>(userList, HttpStatus.OK);
    }
    
    /************************************************************************************
	 * Method: createPlan
	 * Description: It is used to add nutrition plan into nutrition_plan table
	 * @PostMapping: It is used to handle the HTTP POST requests matched.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * 
	 ************************************************************************************/

    @PostMapping(value="/addnutri")
    public ResponseEntity<String> addNewNutritionPlan(@Valid @RequestBody NutritionPlan nutritionPlan)throws InvalidDataException{
    	NutritionPlan user=inutritionService.addNewNutritionPlan(nutritionPlan);
    	String successMessage = environment.getProperty("API.USER_INSERT_SUCCESS") + user.getId();
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }
    
      /************************************************************************************
	 * Method: removePlan
	 * Description: It is used to remove Nutrition Plan from nutrition_plan table
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched.
	 *  
	 ************************************************************************************/
    
    @DeleteMapping(path = "/delnutri/{id}")
    public ResponseEntity<String> deleteNutritionPlan(
            @PathVariable("id") int id)throws InvalidDataException{
    	inutritionService.deleteNutritionPlan(id);
    	String successMessage = environment.getProperty("API.USER_DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    /************************************************************************************
	 * Method: changePlan
	 * Description: It is used to update nutrition Plan which is already there in nutrition_plan table
	 * @PutMapping: It is used to handle the HTTP PUT requests matched.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * 
	 ************************************************************************************/
    
    @PutMapping(path = "/updatenutri/{nutritionPlanDTOId}")
    public ResponseEntity<String> updateNutritionPlan(
            @PathVariable("nutritionPlanDTOId") int nutritionPlanDTOId ,
            @RequestBody NutritionPlanDTO nutritionPlanDTO) throws InvalidDataException{
    	inutritionService.updateNutritionPlan(nutritionPlanDTO );
    	String successMessage = environment.getProperty("API.USER_UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }
}
