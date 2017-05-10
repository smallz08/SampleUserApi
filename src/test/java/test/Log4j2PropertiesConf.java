package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Log4j2PropertiesConf {
	private static Logger logger = LoggerFactory.getLogger(Log4j2PropertiesConf.class);
    public void performSomeTask(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
    }
}
