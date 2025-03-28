package io.github.some_snake_name.model;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public class Map {
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private AssetManager assetManager;

    public Map(String mapPath) {
        assetManager = new AssetManager();
        assetManager.setLoader(TiledMap.class, new TmxMapLoader());
        assetManager.load(mapPath, TiledMap.class);
        assetManager.finishLoading();
        map = assetManager.get(mapPath, TiledMap.class);
        renderer = new OrthogonalTiledMapRenderer(map);
    }

    public void render(Camera camera) {
        renderer.setView(camera.getCamera());
        renderer.render();
    }

    public TiledMap getMap() {
        return map;
    }

    public void dispose() {
        if (map != null) map.dispose();
        if (renderer != null) renderer.dispose();
        if (assetManager != null) assetManager.dispose();
    }

}
