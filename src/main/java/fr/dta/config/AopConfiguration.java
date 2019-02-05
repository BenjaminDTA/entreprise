package fr.dta.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopConfiguration {
	
	private static final  Logger logger = LoggerFactory.getLogger(AopConfiguration.class);
		
	@Around("execution(* fr.dta.service.EmployeeService.*(..))")
	public Object doAccesCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("\n					entrée dans : " + joinPoint.getSignature().getName()+"\n");
		Object returnVal = joinPoint.proceed();
		logger.info("\n					Sortie de : " + joinPoint.getSignature().getName()+"\n");
		return returnVal;
	}
	
	
	@AfterThrowing(pointcut="execution(* fr.dta.repository.EmployeeRepository.*(..))",throwing="ex")
	public void doRecoverActions(RuntimeException ex) {
		logger.info(ex.getMessage());
	}

}
