package com.proxy.statics.game;

public class Client {
    public static void main(String[] args) {
        GamePlayer A = new GamePlayer("小A"); //定义玩家小A
        GamePlayerProxy playerProxy = new GamePlayerProxy("小B",A); //定义代打玩家小B
        playerProxy.login("我是小A呀","123");  //登陆账号
        playerProxy.win(); //赢了一局
        playerProxy.upgrade(); //上星耀了
    }
}
