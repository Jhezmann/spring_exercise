package cn.jhezmann.proxy.dynamic;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

public class CgLibMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CgLib动态代理，方法执行前");
        Object obj = methodProxy.invokeSuper(o,objects);
        System.out.println("CgLib动态代理，方法执行后");
        return obj;
    }
}
