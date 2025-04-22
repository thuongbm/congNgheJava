package io.github.some_snake_name.controller.manage;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import io.github.some_snake_name.model.base.IModel;
import io.github.some_snake_name.model.base.WorldModel;

public class MainController extends ApplicationAdapter {
    private enum ScreenState {
        MENU, GAME, PROFILE, MAP_LEVEL
    }
    private IModel imodel;
    private ScreenState currentScreen;
    private MenuController menuController;
    private GameplayController gameController;
    private ProfileController profileController;

    @Override
    public void create() {
        createmodel();
        menuController = new MenuController(this);
        gameController = new GameplayController(this);
        profileController = new ProfileController(this);

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

        }
    }

    @Override
    public void dispose() {
        menuController.close();
        gameController.close();
        profileController.close();

    }

    // Các phương thức chuyển màn hình thủ công
    public void switchToGame() {
        gameController.create();
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

    public void createmodel(){
        imodel = new WorldModel();
    }
    public IModel getImodel(){return imodel;}
}
