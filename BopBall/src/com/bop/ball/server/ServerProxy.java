package com.bop.ball.server;

import com.bop.ball.CommonProxy;

public class ServerProxy extends CommonProxy
{
    @Override
    public void sayHello()
    {
        System.out.println("I am a server");
    }
}