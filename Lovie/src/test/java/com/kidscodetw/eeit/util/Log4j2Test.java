package com.kidscodetw.eeit.util;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 

 
@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Log4j2Test 
{
     
	static public Logger logger = LoggerFactory.getLogger(Log4j2Test.class); 

	   @Test
	   public void logTC1(){
	      logger.error("error");
	      logger.debug("debug");
	      logger.info("info");
	      logger.trace("trace");
	      logger.warn("warn");
	      logger.error("error {}", "param");
    
    
	   }
}