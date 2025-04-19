package io.github.some_snake_name.model;

public class Score {
    public static int score = 0;

    public Score() {

    }

    public static int getScore() {
        return score;
    }

    public static int inCrease(int amount) {
        score += amount;
        return score;
    }
}
