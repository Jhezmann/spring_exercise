package cn.jhezmann.test;

import cn.jhezmann.MainJavaConfig;
import cn.jhezmann.beans.User;
import cn.jhezmann.controller.MainController;
import cn.jhezmann.dao.BaseDao;
import cn.jhezmann.dao.impl.UserDaoImpl;
import cn.jhezmann.proxy.dynamic.CgLibMethodInterceptor;
import cn.jhezmann.proxy.dynamic.JDKInvocationHandler;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

    private AnnotationConfigApplicationContext ioc;
    @Before
    public void before(){
        ioc = new AnnotationConfigApplicationContext(MainJavaConfig.class);
    }

    /**
     * 测试JDK动态代理
     */
    @Test
    public void testProxy() {
        ClassLoader loader = BaseDao.class.getClassLoader();//类加载器    通常指定被代理类的接口的类加载器
        Class<?>[] interfaces = new Class[]{BaseDao.class};//类型    通常指定被代理类的接口的类型
        InvocationHandler handler = new JDKInvocationHandler(new UserDaoImpl());//委托执行的处理类    通常为日志功能

        BaseDao<User> userBaseDao = (BaseDao<User>) Proxy.newProxyInstance(loader,interfaces,handler);
        User user = userBaseDao.get(0, "testProxy");
        System.out.println(user);
    }

    /**
     * 公用动态代理（JDK）
     */
    @Test
    public void testCommonProxy() {
        BaseDao<User> userBaseDao = (BaseDao<User>) commonProxy(new UserDaoImpl());
        User user = userBaseDao.get(1,"testCommonProxy");
        System.out.println(user);
    }

    public Object commonProxy(Object targetClass) {
        ClassLoader loader = targetClass.getClass().getClassLoader();//类加载器    通常指定被代理类的接口的类加载器
        Class<?>[] interfaces = targetClass.getClass().getInterfaces();//类型    通常指定被代理类的接口的类型
        InvocationHandler handler = new JDKInvocationHandler(targetClass);//委托执行的处理类    通常为日志功能

        Object obj = Proxy.newProxyInstance(loader,interfaces,handler);
        return obj;
    }

    /**
     * CgLib动态代理测试
     */
    @Test
    public void testEnhancer() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E:\\JavaIDE\\IdeaProject\\cn.jhezmann.spring_aop\\src\\test");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(User.class);
        enhancer.setCallback(new CgLibMethodInterceptor());
        User user = (User) enhancer.create();
        user.setId(101);
        System.out.println(user.getId());
    }
}
