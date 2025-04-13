package io.github.some_snake_name.model.entities;

import com.badlogic.gdx.Gdx;
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
        if(map == null){
            Gdx.app.error("Map","Không thể tải bản đồ: "+ mapPath);
        }
        renderer = new OrthogonalTiledMapRenderer(map);

        int tileWidth = map.getProperties().get("tilewidth", Integer.class);
        int tileHeight = map.getProperties().get("tileheight", Integer.class);
        int mapWidth = map.getProperties().get("width", Integer.class);
        int mapHeight = map.getProperties().get("height", Integer.class);

        System.out.println("Map width: " + mapWidth);
        System.out.println("Map height: " + mapHeight);

        Gdx.app.log("Map", "Map size: " + (mapWidth * tileWidth) + "x" + (mapHeight * tileHeight));

    }

    public float getWorldWidth() {
        int tileWidth = map.getProperties().get("tilewidth", Integer.class);
        int mapWidth = map.getProperties().get("width", Integer.class);
        return mapWidth * tileWidth;
    }

    public float getWorldHeight() {
        int tileHeight = map.getProperties().get("tileheight", Integer.class);
        int mapHeight = map.getProperties().get("height", Integer.class);
        return mapHeight * tileHeight;
    }
    public TiledMap getMap() {return map;}
    public OrthogonalTiledMapRenderer getRenderer(){return renderer;}
    public AssetManager getAssetManager (){return assetManager;}

}
