package com.example.paramati.breakoutgame;

import android.graphics.RectF;

public class Brick {

    private RectF rec;

    private boolean isVisible;  // initializing a boolean value to set the visible status either true or false

    public Brick(int row, int column, int width, int height) // this is method to form the bricks based on the four coordinates of the rectf
    {
        // This method is a combined one written by both mahesh Paramati and Kartheek Anumolu

        isVisible = true;

        int padding = 1;

        rec = new RectF(column * width + padding,
                row * height + padding,
                column * width + width - padding,
                row * height + height - padding);
    }

    public RectF getRect()   // get method to return the rectangle with the coordinates

    {
        return this.rec;
    }

    public void setInvisible()   // method to set the bricks invisible
    {
        isVisible = false;
    }

    public boolean getVisibility()   // method to set the bricks visible
    {
        return isVisible;
    }
}