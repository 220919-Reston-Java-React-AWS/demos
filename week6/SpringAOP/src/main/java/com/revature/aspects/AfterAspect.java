package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {

    private Logger log = LoggerFactory.getLogger((this.getClass()));

    @After("execution (* com.revature.service.*.*(..))")
    public  void after(JoinPoint joinPoint){

        log.info("After execution of {}", joinPoint);
    }


    @AfterReturning(value = "execution (* com.revature.service.*.*(..))",
                    returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){

        log.info("{} returned a value of {}", joinPoint, result);

    }

    //@AfterThrowing

    //@Around
}
