package com.bop.ball;

import com.bop.ball.client.gui.CheckBox;
import com.bop.ball.client.gui.GUI;
import com.bop.ball.client.gui.GUIState;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends GUIState
{
    @Override
    public int getID()
    {
        return BopBallGame.MENU_STATE;
    }
    @Override
    public void init(GameContainer con, StateBasedGame game) throws SlickException
    {
        super.init(con, game);
        GUI gui = getGUI();
        gui.setBackground(new Color(255,0,0));
    }
}