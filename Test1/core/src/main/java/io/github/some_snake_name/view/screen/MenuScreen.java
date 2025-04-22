package io.github.some_snake_name.view.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import io.github.some_snake_name.controller.manage.MenuController;
import io.github.some_snake_name.view.base.IViewMenu;

import static io.github.some_snake_name.view.component.Component.BACKGROUND_MENU;
import static io.github.some_snake_name.view.component.Component.SKIN;

public class MenuScreen implements IViewMenu {
    private Stage stage;
    private MenuController menuController;

    public MenuScreen (MenuController controller){
        this.menuController = controller;
    }
    @Override
    public void create() {
        this.stage = new Stage(new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(this.stage);

        Image background = new Image(BACKGROUND_MENU);
        background.setSize(this.stage.getWidth(),this.stage.getHeight());
        background.setFillParent(true);
        this.stage.addActor(background);

        Table table = new Table();
        table.setFillParent(true);
        this.stage.addActor(table);

        TextButton playbutton = new TextButton("Play",SKIN );
        playbutton.addListener(menuController.getPlayListener());
        table.add(playbutton).width(300).height(100).pad(10);
        table.row();

        TextButton profilebutton = new TextButton("Profile",SKIN );
        profilebutton.addListener(menuController.getProfileListener());
        table.add(profilebutton).width(300).height(100).pad(10);
        table.row();

        TextButton existbutton = new TextButton("Exist",SKIN );
        existbutton.addListener(menuController.getExitListener());
        table.add(existbutton).width(300).height(100).pad(10);
        table.row();
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
        this.stage.getViewport().update(width,height,true);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
