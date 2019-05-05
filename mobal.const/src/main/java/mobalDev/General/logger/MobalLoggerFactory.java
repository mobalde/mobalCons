package mobalDev.General.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MobalLoggerFactory {
	
	public static String FUNCTIONAL_LOGGER = "mobal.logger.functional.";
	
	public static String TECHNICAL_LOGGER = "mobal.logger.technical.";
	
	public static Logger getFunctionalLogger(Class<?> classe){
		return LoggerFactory.getLogger(FUNCTIONAL_LOGGER + classe.getName());
	}
	
	public static Logger getTechnicalLogger(Class<?> classe){
		return LoggerFactory.getLogger(TECHNICAL_LOGGER + classe.getName());
	}

}
