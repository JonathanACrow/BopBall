package com.bop.ball.client.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public abstract class GUIState extends BasicGameState
{
    private GUI gui;
    
    public GUI getGUI()
    {
        return gui;
    }
    @Override
    public void init(GameContainer con, StateBasedGame game) throws SlickException
    {
        gui = new GUI();
    }
    @Override
    public void render(GameContainer con, StateBasedGame game, Graphics g) throws SlickException
    {
        gui.render(con, game, g);
    }
    @Override
    public void update(GameContainer con, StateBasedGame game, int delta) throws SlickException
    {
        gui.update(con, game, delta);
    }
    @Override
    public void mousePressed(int button, int x, int y)
    {
        gui.onClick(x, y);
    }
    @Override
    public void keyPressed(int key, char c)
    {
        gui.onKeyPress(key);
    }
}