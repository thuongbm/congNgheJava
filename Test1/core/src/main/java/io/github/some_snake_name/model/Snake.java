package io.github.some_snake_name.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

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

    public  Snake(){}

    public Snake(TiledMap map, TiledMapTileLayer layer,Wall wall, int startX, int startY) {
        this.map = map;
        this.layer = layer;
        this.posX = startX;
        this.posY = startY;
        this.wall = wall;

        // Thêm phần thân ban đầu
        for (int i = 1; i <= 4; i++) { // Ban đầu rắn có 3 đốt
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

        if (wall.IsWall(posX, posY)) {
            System.out.println("Game Over");
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
            bodyCell.setTile(map.getTileSets().getTile(233)); // Mã tile của thân rắn
            layer.setCell(part[0], part[1], bodyCell);
        }

        // Cập nhật đầu rắn
        TiledMapTileLayer.Cell headCell = new TiledMapTileLayer.Cell();
        headCell.setTile(map.getTileSets().getTile(230)); // Mã tile của đầu rắn
        layer.setCell(posX, posY, headCell);
    }

    public void changeDirection(int dx, int dy) {
        if ((dx != 0 && dirX == 0) || (dy != 0 && dirY == 0)) {
            dirX = dx;
            dirY = dy;
        }
    }



    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
