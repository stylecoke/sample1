package com.myapp.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggerAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void printLog(JoinPoint joinPoint) throws Throwable {

		String type = "";
		String name = joinPoint.getSignature().getDeclaringTypeName();
		
		if (name.contains("Controller")) {
			type = "Sample Controller ===> ";

		} else if (name.contains("Service")) {
			type = "Sample ServiceImpl ===> ";

		} else if (name.contains("Mapper")) {
			type = "Sample Mapper ===> ";
		}

		logger.info(type + name + "." + joinPoint.getSignature().getName() + "()");
	}

}
