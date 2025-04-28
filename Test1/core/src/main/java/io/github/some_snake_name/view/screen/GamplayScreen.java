package io.github.some_snake_name.view.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.some_snake_name.controller.manage.GameplayController;
import io.github.some_snake_name.model.base.IModel;
import io.github.some_snake_name.model.base.WorldModel;
import io.github.some_snake_name.view.base.IViewGameplay;

import static io.github.some_snake_name.view.component.Component.SKIN;

public class GamplayScreen implements IViewGameplay {
    private Stage gamestage;
    private Stage hubstage;
    private GameplayController gameplayController;
    private WorldModel model;
    private Label scoreLabel;
    //private TextButton pausebutton;

    public GamplayScreen (GameplayController controller){
        this.gameplayController=controller;
    }

    @Override
    public void create(IModel iModel) {
        // Lấy model
        this.model = iModel.getWorldModel();

        // 1) Stage cho gameplay (map, sprite, v.v.)
        gamestage = new Stage(new ExtendViewport(
            Gdx.graphics.getWidth(),
            Gdx.graphics.getHeight() *0.9f,
            model.getCamera().getCamera()
        ));

        //update kích cỡ screen
        model.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // Cập nhật camera


        // 2) Stage cho HUD/UI thuần túy (không theo camera game)
        hubstage = new Stage(new ScreenViewport());

        // 3) InputMultiplexer, ưu tiên HUD (nếu có button click), rồi gameStage
        InputMultiplexer im = new InputMultiplexer();
        im.addProcessor(hubstage);
        im.addProcessor(gamestage);
        Gdx.input.setInputProcessor(im);

        // 4) Khởi tạo UI: Score + Pause
        scoreLabel = new Label("", SKIN);
        //pausebutton = new TextButton("Pause", SKIN);

        // 5) Dùng 1 Table duy nhất để căn HUD
        Table root = new Table();
        root.setFillParent(true);
        root.bottom().pad(10);             // đặt hàng HUD ở đáy
        // thêm 2 ô: Score bên trái, Pause bên phải
        root.add(scoreLabel).expandX().left();
        //root.add(pausebutton).expandX().right();
        //pausebutton.setSize(300,100);
        //.addListener(gameplayController.getpausegame());
        // 6) Add table vào hudStage
        hubstage.addActor(root);

    }
    @Override
    public boolean getinputKey() {
        return (Gdx.input.isKeyJustPressed(Input.Keys.SPACE));
    }


    @Override
    public void updateData() {
        model.update(Gdx.graphics.getDeltaTime());
    }


    @Override
    public void render( ) {

        model.getCamera().getCamera().update();
        model.getMap().getRenderer().setView(model.getCamera().getCamera());
        // vẽ bản đồ
        model.getMap().getRenderer().render();

        scoreLabel.setText("Score: " + model.getSnake().getScore());
        gamestage.act(Gdx.graphics.getDeltaTime());
        gamestage.draw();
        hubstage.act(Gdx.graphics.getDeltaTime());
        hubstage.draw();
    }

    @Override
    public void resize(int width, int height) {
        this.gamestage.getViewport().update(width,height,true);
        model.resize(width, height); // Cập nhật camera
        hubstage.getViewport().update(width,height,true);
    }

    @Override
    public void dispose() {
        if(gamestage != null) gamestage.dispose();
        if(hubstage != null ) hubstage.dispose();
    }
}
