package handtohand.controllers;

import java.util.ArrayList;
import java.util.List;

import handtohand.Config.DbConfig;
import handtohand.model.EventInformasion;

public class InformasiControl extends DbConfig{

    public static boolean addEvent(String title, String imagePath, String lokasi, String waktu,
            String deskripsi) {
        query = "INSERT INTO informasi (title, image_path, lokasi, waktu, deskripsi) VALUES (?, ?, ?, ?, ?)";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, imagePath);
            preparedStatement.setString(3, lokasi);
            preparedStatement.setString(4, waktu);
            preparedStatement.setString(5, deskripsi);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static List<EventInformasion> getAllInfo(){
        List<EventInformasion> infos = new ArrayList<>();
        query = "SELECT * FROM informasi";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultset = preparedStatement.executeQuery();
            while(resultset.next()){
                int id = resultset.getInt("id");
                String title = resultset.getString("title");
                String image_path = resultset.getString("image_path");
                String lokasi = resultset.getString("lokasi");
                String waktu = resultset.getString("waktu");
                String deskripsi = resultset.getString("deskripsi");
                EventInformasion info = new EventInformasion(id, title, image_path, lokasi, waktu, deskripsi);
                infos.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return infos;
    }

    public static EventInformasion getInfoById(int id){
        query = "SELECT * FROM informasi WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultset = preparedStatement.executeQuery();
            while(resultset.next()){
                String title = resultset.getString("title");
                String image_path = resultset.getString("image_path");
                String lokasi = resultset.getString("lokasi");
                String waktu = resultset.getString("waktu");
                String deskripsi = resultset.getString("deskripsi");
                // int peserta = resultset.getInt("peserta");
                EventInformasion event = new EventInformasion(id, title, image_path, lokasi, waktu, deskripsi);
                return event;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

        public static boolean updateInfo(int id, String title, String lokasi, String waktu, String deskripsi) {
        query = "UPDATE informasi SET title=?, lokasi=?, waktu=?, deskripsi=? WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, lokasi);
            preparedStatement.setString(3, waktu);
            preparedStatement.setString(4, deskripsi);
            // preparedStatement.setInt(5, stock);
            preparedStatement.setInt(6, id);
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // DELETE
    public static boolean deleteInfo(int id) {
        query = "DELETE FROM informasi WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}



    // public static boolean  addInfo(String image_path, String lokasi, String waktu, String deskripsi,int peserta){
    //     query = "INSERT INTO informasi (image_path, lokasi, waktu, deskripsi, peserta) VALUES (?, ?, ?, ?, ?)";
    //     try {
    //         getConnection();
    //         preparedStatement.setString(1, image_path);
    //         preparedStatement.setString(2, lokasi);
    //         preparedStatement.setString(3, waktu);
    //         preparedStatement.setString(4, deskripsi);
    //         preparedStatement.setInt(5, peserta);
    //         preparedStatement.executeUpdate();
    //         return true;

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return false;
    // }

    // public static boolean JoinPeserta(){
    //     query = "SELECT * FROM informasi";
    //     try {
    //         getConnection();
    //         preparedStatement = connection.prepareStatement(query);
    //         resultset = preparedStatement.executeQuery();
    //         if(resultset.next()){
    //             int peserta = resultset.getInt("peserta");
    //             try {
    //                 getConnection();
    //                 String query1 = "INSERT INTO informasi (peserta) VALUES (?)";
    //                 PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
    //                 int pesesrtaNew = peserta+1;
    //                 preparedStatement1.setInt(1, pesesrtaNew);
    //                 return  true;
    //             } catch (Exception e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //         return false;

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return false;
    //     }
    // }

