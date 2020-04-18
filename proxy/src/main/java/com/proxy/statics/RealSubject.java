package com.proxy.statics;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("业务代码");
    }
}
