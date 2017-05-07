package edu.isb14.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainMenuScreen implements Screen {

    final SunsGame game;
    // Настройка отображения под разными экранами
    private Viewport viewport;
    private Camera camera;

    public MainMenuScreen(final SunsGame gam) {
        this.game = gam;
        // Настройка отображения под разными экранами
        camera = new OrthographicCamera();
        viewport = new FitViewport(SunsGame.CONFIG_WIDTH, SunsGame.CONFIG_HEIGHT, camera);	// отображение экрана с чёрными линииями по краям и сохранение пропорций

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
//        update();
        Gdx.gl.glClearColor(0, 0, 0, 1);	// Цвет фона
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	// Очищает экран при каждом кадре.

        game.batch.begin();

//        background.render(batch);	// Отрисовка фона
//        //walkAnimation.render(batch);	// Отрисовка бегущего человечка
//        player1.render(batch);		// Отрисовка игрока
//        player2.render(batch);		// Отрисовка игрока
//        if (badGuy.isActive()){
//            badGuy.render(batch);
//            badGuy.bulletRender(batch);
//        }
        game.gameName.draw(game.batch, "SunsGame", 100, 700);
        game.font.draw(game.batch, "Press SPACE to play", 100, 150); // отображает текст на экране

        game.batch.end();
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            game.setScreen(new GameScreen(game));
            dispose();
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
