package edu.isb14.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {
    private Texture texture;
    public Background(String strBackTexture){
        texture = new Texture(Gdx.files.internal(strBackTexture));
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, 0, 0, SunsGame.CONFIG_WIDTH, SunsGame.CONFIG_HEIGHT);
    }
}
