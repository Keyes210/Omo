package com.alexlowe.omo.states;

import com.alexlowe.omo.Omo;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by dell on 1/10/2016.
 */
public abstract class State {

    protected GSM gsm;
    protected OrthographicCamera cam;
    protected Vector3 mouse;

    protected State(GSM gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, Omo.WIDTH, Omo.HEIGHT);
        mouse = new Vector3();
    }

    public abstract void update(float delta);
    public abstract void render(SpriteBatch batch);
    public abstract void handleInput();
}
