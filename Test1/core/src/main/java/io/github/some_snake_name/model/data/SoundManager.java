package io.github.some_snake_name.model.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {
    public static Sound Eatsound;
    public static Sound Gameoversound;
    public static Sound Keysound;

    public static void loadSound(){
        Eatsound = Gdx.audio.newSound(Gdx.files.internal("Sound/Eat22.wav"));
        Gameoversound = Gdx.audio.newSound(Gdx.files.internal("Sound/EndGameSound2.wav"));
        Keysound = Gdx.audio.newSound(Gdx.files.internal("Sound/KeyPress2.wav"));
    }

    public static void playEat() {
        Eatsound.play();
    }

    public static void playGameOver() {
        Gameoversound.play();
    }

    public static void playKey() {
        Keysound.play();
    }

    public static void Dispose() {
        Eatsound.dispose();
        Gameoversound.dispose();
        Keysound.dispose();
    }
}
