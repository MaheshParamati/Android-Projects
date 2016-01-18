package com.example.paramati.breakoutgame;

/**
 * Created by paramati on 11/25/2015.
 */
import android.graphics.*;

import java.util.Random;

public class Ball
{
    private RectF rec;   // Here we are assuming the ball to be a rectangle in shape which consists of four coordinates so that it is easy for during the intersection with the paddle
    float x_speed;  // this for setting the movement speed of the ball
    float y_speed;
    float ballWidth = 10;   // this setting the dimensions of the ball
    float ballHeight = 10;

    public Ball(int screenX, int screenY,float ballspeedstatus){

        // Setting the initial speed
        x_speed = 450*ballspeedstatus;
        y_speed = -650*ballspeedstatus;
        rec = new RectF();
    }

    public RectF getRect()
    {
        return rec;
    }

    public void update(long fps)  // this function is to update ball movement whenever if changes the postion this is written by Kartheek Anumolu kxa152730
    {
        rec.left = rec.left + (x_speed / fps);     // here we are updating all the four coordinates for the rectF
        rec.top = rec.top + (y_speed / fps);
        rec.right = rec.left + ballWidth;
        rec.bottom = rec.top - ballHeight;
    }

    public void reverseY()    // this function is for reverse movement of x axis done by Kartheek Anumolu kxa152730
    {
        y_speed = -y_speed;
    }

    public void reverseX()  // Similarly this function is for reverse movement of y axis
    {
        x_speed = - x_speed;
    }

    public void setrandom_X_speed(){  // this method is for generating the random number for the next setting the random speed written by Mahesh Paramati
        Random speed = new Random();
        int new_speed = speed.nextInt(2);

        if(new_speed == 0)  // if by anychance the random number generated is zero then do the reverse movement of x
        {
            reverseX();
        }
    }

    public void clearObstacleY(float y)
    {
        rec.bottom = y;
        rec.top = y - ballHeight;
    }

    public void clearObstacleX(float x){
        rec.left = x;
        rec.right = x + ballWidth;
    }

    public void reset(int x, int y)
    {
        rec.left = x *11/24;
        rec.top = y-20;
        rec.right = x*13/24 + ballWidth;
        rec.bottom = y;
    }

}