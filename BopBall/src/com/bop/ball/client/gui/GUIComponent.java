package com.bop.ball.client.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public abstract class GUIComponent
{
    private static final Font DEFAULT_FONT = new TrueTypeFont(new java.awt.Font("Aerial",0,20), true);
    private Font font;
    private Rectangle bounds;
    private String txt;
    private Color bg, fg;
    private boolean focus;
    
    public GUIComponent()
    {
        bounds = new Rectangle(0,0,0,0);
        font = DEFAULT_FONT;
        bg = Color.white;
        fg = Color.black;
    }
    public void setText(String txt)
    {
        this.txt = txt;
    }
    public String getText()
    {
        return txt;
    }
    public void setFont(Font font)
    {
        this.font = font;
    }
    public Font getFont()
    {
        return font;
    }
    protected void setBounds(Rectangle bounds)
    {
        this.bounds = bounds;
    }
    public Rectangle getBounds()
    {
        return bounds;
    }
    public void setPosition(float x, float y)
    {
        bounds.setLocation(x, y);
    }
    public float getX()
    {
        return bounds.getX();
    }
    public float getY()
    {
        return bounds.getY();
    }
    public float getWidth()
    {
        return bounds.getWidth();
    }
    public float getHeight()
    {
        return bounds.getHeight();
    }
    public void setBackground(Color bg)
    {
        this.bg = bg;
    }
    public Color getBackground()
    {
        return bg;
    }
    public void setForeground(Color fg)
    {
        this.fg = fg;
    }
    public Color getForeground()
    {
        return fg;
    }
    void setHasFocus(boolean focus)
    {
        this.focus = focus;
    }
    public boolean hasFocus()
    {
        return focus;
    }
    public abstract void onClick(float mouseX, float mouseY);
    public abstract void onKeyPress(int key);
    public abstract void render(GameContainer con, StateBasedGame game, Graphics g) throws SlickException;
    public abstract void update(GameContainer con, StateBasedGame game, int delta) throws SlickException;
}