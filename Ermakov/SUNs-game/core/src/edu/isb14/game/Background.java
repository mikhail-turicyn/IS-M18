package edu.isb14.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;

public class Background {
    SunsGame game;

    private int position1;
    private Texture backgroundTex;
    private MntnEmmiter mntnEmmiter;
    private CloudEmmiter cloudEmmiter;
    private StatusBar statusBar;

    public Background(String strBackTexture, SunsGame game){
        backgroundTex = new Texture(Gdx.files.internal(strBackTexture));
        position1 = 0;

        cloudEmmiter = new CloudEmmiter();
        mntnEmmiter = new MntnEmmiter();

        this.game = game;

        statusBar = new StatusBar();

    }
    
    public void render(SpriteBatch batch){
        update();
        batch.draw(backgroundTex, position1, 0, SunsGame.CONFIG_WIDTH, SunsGame.CONFIG_HEIGHT);

        mntnEmmiter.render(batch);
        cloudEmmiter.render(batch);
    }

    public void renderStatusBar(SpriteBatch batch, boolean onePlayers){
        statusBar.render1(batch);
        if (!onePlayers){
            statusBar.render2(batch);
        }
    }

    public void update() { //движение картинки

    }


    class MntnEmmiter{
        private String mntnItems[];
        private final int MNTN_COUNTS = 10;
        private Mntn[] mntns;
        private int vib;

        public MntnEmmiter(){
            mntnItems = new String[]{
                    "mntn/mntn 1.png",
                    "mntn/mntn 2.png",
                    "mntn/mntn 3.png",
                    "mntn/mntn 4.png",
                    "mntn/mntn 5.png",
            };

            this.mntns = new Mntn[MNTN_COUNTS];

            for (int i = 0; i < MNTN_COUNTS; i++) {
                vib = (int) (Math.random() * 5.0);
                switch (vib) {
                    case 1: mntns[i] = new Mntn(mntnItems[0]); break;
                    case 2: mntns[i] = new Mntn(mntnItems[1]); break;
                    case 3: mntns[i] = new Mntn(mntnItems[2]); break;
                    case 4: mntns[i] = new Mntn(mntnItems[3]); break;
                    case 5: mntns[i] = new Mntn(mntnItems[4]); break;
                    default: mntns[i] = new Mntn(mntnItems[4]); break;
                }

            }

        }

        public void render(SpriteBatch batch){
            for (int i = 0; i < MNTN_COUNTS; i++) {
                mntns[i].render(batch);
            }
        }

        class Mntn{
            private float speed;
            private Vector2 position;
            private Texture cloudTex;

            public Mntn(String cloudTex){
                this.cloudTex = new Texture(Gdx.files.internal(cloudTex));
                speed = 0.8f;
                position = new Vector2( SunsGame.CONFIG_WIDTH +(float)(3000*Math.random()), 0 );

            }

            public void render(SpriteBatch batch){
                batch.draw(cloudTex, position.x, position.y);
                update();
            }

            public void update(){
                position.x -= speed;
                if (position.x < -1180){
                    position.x = SunsGame.CONFIG_WIDTH +(float)(3000*Math.random());
                    position.y = 0;
                }
            }
        }


    }

    class CloudEmmiter{
        private String cloudItems[];
        private final int CLOUD_COUNTS = 10;
        private Cloud[] clouds;
        private int vib;

        public CloudEmmiter(){
            cloudItems = new String[]{
                    "cloud/cloud_2l_32px.png",
                    "cloud/cloud_2l_48px.png",
                    "cloud/cloud_3l_48px.png",
                    "cloud/cloud_3l_56px.png",
                    "cloud/cloud_3l_72px.png",
                    "cloud/cloud_5l_72px.png",
                    "cloud/cloud_5l_120px.png"
            };

            this.clouds = new Cloud[CLOUD_COUNTS];

            for (int i = 0; i < CLOUD_COUNTS; i++) {
                vib = (int) (Math.random() * 8.0);
                switch (vib) {
                    case 1: clouds[i] = new Cloud(cloudItems[0]); break;
                    case 2: clouds[i] = new Cloud(cloudItems[1]); break;
                    case 3: clouds[i] = new Cloud(cloudItems[2]); break;
                    case 4: clouds[i] = new Cloud(cloudItems[3]); break;
                    case 5: clouds[i] = new Cloud(cloudItems[4]); break;
                    case 6: clouds[i] = new Cloud(cloudItems[5]); break;
                    case 7: clouds[i] = new Cloud(cloudItems[6]); break;
                    default: clouds[i] = new Cloud(cloudItems[6]); break;
                }


            }

        }

        public void render(SpriteBatch batch){
            for (int i = 0; i < CLOUD_COUNTS; i++) {
                clouds[i].render(batch);
            }
        }

        class Cloud{
            private float speed;
            private Vector2 position;
            private Texture cloudTex;

            public Cloud(String cloudTex){
                this.cloudTex = new Texture(Gdx.files.internal(cloudTex));
                speed = 0.5f + (float) Math.random()*1.1f;
                position = new Vector2( 600+ (float)(Math.random()*2000), 500 + (float)(Math.random()*200) );
            }

            public void render(SpriteBatch batch){
                batch.draw(cloudTex, position.x, position.y);
                update();
            }

            public void update(){
                    position.x -= speed;
                if (position.x < -120){
                    position.x = SunsGame.CONFIG_WIDTH + (float) Math.random()*SunsGame.CONFIG_WIDTH;
                    position.y = 500 + (float)(Math.random()*200);
                }
            }
        }


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

            font.draw(batch, "Player1:", 25, SunsGame.CONFIG_HEIGHT - 20);

            for (int i = 0; i < properties.length; i++) {
                font.draw(
                        batch,
                        properties[i],
                        100 + i * 72,
                        SunsGame.CONFIG_HEIGHT - 20
                );
            }

            font.draw(batch, String.valueOf(((GameScreen) game.getScreen()).getPlayer1().getHp()), 125, SunsGame.CONFIG_HEIGHT - 20);
            font.draw(batch, String.valueOf(((GameScreen) game.getScreen()).getPlayer1().getScore()), 217, SunsGame.CONFIG_HEIGHT - 20);

            font.draw(batch, ":", SunsGame.CONFIG_WIDTH/2, SunsGame.CONFIG_HEIGHT - 20 );
            font.draw(batch, String.valueOf(SunsGame.minute), SunsGame.CONFIG_WIDTH/2 - 4, SunsGame.CONFIG_HEIGHT - 20,1f, Align.right,false );
            font.draw(batch, String.valueOf((int)SunsGame.sec), SunsGame.CONFIG_WIDTH/2 + 7, SunsGame.CONFIG_HEIGHT - 20,1f, Align.left,false);
        }

        public void render2(SpriteBatch batch){

            font.draw(batch, "Player2:", 25, SunsGame.CONFIG_HEIGHT - 40);
            // draw prop
            for (int i = 0; i < properties.length; i++) {
                font.draw(
                        batch,
                        properties[i],
                        100 + i * 72,
                        SunsGame.CONFIG_HEIGHT - 40
                );
            }

            font.draw(batch, String.valueOf( ((GameScreen) game.getScreen()).getPlayer2().getHp() ), 125, SunsGame.CONFIG_HEIGHT - 40);
            font.draw(batch, String.valueOf( ((GameScreen) game.getScreen()).getPlayer2().getScore()  ), 217, SunsGame.CONFIG_HEIGHT - 40);
        }

    }
}
