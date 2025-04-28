package io.github.some_snake_name.model;

public class Profile {
    private String id;
    private String user_name;
    private int highest_score;

    @Override
    public String toString() {
        return "Profile{" +
            "id='" + id + '\'' +
            ", user_name='" + user_name + '\'' +
            ", highest_score=" + highest_score +
            '}';
    }

    public Profile(String id, String user_name, int highest_score) {
        this.id = id;
        this.user_name = user_name;
        this.highest_score = highest_score;
    }

    public Profile() {
    }

    public String getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public int getHighest_score() {
        return highest_score;
    }

    public void setHighest_score(int highest_score) {
        this.highest_score = highest_score;
    }

    public void setProfile (Profile other){
        this.id = other.getId();
        this.user_name = other.getUser_name();
        this.highest_score = other.getHighest_score();
    }
}

