package io.github.some_snake_name.view.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import io.github.some_snake_name.controller.manage.GameplayController;
import io.github.some_snake_name.model.base.IModel;
import io.github.some_snake_name.view.base.IViewGameplay;

import static com.badlogic.gdx.utils.Align.center;
import static io.github.some_snake_name.view.component.Component.SKIN;

public class GameoverScreen implements IViewGameplay {
    private Stage stage;
    private int score;
    private Label scorelabel;
    private TextButton tryagainbutton;
    private TextButton cancelbutton;
    private GameplayController gameplayController;

    public GameoverScreen(GameplayController controller){
        gameplayController = controller;
    }

    @Override
    public void create(IModel iModel) {
        score = iModel.getWorldModel().getSnake().getScore();

        stage = new Stage(new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);

        scorelabel = new Label("",SKIN);
        scorelabel.setAlignment(center);
        tryagainbutton = new TextButton("Try",SKIN);
        tryagainbutton.addListener(gameplayController.gettry());
        cancelbutton = new TextButton("Cancel",SKIN);
        cancelbutton.addListener(gameplayController.getcancel());

        Table table = new Table();
        table.add(scorelabel).width(400).height(200).row();
        table.add(tryagainbutton).width(300).height(100).row();
        table.add(cancelbutton).width(300).height(100);
        table.setFillParent(true);
        table.center();

        stage.addActor(table);
    }

    @Override
    public void updateData() {
    }

    @Override
    public boolean getinputKey() {
        return cancelbutton.isChecked();
    }


    @Override
    public void render() {
        scorelabel.setText("Score: "+score );
        Gdx.gl.glClearColor(0, 0, 0, 0.5f); // Màu đen với độ mờ 50%
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.stage.getViewport();
        this.stage.act();
        this.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height,true);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
