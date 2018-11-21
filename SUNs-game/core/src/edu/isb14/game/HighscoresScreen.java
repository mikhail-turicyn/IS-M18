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

public class HighscoresScreen implements Screen {
    final SunsGame game;
    // Настройка отображения под разными экранами
    private Viewport viewport;
    private Camera camera;

    private BitmapFont font;
    private BitmapFont quitFont;

    public HighscoresScreen(final SunsGame gam){
        this.game = gam;

        // Настройка отображения под разными экранами
        camera = new OrthographicCamera();
        viewport = new FitViewport(SunsGame.CONFIG_WIDTH, SunsGame.CONFIG_HEIGHT, camera);	// отображение экрана с чёрными линииями по краям и сохранение пропорций

        font = new BitmapFont();
        quitFont = new BitmapFont();

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);	// Цвет фона
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	// Очищает экран при каждом кадре.

        game.batch.begin();

        font.draw(game.batch, "Highscores", (SunsGame.CONFIG_WIDTH)/2, 700);
        quitFont.setColor(Color.RED);
        quitFont.draw(game.batch, "Back to menu", (SunsGame.CONFIG_WIDTH)/2, 100);

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
                game.setScreen(new MainMenuScreen(game));
                dispose();
            }

        game.batch.end();


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
        quitFont.dispose();
        font.dispose();
    }
}
