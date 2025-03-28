package io.github.some_snake_name.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Wall {
    private TiledMapTileLayer wallLayer;
    private TiledMap map;
    private List<int[]> wallPositions = new ArrayList<>();

    public Wall (TiledMap map) {
        this.map = map;
        this.wallLayer = wallLayer;

        wallLayer = (TiledMapTileLayer) map.getLayers().get("Wall");

        FindWallPositions();


    }

    public void FindWallPositions() {
        for (int x = 0; x < wallLayer.getWidth(); x++) {
            for (int y = 0; y < wallLayer.getHeight(); y++) {
                if (wallLayer.getCell(x, y) != null) {
                    wallPositions.add(new int[]{x, y});
                }
            }
        }
    }

    public boolean IsWall(int x, int y) {
        for (int[] wallPosition : wallPositions) {
            if (wallPosition[0] == x && wallPosition[1] == y) {
                return true;
            }
        }
        return false;
    }
}
