package com.alexlowe.omo.states;

import com.alexlowe.omo.Omo;
import com.alexlowe.omo.ui.Graphic;
import com.alexlowe.omo.ui.TextImage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by dell on 2/4/2016.
 */
public class MenuState extends State {

    private Graphic title;
    private TextImage play;

    public MenuState(GSM gsm){
        super(gsm);
        title = new Graphic(
                Omo.res.getAtlas("pack").findRegion("omo"),
                Omo.WIDTH / 2,
                (Omo.HEIGHT / 2) + 100);

        play = new TextImage("play", Omo.WIDTH / 2, Omo.HEIGHT / 2 - 50);
    }

    @Override
    public void update(float delta) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        //always need a camera when you draw something
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        title.render(batch);
        play.render(batch);
        batch.end();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            mouse.x = Gdx.input.getX();
            mouse.y = Gdx.input.getY();
            cam.unproject(mouse);
            if(play.contains(mouse.x, mouse.y)){
                gsm.set(new DifficultyState(gsm));
            }
        }
    }
}
