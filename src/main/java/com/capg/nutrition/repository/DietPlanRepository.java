package com.capg.nutrition.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.capg.nutrition.dto.DietPlanDTO;
import com.capg.nutrition.entity.DietPlan;


public interface DietPlanRepository extends CrudRepository<DietPlan, Integer> {
    Optional<DietPlan> findDietPlanById(long id);

//    @Query("SELECT u FROM User u WHERE u.userId = ?1")
//    Optional<User> findByUserId(String userId);

	Optional<DietPlan> findDietPlanByFoodType(String settype);

	DietPlanDTO save(DietPlanDTO dietPlanDTO);
	
	//DietPlanDTO deleteByString(String str);
    
}
