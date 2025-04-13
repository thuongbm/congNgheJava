package io.github.some_snake_name.model.entities;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import io.github.some_snake_name.model.data.Time;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private int posX, posY;
    private int dirX = -1, dirY = 0;
    private TiledMapTileLayer layer;
    private TiledMap map;
    private List<int[]> snakeBody = new ArrayList<>();
    private float moveTimer = 0f;
    private final float MOVE_INTERVAL = 0.15f;
    private Wall wall;
    private Food food;
    private Time time;

    public  Snake(){}

    public Snake(TiledMap map, TiledMapTileLayer layer,Wall wall, Food food, int startX, int startY) {
        this.map = map;
        this.layer = layer;
        this.posX = startX;
        this.posY = startY;
        this.wall = wall;
        this.food = food;

        // Thêm phần thân ban đầu
        for (int i = 1; i <= 3; i++) { // Ban đầu rắn có 3 đốt
            snakeBody.add(new int[]{startX + i, startY});
        }

        updatePosition(); // Cập nhật vị trí ban đầu
    }

    public void update(float deltaTime) {
        moveTimer += deltaTime;
        if (moveTimer < MOVE_INTERVAL) {
            return;
        }
        moveTimer = 0;

        // Xóa thân rắn cũ khỏi layer
        clearOldPosition();

        // Lấy vị trí hiện tại của đầu rắn
        int oldX = posX;
        int oldY = posY;

        // Cập nhật vị trí đầu rắn
        posX += dirX;
        posY += dirY;

        // Nếu rắn có thân thì di chuyển thân theo đầu rắn
        if (!snakeBody.isEmpty()) {
            int[] lastPart = snakeBody.remove(snakeBody.size() - 1);
            snakeBody.add(0, new int[]{oldX, oldY});
        }

        food.SpawnRandomFood();

        if (wall.IsWall(posX, posY) || isBody(posX, posY)) {
        //    time.TimePeriod();
            System.exit(0);
        }

        if (food.IsFood(posX, posY)) {
            food.HasBeenEaten(posX, posY);
            grow();
        }
        // Cập nhật vị trí mới trên bản đồ
        updatePosition();

    }

    private void clearOldPosition() {
        // Xóa tất cả các phần của rắn khỏi layer
        for (int[] part : snakeBody) {
            layer.setCell(part[0], part[1], null);
        }
        layer.setCell(posX, posY, null);
    }

    private void updatePosition() {
        // Cập nhật thân rắn
        for (int[] part : snakeBody) {
            TiledMapTileLayer.Cell bodyCell = new TiledMapTileLayer.Cell();
            bodyCell.setTile(map.getTileSets().getTile(1454)); // Mã tile của thân rắn
            layer.setCell(part[0], part[1], bodyCell);
        }

        // Cập nhật đầu rắn
        TiledMapTileLayer.Cell headCell = new TiledMapTileLayer.Cell();
        if (dirX == 1 && dirY == 0) {
            headCell.setTile(map.getTileSets().getTile(1453)); // phải
        } else if (dirX == -1 && dirY == 0) {
            headCell.setTile(map.getTileSets().getTile(1451)); // trái
        } else if (dirX == 0 && dirY == 1) {
            headCell.setTile(map.getTileSets().getTile(1450)); // lên
        } else if (dirX == 0 && dirY == -1) {
            headCell.setTile(map.getTileSets().getTile(1452)); // xuống
        } else {
            headCell.setTile(map.getTileSets().getTile(1453)); // default fallback
        }

        layer.setCell(posX, posY, headCell);
    }

    public void changeDirection(int dx, int dy) {
        if ((dx != 0 && dirX == 0) || (dy != 0 && dirY == 0)) {
            dirX = dx;
            dirY = dy;
        }
    }

    public Boolean isBody(int x, int y) {
        for (int[] part : snakeBody) {
            if (part[0] == x && part[1] == y) {
                return true;
            }
        }
        return false;
    }

    public void grow() {
        // Thêm một phần thân mới vào vị trí cuối cùng của rắn
        if (!snakeBody.isEmpty()) {
            int[] lastPart = snakeBody.get(snakeBody.size() - 1);
            snakeBody.add(new int[]{lastPart[0], lastPart[1]});
        }
    }

    public void HeadDirection(int dx, int dy) {
        TiledMapTileLayer.Cell headCell = new TiledMapTileLayer.Cell();
        TiledMapTileLayer.Cell head1Cell = new TiledMapTileLayer.Cell();
        TiledMapTileLayer.Cell head2Cell = new TiledMapTileLayer.Cell();
        TiledMapTileLayer.Cell head3Cell = new TiledMapTileLayer.Cell();

        headCell.setTile(map.getTileSets().getTile(1453));// Mã tile của đầu rắn
        head1Cell.setTile(map.getTileSets().getTile(1452));// Mã tile của đầu rắn
        head2Cell.setTile(map.getTileSets().getTile(1451));// Mã tile của đầu rắn
        head3Cell.setTile(map.getTileSets().getTile(1450));// Mã tile của đầu rắn
        if (dx == 1 && dy == 0) {
            layer.setCell(posX, posY, headCell);
        }
        else if (dx == -1 && dy == 0) {
            layer.setCell(posX, posY, head2Cell);
        }
        else if (dx == 0 && dy == 1) {
            layer.setCell(posX, posY, head1Cell);
        }
        else if (dx == 0 && dy == -1) {
            layer.setCell(posX, posY, head3Cell);
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

}
