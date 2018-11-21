package edu.isb14.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by user on 14.05.2017.
 */
public class ConfigScreen implements Screen{

    final SunsGame game;
    // Настройка отображения под разными экранами
    private Viewport viewport;
    private Camera camera;

    private BitmapFont font;
    private BitmapFont menuName;

    private String menuItems[];
    private int currentItem;

    public ConfigScreen(final SunsGame gam){
        this.game = gam;

        // Настройка отображения под разными экранами
        camera = new OrthographicCamera();
        viewport = new FitViewport(SunsGame.CONFIG_WIDTH, SunsGame.CONFIG_HEIGHT, camera);	// отображение экрана с чёрными линииями по краям и сохранение пропорций

        font = new BitmapFont();
        menuName = new BitmapFont();

        menuItems = new String[]{
                "Save changes",
                "Back to menu"
        };
        currentItem = 0;

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);	// Цвет фона
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	// Очищает экран при каждом кадре.

        game.batch.begin();

        menuName.draw(game.batch, "Configurations", (SunsGame.CONFIG_WIDTH)/2, 700);

        // draw menu
        for(int i = 0; i < menuItems.length; i++) {
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
            // Save changes
            if (currentItem == 0) {
//                game.setScreen(new GameScreen(game, true));
//                dispose();
            }
            // back to menu
            if (currentItem == 1) {
                game.setScreen(new MainMenuScreen(game));
                dispose();
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

    }
}
