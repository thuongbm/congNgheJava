package io.github.some_snake_name.model.data;

public class Profile {
    private String userName;
    private int levelMap;
    private int highScore;

    public Profile() {
        this.userName = "Son adu TKvip";
        this.highScore = 100;
        this.levelMap = 2;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLevelMap() {
        return levelMap;
    }

    public void setLevelMap(int levelMap) {
        this.levelMap = levelMap;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
