package com.bop.ball;

import java.util.HashMap;

/**
 * @author Jonathan Crow
 */
public class RuntimeArgs
{
    public static final String ENDPOINT_ARG = "EndPoint", IP_ARG = "ip", PORT_ARG = "port";
    private static HashMap<String, String> args;
    
    /**
     * @param a The command line arguments from main(String[] args)
     */
    public static void setArgs(String[] a)
    {
        args = new HashMap<>();
        for(String arg : a)
        {
            String[] parts = arg.split("=");
            if(parts.length == 2) args.put(parts[0].toLowerCase(), parts[1]);
        }
    }
    /**
     * @param arg The title of the argument
     * @return The value of the argument
     */
    public static String getArg(String arg)
    {
        arg = arg.toLowerCase();
        return args.containsKey(arg) ? args.get(arg) : "";
    }
    /**
     * Attemps to parse an argument to a double
     * @param arg The title of the argument
     * @return The value of the argument
     */
    public static double getNumericArg(String arg)
    {
        String val = getArg(arg);
        if(!val.isEmpty())
        {
            try
            {
                return Double.parseDouble(val);
            }
            catch(Exception error)
            {}
        }
        return Double.NaN;
    }
}