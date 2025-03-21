package io.github.some_snake_name.model;

public class Profile {
    public String UserName;
    public int levelMap;
    public int HightScore;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public int getLevelMap() {
        return levelMap;
    }

    public void setLevelMap(int levelMap) {
        this.levelMap = levelMap;
    }

    public int getHightScore() {
        return HightScore;
    }

    public void setHightScore(int hightScore) {
        HightScore = hightScore;
    }

    public void Display(){
        System.out.println("<> " + this.UserName);
        System.out.println("<> " + this.HightScore);
        System.out.println("<> " + this.levelMap);
    }
}

