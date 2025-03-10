package io.github.some_snake_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.assets.AssetManager;

public class Main1 extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer; // bien tao hinh vuong
    private FitViewport viewport; // view
    private float posX, posY; //vi tri
    private float speed = 100; // toc do
    private int dirX = -1, dirY = 0; // huong
    private AssetManager assetManager;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer; // lay ban do tu project tiled
    private OrthographicCamera camera; // goc cam nguoi choi

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer(); // hinh vuong
        posX = 300;
        posY = 300;

        // Load bản đồ
        assetManager = new AssetManager();
        assetManager.setLoader(TiledMap.class, new TmxMapLoader());
        assetManager.load("Map/Map1/examples/Test/ran1.tmx", TiledMap.class);
        assetManager.finishLoading();
        map = assetManager.get("Map/Map1/examples/Test/ran1.tmx", TiledMap.class); // dat ban do trong bien map

        // Lấy kích thước bản đồ
        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(0);
        int mapWidth = layer.getWidth() * 20; // lay rong
        int mapHeight = layer.getHeight() * 20; // lay chieu cao

        // Khởi tạo camera và viewport
        camera = new OrthographicCamera();
        viewport = new FitViewport(mapWidth, mapHeight, camera);
        camera.position.set(mapWidth / 2f, mapHeight / 2f, 0);
        camera.update();

        // Tạo renderer
        mapRenderer = new OrthogonalTiledMapRenderer(map);


    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();

        // Cập nhật camera
        camera.position.set(posX, posY, 0);
        camera.update();
        mapRenderer.setView(camera);
        mapRenderer.render(); // Đưa map lên

        input();

        // Cập nhật vị trí nhân vật
        posX += dirX * speed * Gdx.graphics.getDeltaTime();
        posY += dirY * speed * Gdx.graphics.getDeltaTime();

//        // vẽ hình vuông lên bản đồ
//        shapeRenderer.setProjectionMatrix(camera.combined);
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        shapeRenderer.setColor(Color.RED);
//        shapeRenderer.rect(posX, posY, 10, 10);
//        shapeRenderer.end();
    }

    private void input() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && dirX == 0) {
            dirX = 1;
            dirY = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && dirX == 0) {
            dirX = -1;
            dirY = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && dirY == 0) {
            dirX = 0;
            dirY = 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && dirY == 0) {
            dirX = 0;
            dirY = -1;
        }
    }

    // Cập nhật kích thước cửa khi cửa sổ thay đổi
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    //Dọn dẹp bộ nhớ khi thoát game
    @Override
    public void dispose() {
        shapeRenderer.dispose();
        if (map != null) map.dispose();
        if (mapRenderer != null) mapRenderer.dispose();
        if (assetManager != null) assetManager.dispose();
    }

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Snake");
        config.setWindowedMode(640, 640);
        new Lwjgl3Application(new Main1(), config);
    }
}
