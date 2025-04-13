package io.github.some_snake_name.controller.manager;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import io.github.some_snake_name.controller.base.IController;
import io.github.some_snake_name.view.base.IView;
import io.github.some_snake_name.view.screen.ProfileScreen;

public class ProfileController implements IController {
    private IView view;
    private MainController mainController;
    public ProfileController(MainController controller) {
        this.mainController = controller;
    }

    @Override
    public void create() {
        if(this.view == null){
            this.view = new ProfileScreen(this);
        }
        update();
        this.view.create(this.mainController.getImodel());

    }

    @Override
    public void start() {
        this.view.render();
    }

    @Override
    public void update() {
        this.view.updateData(this.mainController.getImodel());
    }

    @Override
    public void close() {
        this.view.dispose();
    }

    @Override
    public void resize(int width, int height) {
        this.view.resize(width,height);
    }

    public ClickListener getBackListener(){
        return new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("🎮 Back!");
                mainController.switchToMapOption();
            }
        };
    }


    public MainController getMainController(){return this.mainController;}
}
