package com.bop.ball;

public abstract class CommonProxy
{
    public abstract void init();
    public abstract void connect(String ip, int port);
    public abstract void disconnect();
}