package edu.isb14.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainMenuScreen implements Screen {
    final SunsGame game;

    // Настройка отображения под разными экранами
    private Viewport viewport;
    private Camera camera;

    private BitmapFont gameName;// для отображения текста
    private BitmapFont font;
//    public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
    private int currentItem; // в начальный момент времени находимся на первом пункте меню - один игрок
    private String menuItems[];

    public MainMenuScreen(final SunsGame gam) {
//        font = TrueTypeFontFactory.createBitmapFont(Gdx.files.internal("font.ttf"), FONT_CHARACTERS, 12.5f, 7.5f, 1.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        font.setColor(1f, 0f, 0f, 1f);
//        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/myfont.ttf"));
//        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
//        parameter.size = 12;
//        BitmapFont font12 = generator.generateFont(parameter); // font size 12 pixels
//        generator.dispose(); // don't forget to dispose to avoid memory leaks!
        this.game = gam;
        // Настройка отображения под разными экранами
        camera = new OrthographicCamera();
        viewport = new FitViewport(SunsGame.CONFIG_WIDTH, SunsGame.CONFIG_HEIGHT, camera);	// отображение экрана с чёрными линииями по краям и сохранение пропорций

        gameName = new BitmapFont();
        gameName.setColor(Color.RED);

        font = new BitmapFont();

        menuItems = new String[]{
                "One Player",
                "Two Players",
                "Highscores",
                "Configurations",
                "Quit"
        };

        currentItem = 0; // в начальный момент времени находимся на первом пункте меню - один игрок

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);	// Цвет фона
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	// Очищает экран при каждом кадре.

        game.batch.begin();

        gameName.draw(game.batch, "SunsGame", (SunsGame.CONFIG_WIDTH)/2, 700);

        // draw menu
        for(int i = 0; i < menuItems.length; i++) {
//            width = font.getBounds(menuItems[i]).width;
            if(currentItem == i) font.setColor(Color.RED);
            else font.setColor(Color.WHITE);
            font.draw(
                    game.batch,
                    menuItems[i],
                    (SunsGame.CONFIG_WIDTH)/2,
                    180 - 35 * i
            );
        }


        game.batch.end();

        handleInput(delta);


//        if ( (Gdx.input.isKeyPressed(Input.Keys.DOWN)) && (target == 1) ) {
//            onePlayer.setColor(Color.WHITE);
//            twoPlayer.setColor(Color.RED);
//            target = 2;
//
//        }
//
//        if ( (Gdx.input.isKeyPressed(Input.Keys.DOWN)) && (target == 2) ){
//            twoPlayer.setColor(Color.WHITE);
//            records.setColor(Color.RED);
//            target = 3;
//        }
//        if ( (Gdx.input.isKeyPressed(Input.Keys.DOWN)) && (target == 3) ){
//            records.setColor(Color.WHITE);
//            config.setColor(Color.RED);
//            target = 4;
//        }
//        if ( (Gdx.input.isKeyPressed(Input.Keys.DOWN)) && (target == 4) ){
//            config.setColor(Color.WHITE);
//            exit.setColor(Color.RED);
//            target = 5;
//        }
//
////        System.out.println("t = "+ target);
//
//        if ( (Gdx.input.isKeyPressed(Input.Keys.UP)) && (target == 5) ){
//            exit.setColor(Color.WHITE);
//            config.setColor(Color.RED);
//            target = 4;
//        } else if (target == 4){
//            config.setColor(Color.WHITE);
//            records.setColor(Color.RED);
//            target = 3;
//        } else if (target == 3){
//            records.setColor(Color.WHITE);
//            twoPlayer.setColor(Color.RED);
//            target = 2;
//        } else  if (target == 4){
//            twoPlayer.setColor(Color.WHITE);
//            onePlayer.setColor(Color.RED);
//            target = 1;
//        }
//
//        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
//            game.setScreen(new GameScreen(game));
//            dispose();
//        }


    }


    public void handleInput(float delta) {

        if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)) {
//            if (currentItem > 0){
//                currentItem--;
//            }
            currentItem = 0;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.NUM_2)) {
//            if (currentItem < menuItems.length -1){
//                currentItem++;
//            }
            currentItem = 1;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.NUM_3)) {
            currentItem = 2;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.NUM_4)) {
            currentItem = 3;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.NUM_5)) {
            currentItem = 4;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            if (currentItem == 0) {
                game.setScreen(new GameScreen(game));
                dispose();
            }

            if (currentItem == 1) {
                Gdx.app.exit();
            }

            if (currentItem == 2) {
                Gdx.app.exit();
            }

            if (currentItem == 3) {
                //gsm.setState(GameStateManager.HIGHSCORES);
            }
            if (currentItem == 4) {
                Gdx.app.exit();
            }
        }

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        gameName.dispose();
        font.dispose();
    }
}
