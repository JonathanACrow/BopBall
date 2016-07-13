package com.bop.ball;

import com.bop.ball.client.gui.Button;
import com.bop.ball.client.gui.GUI;
import com.bop.ball.client.gui.GUIAction;
import com.bop.ball.client.gui.GUIComponent;
import com.bop.ball.client.gui.GUIState;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends GUIState
{
    private Button logBtn, regBtn;
    private LoginState login;
    
    @Override
    public int getID()
    {
        return BopBallGame.MENU_STATE;
    }
    @Override
    public void init(GameContainer con, StateBasedGame game) throws SlickException
    {
        super.init(con, game);
        con.getInput().enableKeyRepeat();
        login = (LoginState)game.getState(BopBallGame.LOGIN_STATE);
        GUI gui = getGUI();
        gui.addComponent(logBtn = new Button("Login"));
        logBtn.addAcion(act);
        logBtn.setPosition(con.getWidth()/2.0f-logBtn.getWidth()-5, con.getHeight()/2.0f-logBtn.getHeight()/2);
        gui.addComponent(regBtn = new Button("Create Account"));
        regBtn.addAcion(act);
        regBtn.setPosition(con.getWidth()/2.0f+5, con.getHeight()/2.0f-regBtn.getHeight()/2);
    }
    
    private final GUIAction act = new GUIAction()
    {
        @Override
        public void act(GUIComponent comp)
        {
            login.configure(comp == regBtn);
            getGame().enterState(login.getID());
        }
    };
}