package edu.isb14.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends ApplicationAdapter implements Screen{

	final SunsGame game;
	private SpriteBatch batch;
	OrthographicCamera camera1;
	private Background background;
	// Настройка отображения под разными экранами
	private Viewport viewport;
	private Camera camera;
	// Анимация человечка
	private AnimationGame walkAnimation;
	// Противники
    private MediumEnemy badGuy;
	// Игроки
	private Hero player1;
	private Hero player2;

	public GameScreen (final SunsGame gam) {		// используем конструткор вместо метода create при работе с экранами
		this.game = gam;
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		background = new Background("back.png");
                badGuy = new MediumEnemy("enemy.png");

		//camera = new PerspectiveCamera();

		viewport = new FitViewport(SunsGame.CONFIG_WIDTH, SunsGame.CONFIG_HEIGHT, camera);	// отображение экрана с чёрными линииями по краям и сохранение пропорций

		walkAnimation = new AnimationGame("sprite-animation4.png", 5, 6, 0.02f, false);

		player1 = new Hero(Hero.Player.P1);
		player2 = new Hero(Hero.Player.P2);

	}

	@Override
	public void render (float delta) {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);	// Цвет фона
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	// Очищает экран при каждом кадре.

		game.batch.begin();

		background.render(game.batch);	// Отрисовка фона
		//walkAnimation.render(batch);	// Отрисовка бегущего человечка
		player1.render(game.batch);		// Отрисовка игрока
		player2.render(game.batch);		// Отрисовка игрока
                if (badGuy.isActive()){
                    badGuy.render(game.batch);
                    badGuy.bulletRender(game.batch);
                }
		game.batch.end();
	}

	@Override
	public void show() {

	}


	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	@Override
	public void hide() {

	}

	private void update(){

            if (badGuy.isActive())
                badGuy.update();
            
            for(int i = 0; i < player1.bulletEmitter.getBulletsCount(); i++){
                if (player1.bulletEmitter.bullets[i].isActive())
                    if(badGuy.getHitBox().contains(player1.bulletEmitter.bullets[i].getPosition()) ){
                        badGuy.getDamage(player1.getAttack()); //надо бы получить доступ к полю урона игрока
                        player1.bulletEmitter.bullets[i].destroy();
                    }
            }
	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
	}
}
