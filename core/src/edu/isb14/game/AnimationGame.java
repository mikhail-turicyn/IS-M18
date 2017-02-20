package edu.isb14.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

abstract class AnimationGame {

    AnimationGame(){}

    static TextureRegion[] getFrames(String strTex, int frame_rows, int frame_cols){
        Texture texture;
        texture = new Texture(Gdx.files.internal(strTex));	// Загрузка сета текстур
        TextureRegion[] frames = new TextureRegion[frame_rows*frame_cols];	// Массив фреймов

        // TextureRegion.split - разбивает текстуру на фреймы в двумерный массив
        TextureRegion tmp[][] = TextureRegion.split(texture, texture.getWidth() / frame_cols, texture.getHeight() / frame_rows);

        // помещаем двумерный массив в одномерный, для использования анимации
        int index = 0;
        for (int i = 0; i < frame_rows; i++)
            for (int j = 0; j < frame_cols; j++)
                frames[index++] = tmp[i][j];

        return frames;
    }
}

/*  MANUAL
Класс для более простой работы с анимацией
Выглядит так:
AnimationGame.getFrames("строка_адресс_текстуры",FRAME_ROWS,FRAME_COLS);

AnimationGame - имя класса
getFrames - имя статического метода(статический, для того, чтобы не создавать объект класса
1 параметр - имя текстуры ( здесь текстура это набор картинок (кадры) для анимации
2 параметр - кол-во строк в этой текстуре
3 параметр - кол-во стобцов в этой текстуре
Возвращаемое значение - массив фреймов, которые можно сразу использовать для отрисовки анимации с помощью класса libGDX - Animation

--ПРИМЕР
public class SunsGame extends ApplicationAdapter {
    ----
    public static final int FRAME_ROWS = 3;
	public static final int FRAME_COLS = 3;

	Animation explosionAnimation;
	TextureRegion[] explosionFrames;
	TextureRegion currentFrameExplosion;
	float stateTimeExplosion = 0;


public void create ()
    ------------
    explosionFrames = AnimationGame.getFrames("boom.png",FRAME_ROWS,FRAME_COLS);
	explosionAnimation = new Animation(0.1f,explosionFrames);
	stateTimeExplosion = 0;
	------

public void render () {
		update();
    ------
		batch.begin();
		batch.draw(currentFrameExplosion, 200, 200);
		batch.end();
	}

	public void update(){
		stateTimeExplosion += Gdx.graphics.getDeltaTime(); //  Добавляет время в stateTimeExplosion, прошедшее с момента последней визуализации.
		currentFrameExplosion = explosionAnimation.getKeyFrame(stateTimeExplosion, true);	// Возвращает послений фрейм, для отрисовки
	}

 */