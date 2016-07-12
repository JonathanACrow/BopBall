package com.bop.ball;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class BopBallGame extends StateBasedGame
{
    public static final int MENU_STATE = 1, LOGIN_STATE = 2;
    
    public BopBallGame()
    {
        super("Bop Ball");
    }
    @Override
    public void initStatesList(GameContainer con) throws SlickException
    {
        addState(new MenuState());
        addState(new LoginState());
    }
}