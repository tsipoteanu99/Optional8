package lab8.java;
import lab8.java.controllers.AlbumController;
import lab8.java.controllers.ArtistController;
import lab8.java.controllers.ChartController;
import lab8.java.dao.AlbumDAO;
import lab8.java.dao.ArtistDAO;
import lab8.java.entities.Album;
import lab8.java.entities.Artist;
import lab8.java.singleton.Database;

import java.sql.Connection;
import java.sql.SQLException;

import static javafx.application.Platform.exit;

public class Main {

    public static void main(String[] args) throws SQLException {

        /* ->>>>>> COMPULSORY <<<<<<<- */

        /* INSTANTIEREA CONTROLLERELOR */

         //   ArtistController artistController = new ArtistController();
            AlbumController albumController = new AlbumController();

        /* TESTAREA METODELOR DIN CONTROLLERE */

          //  artistController.create("Razvan", "romania");
          //  System.out.println(artistController.findByName("Razvan"));

          //  albumController.create("colindecraciun",15,2018);
           // System.out.println(albumController.findByArtist(15));

        /* ->>>>>> OPTIONAL <<<<<<<- */

            Artist myArtist= new ArtistDAO().getArtist(1);
            Album myAlbum= new AlbumDAO().getAlbum(3);

            System.out.println(myArtist);
            System.out.println(myAlbum);


            ChartController chartController=new ChartController();
         //   chartController.create(myAlbum.getName(),myAlbum.getArtistName());

       System.out.println(chartController.getTop());


    }

}
