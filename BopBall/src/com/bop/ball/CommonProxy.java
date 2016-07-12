package com.bop.ball;

/**
 * @author Jonathan Crow
 */
public abstract class CommonProxy
{
    /**
     * all pre-run steps to be performed here
     */
    public abstract void init();
    /**
     * Either start the server or connect to one
     * @param ip ip of the server
     * @param port port of the server to connect to or to start
     */
    public abstract void connect(String ip, int port);
    /**
     * Either close the server or disconnect from it
     */
    public abstract void disconnect();
}