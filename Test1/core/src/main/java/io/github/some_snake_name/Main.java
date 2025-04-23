package io.github.some_snake_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.some_snake_name.controller.MenuController;
import io.github.some_snake_name.controller.manage.MainController;

public class Main extends ApplicationAdapter {


    public static void main(String[] args) {
        try {
            Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
            config.setTitle(" Game");
            config.setWindowedMode(640, 640);
            new Lwjgl3Application(new Main(), config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private MainController mainController;

    @Override
    public void create() {
        mainController = new MainController();
        mainController.create();
    }

    @Override
    public void render() {
        mainController.render();
    }


    @Override
    public void resize(int width, int height) {
        mainController.resize(width,height);
    }

    @Override
    public void dispose() {

        mainController.dispose();
    }

}
