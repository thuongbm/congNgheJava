package io.github.some_snake_name.controller.manage;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import io.github.some_snake_name.controller.base.IControllerGame;
import io.github.some_snake_name.controller.base.IControllerMenu;
import io.github.some_snake_name.controller.base.IControllerProfile;
import io.github.some_snake_name.model.base.IModel;
import io.github.some_snake_name.model.base.WorldModel;
import io.github.some_snake_name.model.data.DataAccess;
import io.github.some_snake_name.model.data.ProfileDA;

import java.sql.Connection;
import java.sql.SQLException;

public class MainController extends ApplicationAdapter {
    private enum ScreenState {
        MENU, GAME, PROFILE, MAP_LEVEL
    }
    private IModel imodel;
    private ScreenState currentScreen;
    private IControllerMenu menuController;
    private IControllerGame gameController;
    private IControllerProfile profileController;
    private DataAccess dataAccess;

    @Override
    public void create() {
        createmodel();
        createDA();
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
        try{
            dataAccess.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    public void createDA(){
        dataAccess = new DataAccess();

        try{
            dataAccess.createConnection();
            //
            Connection conn = dataAccess.getConnection();
            //
            ProfileDA profileDA = new ProfileDA(conn);
            if(!profileDA.hasAccount()){
                profileDA.createDefaultAccount();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public IModel getImodel(){return imodel;}
    public DataAccess getDataAccess(){return dataAccess;}

}
