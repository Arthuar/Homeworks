package org.example;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectLog {
    @Pointcut("execution(* org.example.ConsoleTaker.transform())")
    public void inputLogging() {
    }
    @AfterReturning(value = "inputLogging()", returning = "returningValue")
    public void beforeAdvice(String returningValue) {
        System.out.println(returningValue);
    }
}
