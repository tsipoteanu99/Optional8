package lab8.java.controllers;

import lab8.java.singleton.Database;

import java.sql.*;

import static java.lang.String.*;

public class AlbumController {
    public void create(String albumName, int artistID, int releaseYear) throws SQLException {


        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultCount = statement.executeQuery("select max(id) from albums");
            PreparedStatement statement2 = connection.prepareStatement("insert into albums values (?, ?, ?, ?)");
                resultCount.next();
                statement2.setInt(1, resultCount.getInt(1) + 1);
                statement2.setString(2, albumName);
                statement2.setInt(3, artistID);
                statement2.setInt(4, releaseYear);
                statement2.executeUpdate();
                connection.commit();
            connection.close();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    public Integer findByArtist(int artistID) throws SQLException {
        Connection con = Database.getInstance().getConnection();
        try (Statement statement = con.createStatement()) {
            ResultSet querry = statement.executeQuery("select id from albums where ARTIST_ID=" + artistID);
            Integer id = querry.next() ? querry.getInt(1) : null;
            querry.close();
            con.close();
            return id;
        }
    }
}