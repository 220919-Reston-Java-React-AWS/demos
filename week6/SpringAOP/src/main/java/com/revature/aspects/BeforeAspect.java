package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect //An aspect is a modularization of concern that cuts across multiple classes.
@Configuration //this tells spring to configure this aspect as part of the global application
public class BeforeAspect {

    //logger
    private Logger log = LoggerFactory.getLogger(this.getClass());

    //Build some advice that declares WHEN we want to do SOMETHING.
    @Before("execution (* com.revature.data.*.*(..))")
    public void before(JoinPoint joinPoint){


        log.info("Checking for users access.....");

        log.info("Intercepted method call of {}", joinPoint);

    }

    /**
     * - JoinPoint: is the opportunity to intercept (almost always a method)
     * - PointCut: the specific pattern of methods that we're intercepting
     * - Aspect: the combo of advice + a point cut
     * - Advice: the implementation of what to do at the pointcut, and when @Before, @After, @Around
     *
     * Restaurant Analogy:
     *
     * The menu is the JoinPoint(all the foods that you CAN order)
     * Your order is the PointCut (the specific food you order a.k.a the pattern defined in Spring Expression Language)
     */

}
