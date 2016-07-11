package com.bop.ball.client.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Button extends GUIActionComponent
{
    @Override
    public void onClick(float mouseX, float mouseY) {
        
    }

    @Override
    public void onKeyPress(int key) 
    {
        if(key == Input.KEY_ENTER) onClick(0,0);
    }

    @Override
    public void render(GameContainer con, StateBasedGame game, Graphics g) throws SlickException {
        
    }

    @Override
    public void update(GameContainer con, StateBasedGame game, int delta) throws SlickException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
