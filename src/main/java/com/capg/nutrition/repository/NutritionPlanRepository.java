package com.capg.nutrition.repository;

import com.capg.nutrition.entity.NutritionPlan;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/*
  * Version : 1.0
 * Date : 19-10-2022
 * Description : This is NutritionPlanRepository.
*/

/*Repository  is used to indicate that the class provides the mechanism 
 * for storage, retrieval, search, update and delete operation on objects*/

public interface NutritionPlanRepository
extends CrudRepository<NutritionPlan, Integer>  {

    // SELECT * FROM nutrition_planDTO where email= XYZ ;
    // @Query("SELECT n FROM nutrition_planDTO n where n.price= ?1")
    //Optional<NutritionPlanDTO> findNutritionPlanDTOByPrice(Double price);
	List<NutritionPlan> findUserByName(String Name);
}
