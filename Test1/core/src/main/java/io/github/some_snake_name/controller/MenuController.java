package io.github.some_snake_name.controller;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import io.github.some_snake_name.model.Profile;
import io.github.some_snake_name.model.SnakeModel;
import io.github.some_snake_name.view.Screen;

public class MenuController {
    private SnakeModel snakeModel;
    private Screen screen;
    private SnakeController snakeController;

    public MenuController() {
        this.snakeModel = new SnakeModel();
        this.screen = new Screen(this);  // Truyền this vào Screen
        this.snakeController = new SnakeController();  // Khởi tạo snakeController
        this.setButton();
    }

    public void setButton(){
        this.screen.getMenuPanel().getplayButton().addListener( new ClickListener(){
            public void clicked(InputEvent event , float x, float y){
                selectPlay();
            }
        });

        this.screen.getMenuPanel().getprofileButton().addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                selectProfile();
            }
        });

        this.screen.getMenuPanel().getexitsButton().addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                selectExit();
            }
        });
    }

    public void selectPlay() {
        System.out.println("🎮 Chơi game!");
        snakeController.gamePlay();
    }

    public void selectProfile() {
        Profile profile = snakeModel.getProfile();
        this.screen.showProfile(profile);
    }

    public void selectExit(){
        this.dispose();

    }

    public void selectHome(){

    }

    public void render() {
        this.screen.render();
    }

    public Screen getScreen() {
        return this.screen;
    }

    public SnakeModel getSnakeModel(){
        return this.snakeModel;

    }

    public void dispose() {
        this.screen.dispose();
    }
}
