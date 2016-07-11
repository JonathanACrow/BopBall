package com.bop.ball.server;

import com.bop.ball.CommonProxy;
import com.bop.ball.Network;
import com.bop.ball.RuntimeArgs;
import com.bop.ball.server.cmd.CommandExecuter;
import com.bop.ball.server.cmd.CommandListener;
import com.esotericsoftware.kryonet.Server;

public class ServerProxy extends CommonProxy
{
    private Server gameServ, lobbyServ;
    private CommandExecuter exec;
    
    @Override
    public void init()
    {
        double port = RuntimeArgs.getNumericArg(RuntimeArgs.PORT_ARG);
        connect("", port == Double.NaN ? Network.DEFAULT_PORT : (int)port);
    }
    @Override
    public void connect(String ip, int port)
    {
        disconnect();
        gameServ = new Server();
        lobbyServ = new Server();
        exec = new CommandExecuter();
        gameServ.addListener(new GameListener());
        lobbyServ.addListener(new LobbyListener());
        exec.addCommandListener(cmds);
        gameServ.start();
        lobbyServ.start();
        CommandExecuter.start(exec);
        try
        {
            gameServ.bind(port, port);
            lobbyServ.bind(port+1);
        }
        catch(Exception error)
        {
            error.printStackTrace();
        }
    }
    @Override
    public void disconnect()
    {
        if(gameServ != null)
        {
            gameServ.stop();
            gameServ.close();
            gameServ = null;
        }
        if(lobbyServ != null)
        {
            lobbyServ.stop();
            lobbyServ.close();
            lobbyServ = null;
        }
        if(exec != null)
        {
            exec.stop();
            exec = null;
        }
    }
    
    private final CommandListener cmds = new CommandListener()
    {
        @Override
        public void command(String cmd, String[] args)
        {
            if(cmd.equalsIgnoreCase("stop")) disconnect();
        }
    };
}