package edu.isb14.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SunsGame extends Game {
    public static final int CONFIG_WIDTH = 1280;
    public static final int CONFIG_HEIGHT = 720;

    // Timing
    public static float worldTime;
    public static int minute;
    public static float sec;

    SpriteBatch batch;

    public enum State{
        Running, Paused
    }

    State state = State.Running;


    @Override
    public void create() {
        batch = new SpriteBatch();

        worldTime = 0;
        minute = 0;
        sec = 0;

        this.setScreen(new MainMenuScreen(this));

    }

    public void render(){
        super.render();
    }

    public void updateTime(float delta){
        worldTime += delta;

        sec = (int) worldTime - 60*minute;

        if (sec == 60){
            minute++;
            sec = 0;
        }
    }

    public void timeDispose(){
        worldTime = 0;
        sec = 0;
        minute = 0;
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();

    }
}
