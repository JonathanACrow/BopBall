package com.bop.ball.client.gui;

import com.bop.ball.BopBallGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public abstract class GUIState extends BasicGameState
{
    private GameContainer con;
    private BopBallGame game;
    private GUI gui;
    
    public GUI getGUI()
    {
        return gui;
    }
    protected GameContainer getGameContainer()
    {
        return con;
    }
    protected BopBallGame getGame()
    {
        return game;
    }
    @Override
    public void init(GameContainer con, StateBasedGame game) throws SlickException
    {
        this.con = con;
        this.game = (BopBallGame)game;
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
    public void mousePressed(int btn, int x, int y)
    {
        gui.onClick(x, y, btn);
    }
    @Override
    public void keyPressed(int key, char c)
    {
        gui.onKeyPress(key, c);
    }
}