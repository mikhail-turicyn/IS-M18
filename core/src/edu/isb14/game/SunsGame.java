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

	SpriteBatch batch;
	OrthographicCamera camera1;
	Texture img;
	// hi
	private Viewport viewport;
	private Camera camera;

	Animation explosionAnimation;
	TextureRegion[] explosionFrames;
	TextureRegion currentFrameExplosion;
	float stateTimeExplosion = 0;

//	ImageButton button;
//	ImageButton.ImageButtonStyle buttonStyle;

//	public void show()
//	{
//		//назначаете позицию, размер, стиль вышеперечисленных кнопки и стиля
//
//		TextureAtlas mainMenuAtlas = Assets.manager.get("mainmenu/mainMenu.atlas", TextureAtlas.class);//если есть менеджер ассетов - загрузите ваш атлас с изображениями
//		Skin buttonsSkin = new Skin(mainMenuAtlas);
//
//		ImageButton.ImageButtonStyle connectToHost = new ImageButton.ImageButtonStyle();
//		connectToHost.up = buttonsSkin.getDrawable("menu-connect-btn");//кнопка не нажата
//		connectToHost.over = buttonsSkin.getDrawable("menu-connect-btn");
//		connectToHost.down = buttonsSkin.getDrawable("menu-connect-btn-down"); // кнопка нажата
//
//		ImageButton gameClientButton = new ImageButton(connectToHost);
//		gameClientButton.setSize(100, 200);// размер кнопки
//		gameClientButton.setPosition(10, 10); // позиция кнопки(с нижнего левого угла координаты считаются)
////		gameClientButton.addListener(new ClientListener()); //действие при нажатии
//		stage.addActor(gameClientButton ); //добавляем кнопку к сцене
//	}
//
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
//		camera1.setToOrtho(false, 800, 480);
		img = new Texture(Gdx.files.internal("back.png"));

		camera = new PerspectiveCamera();
		viewport = new FitViewport(1920, 1080, camera);

		explosionFrames = AnimationGame.getFrames("sprite-animation4.png",FRAME_ROWS,FRAME_COLS);
		explosionAnimation = new Animation(0.02f,explosionFrames);
		stateTimeExplosion = 0;

	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);	// Цвет фона
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	// Очищает экран при каждом кадре.

		batch.begin();
		batch.draw(img, 0, 0, CONFIG_WIDTH, CONFIG_HEIGHT);

		batch.draw(currentFrameExplosion, 200, 200);
		batch.end();
	}

	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	public void update(){
		stateTimeExplosion += Gdx.graphics.getDeltaTime(); //  Добавляет время в stateTimeExplosion, прошедшее с момента последней визуализации.
		currentFrameExplosion = explosionAnimation.getKeyFrame(stateTimeExplosion, true);	// Возвращает послений фрейм, для отрисовки
	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		img.dispose();
	}
}
