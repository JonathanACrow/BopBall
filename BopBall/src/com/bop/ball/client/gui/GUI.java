package com.bop.ball.client.gui;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Jonathan Crow
 */
public class GUI
{
    private ArrayList<GUIComponent> comps = new ArrayList<>();
    private GUIComponent focus;
    private Color bg;
    
    public GUI()
    {
        bg = Color.white;
    }
    /**
     * @param bg The background color of the gui
     */
    public void setBackground(Color bg)
    {
        this.bg = bg;
    }
    
    /**
     * @return The background color of the gui
     */
    public Color getBackground()
    {
        return bg;
    }
    /**
     * @param comp GUIComponent to be added to this gui. Will be rendered, updated, and will process input unless hidden.
     */
    public void addComponent(GUIComponent comp)
    {
        comps.add(comp);
    }
    /**
     * @param comp GUIComponent to be removed from this gui. Will no longer be rendered or updated.
     */
    public void removeComponent(GUIComponent comp)
    {
        comps.remove(comp);
    }
    /**
     * @return a generated array of the components in this gui. Manipulating it will do nothing to the GUI.
     */
    public GUIComponent[] getComponents()
    {
        return comps.toArray(new GUIComponent[0]);
    }
    /**
     * Should only be called by GUIState
     * @param x the x coord of the click
     * @param y the y coord of the click
     * @param btn which button of the mouse was used
     */
    void onClick(int x, int y, int btn)
    {
        Rectangle bounds;
        for(int i = comps.size()-1; i >= 0; i--)
        {
            if(!comps.get(i).isHidden())
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
    }
    /**
     * Should only be called by GUIState
     * @param key the raw value of the key pressed
     * @param c the actual character of the key press
     */
    void onKeyPress(int key, char c)
    {
        if(focus != null && !focus.isHidden()) focus.onKeyPress(key, c);
    }
    /**
     * Should only be called by GUIState
     * Renders all non-hidden components in this gui
     * @param con The GameContainer being rendered on
     * @param game The current game
     * @param g graphics context
     * @throws SlickException 
     */
    void render(GameContainer con, StateBasedGame game, Graphics g) throws SlickException
    {
        g.setColor(bg);
        g.fillRect(0, 0, con.getWidth(), con.getHeight());
        for(int i = comps.size()-1; i >= 0; i--)
        {
            if(!comps.get(i).isHidden())
            {
                comps.get(i).render(con, game, g);
                g.resetFont();
                g.resetLineWidth();
                g.resetTransform();
            }
        }
    }
    /**
     * Should only be called by GUIState
     * Updates all non-hidden components in this gui
     * @param con The GameContainer being rendered on
     * @param game The current game
     * @param delta the amount of time since last update
     * @throws SlickException 
     */
    void update(GameContainer con, StateBasedGame game, int delta) throws SlickException
    {
        for(int i = comps.size()-1; i >= 0; i--)
            if(!comps.get(i).isHidden()) comps.get(i).update(con, game, delta);
    }
}