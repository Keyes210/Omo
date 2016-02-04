package com.alexlowe.omo.ui;

import com.alexlowe.omo.Omo;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by dell on 2/4/2016.
 */
public class TextImage extends Box{
    private String text;
    private TextureRegion[][] fontSheet;

    public TextImage(String text, float x, float y){
        this.text = text;
        this.x = x;
        this.y = y;

        int size = 50;
        width = size * text.length();
        height = size;

        TextureRegion sheet = Omo.res.getAtlas("pack").findRegion("fontsheet");
        int numCols = sheet.getRegionWidth() / size; //each letter is 50x50
        int numRows = sheet.getRegionHeight() / size;
        fontSheet = new TextureRegion[numRows][numCols];

        for (int row = 0; row < numRows; row++){
            for (int col = 0; col < numCols; col++){
                fontSheet[row][col] = new TextureRegion(
                        sheet,
                        size * col,
                        size * row,
                        size,
                        size
                );
            }
        }
    }

    public void render(SpriteBatch batch){
        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            c -= 'a';
            int index = (int) c;
            int row = index / fontSheet[0].length;
            int col = index % fontSheet[0].length;

            batch.draw(
                    fontSheet[row][col],
                    x - (width / 2) + 50 * i, //increment 50px for each letter
                    y - (height / 2)
            );
        }
    }
}
