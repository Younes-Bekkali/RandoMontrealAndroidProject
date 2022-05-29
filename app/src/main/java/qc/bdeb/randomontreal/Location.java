package qc.bdeb.randomontreal;

public class Location {
    private String name;
    private int image;
    private String detail;


    public Location(String name, int image){
        this.name = name;
        this.image = image;
    }

    public Location(String name, int image, String detail) {
        this.name = name;
        this.image = image;
        this.detail = detail;
    }

    public Location() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


}
