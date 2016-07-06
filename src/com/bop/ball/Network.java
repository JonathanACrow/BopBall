package com.bop.ball;

import com.bop.ball.client.ClientProxy;
import com.bop.ball.server.ServerProxy;

public class Network
{
    public static final int DEFAULT_PORT = 3474;
    private static CommonProxy proxy;
    
    public static void init()
    {
        proxy = RuntimeArgs.getArg(RuntimeArgs.ENDPOINT_ARG).equals("server") ? new ServerProxy() : new ClientProxy();
        proxy.init();
    }
    public static CommonProxy getProxy()
    {
        return proxy;
    }
}