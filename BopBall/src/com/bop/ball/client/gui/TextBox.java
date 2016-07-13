package com.bop.ball.client.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Jonathan Crow
 */
public class TextBox extends GUIActionComponent
{
    private Color hl;
    private int charLim;
    private boolean pass;
    private String cont, hide, draw;
    
    /**
     * @param x left of bounds
     * @param y top of bounds
     * @param w width of bounds
     * @param h height of bounds
     * @param charLim maximum length of the textbox's String
     */
    public TextBox(float x, float y, float w, float h, int charLim)
    {
        setBounds(new Rectangle(x, y, w, h));
        this.charLim = charLim;
        hl = Color.lightGray;
        pass = false;
        cont = "";
        hide = "";
    }
    /**
     * @return The color of this component when focused
     */
    public Color getHighlight()
    {
        return hl;
    }
    /**
     * @param hl The color of this component when focused
     */
    public void setHighlight(Color hl)
    {
        this.hl = hl;
    }
    /**
     * @return maximum length of the textbox's String
     */
    public int getCharacterLimit()
    {
        return charLim;
    }
    /**
     * @param charLim maximum length of the textbox's String
     */
    public void setCharacterLimit(int charLim)
    {
        this.charLim = charLim;
    }
    /**
     * @return true if the contents of the textbox should be hidden
     */
    public boolean isPassword()
    {
        return pass;
    }
    /**
     * @param pass true if the contents of the textbox should be hidden
     */
    public void setPassword(boolean pass)
    {
        this.pass = pass;
    }
    /**
     * @param cont The text within the textbox
     */
    public void setContent(String cont)
    {
        this.cont = cont;
        if(pass)
        {
            char[] hideArr = new char[cont.length()];
            for(int i = 0; i < hideArr.length; i++)
                hideArr[i] = '*';
            hide = new String(hideArr);
        }
    }
    /**
     * @return cont The text within the textbox
     */
    public String getContent()
    {
        return cont;
    }
    @Override
    public void onClick(int x, int y, int btn)
    {}
    @Override
    public void onKeyPress(int key, char c)
    {
        if(c >= 32 && c < 127 && getContent().length() < getCharacterLimit()) setContent(getContent()+c);
        else if(key == Input.KEY_BACK && getContent().length() > 0) setContent(getContent().substring(0, getContent().length()-1));
    }
    @Override
    public void render(GameContainer con, StateBasedGame game, Graphics g) throws SlickException
    {
        g.setColor(hasFocus() ? hl : getBackground());
        g.fill(getBounds());
        g.setColor(getForeground());
        g.setFont(getFont());
        g.setLineWidth(2f);
        g.draw(getBounds());
        g.drawString(draw, getBounds().getCenterX()-getFont().getWidth(draw)/2.0f, getBounds().getCenterY()-getFont().getHeight(draw)/2.0f);
    }
    @Override
    public void update(GameContainer con, StateBasedGame game, int delta) throws SlickException
    {
        draw = getContent().isEmpty() ? getText() : (pass ? hide : getContent());
    }
}