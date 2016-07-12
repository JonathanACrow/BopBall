package com.bop.ball.client.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Jonathan Crow
 */
public abstract class GUIComponent
{
    private static final Font DEFAULT_FONT = new TrueTypeFont(new java.awt.Font("Aerial",0,20), true);
    private Font font;
    private Rectangle bounds;
    private String txt;
    private Color bg, fg;
    private boolean focus, hide;
    
    public GUIComponent()
    {
        bounds = new Rectangle(0,0,0,0);
        font = DEFAULT_FONT;
        bg = Color.white;
        fg = Color.black;
        txt = "";
    }
    /**
     * @param txt Text of this component - for various uses
     */
    public void setText(String txt)
    {
        this.txt = txt;
    }
    /**
     * @return Text of this component - for various uses
     */
    public String getText()
    {
        return txt;
    }
    /**
     * @param font The font to be used in the rendering of this component's text
     */
    public void setFont(Font font)
    {
        this.font = font;
    }
    /**
     * @return The font to be used in the rendering of this component's text
     */
    public Font getFont()
    {
        return font;
    }
    /**
     * @param bounds The bounding rectangle of the component
     */
    protected void setBounds(Rectangle bounds)
    {
        this.bounds = bounds;
    }
    /**
     * @return The bounding rectangle of the component
     */
    public Rectangle getBounds()
    {
        return bounds;
    }
    /**
     * Moves the component's bounds to the provided location
     * @param x new X coord
     * @param y new Y coord
     */
    public void setPosition(float x, float y)
    {
        bounds.setLocation(x, y);
    }
    /**
     * @return The x coord of the bounds
     */
    public float getX()
    {
        return bounds.getX();
    }
    /**
     * @return The y coord of the bounds
     */
    public float getY()
    {
        return bounds.getY();
    }
    /**
     * @return The width of the bounds
     */
    public float getWidth()
    {
        return bounds.getWidth();
    }
    /**
     * @return The height of the bounds
     */
    public float getHeight()
    {
        return bounds.getHeight();
    }
    /**
     * @param bg The background color of the component
     */
    public void setBackground(Color bg)
    {
        this.bg = bg;
    }
    /**
     * @return The background color of the component
     */
    public Color getBackground()
    {
        return bg;
    }
    /**
     * @param fg The foreground color of the component
     */
    public void setForeground(Color fg)
    {
        this.fg = fg;
    }
    /**
     * @return The foreground color of the component
     */
    public Color getForeground()
    {
        return fg;
    }
    /**
     * @param focus true if this is the focused component of the containing gui
     */
    void setHasFocus(boolean focus)
    {
        this.focus = focus;
    }
    /**
     * @return true if this is the focused component of the containing gui
     */
    public boolean hasFocus()
    {
        return focus;
    }
    /**
     * @param hide true if this component should be hidden and dormant
     */
    public void setHidden(boolean hide)
    {
        this.hide = hide;
    }
    /**
     * @return true if this component should be hidden and dormant
     */
    public boolean isHidden()
    {
        return hide;
    }
    public abstract void onClick(int x, int y, int btn);
    public abstract void onKeyPress(int key, char c);
    public abstract void render(GameContainer con, StateBasedGame game, Graphics g) throws SlickException;
    public abstract void update(GameContainer con, StateBasedGame game, int delta) throws SlickException;
}