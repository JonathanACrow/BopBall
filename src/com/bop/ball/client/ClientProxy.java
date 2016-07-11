package com.bop.ball.client;

import com.bop.ball.BopBallGame;
import com.bop.ball.CommonProxy;
import org.newdawn.slick.AppGameContainer;

public class ClientProxy extends CommonProxy
{
    @Override
    public void init()
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
    @Override
    public void connect(String ip, int port)
    {}
    @Override
    public void disconnect()
    {}
}