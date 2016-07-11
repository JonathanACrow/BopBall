package com.bop.ball;

public class BopBall
{
    public static void main(String[] args)
    {
        args = new String[]{"endPoint=client"};
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