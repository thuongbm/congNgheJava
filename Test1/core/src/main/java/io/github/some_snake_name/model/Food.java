package io.github.some_snake_name.model;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
public class Food {
    private double posX;
    private double posY;
    private float radius; // Bán kính của thức ăn
    private boolean isEaten;

    // Constructor
    public Food(double x, double y, float radius) {
        this.posX = x;
        this.posY = y;
        this.radius = radius;
        this.isEaten = false;
    }

    // Getter và Setter (nếu cần)
    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public float getRadius() {
        return radius;
    }

    public boolean getStatus() {
        return isEaten;
    }

    public void setStatus(boolean status) {
        this.isEaten = status;
    }

    // Vẽ thức ăn
    public void render(ShapeRenderer shapeRenderer) {
        if (!isEaten) { // Chỉ vẽ nếu mồi chưa bị ăn
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);// vẽ đặc
            shapeRenderer.setColor(Color.GREEN); // Màu thức ăn
            shapeRenderer.circle((float) posX, (float) posY, radius); // Vẽ thức ăn dưới dạng hình tròn
            shapeRenderer.end();
        }
    }
}
