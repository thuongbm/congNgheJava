package io.github.some_snake_name;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameCamera {
    private OrthographicCamera camera;
    private FitViewport viewport;
    private Snake snake;
    private final float SMOOTHING_FACTOR = 0f; // Giảm độ nhạy của camera

    public GameCamera(Snake snake) {
        this.snake = snake;
        camera = new OrthographicCamera();
        viewport = new FitViewport(250, 250, camera);
        camera.update();
    }

    public void update(float deltaTime) {
        // Làm mượt chuyển động camera theo rắn
        camera.position.x += (snake.getPosX() * 20 + 10 - camera.position.x) * SMOOTHING_FACTOR * deltaTime;
        camera.position.y += (snake.getPosY() * 20 + 10 - camera.position.y) * SMOOTHING_FACTOR * deltaTime;
        camera.update();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }
}
