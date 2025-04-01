package io.github.some_snake_name.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

public class SnakeModel {
    private Snake snake;
    private Food food;
    private Profile profile;
    private int score;
    private boolean isGameOver;
    private Camera camera;
    private Map map;
    private Wall wall ;

    public SnakeModel(){
        food = new Food();
        profile=new Profile();
        score =0;
        isGameOver = false;

        map = new Map("Map/Map5/Map/Map5.tmx");
        wall = new Wall(map.getMap());
        snake = new Snake(map.getMap(),
            (com.badlogic.gdx.maps.tiled.TiledMapTileLayer) map.getMap().getLayers().get("Snake and food"), wall, 5, 5);
        camera = new Camera(this.snake);
    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){

            snake.changeDirection(1, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) snake.changeDirection(-1, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) snake.changeDirection(0, 1);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) snake.changeDirection(0, -1);
    }

    public void update(float deltaTime) {
        handleInput();
        snake.update(deltaTime);
        camera.update(deltaTime);
    }

    public void resize(int width, int height) {
        camera.resize(width, height);
    }



    public Snake getSnake() { return snake; }
    public Food getFood() { return food; }
    public Profile getProfile() { return profile; }
    public int getScore() { return score; }
    public boolean getisGameOver(){ return isGameOver;}
    public Camera getCamera(){return camera;}
    public Map getMap(){return map;}
}
