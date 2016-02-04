package com.alexlowe.omo.ui;

import com.alexlowe.omo.Omo;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by dell on 1/11/2016.
 */
public class Tile extends Box{

    private TextureRegion light;
    private TextureRegion dark;

    private boolean selected;

    private float totalWidth;
    private float totalHeight;
    private float timer;
    private float maxTime = 0.5f;

    public Tile(float x, float y, float width, float height){
        //every time a new box is created, have to specify these attributes
        this.x = x;
        this.y = y;
        this.totalWidth = width - 8;
        this.totalHeight = height - 8;

        this.width = 0;
        this.height = 0;

        light = Omo.res.getAtlas("pack").findRegion("light");
        dark = Omo.res.getAtlas("pack").findRegion("dark");
    }

    public void setTimer(float t){
        timer = t;
    }

    public void setSelected(boolean b){
        selected = b;
    }

    public boolean isSelected(){
        return selected;
    }


    public void update(float delta){
        if(width < totalWidth && height < totalHeight){
            timer += delta;
            width = (timer / maxTime) * totalWidth;
            height = (timer / maxTime) * totalHeight;
            if(width < 0) width = 0;
            if (height < 0) height = 0;
            if(width > totalWidth){
                width = totalWidth;
            }
            if(height > totalHeight){
                height = totalHeight;
            }
        }
    }

    public void render(SpriteBatch batch){
        if (selected){
            batch.draw(light, x - (width / 2), y - (height / 2), width, height);
            //center focused, so need to add "- width/2" etc. to draw at bottom left corner
        }else{
            batch.draw(dark, x - (width / 2), y - (height / 2), width, height);
        }
    }

}
