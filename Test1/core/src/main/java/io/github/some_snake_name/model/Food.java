package io.github.some_snake_name.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.MathUtils;

public class Food {
    private TiledMapTileLayer foodLayer;
    private TiledMap map;
    private Wall wall;
    private boolean foodSpawned = false;
    private Background background;
    private int posFoodX;
    private int posFoodY;

    public Food (TiledMap map, Wall wall, Background background) {
        this.map = map;
        this.wall = wall;
        this.background = background;

        // Initialize the food layer
        foodLayer = (TiledMapTileLayer) map.getLayers().get("Snake and food");

    }

    public void DisplayFood(int x, int y) {
        TiledMapTileLayer.Cell foodCell = new TiledMapTileLayer.Cell();
        foodCell.setTile(map.getTileSets().getTile(1455));
        foodLayer.setCell(x, y, foodCell);
    }

    public void SpawnRandomFood() {
        if (!foodSpawned){
            int x, y;
            do {
                x = MathUtils.random(0, foodLayer.getWidth());
                y = MathUtils.random(0, foodLayer.getHeight());
            } while (foodLayer.getCell(x, y) != null || wall.IsWall(x, y) || !background.IsBackground(x, y));

            DisplayFood(x, y);
            posFoodX = x;
            posFoodY = y;
            foodSpawned = true;
        }
    }

    public boolean IsFood(int x, int y) {
        if (x == posFoodX && y == posFoodY) {
            return true;
        }

        return false;
    }

    public void HasBeenEaten(int x, int y) {

        if (foodLayer.getCell(x, y) != null) {

            foodLayer.setCell(x, y, null);
            foodSpawned = false;
        }
    }



}
