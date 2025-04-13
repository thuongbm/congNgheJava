package io.github.some_snake_name.controller.manager;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import io.github.some_snake_name.model.SnakeModel;
import io.github.some_snake_name.model.WorldModel;
import io.github.some_snake_name.model.base.IModel;

import java.awt.*;

public class MainController extends ApplicationAdapter {
    private enum ScreenState {
        MENU, GAME, PROFILE, MAP_LEVEL
    }
    private IModel imodel;
    private ScreenState currentScreen;
    private MenuController menuController;
    private GamePlayController gameController;
    private ProfileController profileController;
    private MapSelectController mapController;

    @Override
    public void create() {
        imodel = new WorldModel();
        menuController = new MenuController(this);
        gameController = new GamePlayController(this);
        profileController = new ProfileController(this);
        mapController = new MapSelectController(this);

        currentScreen = ScreenState.MENU;
        menuController.create();


    }

    @Override
    public void render() {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Vẽ màn hình hiện tại
        switch (currentScreen) {
            case MENU:
                menuController.start();
                break;
            case GAME:
                gameController.start();
                break;
            case PROFILE:
                profileController.start();
                break;
            case MAP_LEVEL:
                mapController.start();
                break;
        }
    }

    @Override
    public void resize (int width, int height) {
        switch (currentScreen) {
            case MENU:
                menuController.resize(width, height);
                break;
            case GAME:
                gameController.resize(width, height);
                break;
            case PROFILE:
                profileController.resize(width, height);
                break;
            case MAP_LEVEL:
                mapController.resize(width, height);
                break;
        }
    }

    @Override
    public void dispose() {
        menuController.close();
        gameController.close();
        profileController.close();
        mapController.close();
    }

    // Các phương thức chuyển màn hình thủ công
    public void switchToGame() {
        gameController.create();
        currentScreen = ScreenState.GAME;
    }

    public void switchToGame(int level) {
        //gameController.createWithLevel(level);
        currentScreen = ScreenState.GAME;
    }

    public void switchToMenu() {
        menuController.create();
        currentScreen = ScreenState.MENU;
    }

    public void switchToProfile() {
        profileController.create();
        currentScreen = ScreenState.PROFILE;
    }

    public void switchToMapOption() {
        mapController.create();
        currentScreen = ScreenState.MAP_LEVEL;
    }

    public IModel getImodel(){return imodel;}
}
