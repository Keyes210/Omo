package com.alexlowe.omo;

import com.alexlowe.omo.handler.Content;
import com.alexlowe.omo.states.GSM;
import com.alexlowe.omo.states.PlayState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Omo extends ApplicationAdapter {

	public static final String TITLE = "Omo";
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	//static so that's it's visible everywhere
	public static Content res;

    private GSM gsm;
    private SpriteBatch batch;

	@Override
	public void create () {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);

		res = new Content();

		//path is relative to the assets folder
		res.loadAtlas("pack.pack", "pack");

        batch = new SpriteBatch();
        gsm = new GSM();
        gsm.push(new PlayState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
	}
}
