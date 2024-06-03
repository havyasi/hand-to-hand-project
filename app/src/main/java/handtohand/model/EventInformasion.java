package handtohand.model;

public class EventInformasion extends Model {
    private String title;
    private String image_path;
    private String lokasi;
    private String waktu;
    private String deskripsi;
    
    public EventInformasion(int id, String title, String image_path, String lokasi, String waktu, String deskripsi) {
        super(id);
        this.title = title;
        this.image_path = image_path;
        this.lokasi = lokasi;
        this.waktu = waktu;
        this.deskripsi = deskripsi;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImage_path() {
        return image_path;
    }
    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
    public String getLokasi() {
        return lokasi;
    }
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    public String getWaktu() {
        return waktu;
    }
    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
