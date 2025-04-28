package io.github.some_snake_name.controller.manage;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import io.github.some_snake_name.controller.base.IControllerProfile;
import io.github.some_snake_name.model.Profile;
import io.github.some_snake_name.model.data.ProfileDA;
import io.github.some_snake_name.view.base.IViewProfile;
import io.github.some_snake_name.view.screen.ProfileScreen;

import java.sql.Connection;
import java.sql.SQLException;

public class ProfileController implements IControllerProfile {
    private IViewProfile view;
    private MainController mainController;
    public ProfileController(MainController controller) {
        this.mainController = controller;
    }

    @Override
    public void create() {
        this.view = new ProfileScreen(this);
        update();
        this.view.updateData(this.mainController.getImodel());
        this.view.create(this.mainController.getImodel());
    }

    @Override
    public void start() {
        view.render();
    }

    @Override
    public void update()  {
        try {
            mainController.getDataAccess().createConnection();
            Connection connection = mainController.getDataAccess().getConnection();
            ProfileDA profileDA = new ProfileDA(connection);
            if(!profileDA.hasAccount()){
                profileDA.createDefaultAccount();
            }
            //
            Profile profile = profileDA.getProfile();
            //
            mainController.getImodel().getWorldModel().getProfile().setProfile(profile);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void close() {
        view.dispose();
    }

    @Override
    public void resize(int width, int height) {
        view.resize(width, height);
    }
    public ClickListener getBackListener(){
        return new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("🎮 Back!");
                mainController.switchToMenu();
            }
        };
    }
}
