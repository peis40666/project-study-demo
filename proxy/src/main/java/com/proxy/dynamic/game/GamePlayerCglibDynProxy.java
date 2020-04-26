package com.proxy.dynamic.game;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class GamePlayerCglibDynProxy implements MethodInterceptor {

    private Object target;

    public Object getProxyInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equalsIgnoreCase("login")){  //前置方法可以根据条件是否调用
            before(args[0]);//登陆的时候才打印
        }
        Object obj = methodProxy.invokeSuper(o,args);
        if(method.getName().equalsIgnoreCase("upgrade")){  //后置方法可以根据条件是否调用
            after();    //升级之后才打印
        }
        return obj;
    }

    private void before(Object args){
        System.out.println("正在使用"+args.toString()+"登陆游戏");
    }

    private void after(){
        System.out.printf("完成任务！");
    }
}
