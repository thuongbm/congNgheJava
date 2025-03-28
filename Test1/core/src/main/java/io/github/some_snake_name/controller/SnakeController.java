package io.github.some_snake_name.controller;

import io.github.some_snake_name.model.SnakeModel;

public class SnakeController {
    private SnakeModel snakeModel;

    public SnakeController(){
        snakeModel = new SnakeModel();
    }

    public void createGame(){
        this.snakeModel = new SnakeModel();
    }

    public void renderGame(){
        this.snakeModel.render();
    }

    public void gameOver(){
        this.dispose();
    }

    public void gamePlay() {
//        this.createGame();
        this.renderGame();
    }
    public void dispose(){
        snakeModel.dispose();
    }

    public SnakeModel getSnakeModel(){return  this.snakeModel; }
}
