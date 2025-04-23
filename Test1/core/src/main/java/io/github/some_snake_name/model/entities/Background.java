package io.github.some_snake_name.model.entities;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.ArrayList;
import java.util.List;

public class Background {
    private TiledMapTileLayer BackgroundLayer;
    private TiledMap map;
    private List<int[]> BackgroundPositions = new ArrayList<>();

    public Background (TiledMap map) {
        this.map = map;
        this.BackgroundLayer = BackgroundLayer;

        BackgroundLayer = (TiledMapTileLayer) map.getLayers().get("SpawnLayer");

        FindBackgroundPositions();
    }

    public void FindBackgroundPositions() {
        for (int x = 0; x < BackgroundLayer.getWidth(); x++) {
            for (int y = 0; y < BackgroundLayer.getHeight(); y++) {
                if (BackgroundLayer.getCell(x, y) != null) {
                    BackgroundPositions.add(new int[]{x, y});
                }
            }
        }
    }

    public boolean IsBackground(int x, int y) {
        for (int[] BackgroundPosition : BackgroundPositions) {
            if (BackgroundPosition[0] == x && BackgroundPosition[1] == y) {
                return true;
            }
        }
        return false;
    }
}
