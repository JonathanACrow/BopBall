package com.bop.ball.client.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Jonathan Crow
 */
public class CheckBox extends GUIComponent
{
    private boolean check;
    private float textY = 0;
    
    public CheckBox(String txt, boolean check)
    {
        setText(txt);
        this.check = check;
    }
    private void updateBounds()
    {
        float h = getFont().getHeight(getText())+10;
        setBounds(new Rectangle(getX(), getY(), getFont().getWidth(getText())+10+h, h));
        textY = getY()+(getHeight()+5)/2-getFont().getHeight(getText())/2;
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
        if(btn == Input.MOUSE_LEFT_BUTTON) check = !check;
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
        if(check) g.fillRect(getX()+5, getY()+5, getHeight(), getHeight());
        else g.drawRect(getX()+5, getY()+5, getHeight(), getHeight());
        g.setColor(getForeground());
        g.setFont(getFont());
        g.drawString(getText(), getX()+getHeight()+15, getY()+5);
    }
    @Override
    public void update(GameContainer con, StateBasedGame game, int delta) throws SlickException
    {}
}