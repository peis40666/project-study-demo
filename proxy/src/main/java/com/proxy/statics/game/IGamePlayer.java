package com.proxy.statics.game;

/**
 * 定义一个玩家接口
 */
public interface IGamePlayer {


    //登陆王者荣耀游戏
    public void login(String userName,String password);
    //赢了一局
    public void win();
    //升段位
    public void upgrade();
}
