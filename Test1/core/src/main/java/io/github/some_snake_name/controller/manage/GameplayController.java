package io.github.some_snake_name.controller.manage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import io.github.some_snake_name.controller.base.IControllerGame;
import io.github.some_snake_name.model.MainController;
import io.github.some_snake_name.view.base.IViewGameplay;
import io.github.some_snake_name.view.screen.GameoverScreen;
import io.github.some_snake_name.view.screen.GamplayScreen;

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
    public ClickListener getpausegame() {
        return new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("pause game", "Settings clicked");
                System.out.println("🎮 pause!");
                pause();
            }
        };
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
//    public boolean getispause(){return  ispause;}
    public MainController MainController(){return mainController;}
}
