package io.github.some_snake_name.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL32;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import io.github.some_snake_name.controller.MenuController;
import io.github.some_snake_name.model.Profile;
import java.util.Scanner;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.graphics.Texture;

import static com.badlogic.gdx.Gdx.gl;

public class Screen {
    private MenuController menuController;
    private MenuPanel menuPanel;
    private Stage currentStage;  // Quản lý Stage hiện tại

    public Screen(MenuController menuController) {
        this.menuController = menuController;
        this.menuPanel = new MenuPanel(menuController);
        this.currentStage = menuPanel.getStage();  // Mặc định là menuPanel
    }

    public void render() {
        Gdx.gl.glClear(GL32.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f); // Màu đen

        currentStage.getViewport().apply();
        currentStage.act(Gdx.graphics.getDeltaTime());
        currentStage.draw();
    }

    public void showProfile(Profile profile) {
        Stage profileStage = new Stage(new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        Gdx.input.setInputProcessor(profileStage);

        Image background = new Image(new Texture("ui/Transparent_PNG/layer-3-ground.png"));
        background.setSize(profileStage.getWidth(),profileStage.getHeight());
        profileStage.addActor(background);

        Table table = new Table();
        table.setFillParent(true);
        profileStage.addActor(table);

        // Hiển thị thông tin Profile
        Label profileLabel = new Label("📌PROFILE", skin);
        table.add(profileLabel).width(300).height(100);
        table.row();

        Label nameLabel = new Label("👤 Tên: " + profile.getUserName(), skin);
        table.add(nameLabel).width(300).height(100);
        table.row();

        Label scoreLabel = new Label("🏆 Điểm cao: " + profile.getHighScore(), skin);
        table.add(scoreLabel).width(300).height(100);
        table.row();

        Label levelMapLabel = new Label("🗺️ Cấp độ bản đồ: " + profile.getLevelMap(), skin);
        table.add(levelMapLabel).width(300).height(100);
        table.row();

        // Thêm nút Back để quay lại menu chính
        TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                currentStage = menuPanel.getStage();  // Chuyển về menuPanel
                Gdx.input.setInputProcessor(currentStage);
            }
        });
        backButton.setPosition(20,20);
        backButton.setSize(100,100);
        backButton.setColor(new Color(Color.GREEN));
        profileStage.addActor(backButton);
        currentStage = profileStage;  // Chuyển sang profileStage
    }

    public void resize(int width, int height) {

    }

    public void dispose() {
        menuPanel.dispose();
        if (currentStage != menuPanel.getStage()) {
            currentStage.dispose();  // Dispose profileStage nếu đang hiển thị
        }
    }
    public MenuPanel getMenuPanel(){return this.menuPanel;}
}
