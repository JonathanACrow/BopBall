package com.bop.ball.client;

import com.bop.ball.BopBallGame;
import com.bop.ball.CommonProxy;
import com.esotericsoftware.kryonet.Client;
import org.newdawn.slick.AppGameContainer;

/**
 * @author Jonathan Crow
 */
public class ClientProxy extends CommonProxy
{
    private Client gameClient, lobbyClient;
    
    @Override
    public void init()
    {
        try
        {
            AppGameContainer con = new AppGameContainer(new BopBallGame());
            con.setDisplayMode(1200, 750, false);
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
    {
        disconnect();
        gameClient = new Client();
        lobbyClient = new Client();
        gameClient.addListener(new GameListener());
        lobbyClient.addListener(new LobbyListener());
        gameClient.start();
        lobbyClient.start();
        try
        {
            gameClient.connect(7500, ip, port, port);
            lobbyClient.connect(7500, ip, port, port);
        }
        catch(Exception error)
        {
            error.printStackTrace();
            disconnect();
        }
    }
    @Override
    public void disconnect()
    {
        if(gameClient != null)
        {
            gameClient.stop();
            gameClient.close();
            gameClient = null;
        }
        if(lobbyClient != null)
        {
            lobbyClient.stop();
            lobbyClient.close();
            lobbyClient = null;
        }
    }
}