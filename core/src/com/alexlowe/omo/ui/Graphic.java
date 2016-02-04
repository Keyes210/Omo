package com.alexlowe.omo.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by dell on 2/4/2016.
 */
public class Graphic extends Box{

    private TextureRegion image;

    public Graphic(TextureRegion image, float x, float y){
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = image.getRegionWidth();
        this.height = image.getRegionHeight();
    }

    public void render(SpriteBatch batch){
        batch.draw(image, x - width / 2, y - height / 2);
    }
}
