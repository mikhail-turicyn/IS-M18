package edu.isb14.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SunsGame extends Game {
    public static final int CONFIG_WIDTH = 1280;
    public static final int CONFIG_HEIGHT = 720;

    SpriteBatch batch;

    public enum State{
        Running, Paused
    }

    State state = State.Running;


    @Override
    public void create() {
        batch = new SpriteBatch();


        this.setScreen(new MainMenuScreen(this));

    }

    public void render(){
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();

    }
}
