package com.example.testweb.service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class aopTestAspect {

    // the pointcut expression
    // .. : 하위의 모든 디렉토리를 의미
    // *(..) : * - 하위의 모든 메서드, (..) - 모든 매개변수
    // Controller
    // @Pointcut("execution(* com.example.testweb.controller.*(..))")
    // Service
    //@Pointcut("execution(* com.example.testweb.service.*(..))")
    // 어노테이션이 지정된 곳에서 실행.
    @Pointcut("@annotation(com.example.testweb.service.annotation.protocolTest)")
    private void protocolEvent1() {} // the pointcut signature

    // 메소드 호출전 실행
    @Before("@annotation(com.example.testweb.service.annotation.protocolTest)")
    public void aspectTestLog_Before() {
        log.info("Before");
    }

    // exception과 상관 없이, 메소드가 정상적으로 실행된 이후에 실행.
    @After("@annotation(com.example.testweb.service.annotation.protocolTest)")
    public void aspectTestLog_After() {
        log.info("After");
    }

    // exception이 발생하지 않고 정상적으로 실행된 경우, 실행.
    @AfterReturning("@annotation(com.example.testweb.service.annotation.protocolTest)")
    public void aspectTestLog_AfterReturning_1() {
        log.info("After Returning");
    }

    // 리턴값 받아서 처리하는 부분
    @AfterReturning(value ="@annotation(com.example.testweb.service.annotation.protocolTest)", returning = "returnValue")
    public void aspectTestLog_AfterReturning_2(Object returnValue) {
        log.info("After Returning");
        log.info("returnValue : {}", returnValue);
    }

    // exception이 발생하지 않고 정상적으로 실행된 경우, 실행.
    @AfterThrowing("@annotation(com.example.testweb.service.annotation.protocolTest)")
    public void aspectTestLog_AfterThrowing() {
        log.info("After Throwing");
    }

    // 메소드 실행 전.후 익셉션 발생 시점 등 다양하게 기능 설정. 및 구현 가능.
    @Around("@annotation(com.example.testweb.service.annotation.protocolTest)")
    public Object aspectTestLog3(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
        log.info("Around Start");
        /*해당 Object 에는 메소드가 실행뒤의 결과값이 담겨 있다.*/
        Object result = pjp.proceed();
        // stop stopwatch
        log.info("Around End");

        return result;
    }
}
