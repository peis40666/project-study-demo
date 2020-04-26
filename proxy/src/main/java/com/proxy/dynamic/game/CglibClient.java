package com.proxy.dynamic.game;

import com.proxy.statics.game.GamePlayer;
import com.proxy.statics.game.IGamePlayer;

public class CglibClient {
    public static void main(String[] args) {
        IGamePlayer proxy = (IGamePlayer) new GamePlayerCglibDynProxy().getProxyInstance(new GamePlayer("小A"));
        System.out.println(proxy.getClass().getName());  //这里我打印了代理类的类名
        proxy.login("我是小A呀","123");  //登陆账号
        proxy.win(); //赢了一局
        proxy.upgrade(); //上星耀了
    }
}
