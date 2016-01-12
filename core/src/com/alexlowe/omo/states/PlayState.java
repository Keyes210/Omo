package com.alexlowe.omo.states;

import com.alexlowe.omo.Omo;
import com.alexlowe.omo.ui.Tile;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Created by dell on 1/10/2016.
 */
public class PlayState extends State {
    private Tile[][] tiles;
    private int tileSize;
    private float boardOffset;

    public PlayState(GSM gsm){
        super(gsm);

        tiles = new Tile[4][4];

        tileSize = Omo.WIDTH / tiles[0].length; //tiles[0] is number of cols , tiles.length is rows
        //screen size 480 x 800 FOR 4x4 board:
        // tilesize = 480 / 4 = 120

        boardOffset = (Omo.HEIGHT - (tileSize * tiles.length)) / 2;
        //(800 - 480) / 2

        for (int row = 0; row < tiles.length; row++){
            for (int col = 0; col < tiles[0].length; col++){
                tiles[row][col] = new Tile(
                        (col * tileSize) + (tileSize/2),
                        (row * tileSize) + boardOffset + (tileSize/2),
                        tileSize,
                        tileSize);
            }
        }
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void render(SpriteBatch batch) {
       // System.out.println("D/" + "rimjob" + ": " + "currently rendering");

        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        for (int row = 0; row < tiles.length; row++){
            for (int col = 0; col < tiles[0].length; col++){
                tiles[row][col].render(batch);
            }
        }
        batch.end();
    }

    @Override
    public void handleInput() {
    }
}
