package com.learning.design.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MensajeAspect {

    private static final Logger log = LoggerFactory.getLogger(MensajeAspect.class);

    @Pointcut("execution(* Mensajeria.*(..))")
    public void pointcut() {
    }

    @After("pointcut()")
    public void myAdvice(JoinPoint jp) {
        log.info("POINT CUT - after\n");
    }

}
