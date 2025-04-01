package io.github.some_snake_name.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Camera {
    private OrthographicCamera camera;
    private FitViewport viewport;
    private io.github.some_snake_name.model.Snake snake;
    private final float SMOOTHING_FACTOR = 5f; // Giảm độ nhạy của camera

    public Camera(Snake snake) {
        this.snake = snake;
        camera = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        camera.update();
    }

    public void update(float deltaTime) {
        // Làm mượt chuyển động camera theo rắn
        camera.position.x += (snake.getPosX() * 32 + 16 - camera.position.x) * SMOOTHING_FACTOR * deltaTime;
        camera.position.y += (snake.getPosY() * 32 + 16 - camera.position.y) * SMOOTHING_FACTOR * deltaTime;
        camera.update();
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
