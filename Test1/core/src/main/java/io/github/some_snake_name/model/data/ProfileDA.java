package io.github.some_snake_name.model.data;

import io.github.some_snake_name.model.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileDA {
    private Connection connection;

    public ProfileDA(Connection conn) {
        this.connection = conn;
    }

    public boolean hasAccount() throws SQLException {
        String sql="select top 1 Pid " +
            "from Player ";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                System.out.println("has account");
                return true;
            }
        }
        System.out.println("hasn't account");
        return false;
    }

    public Profile getProfile() throws SQLException {
        String sql="select Pid, Username, Score " +
            "from Player";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                int score = rs.getInt(3);
                return new Profile(id,name,score);
            }
            return null;
        }

    }

    public void updateProfile(int score) throws SQLException {
        String sql="update Player " +
            "set Score = ? " +
            "where Score < ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1,score);
            stmt.setInt(2,score);
            stmt.execute();
            System.out.println("updated successfully");
        }
    }

    public void createDefaultAccount() throws SQLException {
        String sql="insert into Player (Pid, Username,Score)" +
            "values ('P01','SonaduTKvip',0)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.execute();
            System.out.println("created account successfully");
        }
    }

    public static void main(String[] args) throws SQLException {
        DataAccess dataAccess = new DataAccess();

        try {
            dataAccess.createConnection();
            //
            ProfileDA profileDA = new ProfileDA(dataAccess.getConnection());
            //
            System.out.println("has account: " + profileDA.hasAccount());
            if(!profileDA.hasAccount()) profileDA.createDefaultAccount();
            profileDA.updateProfile(10);
            System.out.println(profileDA.getProfile());
            //
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            dataAccess.closeConnection();
        }
    }
}
