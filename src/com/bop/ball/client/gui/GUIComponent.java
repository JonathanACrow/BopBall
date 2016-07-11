package com.bop.ball.client.gui;

import java.awt.Rectangle;

public abstract class GUIComponent
{
    private Rectangle bounds = new Rectangle();
    
    protected void setBounds(Rectangle bounds)
    {
        this.bounds = bounds;
    }
    public Rectangle getBounds()
    {
        return bounds;
    }
    public abstract void onClick(float mouseX, float mouseY);
    public abstract void onKeyPress(int key);
}