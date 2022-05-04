package com.example.testweb.service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class aopTestAspect {
    @Around("@annotation(com.example.testweb.service.annotation.protocolTest)")
    public Object aspectTestLog(ProceedingJoinPoint pjp) throws Throwable {
        log.info("test Start Log");

        Object result = pjp.proceed();

        log.info("test End Log");
        return result;
    }
}
