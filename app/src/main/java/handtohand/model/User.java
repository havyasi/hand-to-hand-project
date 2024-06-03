package handtohand.model;

public class User extends Model {   
    private String username;
    private String nama;
    private String hobby;
    private String mottoHidup;
    private String role;
    private String profesi;
    private int usia;
    
    
    public User(int id, String role, String username){
        super(id);
        this.role = role;
        this.username = username;
    }

    public User(int id, String username, String profesi, String nama, String hobby, String mottoHidup, String role, int usia) {
        super(id);
        this.username = username;
        this.nama = nama;
        this.usia = usia;
        this.hobby = hobby;
        this.profesi = profesi;
        this.mottoHidup = mottoHidup;
        this.role = role;
    }
        
    public String getUsername() {
        return username;
    }
        
    public void setUsername(String username) {
        this.username = username;
    }
        
    public String getProfesi() {
         return profesi;
    }
        
    public void setProfesi(String profesi) {
        this.profesi = profesi;
    }
        
    public String getNama() {
        return nama;
    }
        
    public void setNama(String nama) {
        this.nama = nama;
    }
        
    public int getUsia() {
        return usia;
    }
        
    public void setUsia(int usia) {
        this.usia = usia;
    }
        
    public String getHobby() {
        return hobby;
    }
        
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
        
    public String getMottoHidup() {
        return mottoHidup;
    }
        
    public void setMottoHidup(String mottoHidup) {
        this.mottoHidup = mottoHidup;
    }

    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
}
    