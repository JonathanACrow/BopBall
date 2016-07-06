package com.bop.ball;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends BasicGameState
{
    private Color bg;
    
    @Override
    public int getID()
    {
        return BopBallGame.MENU_STATE;
    }
    @Override
    public void init(GameContainer con, StateBasedGame game) throws SlickException
    {
        bg = new Color(255,0,0);
    }
    @Override
    public void render(GameContainer con, StateBasedGame game, Graphics g) throws SlickException
    {
        g.setColor(bg);
        g.fillRect(10, 10, 100, 500);
    }
    @Override
    public void update(GameContainer con, StateBasedGame game, int delta) throws SlickException
    {
        
    }
}