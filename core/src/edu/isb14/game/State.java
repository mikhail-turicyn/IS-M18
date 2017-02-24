package edu.isb14.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! СКОРЕЕ ВСЕГО НЕ ПОНАДОБИТСЯ
// Класс, описывающий состояние объекта
public class State {
    private int hp = 0;
    private int score = 0;
    private int attack = 1;
    private float speed = 1;
    private int fireRate = 1;       //
    private int fireCounter = 0;    // how many time press SPACE
    private Vector2 position;
    private Rectangle rect;
    public State(){


    }

    public void plusHp(int hpChange){
        hp += hpChange;
    }

    public void setHp(int hpChange){
        hp = hpChange;
    }

    public int getHp(){
        return hp;
    }

    public void plusScore(int scoreChange){
        score += scoreChange;
    }

    public int getScore(){
        return score;
    }

    public void setAttack(int attackChange){
        attack = attackChange;
    }

    public int getAttack(){
        return attack;
    }

    public void setSpeed(float speedChange){
        speed = speedChange;
    }

    public float getSpeed(){
        return speed;
    }

    public void setPosition(Vector2 positionChange){
        position = positionChange;
    }

    public void setPosition(float x, float y){
        position.x = x;
        position.y = y;
    }

    public Vector2 getPosition(){
        return position;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public int getFireCounter() {
        return fireCounter;
    }

    public void setFireCounter(int fireCounter) {
        this.fireCounter = fireCounter;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }
}
