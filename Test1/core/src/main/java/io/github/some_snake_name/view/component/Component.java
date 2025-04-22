package io.github.some_snake_name.view.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Component {
    public static Skin SKIN = new Skin(Gdx.files.internal("ui/style/widgets_ui.json"));
    public static Texture BACKGROUND_MENU = new Texture(Gdx.files.internal("ui/Transparent_PNG/Full-Background.png"));
    public static Texture BACKGROUND_PROFILE = new Texture(Gdx.files.internal("ui/Transparent_PNG/layer-3-ground.png"));

}
