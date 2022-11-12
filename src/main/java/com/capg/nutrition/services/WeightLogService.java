package com.capg.nutrition.services;

import java.util.List;
import javax.transaction.Transactional;
import com.capg.nutrition.entity.WeightLog;
import com.capg.nutrition.exceptions.WeightLogNotFoundException;

public interface WeightLogService {

    public WeightLog addWeightLog(WeightLog weightLog)throws WeightLogNotFoundException;
    @Transactional
    public WeightLog updateWeightLog(WeightLog weightLog, Long ID) throws WeightLogNotFoundException;

    public String removeWeightLog(Long ID) throws WeightLogNotFoundException, WeightLogNotFoundException;

    public List<WeightLog> showAllWeightLog() throws WeightLogNotFoundException;

	

}