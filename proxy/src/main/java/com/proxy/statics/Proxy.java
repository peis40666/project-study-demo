package com.proxy.statics;

public class Proxy implements Subject {

    private  RealSubject realSubject;


    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        this.before();
        realSubject.request();
        this.after();
    }

    private void before(){
        System.out.println("预处理");
    }

    private void after(){
        System.out.println("善后处理");
    }
}
