package edu.isb14.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationGame {
    private TextureRegion currentFrame;
    private float stateTimeExplosion = 0;
    private  Animation animation;
    private boolean loop;

    AnimationGame(String strTex, int frame_rows, int frame_cols, float time, boolean loop){
        this.loop = loop;

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

        animation = new Animation(time,frames);
    }

    public void render(SpriteBatch batch){

        if (animation.isAnimationFinished(stateTimeExplosion) == false || loop == true ){
            stateTimeExplosion += Gdx.graphics.getDeltaTime(); //  Добавляет время в stateTimeExplosion, прошедшее с момента последней визуализации.
            currentFrame = animation.getKeyFrame(stateTimeExplosion, loop);	// Возвращает послений фрейм, для отрисовки
            batch.draw(currentFrame, 0, 0);
        }

    }

}

/*  MANUAL
Класс для более простой работы с анимацией
Выглядит так: AnimationGame("sprite-animation4.png", FRAME_ROWS, FRAME_COLS, 0.02f, false);

AnimationGame - имя класса
getFrames - имя статического метода(статический, для того, чтобы не создавать объект класса
1 параметр - имя текстуры ( здесь текстура это набор картинок (кадры) для анимации
2 параметр - кол-во строк в этой текстуре
3 параметр - кол-во стобцов в этой текстуре
4 параметр - время отрисовки одного спрайта
5 параметр - loop - повторяющаяся анимация или нет

 */