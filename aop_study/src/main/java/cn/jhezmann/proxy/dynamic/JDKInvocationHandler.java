package cn.jhezmann.proxy.dynamic;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class JDKInvocationHandler implements InvocationHandler {

    private Object target;

    public JDKInvocationHandler(Object target){
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (args==null || args.length==0){
            System.out.println();
        } else {
            System.out.println(Arrays.asList(args));
        }

        return method.invoke(target,args);
    }
}
