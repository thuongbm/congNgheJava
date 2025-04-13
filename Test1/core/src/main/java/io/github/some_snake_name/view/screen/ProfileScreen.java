package io.github.some_snake_name.view.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import io.github.some_snake_name.controller.manager.ProfileController;
import io.github.some_snake_name.model.base.IModel;
import io.github.some_snake_name.model.data.Profile;
import io.github.some_snake_name.view.base.IView;
import io.github.some_snake_name.view.component.CustomButton;

public class ProfileScreen implements IView {
    private Stage stage;
    private Profile profileData;
    private ProfileController profileController;

    public ProfileScreen (ProfileController controller){
        this.profileController = controller;
    }
    @Override
    public void create(IModel iModel) {
        this.profileData = new Profile();
        this.updateData(iModel);

        this.stage = new Stage(new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        Gdx.input.setInputProcessor(this.stage);

        Image background = new Image( new Texture("ui/Transparent_PNG/layer-3-ground.png"));
        background.setSize(this.stage.getWidth(),this.stage.getHeight());
        background.setFillParent(true);
        this.stage.addActor(background);

        Table table = new Table();
        table.setFillParent(true);
        this.stage.addActor(table);

        Label profileLabel = new Label("📌PROFILE", skin);
        table.add(profileLabel).width(300).height(100);
        table.row();
        Label nameLabel = new Label("👤 Tên: " + this.profileData.getUserName(), skin);
        table.add(nameLabel).width(300).height(100);
        table.row();
        Label scoreLabel = new Label("🏆 Điểm cao: " + this.profileData.getHighScore(), skin);
        table.add(scoreLabel).width(300).height(100);
        table.row();

        CustomButton backButton = new CustomButton("Back",profileController.getBackListener());
        backButton.getActor().setSize(150,80);
        backButton.getActor().bottom().right().pad(20);
        this.stage.addActor(backButton.getActor());
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.stage.getViewport();
        this.stage.act();
        this.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        this.stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        this.stage.dispose();
    }

    @Override
    public void updateData(IModel iModel) {
        profileData = iModel.getWorldModel().getProfile();
    }
}
