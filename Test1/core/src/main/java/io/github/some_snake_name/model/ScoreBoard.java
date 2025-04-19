package io.github.some_snake_name.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreBoard {
    private BitmapFont font;
    private int score;
    private int highScore;

    public ScoreBoard() {
        font = new BitmapFont();
        font.getData().setScale(0.2f);
        score = 0;
        highScore = 0;
    }

    public void AddScore() {
        score = Score.getScore();
        if (score > highScore){
            highScore = score;
        }
    }
    public void resetScore() {
        score = 0;
    }


    public void Render(SpriteBatch batch){
        font.setColor(Color.WHITE);
        font.draw(batch, "Score: " + score, 240, 20);
        font.draw(batch, "High Score: " + highScore, 240, 10);
    }

    public void Dispose() {
        font.dispose();
    }

}
