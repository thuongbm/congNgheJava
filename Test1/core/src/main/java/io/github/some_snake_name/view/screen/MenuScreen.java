package io.github.some_snake_name.view.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.some_snake_name.controller.manager.MenuController;
import io.github.some_snake_name.model.base.IModel;
import io.github.some_snake_name.view.base.IView;
import io.github.some_snake_name.view.component.CustomButton;

public class MenuScreen implements IView {
    private Stage stage;
    private MenuController menuController;

    public MenuScreen (MenuController controller){
        this.menuController = controller;
    }
    @Override
    public void create(IModel iModel) {
        this.stage = new Stage(new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(this.stage);

        Texture backgroundTexture = new Texture(Gdx.files.internal("ui/Transparent_PNG/Full-Background.png"));
        backgroundTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear); // Chống răng cưa

        Image background = new Image(backgroundTexture);
        background.setSize(this.stage.getWidth(),this.stage.getHeight());
        background.setFillParent(true);
        this.stage.addActor(background);


        Table table = new Table();
        table.setFillParent(true);
        this.stage.addActor(table);

        CustomButton playButton = new CustomButton("play", menuController.getPlayListener());
        table.add(playButton.getActor()).width(300).height(100).pad(10);
        table.row();

        CustomButton profileButton = new CustomButton("Profile", menuController.getProfileListener());
        table.add(profileButton.getActor()).width(300).height(100).pad(10);
        table.row();

        CustomButton mapOptionButton = new CustomButton("Map Option", menuController.getMapOptionListener());
        table.add(mapOptionButton.getActor()).width(300).height(100).pad(10);
        table.row();

        CustomButton exitButton = new CustomButton("Exit", menuController.getExitListener());
        table.add(exitButton.getActor()).width(300).height(100).pad(10);


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

    }
}
