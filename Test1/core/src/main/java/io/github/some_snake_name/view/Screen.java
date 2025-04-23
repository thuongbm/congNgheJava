package io.github.some_snake_name.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL32;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import io.github.some_snake_name.controller.MenuController;
import io.github.some_snake_name.model.*;
import io.github.some_snake_name.model.data.Profile;
import io.github.some_snake_name.model.data.SoundManager;

public class Screen {
    private MenuPanel menuPanel;
    private Stage currentStage;
    private boolean isGameRunning;
    private static double timeStart;

    public Screen(MenuController menuController) {
        this.menuPanel = new MenuPanel(menuController);
        this.currentStage = menuPanel.getStage();
        this.isGameRunning = false;

        SoundManager.loadSound();
    }

    public void render(SnakeModel model) {

        if (isGameRunning ) {
            // Vẽ game trong View
            ScreenUtils.clear(Color.BLACK);
            model.getCamera().getCamera().update();
            model.getMap().getRenderer().setView(model.getCamera().getCamera());
            // vẽ bản đồ
            model.getMap().getRenderer().render();
            //caapj nhật logic game
            model.update(Gdx.graphics.getDeltaTime());
        } else {
            Gdx.gl.glClear(GL32.GL_COLOR_BUFFER_BIT);
            Gdx.gl.glClearColor(0f, 0f, 0f, 1f); // Màu đen
            // Vẽ menu hoặc profile
            currentStage.getViewport().apply();
            currentStage.act(Gdx.graphics.getDeltaTime());
            currentStage.draw();
        }
    }

    public void showProfile(Profile profile) {
        Stage profileStage = new Stage(new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        Gdx.input.setInputProcessor(profileStage);

        Image background = new Image(new Texture("ui/Transparent_PNG/layer-3-ground.png"));
        background.setSize(profileStage.getWidth(), profileStage.getHeight());
        profileStage.addActor(background);

        Table table = new Table();
        table.setFillParent(true);
        profileStage.addActor(table);

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
        table.add(levelMapLabel).width(100).height(100);
        table.row();

        TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                currentStage = menuPanel.getStage();
                Gdx.input.setInputProcessor(currentStage);
            }
        });
        backButton.setPosition(20, 20);
        backButton.setSize(100, 100);
        backButton.setColor(new Color(Color.GREEN));
        profileStage.addActor(backButton);
        currentStage = profileStage;
    }

    public void startGame() {
        this.isGameRunning = true;
        Screen.setGameStart(System.currentTimeMillis());
        Gdx.input.setInputProcessor(null);

    }


    public void dispose(SnakeModel model) {
        menuPanel.dispose();
        if (currentStage != menuPanel.getStage()) {
            currentStage.dispose();
        }
        if(model != null){
            if(model.getMap().getMap() != null) model.getMap().getMap().dispose();
            if(model.getMap().getRenderer() != null) model.getMap().getRenderer().dispose();
            if(model.getMap().getAssetManager() != null ) model.getMap().getAssetManager().dispose();
        }
    }

    public void resize(int width, int height,SnakeModel model) {
        currentStage.getViewport().update(width, height, true);

        model.getCamera().resize(width, height);
    }

    public MenuPanel getMenuPanel() {
        return this.menuPanel;
    }
    public boolean getisGameRunning(){return this.isGameRunning;}

    public static void setGameStart(double time){
        timeStart = time;
    }

    public static double getTimeStart(){
        return timeStart;
    }
}
