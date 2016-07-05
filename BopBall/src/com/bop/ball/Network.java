package com.bop.ball;

import com.bop.ball.server.ServerProxy;

public class Network
{
    private static CommonProxy proxy;
    
    public static void init()
    {
        proxy = new ServerProxy();
    }
    public static CommonProxy getProxy()
    {
        return proxy;
    }
}