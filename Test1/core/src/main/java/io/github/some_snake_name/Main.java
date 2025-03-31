package io.github.some_snake_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.some_snake_name.controller.MenuController;
import io.github.some_snake_name.model.Wall;

public class Main extends ApplicationAdapter {
    private Snake snake;
    private GameCamera cameraController;
    private GameMap mapLoader;
    private Wall wall;

//    @Override
//    public void create() {
//        mapLoader = new GameMap("Map/Map3/Map/Map3.tmx");
//        wall = new Wall(mapLoader.getMap());
//        snake = new Snake(mapLoader.getMap(),
//            (com.badlogic.gdx.maps.tiled.TiledMapTileLayer) mapLoader.getMap().getLayers().get("Snake and food"),
//            wall, 5, 5);
//
//        cameraController = new GameCamera(snake);
//    }
//
//    @Override
//    public void render() {
//        ScreenUtils.clear(Color.BLACK);
//        mapLoader.render(cameraController);
//
//        handleInput();
//        snake.update(Gdx.graphics.getDeltaTime());
//        cameraController.update(Gdx.graphics.getDeltaTime());
//    }
//
//    private void handleInput() {
//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) snake.changeDirection(1, 0);
//        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) snake.changeDirection(-1, 0);
//        if (Gdx.input.isKeyPressed(Input.Keys.UP)) snake.changeDirection(0, 1);
//        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) snake.changeDirection(0, -1);
//    }
//
//    @Override
//    public void resize(int width, int height) {
//        cameraController.resize(width, height);
//    }
//
//    @Override
//    public void dispose() {
//        mapLoader.dispose();
//    }

    public static void main(String[] args) {
        try {
            Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
            config.setTitle("Snake Game");
            config.setWindowedMode(640, 600);
            new Lwjgl3Application(new Main(), config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private MenuController menuController;

    @Override
    public void create() {
        menuController = new MenuController();
    }

    @Override
    public void render() {
        menuController.render();
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {

        menuController.dispose();
    }
}
