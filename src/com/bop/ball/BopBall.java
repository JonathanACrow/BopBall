package com.bop.ball;

import com.bop.ball.server.acc.Account;

public class BopBall
{
    public static void main(String[] args)
    {
        if(args.length == 0)
        {
            new Account(1234).build();
            return;
        }
        args = new String[]{"endPoint=server"};
        RuntimeArgs.setArgs(args);
        Network.init();
        /*
        try
        {
            AppGameContainer con = new AppGameContainer(new BopBallGame());
            con.setDisplayMode(500, 500, false);
            con.setTargetFrameRate(60);
            con.start();
        }
        catch(Exception error)
        {
            error.printStackTrace();
        }
                */
    }
}