package io.github.some_snake_name.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import io.github.some_snake_name.model.Profile;
import io.github.some_snake_name.model.SnakeModel;
import io.github.some_snake_name.view.Screen;

public class MenuController {
    private Screen screen;
    private SnakeModel snakeModel;
    public MenuController() {
        this.screen = new Screen(this); // Khởi tạo Screen với MenuController
        this.snakeModel = new SnakeModel();
        this.setButton(); // Thiết lập các sự kiện nút
    }

    public void setButton() {
        // Nút Play: Chuyển sang chế độ game
        this.screen.getMenuPanel().getplayButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                selectPlay();
            }
        });

        // Nút Profile: Hiển thị thông tin người chơi
        this.screen.getMenuPanel().getprofileButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                selectProfile();
            }
        });

        // Nút Exit: Thoát game
        this.screen.getMenuPanel().getexitsButton().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                selectExit();
            }
        });
    }

    public void selectPlay() {
        System.out.println("🎮 Play game!");
        this.screen.startGame();
        System.out.println("🎮 is game running = "+ this.screen.getisGameRunning());
    }

    public void selectProfile() {
        System.out.println("🎮 Profile!");
        Profile profile = this.snakeModel.getProfile();
        this.screen.showProfile(profile); // Hiển thị profile trong Screen
    }

    public void selectExit() {
        System.out.println("🎮 Exited!");
        Gdx.app.exit(); // Thoát ứng dụng
    }

    public void selectHome() {
        System.out.println("🎮 Go Home!");
        // Có thể thêm logic nếu cần quay lại menu chính từ trạng thái khác
    }

    public void render() {
        this.screen.render(this.snakeModel); // Giao việc vẽ cho Screen
    }


    public void dispose() {
        this.screen.dispose(this.snakeModel);
        // Dọn dẹp tài nguyên
    }
    public Screen getScreen() {
        return this.screen;
    }
}
