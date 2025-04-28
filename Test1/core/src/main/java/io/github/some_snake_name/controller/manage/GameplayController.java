package io.github.some_snake_name.controller.manage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import io.github.some_snake_name.controller.base.IControllerGame;
import io.github.some_snake_name.model.data.ProfileDA;
import io.github.some_snake_name.view.base.IViewGameplay;
import io.github.some_snake_name.view.screen.GameoverScreen;
import io.github.some_snake_name.view.screen.GamplayScreen;

import java.sql.Connection;

public class GameplayController implements IControllerGame {
    private IViewGameplay view;
    private MainController mainController;
    private boolean ispause= false;



    public GameplayController(MainController controller) {
        this.mainController = controller;
    }

    @Override
    public void create() {
        if(mainController.getImodel().getWorldModel().getSnake().isGameOver())
            view = new GameoverScreen(this);
        else
        {
            mainController.createmodel();
            view = new GamplayScreen(this);
        }
        view.create(mainController.getImodel());
    }

    @Override
    public void start() {
        getiput();
        if(!ispause ) update();
        view.render();
    }

    public void getiput() {
        if (view.getinputKey()) pause();
    }

    @Override
    public void update() {
            if(mainController.getImodel().getWorldModel().getSnake().isGameOver() &&!(view instanceof GameoverScreen)){
                mainController.switchToGame();
                // load to database
                try {
                    Connection connection = mainController.getDataAccess().getConnection();
                    ProfileDA profileDA = new ProfileDA(connection);
                    //update highest_score
                    int currentscore = mainController.getImodel().getWorldModel().getSnake().getScore();
                    profileDA.updateProfile(currentscore);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            view.updateData();
    }

    @Override
    public void close() {
        view.dispose();
    }

    @Override
    public void resize(int width, int height) {
        view.resize(width, height);
    }

    @Override
    public void pause() {
        if(ispause) ispause =false;
        else ispause = true;
    }


    public ClickListener gettry() {
        return new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("try game", "Settings clicked");
                System.out.println("🎮 try!");
                mainController.getImodel().getWorldModel().getSnake().setGameOver(false);
                mainController.switchToGame();
            }
        };
    }
    public ClickListener getcancel() {
        return new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("cancel game", "Settings clicked");
                System.out.println("🎮 cancel!");
                mainController.getImodel().getWorldModel().getSnake().setGameOver(false);
                mainController.switchToMenu();
            }
        };
    }
    public MainController MainController(){return mainController;}
}
