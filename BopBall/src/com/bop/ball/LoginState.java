package com.bop.ball;

import com.bop.ball.client.gui.Button;
import com.bop.ball.client.gui.GUI;
import com.bop.ball.client.gui.GUIAction;
import com.bop.ball.client.gui.GUIComponent;
import com.bop.ball.client.gui.GUIState;
import com.bop.ball.client.gui.TextBox;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Jonathan Crow
 */
public class LoginState extends GUIState
{
    private TextBox user, pass, passConf;
    private Button regBtn, logBtn;
    
    /**
     * @param reg true if the ui should be configured to allow the user to register an account
     */
    void configure(boolean reg)
    {
        float centX = getGameContainer().getWidth()/2.0f;
        passConf.setHidden(!reg);
        regBtn.setHidden(!reg);
        if(reg)
        {
            regBtn.setPosition(centX-regBtn.getWidth()-5, regBtn.getY());
            logBtn.setPosition(centX+logBtn.getWidth()+5, logBtn.getY());
        }
        else logBtn.setPosition(centX-logBtn.getWidth()/2, logBtn.getY());
    }
    @Override
    public int getID()
    {
        return BopBallGame.LOGIN_STATE;
    }
    @Override
    public void init(GameContainer con, StateBasedGame game) throws SlickException
    {
        super.init(con, game);
        GUI gui = getGUI();
        float centX = con.getWidth()/2.0f, yInt = con.getHeight()/5.0f;
        gui.addComponent(user = new TextBox(centX-100,yInt,200,50,20));
        user.setText("Username");
        gui.addComponent(pass = new TextBox(centX-125,yInt*2,250,50,25));
        pass.setText("Password");
        pass.setPassword(true);
        gui.addComponent(passConf = new TextBox(centX-125,yInt*3,250,50,25));
        passConf.setText("Confirm Password");
        passConf.setPassword(true);
        gui.addComponent(regBtn = new Button("Register"));
        regBtn.addAcion(act);
        regBtn.setPosition(centX-regBtn.getWidth()-5, yInt*4);
        gui.addComponent(logBtn = new Button("Login"));
        logBtn.addAcion(act);
        logBtn.setPosition(centX+5, yInt*4);
    }
    
    private final GUIAction act = new GUIAction()
    {
        @Override
        public void act(GUIComponent comp)
        {
            if(comp == regBtn)
            {}
            else if(comp == logBtn)
            {}
        }
    };
}