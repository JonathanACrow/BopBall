package com.bop.ball.client.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Label extends GUIComponent
{
    public Label(String txt)
    {
        setText(txt);
        setBounds(new Rectangle(0,0,getFont().getWidth(txt),getFont().getHeight(txt)));
    }
    @Override
    public void onClick(int x, int y, int btn)
    {}
    @Override
    public void onKeyPress(int key, char c)
    {}
    @Override
    public void render(GameContainer con, StateBasedGame game, Graphics g) throws SlickException
    {
        g.setColor(getForeground());
        g.setFont(getFont());
        g.drawString(getText(), getX(), getY());
    }
    @Override
    public void update(GameContainer con, StateBasedGame game, int delta) throws SlickException
    {}
}