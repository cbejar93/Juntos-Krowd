package com.krowd.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * Making a logging Aspect to implement AOP into the application.
 * This class should log everything that happens with the applications
 * work state into a .txt file.
 * 
 */
@Aspect
@Component
public class LoggingAspect {

	/*
	 * Declaring the logging variable to be able to print out our logs to the log.txt file
	 */
	private static Logger log = Logger.getLogger(LoggingAspect.class);
	
	/*
	 * Making a general PointCut where the advice can be applied. This applies to all the methods and 
	 * their executions. This makes it easier for logging.
	 */
	@Pointcut("execution(*com.krowd.*(..)")
	private void generalPointCut() {
		
	}
	
	/*
	 * This method is called before the generalPointCut method that we made above to log the info to the
	 * info to the text file. The logging itself is going to happen a txt file named log.
	 */
	@Before("generalPointCut()")
	public void infoLog(JoinPoint jp) {
		log.info(jp.getTarget().getClass().getSimpleName()+" : "+jp.getSignature().getName());
	}
	
	

}
