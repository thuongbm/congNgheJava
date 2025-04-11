package io.github.some_snake_name.view;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL32;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import io.github.some_snake_name.controller.MenuController;

import static com.badlogic.gdx.Gdx.gl;

public class MenuPanel {
    private Stage stage;
    private Image background;
    private TextButton playButton;
    private TextButton exitsButton;
    private TextButton profileButton;
    private TextButton homeButton;

    public MenuPanel(MenuController menuController){
        // tạo canvas
        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        this.stage = new Stage(new ExtendViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);

        // background stage
        Texture backgroundTexture = new Texture(Gdx.files.internal("ui/Transparent_PNG/Full-Background.png"));
        backgroundTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear); // Chống răng cưa

        Image background = new Image(backgroundTexture);
        background.setSize(this.stage.getWidth(),this.stage.getHeight());
        background.setFillParent(true);
        this.stage.addActor(background);

        Table table = new Table();
        table.setFillParent(true);
        this.stage.addActor(table);

        // tạo các button (actors)
        this.playButton = new TextButton("Play",   skin);
        table.add(this.playButton).width(300).height((100));
        table.row();

        this.homeButton = new TextButton("Home",   skin);
        this.homeButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x,float y){
                menuController.selectHome();
            }
        });
        table.add(this.homeButton).width(300).height(100);
        table.row();

        this.profileButton = new TextButton("Profile",skin);
        table.add(this.profileButton).width(300).height(100);
        table.row();

        this.exitsButton   = new TextButton("Exit",   skin);
        table.add(this.exitsButton).width(300).height(100);


    }
    public Stage getStage(){
        return this.stage;
    }
    // vẽ ui
    public void render() {
        gl.glClear(GL32.GL_COLOR_BUFFER_BIT);
        gl.glClearColor(0.9f,0.9f,0.9f,0.9f);

        this.stage.getViewport().apply();
        this.stage.act();
        this.stage.draw();
    }

    public void dispose() {
        this.stage.dispose();
    }
    public Button getplayButton(){return this.playButton;}
    public Button getprofileButton(){return this.profileButton;}
    public Button getexitsButton(){return this.exitsButton;}
    public Button gethomeButton(){return this.homeButton;}
}
