package edu.isb14.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SunsGame extends ApplicationAdapter {
	public static final int CONFIG_WIDTH = 1280;
	public static final int CONFIG_HEIGHT = 720;
	public static final int FRAME_ROWS = 5;
	public static final int FRAME_COLS = 6;

	private SpriteBatch batch;
	OrthographicCamera camera1;
	private Background background;
	// Настройка отображения под разными экранами
	private Viewport viewport;
	private Camera camera;
	// Анимация человечка
	private AnimationGame walkAnimation;
	// ---
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
//		camera1.setToOrtho(false, 800, 480);
		background = new Background("back.png");

		camera = new PerspectiveCamera();
		viewport = new FitViewport(CONFIG_WIDTH, CONFIG_HEIGHT, camera);

		walkAnimation = new AnimationGame("sprite-animation4.png", FRAME_ROWS, FRAME_COLS, 0.02f, false);

	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);	// Цвет фона
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	// Очищает экран при каждом кадре.

		batch.begin();
		background.render(batch);	// Отрисовка фона
		walkAnimation.render(batch);	// Отрисовка бегущего человечка
//		batch.draw(currentFrameExplosion, 200, 200);
		batch.end();
	}

	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	private void update(){
//		stateTimeExplosion += Gdx.graphics.getDeltaTime(); //  Добавляет время в stateTimeExplosion, прошедшее с момента последней визуализации.
//		currentFrameExplosion = explosionAnimation.getKeyFrame(stateTimeExplosion, true);	// Возвращает послений фрейм, для отрисовки
	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		img.dispose();
	}
}
