package com.capg.nutrition.services;

import java.util.List;



import com.capg.nutrition.dto.DietPlanDTO;
import com.capg.nutrition.entity.DietPlan;
import com.capg.nutrition.exceptions.InvalidDataException;

/**
 * The Interface IDietService.
 */
public interface DietService {

	/**
	 * Adds/Creates the Diet.
	 * @param DietPlanDTO the DietPlan DTO
	 * @return the DietPlan DTO
	 * @throws DietPlanException the DietPlan exception
	 */
    public DietPlanDTO createDietPlan(DietPlanDTO dietPlanDTO) throws InvalidDataException ;
    
    /**
	 * Update/Change DietPlan.
	 * @param DietPlanDTO the DietPlan DTO
	 * @return the DietPlan DTO
	 * @throws DietPlanException the DietPlanNotFound exception
	 */
    public DietPlanDTO changeDietPlan(DietPlanDTO dietplanDTO) throws InvalidDataException;
    
    /**
	 * Removes the DietPlan.
	 * @param DietPlanDTO the DietPlan DTO
	 * @return the DietPlan DTO
	 * @throws DietPlanException the DietPlanNotFound exception
	 */
    public DietPlanDTO removeDietPlan(int dietPlanId) throws InvalidDataException;
    
    /**
	 * Gets and lists the all DietPlan.
	 * @return the all DietPlan
	 */
    public List<DietPlanDTO> listAllPlan()throws InvalidDataException;

}
