package com.alexlowe.omo.states;

import com.alexlowe.omo.Omo;
import com.alexlowe.omo.ui.Tile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Created by dell on 1/10/2016.
 */
public class PlayState extends State {

    private final int MAX_FINGERS = 2;

    private Tile[][] tiles;
    private int tileSize;
    private float boardOffset;
    private int boardHeight;

    public PlayState(GSM gsm){
        super(gsm);

        tiles = new Tile[6][6];

        tileSize = Omo.WIDTH / tiles[0].length; //tiles[0] is number of cols , tiles.length is rows
        //screen size 480 x 800 FOR 4x4 board:
        // tilesize = 480 / 4 = 120

        boardHeight = tileSize * tiles.length;

        boardOffset = (Omo.HEIGHT - boardHeight) / 2;
        //(800 - 480) / 2

        for (int row = 0; row < tiles.length; row++){
            for (int col = 0; col < tiles[0].length; col++){
                tiles[row][col] = new Tile(
                        (col * tileSize) + (tileSize/2),
                        (row * tileSize) + boardOffset + (tileSize/2),
                        tileSize,
                        tileSize);

                tiles[row][col].setTimer((-(tiles.length - row) - col) * 0.05f); //cool tile animation
            }
        }
    }

    @Override
    public void update(float delta) {
        handleInput();
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[0].length; col++) {
                tiles[row][col].update(delta);
            }
        }
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
        for (int i = 0; i < MAX_FINGERS; i++){
            if(Gdx.input.isTouched(i)){ //specifies which pointer i.e. 1st finger, 2nd finger
                mouse.x = Gdx.input.getX(i);
                mouse.y = Gdx.input.getY(i);
                cam.unproject(mouse); //DQGT: changes coordinates from world coords to game coords

                if(mouse.x > 0 && mouse.x < Omo.WIDTH &&
                mouse.y > boardOffset && mouse.y < boardOffset + boardHeight){
                    int row = (int)((mouse.y - boardOffset)/ tileSize);
                    int col = (int)(mouse.x / tileSize);
                    tiles[row][col].setSelected(true);
                }

            }
        }
    }
}
