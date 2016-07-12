package com.bop.ball.client.gui;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class GUI
{
    private ArrayList<GUIComponent> comps = new ArrayList<>();
    private GUIComponent focus;
    private Color bg;
    
    public GUI()
    {
        bg = Color.white;
    }
    public void setBackground(Color bg)
    {
        this.bg = bg;
    }
    public Color getBackground()
    {
        return bg;
    }
    public void addComponent(GUIComponent comp)
    {
        comps.add(comp);
    }
    public void removeComponent(GUIComponent comp)
    {
        comps.remove(comp);
    }
    public GUIComponent[] getComponents()
    {
        return comps.toArray(new GUIComponent[0]);
    }
    void onClick(int x, int y, int btn)
    {
        Rectangle bounds;
        for(int i = comps.size()-1; i >= 0; i--)
        {
            bounds = comps.get(i).getBounds();
            if(bounds.contains(x, y)) 
            {
                if(focus != null) focus.setHasFocus(false);
                focus = comps.get(i);
                focus.onClick((int)(x-bounds.getX()+0.5f), (int)(y-bounds.getY()+0.5f), btn);
                focus.setHasFocus(true);
            }
        }
    }
    void onKeyPress(int key)
    {
        if(focus != null) focus.onKeyPress(key);
    }
    void render(GameContainer con, StateBasedGame game, Graphics g) throws SlickException
    {
        g.setColor(bg);
        g.fillRect(0, 0, con.getWidth(), con.getHeight());
        for(int i = comps.size()-1; i >= 0; i--)
        {
            comps.get(i).render(con, game, g);
            g.resetFont();
            g.resetLineWidth();
            g.resetTransform();
        }
    }
    void update(GameContainer con, StateBasedGame game, int delta) throws SlickException
    {
        for(int i = comps.size()-1; i >= 0; i--)
            comps.get(i).update(con, game, delta);
    }
}