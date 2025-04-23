package io.github.some_snake_name.view.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import io.github.some_snake_name.controller.manage.ProfileController;
import io.github.some_snake_name.model.data.Profile;
import io.github.some_snake_name.model.base.IModel;
import io.github.some_snake_name.view.base.IViewProfile;

import static io.github.some_snake_name.view.component.Component.BACKGROUND_PROFILE;
import static io.github.some_snake_name.view.component.Component.SKIN;

public class ProfileScreen implements IViewProfile {

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
        Gdx.input.setInputProcessor(this.stage);

        Image background = new Image( BACKGROUND_PROFILE);
        background.setSize(this.stage.getWidth(),this.stage.getHeight());
        background.setFillParent(true);
        this.stage.addActor(background);

        Table table = new Table();
        table.setFillParent(true);
        this.stage.addActor(table);

        Label profileLabel = new Label("PROFILE", SKIN);
        table.add(profileLabel).width(200).height(100).pad(20);
        table.row();
        Label nameLabel = new Label("User name: " + this.profileData.getUserName(), SKIN);
        table.add(nameLabel).width(500).height(100).pad(20);
        table.row();
        Label scoreLabel = new Label("High score: " + this.profileData.getHighScore(), SKIN);
        table.add(scoreLabel).width(500).height(100).pad(20);
        table.row();

        TextButton backbutton = new TextButton("Back",SKIN );
        backbutton.addListener(profileController.getBackListener());
        stage.addActor(backbutton);
        backbutton.bottom().right().pad(10);
        backbutton.setWidth(300);
        backbutton.setHeight(100);
        this.stage.addActor(backbutton);
    }

    @Override
    public void updateData(IModel iModel) {
        profileData = iModel.getWorldModel().getProfile();

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
        stage.dispose();
    }
}
