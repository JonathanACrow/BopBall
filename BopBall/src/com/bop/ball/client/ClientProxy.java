package com.bop.ball.client;

import com.bop.ball.CommonProxy;

public class ClientProxy extends CommonProxy
{
    @Override
    public void sayHello()
    {
        System.out.println("I am a client");
    }
}