package edu.isb14.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SunsGame extends Game {
    public static final int CONFIG_WIDTH = 1280;
    public static final int CONFIG_HEIGHT = 720;

    SpriteBatch batch;
    BitmapFont font;    // для отображения текста
    BitmapFont gameName;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        gameName = new BitmapFont();
        gameName.setColor(Color.RED);

        this.setScreen(new MainMenuScreen(this));

    }

    public void render(){
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        font.dispose();
    }
}
