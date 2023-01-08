package com.example.bii.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;



@Component
@Aspect
@Slf4j
public class PerformanceAspect {




    @Around("execution(* com.example.bii.Service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp, JoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
        Object out=pjp.proceed();

        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return out;
    }

}