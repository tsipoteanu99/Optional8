package lab8.java.controllers;

import lab8.java.singleton.Database;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class ChartController {
    public void create(String albumName, String artistName) throws SQLException {


        try {Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultCount = statement.executeQuery("select max(id) from charts");
             PreparedStatement statement2 = connection.prepareStatement("insert into charts (id, album_name, artist_name, LIKES) values (?, ?, ?, 0)");
            resultCount.next();
            statement2.setInt(1, resultCount.getInt(1) + 1);
            statement2.setString(2, albumName);
            statement2.setString(3, artistName);
            statement2.executeUpdate();
            connection.commit();
            connection.close();
        }catch (Exception ex){
            ex.getMessage();
        }
    }

    public ArrayList<String> getTop() throws SQLException {
        Connection connection = Database.getInstance().getConnection();

        String artistName;
        ArrayList<String> top = new ArrayList<>();
        int count = 10;

        try (
            Statement statement = connection.createStatement()){
            ResultSet querry = statement.executeQuery("select artist_name from charts order by LIKES desc");
            while (querry.next() && count>0) {
                artistName = querry.getString(1);
                top.add(artistName);
                count--;
            }
            querry.close();
            connection.close();
            return top;
        } catch (Exception ex) {
            ex.getMessage();
        }
        return null;
    }
}
