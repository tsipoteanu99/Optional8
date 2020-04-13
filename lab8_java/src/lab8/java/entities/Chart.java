package lab8.java.entities;

public class Chart {
    private int id;
    private String albumName;
    private String artistName;
    private int likes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "id=" + id +
                ", albumName='" + albumName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", likes=" + likes +
                '}';
    }
}
