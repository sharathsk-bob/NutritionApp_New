package com.capg.nutrition.utility;

import org.apache.commons.logging.Log;
import com.capg.nutrition.exceptions.InvalidDataException;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
	
	/** The Constant LOGGER. */
	public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

	/**
	 * Log service exception.
	 *
	 * @param exception the exception
	 */
	@AfterThrowing(pointcut = "execution(* com.capg.nutritionapp.service.*Impl.*(..))", throwing = "exception")
	public void logServiceException(InvalidDataException exception) {
		LOGGER.error(exception.getMessage(), exception);
	}
	
	/**
	 * Log service exception.
	 *
	 * @param exception the exception
	 */
	@AfterThrowing(pointcut = "execution(* com.capg.nutritionapp.service.*Impl.*(..))", throwing = "exception")
	public void logServiceException(Exception exception) {
		LOGGER.error(exception.getMessage(), exception);
	}

}