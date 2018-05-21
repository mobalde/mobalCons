package mobalDev.General;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggerInfo{

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	protected void loggerInfos(String infos){
		LOGGER.info(infos);
	}
}
