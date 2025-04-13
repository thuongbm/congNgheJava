package io.github.some_snake_name.view.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class CustomButton {
    private TextButton button;

    public CustomButton(String text, float x, float y,ClickListener listener) {
        // Tạo style cho button

        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        // Tạo button
        button = new TextButton(text, skin);
        button.setPosition(x, y);
        // thêm sự kiện
        button.addListener(listener);

    }

    public CustomButton(String text, ClickListener listener) {
        // Tạo style cho button

        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        // Tạo button
        button = new TextButton(text, skin);
        // thêm sự kiện
        button.addListener(listener);
    }

    public TextButton getActor() {
        return button; // Trả về Actor để Screen thêm vào Stage
    }
}
