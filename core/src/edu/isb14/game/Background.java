package edu.isb14.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;

public class Background {
    SunsGame game;

    private int position1;
    private int position2;
    private final int speed = 1;
    private Texture texture1;
//    private Texture texture2;
    private Texture mntn1;
    private Texture mntn2;
    private Texture mntn3;
    private Texture mntn4;
    private Texture mntn5;
    private float mntn1Pos;
    private final float mntnSpeed = 0.8f;
    private float worldTime;

    private StatusBar statusBar;

    public Background(String strBackTexture){
        texture1 = new Texture(Gdx.files.internal(strBackTexture));
        position1 = 0;

        mntn1 = new Texture(Gdx.files.internal("mntn 1.png"));
        mntn2 = new Texture(Gdx.files.internal("mntn 2.png"));
        mntn3 = new Texture(Gdx.files.internal("mntn 3.png"));
        mntn4 = new Texture(Gdx.files.internal("mntn 4.png"));
        mntn5 = new Texture(Gdx.files.internal("mntn 5.png"));
        mntn1Pos = 1000f;

//        texture2 = new Texture(Gdx.files.internal(strBackTexture)); //вторая картинка, чтобы был "непрерывный паровозик"
//        position2 = SunsGame.CONFIG_WIDTH;

        statusBar = new StatusBar();
        worldTime = 0;

    }
    
    public void render(SpriteBatch batch){
        update();
        batch.draw(texture1, position1, 0, SunsGame.CONFIG_WIDTH, SunsGame.CONFIG_HEIGHT);
//        batch.draw(texture2, position2, 0, SunsGame.CONFIG_WIDTH, SunsGame.CONFIG_HEIGHT);

        //mntn
        worldTime+=Gdx.graphics.getDeltaTime();
        if(worldTime >= 5){
            batch.draw(mntn1, mntn1Pos, 0);
        }


    }

    public void renderStatusBar(SpriteBatch batch, boolean onePlayers){
        statusBar.render1(batch);
        if (!onePlayers){
            statusBar.render2(batch);
        }
    }

    public void update() { //движение картинки
//        position1 -= speed;
//
//        if (position1 <= -SunsGame.CONFIG_WIDTH)
//            position1 = SunsGame.CONFIG_WIDTH; // не 1280, ибо появляется чёрная вертикальная полоса
//
//        position2 -= speed;
//        if (position2 <= -SunsGame.CONFIG_WIDTH)
//            position2 = SunsGame.CONFIG_WIDTH;
//        System.out.println("p1="+position1+" p2="+position2+" delta = "+(position2-position1));

        mntn1Pos -= mntnSpeed;
    }


    class StatusBar {
        private BitmapFont font;
        private String properties[];

        public StatusBar() {
            font = new BitmapFont();

            properties = new String[]{
                    "Hp:",
                    "Score:",
            };
        }

        public void render1(SpriteBatch batch) {

            // draw prop
            for (int i = 0; i < properties.length; i++) {
                font.draw(
                        batch,
                        properties[i],
                        100 + i * 100,
                        SunsGame.CONFIG_HEIGHT - 20
                );
            }

            font.draw(batch, String.valueOf(GameScreen.getPlayer1().getHp()), 125, SunsGame.CONFIG_HEIGHT - 20);
            font.draw(batch, String.valueOf(GameScreen.getPlayer1().getScore()), 245, SunsGame.CONFIG_HEIGHT - 20);


            font.draw(batch, ":", SunsGame.CONFIG_WIDTH/2, SunsGame.CONFIG_HEIGHT - 20 );
            font.draw(batch, String.valueOf((int)SunsGame.sec), SunsGame.CONFIG_WIDTH/2 - 4, SunsGame.CONFIG_HEIGHT - 20,1f, Align.right,false );
            font.draw(batch, String.valueOf((int)SunsGame.sec), SunsGame.CONFIG_WIDTH/2 + 7, SunsGame.CONFIG_HEIGHT - 20,1f, Align.left,false);
        }

        public void render2(SpriteBatch batch){

            // draw prop
            for (int i = 0; i < properties.length; i++) {
                font.draw(
                        batch,
                        properties[i],
                        SunsGame.CONFIG_WIDTH/2 + 100 + i * 100,
                        SunsGame.CONFIG_HEIGHT - 20
                );
            }

            font.draw(batch, String.valueOf(GameScreen.getPlayer2().getHp()), SunsGame.CONFIG_WIDTH/2 + 125, SunsGame.CONFIG_HEIGHT - 20);
            font.draw(batch, String.valueOf(GameScreen.getPlayer2().getScore()), SunsGame.CONFIG_WIDTH/2 + 245, SunsGame.CONFIG_HEIGHT - 20);
        }

    }
}
