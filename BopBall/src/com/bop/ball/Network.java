package com.bop.ball;

import com.bop.ball.client.ClientProxy;
import com.bop.ball.server.ServerProxy;

/**
 * @author Jonathan Crow
 */
public class Network
{
    public static final int DEFAULT_PORT = 3474;
    private static CommonProxy proxy;
    
    /**
     * Determines the appropriate proxy to use and initializes it
     */
    public static void init()
    {
        proxy = RuntimeArgs.getArg(RuntimeArgs.ENDPOINT_ARG).equals("server") ? new ServerProxy() : new ClientProxy();
        proxy.init();
    }
    /**
     * @return This game instance's proxy (server or client)
     */
    public static CommonProxy getProxy()
    {
        return proxy;
    }
}