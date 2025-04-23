package io.github.some_snake_name.controller.manage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import io.github.some_snake_name.controller.base.IControllerMenu;
import io.github.some_snake_name.model.MainController;
import io.github.some_snake_name.view.base.IViewMenu;
import io.github.some_snake_name.view.screen.MenuScreen;

public class MenuController implements IControllerMenu {
    private IViewMenu view;
    private MainController mainController;
    public MenuController(MainController main) {
        this.mainController = main;
    }

    @Override
    public void create() {
        this.view = new MenuScreen(this);
        this.view.create();
    }

    @Override
    public void start() {
        this.view.render();
    }

    @Override
    public void update() {

    }

    @Override
    public void close() {
        view.dispose();
    }

    @Override
    public void resize(int width, int height) {
        view.resize(width, height);
    }
    public ClickListener getPlayListener() {
        return new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("Controller", "Play clicked");
                System.out.println("🎮 Play game!");
                mainController.switchToGame();
            }
        };
    }

    public ClickListener getProfileListener() {
        return new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("Controller", "Settings clicked");
                System.out.println("🎮 Profile!");
                mainController.switchToProfile();
            }
        };
    }

    public ClickListener getExitListener() {
        return new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("menu controller", "Exit clicked");
                System.out.println("🎮 Exist!");
                Gdx.app.exit();
            }
        };
    }



}
