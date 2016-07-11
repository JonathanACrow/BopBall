
package com.bop.ball.client.gui;

import java.util.ArrayList;


public abstract class GUIActionComponent  extends GUIComponent
{
    private ArrayList<GUIAction> actions;
    public GUIActionComponent()
    {
        actions = new ArrayList<>();
    }
    
    public void addAcion(GUIAction a)
    {
        actions.add(a);
    }
    public void removeAction(GUIAction a)
    {
        actions.remove(a);
    }
    public void callActions()
    {
        for( GUIAction a : actions)
            a.act(this);
    }
    
}
