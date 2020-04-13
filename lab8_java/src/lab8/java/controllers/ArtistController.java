package lab8.java.controllers;

import lab8.java.singleton.Database;

import java.sql.*;
import java.util.ArrayList;

public class ArtistController {
    public void create(String name, String country) {
        try {
            Connection connection = Database.getInstance().getConnection();
            String maxId = "select max(id) from artists";
            Statement statement = connection.createStatement();
            ResultSet resultCount = statement.executeQuery(maxId);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into artists values (?,?,?)");
            resultCount.next();
            preparedStatement.setObject(1, resultCount.getInt(1) + 1);
            preparedStatement.setObject(2, name);
            preparedStatement.setObject(3, country);
            preparedStatement.executeUpdate();
            connection.commit();
            connection.close();
        } catch (Exception ex) {
            ex.getMessage();
        }

    }


    public ArrayList<Integer> findByName(String artistName) throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        ArrayList<Integer> artistIdList=new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet querry = statement.executeQuery("select id from artists where name='" + artistName + "'");
            while(querry.next()){
                Integer id= querry.getInt(1);
                artistIdList.add(id);
            }
            querry.close();
            connection.close();
            return artistIdList;
        }
    }
}
