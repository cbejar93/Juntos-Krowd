package com.krowd.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
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
	private static final Logger log = Logger.getLogger(LoggingAspect.class);
	
	/*
	 * Making a general PointCut where the advice can be applied. This applies to all the methods and 
	 * their executions. This makes it easier for logging.
	 */
	@Pointcut("execution(* com.krowd.*(..)")
	private void generalPointCut() {
		
	}
	
	/*
	 * This method is called before the generalPointCut method that we made above to log the info to the
	 * info to the text file. The logging itself is going to happen a txt file named log.
	 */
	@Before("generalPointCut()")
	public void infoLog(JoinPoint jp) {
		System.out.println("Before ");
		log.info(jp.getTarget().getClass().getSimpleName()+" : "+jp.getSignature().getName());
	}
	
	/*
	 * This method is called AFTER the method that is being called is executed and logged. This method will
	 * show the word "After" and give the name of the class and method being executed.
	 */
	@After("generalPointCut()")
	public void afterInfoLog(JoinPoint jp) {
		System.out.println("After ");
		log.info(jp.getTarget().getClass().getSimpleName()+" : "+jp.getSignature().getName());
	}
	

}
