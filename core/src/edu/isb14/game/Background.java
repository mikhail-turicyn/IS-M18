package edu.isb14.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {
    private int position1;
    private int position2;
    private final int speed = 1;
    private Texture texture1;
    private Texture texture2;
    
    public Background(String strBackTexture){
        texture1 = new Texture(Gdx.files.internal(strBackTexture));
        position1 = 0;
        
        texture2 = new Texture(Gdx.files.internal(strBackTexture)); //вторая картинка, чтобы был "непрерывный паровозик"
        position2 = SunsGame.CONFIG_WIDTH;
    }
    
    public void render(SpriteBatch batch){
        update();
        batch.draw(texture1, position1, 0, SunsGame.CONFIG_WIDTH, SunsGame.CONFIG_HEIGHT);
        batch.draw(texture2, position2, 0, SunsGame.CONFIG_WIDTH, SunsGame.CONFIG_HEIGHT);
    }

    public void update(){ //движение картинки
        position1 -= speed;


        if(position1 <= -SunsGame.CONFIG_WIDTH)
            position1 = SunsGame.CONFIG_WIDTH; // не 1280, ибо появляется чёрная вертикальная полоса

        position2 -= speed;
        if(position2 <= -SunsGame.CONFIG_WIDTH)
            position2 = SunsGame.CONFIG_WIDTH;
//        System.out.println("p1="+position1+" p2="+position2+" delta = "+(position2-position1));
    }
}
