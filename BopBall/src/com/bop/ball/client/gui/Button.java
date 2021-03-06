package com.bop.ball.client.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Button extends GUIActionComponent
{
    private float textX, textY;
    
    public Button(String txt)
    {
        setText(txt);
    }
    private void updateBounds()
    {
        setBounds(new Rectangle(getX(), getY(), getFont().getWidth(getText()) + 10 , getFont().getHeight(getText())+10));
        textX = getBounds().getCenterX() - getFont().getWidth(getText())/2;
        textY = getBounds().getCenterY() - getFont().getHeight(getText())/2;
    }
    @Override
    public void setPosition(float x, float y)
    {
        super.setPosition(x, y);
        updateBounds();
    }
    @Override
    public void setText(String txt)
    {
        super.setText(txt);
        updateBounds();
    }
    
    @Override
    public void onClick(int x, int y, int btn) 
    {
        if(btn == Input.MOUSE_LEFT_BUTTON) callActions();
    }

    @Override
    public void onKeyPress(int key, char c) 
    {
        if(key == Input.KEY_ENTER) onClick(0,0,Input.MOUSE_LEFT_BUTTON);
    }

    @Override
    public void render(GameContainer con, StateBasedGame game, Graphics g) throws SlickException 
    {
        g.setColor(getBackground());
        g.setLineWidth(2f);
        g.draw(getBounds());
        g.setColor(getForeground());
        g.setFont(getFont());
        g.drawString(getText(),textX, textY);
    }

    @Override
    public void update(GameContainer con, StateBasedGame game, int delta) throws SlickException 
    {  
    }
    
}
