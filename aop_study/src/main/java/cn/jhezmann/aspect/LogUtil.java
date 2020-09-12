package cn.jhezmann.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogUtil {
    @Before("execution(* cn.jhezmann.service..*.*(..))")
    public static void before(Method method,Object[] args){

    }


}
