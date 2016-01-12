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

    public Tile(float x, float y, float width, float height){
        //every time a new box is created, have to specify these attributes
        this.x = x;
        this.y = y;
        this.width = width - 8;
        this.height = height - 8;

        light = Omo.res.getAtlas("pack").findRegion("light");
        dark = Omo.res.getAtlas("pack").findRegion("dark");
    }

    public void update(float delta){}

    public void render(SpriteBatch batch){
        batch.draw(light, x - (width/2), y - (height/2), width, height);
        //center focused, so need to add "- width/2" etc. to draw at bottom left corner
    }

}
