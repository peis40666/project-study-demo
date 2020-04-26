package com.proxy.dynamic.game;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GamePlayerJdkDynProxy implements InvocationHandler {

    private Object target; //目标代理类，不需要持有具体的代理对象

    public Object getProxyInstance(Object target){
        this.target = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equalsIgnoreCase("login")){  //前置方法可以根据条件是否调用
            before(args[0]);//登陆的时候才打印
        }
        Object object = method.invoke(target,args);
        if(method.getName().equalsIgnoreCase("upgrade")){  //后置方法可以根据条件是否调用
            after();    //升级之后才打印
        }
        return object;
    }

    private void before(Object args){
        System.out.println("正在使用"+args.toString()+"登陆游戏");
    }

    private void after(){
        System.out.printf("完成任务！");
    }
}
