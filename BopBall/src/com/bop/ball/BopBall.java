package com.bop.ball;

public class BopBall
{
    public static void main(String[] args)
    {
        Network.init();
        Network.getProxy().sayHello();
    }
}