package com.alexlowe.omo.ui;

/**
 * Created by dell on 1/11/2016.
 */
public class Box {
    protected float x;
    protected float y;
    protected float width;
    protected float height;

    //checks if point(x,y) is within a given box
    public boolean contains(float x, float y){
        return x > (this.x - width / 2) &&
                x < (this.x + width / 2) &&
                y < (this.y + height / 2) &&
                y < (this.y + height / 2);
    }
}
