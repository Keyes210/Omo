package com.alexlowe.omo.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.HashMap;

/**
 * Created by dell on 1/11/2016.
 */
public class Content {

    private HashMap<String, TextureAtlas> atlases;

    public Content(){
        atlases = new HashMap<String, TextureAtlas>();
    }

    public void loadAtlas(String path, String key){
        atlases.put(key, new TextureAtlas(Gdx.files.internal(path)));
    }

    public TextureAtlas getAtlas(String key){
        return atlases.get(key);
    }
}
