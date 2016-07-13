package com.bop.ball.client.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Jonathan Crow
 */
public class DropDownList extends GUIComponent
{
    private Object[] data;
    private String[] dataStrs;
    private int select;
    private boolean open;
    
    public DropDownList(Object[] data)
    {
        setListData(data);
    }
    public void setListData(Object[] data)
    {
        this.data = data;
        dataStrs = new String[data.length];
        int wide = 0, temp;
        for(int i = 0; i < data.length; i++)
        {
            dataStrs[i] = data[i].toString();
            temp = getFont().getWidth(dataStrs[i]);
            if(temp > wide) wide = temp;
        }
        setBounds(new Rectangle(getX(), getY(), wide, getFont().getHeight(" ")+5));
        select = 0;
    }
    public int getSelectedIndex()
    {
        return select;
    }
    public void setSelectedIndex(int select)
    {
        if(select < 0) select = 0;
        else if(select >= data.length) select = data.length-1;
        this.select = select;
    }
    public Object getSelectedItem()
    {
        return data[select];
    }
    public void setSelectedItem(Object obj)
    {
        for(int i = 0; i < data.length; i++)
        {
            if(data[i].equals(obj))
            {
                select = i;
                return;
            }
        }
    }
    @Override
    public void setHasFocus(boolean focus)
    {
        super.setHasFocus(focus);
        if(!focus) open = false;
    }
    @Override
    public void onClick(int x, int y, int btn)
    {}
    @Override
    public void onKeyPress(int key, char c)
    {}
    @Override
    public void render(GameContainer con, StateBasedGame game, Graphics g) throws SlickException
    {
        g.setColor(hasFocus() ? getHighlight() : getBackground());
        g.fill(getBounds());
        g.setColor(getForeground());
        g.draw(getBounds());
        g.setFont(getFont());
        g.drawString(dataStrs[select], getBounds().getCenterX()-getFont().getWidth(dataStrs[select])/2.0f, getBounds().getCenterY()-getFont().getHeight(dataStrs[select])/2.0f);
    }
    @Override
    public void update(GameContainer con, StateBasedGame game, int delta) throws SlickException
    {}
}
