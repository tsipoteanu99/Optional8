package lab8.java.dao;

import lab8.java.entities.Album;
import lab8.java.singleton.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumDAO {
    public Album getAlbum(int id) {
        try {
            String query = "select name, artist_id,RELEASE_YEAR from ALBUMS where id=" + id;
            Album album = new Album();
            album.setId(id);
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            String name = resultSet.getString(1);
            int artistId = resultSet.getInt(2);
            int releaseYear = resultSet.getInt(3);
            album.setName(name);
            album.setArtistId(artistId);
            album.setReleaseYear(releaseYear);
            album.setArtistName(this.getAlbumArtistId(album.getId()));
            return album;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public String getAlbumArtistId(int albumId) throws SQLException {
        String query = "select name from Artists where id=" + albumId;
        Connection connection = Database.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        return resultSet.getString(1);
    }
}
