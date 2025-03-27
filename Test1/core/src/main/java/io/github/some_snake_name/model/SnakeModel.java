package io.github.some_snake_name.model;

public class SnakeModel {
    private Snake snake;
    private Food food;
    private Profile profile;
    private int score;
    public SnakeModel(){
        snake = new Snake();
        food = new Food();
        profile=new Profile();
        score =0;
//        gameMap = new GameMap("Map/Map1/examples/Test/ran1.tmx");
//        snake = new Snake(gameMap.getMap(),
//       (com.badlogic.gdx.maps.tiled.TiledMapTileLayer) gameMap.getMap().getLayers().get("snake"),5, 5);
//        gameCamera = new GameCamera(snake);
    }


    //    public SnakeModel() {
//        gameMap = new GameMap("Map/Map1/examples/Test/ran1.tmx");
//        snake = new Snake(gameMap.getMap(),
//            (com.badlogic.gdx.maps.tiled.TiledMapTileLayer) gameMap.getMap().getLayers().get("snake"),
//            5, 5);
//        food = new Food();
    ////        food.generateNewFood(gameMap.getMapWidth(), gameMap.getMapHeight());
//        profile = new Profile();
//        gameOver = false;
//        score = 0;
//    }

//    public void update(float deltaTime) {
//        if (!gameOver) {
//            snake.update(deltaTime);
//
//            if (snake.checkFoodCollision(food)) {
//                score += 10;
//                food.generateNewFood(gameMap.getMapWidth(), gameMap.getMapHeight());
//                if (score > profile.getHighScore()) {
//                    profile.setHighScore(score);
//                }
//            }
//
//            gameOver = snake.checkSelfCollision() ||
//                snake.checkWallCollision(gameMap.getMapWidth(), gameMap.getMapHeight());
//        }
//    }

//    public void resetGame() {
//        snake.dispose();
//        snake = new Snake(gameMap.getMap(),
//            (com.badlogic.gdx.maps.tiled.TiledMapTileLayer) gameMap.getMap().getLayers().get("snake"),
//            5, 5);
//        food.generateNewFood(gameMap.getMapWidth(), gameMap.getMapHeight());
//        gameOver = false;
//        score = 0;
//    }

    public Snake getSnake() { return snake; }
    public Food getFood() { return food; }
    public Profile getProfile() { return profile; }
    public int getScore() { return score; }

}
