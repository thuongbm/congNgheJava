package io.github.some_snake_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    private Snake snake;
    private GameCamera cameraController;
    private GameMap mapLoader;

    @Override
    public void create() {
        mapLoader = new GameMap("Map/Map1/examples/Test/ran1.tmx");
        snake = new Snake(mapLoader.getMap(),
            (com.badlogic.gdx.maps.tiled.TiledMapTileLayer) mapLoader.getMap().getLayers().get("snake"),
            5, 5);
        cameraController = new GameCamera(snake);
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.BLACK);
        mapLoader.render(cameraController);

        handleInput();
        snake.update(Gdx.graphics.getDeltaTime());
        cameraController.update(Gdx.graphics.getDeltaTime());
    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) snake.changeDirection(1, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) snake.changeDirection(-1, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) snake.changeDirection(0, 1);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) snake.changeDirection(0, -1);
    }

    @Override
    public void resize(int width, int height) {
        cameraController.resize(width, height);
    }

    @Override
    public void dispose() {
        mapLoader.dispose();
    }

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Snake");
        config.setWindowedMode(640, 640);
        config.setForegroundFPS(60);
        new Lwjgl3Application(new Main(), config);
    }
}
