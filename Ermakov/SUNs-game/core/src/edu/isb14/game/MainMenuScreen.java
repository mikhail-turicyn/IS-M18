package edu.isb14.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
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

    private Texture texStar;
    private final int STAR_COUNTS = 30;
    private Star[] stars;

    public MainMenuScreen(final SunsGame gam) {
//        font = TrueTypeFontFactory.createBitmapFont(Gdx.files.internal("font.ttf"), FONT_CHARACTERS, 12.5f, 7.5f, 1.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        font.setColor(1f, 0f, 0f, 1f);
//        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/myfont.ttf"));
//        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
//        parameter.size = 12;
//        BitmapFont font12 = generator.generateFont(parameter); // font size 12 pixels
//        generator.dispose(); // don't forget to dispose to avoid memory leaks!
        texStar = new Texture("star12.tga");
        stars = new Star[STAR_COUNTS];
        for (int i = 0; i<STAR_COUNTS; i++){
            stars[i] = new Star();
        }

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
        update();

        Gdx.gl.glClearColor(0, 0, 0, 1);    // Цвет фона
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);    // Очищает экран при каждом кадре.

        game.batch.begin();

        //draw stars
        for (int i = 0; i<STAR_COUNTS; i++){
            game.batch.draw(texStar, stars[i].position.x, stars[i].position.y);
        }

        gameName.draw(game.batch, "SunsGame", (SunsGame.CONFIG_WIDTH) / 2, 700);

        // draw menu
        for (int i = 0; i < menuItems.length; i++) {
            if (currentItem == i) font.setColor(Color.RED);
            else font.setColor(Color.WHITE);
            font.draw(
                    game.batch,
                    menuItems[i],
                    (SunsGame.CONFIG_WIDTH) / 2,
                    180 - 35 * i
            );
        }


        game.batch.end();

        handleInput();
    }

    public void handleInput() {

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            if (currentItem > 0){
                currentItem--;
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            if (currentItem < menuItems.length -1){
                currentItem++;
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            // One Player
            if (currentItem == 0) {
                game.setScreen(new GameScreen(game, true));
                dispose();
            }
            // Two Players
            if (currentItem == 1) {
                game.setScreen(new GameScreen(game, false));
                dispose();
            }
            // Highscores
            if (currentItem == 2) {
                game.setScreen(new HighscoresScreen(game));
            }
            // Configurations
            if (currentItem == 3) {
                game.setScreen(new ConfigScreen(game));
            }
            // Quit
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
        texStar.dispose();
        gameName.dispose();
        font.dispose();
    }

    public void update(){
        for (int i = 0; i < STAR_COUNTS; i++) {
            stars[i].update();
        }
    }

    class Star{
        private Vector2 position;
        private float speed;

        public Star(){
            position = new Vector2( (float) Math.random()*SunsGame.CONFIG_WIDTH, (float) Math.random()*(SunsGame.CONFIG_HEIGHT) + SunsGame.CONFIG_HEIGHT );
            speed = 0.5f + (float) Math.random()*1.1f; // 5px в кадр , эт плохо. нужно привязываться ко времени, которое прошло с последнего обновлния экрана
        }

        public void update(){
            position.y -= speed;

            if (position.y < -40){
                position.x = (float) Math.random()*SunsGame.CONFIG_WIDTH;
                position.y = (float) Math.random()*(SunsGame.CONFIG_HEIGHT) + SunsGame.CONFIG_HEIGHT;
            }
        }
    }
}
