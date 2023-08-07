public class Album extends Product {

    private String artist;
    public Album() {
        super();
        artist = "";
        count++;
    }

    public void setArtist (String artist) { this.artist = artist; }

    @Override
    public String toString() {
        return super.toString() + " by " + "(" + artist + ")";
    }
}
