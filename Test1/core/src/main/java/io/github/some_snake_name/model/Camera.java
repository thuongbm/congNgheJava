package io.github.some_snake_name.model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Camera {
    private OrthographicCamera camera;
    private FitViewport viewport;
    private Snake snake;
    private final float SMOOTHING_FACTOR = 5f; // Giảm độ nhạy của camera

    public Camera(Snake snake, float worldWidth, float worldHeight) {
        this.snake = snake;
        camera = new OrthographicCamera();
        viewport = new FitViewport(worldWidth, worldHeight, camera); // Sử dụng kích thước bản đồ
        camera.update();
    }

    public void update(float deltaTime) {
        // Làm mượt chuyển động camera theo rắn
        float targetX = snake.getPosX() * 32 + 16;
        float targetY = snake.getPosY() * 32 + 16;
        camera.position.x += (targetX - camera.position.x) * SMOOTHING_FACTOR * deltaTime;
        camera.position.y += (targetY - camera.position.y) * SMOOTHING_FACTOR * deltaTime;

        // Giới hạn camera trong biên bản đồ
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();
        camera.position.x = Math.max(worldWidth / 2, Math.min(camera.position.x, worldWidth - worldWidth / 2));
        camera.position.y = Math.max(worldHeight / 2, Math.min(camera.position.y, worldHeight - worldHeight / 2));

        camera.update();
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
