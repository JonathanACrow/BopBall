package com.bop.ball;

import org.newdawn.slick.AppGameContainer;

public class BopBall
{
    public static void main(String[] args)
    {
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
    }
}