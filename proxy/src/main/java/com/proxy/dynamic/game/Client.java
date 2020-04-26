package com.proxy.dynamic.game;

import com.proxy.statics.game.GamePlayer;
import com.proxy.statics.game.IGamePlayer;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        //获取代理类
        GamePlayerJdkDynProxy gamePlayerJdkDynProxy = new GamePlayerJdkDynProxy();
        IGamePlayer playerProxy = (IGamePlayer) gamePlayerJdkDynProxy.getProxyInstance(new GamePlayer("小A"));
        System.out.println(playerProxy.getClass().getName());  //这里我打印了代理类的类名
        playerProxy.login("我是小A呀","123");  //登陆账号
        playerProxy.win(); //赢了一局
        playerProxy.upgrade(); //上星耀了
//        try{
//            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{GamePlayer.class});
//            FileOutputStream os = new FileOutputStream("/Users/wangpei/Downloads/$Proxy.class");
//            os.write(bytes);
//            os.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
