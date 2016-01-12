package com.alexlowe.omo.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by dell on 1/10/2016.
 */
public class GSM {

    private Stack<State> states;

    public GSM(){
        states = new Stack<State>();
    }

    public void push(State s){
        states.push(s);
    }

    public void pop(){
        states.pop();
    }

    public void set(State s){
        states.pop();
        states.push(s);
    }

    public void update(float delta){
        states.peek().update(delta);
    }

    public void render (SpriteBatch batch){
        states.peek().render(batch);
    }
}
