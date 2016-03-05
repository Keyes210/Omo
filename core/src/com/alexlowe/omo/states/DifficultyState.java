package com.alexlowe.omo.states;

import com.alexlowe.omo.Omo;
import com.alexlowe.omo.ui.TextImage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * Created by dell on 3/4/2016.
 */
public class DifficultyState extends State{

    private Array<TextImage> buttons;

    public DifficultyState(GSM gsm) {
        super(gsm);

        String[] texts = {"easy", "normal", "hard", "insane"};

        buttons = new Array<TextImage>();
        for(int i = 0; i < texts.length; i++){
            buttons.add(new TextImage(
                    texts[i],
                    Omo.WIDTH/2, //middle of the screen
                    Omo.HEIGHT/2 + 100 - 70 * i)); // height changes
        }
    }

    @Override
    public void update(float delta) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {

        batch.setProjectionMatrix(cam.combined);
        batch.begin();

        for (int i = 0; i < buttons.size; i++){
            buttons.get(i).render(batch);
        }

        batch.end();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            mouse.x = Gdx.input.getX();
            mouse.y = Gdx.input.getY();
            cam.unproject(mouse);

            for (int i = 0; i < buttons.size; i++){
                if(buttons.get(i).contains(mouse.x, mouse.y)){
                    gsm.set(new PlayState(gsm, PlayState.Difficulty.values()[i]));
                }
            }
        }
    }
}
