package lab8.java.dao;

import lab8.java.entities.Album;
import lab8.java.entities.Chart;
import lab8.java.singleton.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChartDAO {
    public Chart getChart(int id){
        try {
            String query = "select album_name, artist_name, likes from charts where id="+id;
            Chart chart = new Chart();
            chart.setId(id);
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            String albumName = resultSet.getString(1);
            String artistName = resultSet.getString(2);
            int likes = resultSet.getInt(3);
            chart.setAlbumName(albumName);
            chart.setArtistName(artistName);
            chart.setLikes(likes);
            return chart;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
}
