package io.github.some_snake_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Main1 extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer; // bien tao hinh vuong
    private FitViewport viewport; // view khi chay
    private float posX; // vi tri theo truc ngang
    private float posY; // vi tri theo truc doc
    private float speed = 100; // toc do o vuong
    private int dirX = -1;
    private int dirY = 0;

    @Override
    public void create() {
        viewport = new FitViewport(800, 600); // dat cua so dai 800 rong 600
        viewport.getCamera().position.set(400, 300, 0);
        viewport.getCamera().update();

        shapeRenderer = new ShapeRenderer();
        posX = 300; // vi tri ban dau
        posY = 300;
        dirX = -1;
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.BLACK); // mau nen cho cua so
        viewport.apply();

        input(); // goi ham
//
//        if (posX + 200 <= 0) {
//            posX = 800;
//        }
//
//        if (posX + 200 >= -200) {
//            posX = 0;
//        }
        posX += dirX * speed * Gdx.graphics.getDeltaTime(); // Luôn di chuyển theo hướng hiện tại
        posY += dirY * speed * Gdx.graphics.getDeltaTime();
//
        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined); // bat dau ve

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled); // tao hinh vuong dac
        shapeRenderer.setColor(Color.RED); // dat mau
        shapeRenderer.rect(posX, posY, 10, 10);// kich co vi tri dat hinh vuong ban dau
        shapeRenderer.end(); // ket thuc ve
    }
    private void input() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && dirX == 0) {
            dirX = 1;
            dirY = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            dirX = -1; // sang trais
            dirY = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            dirX = 0;
            dirY = 1; // lên
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            dirX = 0;
            dirY = -1; // xuống
        }
    }
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Snake");
        config.setWindowedMode(640, 640);
        new Lwjgl3Application(new Main1(), config);
    }

}
