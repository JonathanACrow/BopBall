package com.bop.ball.server.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CommandExecuter
{
    private ArrayList<CommandListener> listen = new ArrayList<>();
    private boolean run;
    
    public void addCommandListener(CommandListener cmd)
    {
        listen.add(cmd);
    }
    public void removeCommandListener(CommandListener cmd)
    {
        listen.remove(cmd);
    }
    public void start() throws IOException, InterruptedException
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        run = true;
        while(run)
        {
            while(!buf.ready() && run)
                Thread.sleep(250);
            String raw = buf.readLine();
            if(!raw.isEmpty())
            {
                String[] parts = raw.split(" "), args = new String[parts.length-1];
                for(int i = 0; i < args.length; i++)
                    args[i] = parts[i+1];
                for(CommandListener cmdList : listen)
                    cmdList.command(parts[0], args);
            }
        }
    }
    public void stop()
    {
        run = false;
    }
    
    public static void start(CommandExecuter exec)
    {
        new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    exec.start();
                }
                catch(Exception error)
                {
                    error.printStackTrace();
                }
            }
        }).start();
    }
}