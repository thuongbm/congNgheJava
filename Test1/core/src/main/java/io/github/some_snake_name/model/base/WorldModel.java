package io.github.some_snake_name.model.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import io.github.some_snake_name.model.*;

public class WorldModel implements IModel{
    private Snake snake;
    private Food food;
    private Profile profile;
    private Camera camera;
    private Map map;
    private Wall wall;
    private Background background;

    public WorldModel(){
        SoundManager.loadSound();

        profile=new Profile();

        map = new Map("Map/Map5/Map/Map5.tmx");
        background = new Background(map.getMap());
        wall = new Wall(map.getMap());
        food = new Food(map.getMap(), wall, background);
        snake = new Snake(map.getMap(),
            (com.badlogic.gdx.maps.tiled.TiledMapTileLayer) map.getMap().getLayers().get("Snake and food"), wall, food,5, 5);        camera = new Camera(this.snake, map.getWorldWidth(), map.getWorldHeight());
        wall = new Wall(map.getMap());

    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            SoundManager.playKey();
            snake.changeDirection(1, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            SoundManager.playKey();
            snake.changeDirection(-1, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            SoundManager.playKey();
            snake.changeDirection(0, 1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            SoundManager.playKey();
            snake.changeDirection(0, -1);
        }
    }

    public void update(float deltaTime) {
        handleInput();
        snake.update(deltaTime);
        camera.update(deltaTime);
    }


    @Override
    public WorldModel getWorldModel() {
        return this;
    }

    public void resize(int width, int height) {
        camera.resize(width, height);
    }

    public Snake getSnake() { return snake; }
    public Food getFood() { return food; }
    public Profile getProfile() { return profile; }
    public Camera getCamera(){return camera;}
    public Map getMap(){return map;}
}
