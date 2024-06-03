package handtohand.Scene.user_scene;

import java.io.File;

import handtohand.Scene.components.Header;
import handtohand.Scene.components.Navbar;
import handtohand.controllers.InformasiControl;
import handtohand.controllers.UserControl;
import handtohand.model.EventInformasion;
import handtohand.model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class EventdetailScene {
    private Stage stage;

    public EventdetailScene(Stage stage) {
        this.stage = stage;
    }

    public void show(int id, int eventId) {
        User user = UserControl.getUserById(id);

        EventInformasion event = InformasiControl.getInfoById(eventId);

        Label labelTitle = new Label("Detail Kegiatan");  
        labelTitle.setFont(Font.font("Sytem", FontWeight.BOLD, 24));
        labelTitle.setStyle("-fx-font-size: 24px;"); 
        
        Label labelTitleInfo = new Label(event.getTitle());
        labelTitleInfo.setFont(Font.font("System", FontWeight.BOLD, 20));
        labelTitleInfo.setStyle("-fx-font-size: 20px;"); 
        VBox vBoxTitleInfo = new VBox(labelTitleInfo);
        vBoxTitleInfo.setAlignment(Pos.CENTER);

        ImageView imageViewBook = new ImageView();
        imageViewBook.setFitHeight(200);
        imageViewBook.setPreserveRatio(true);
        
        if (event.getImage_path() != null && !event.getImage_path().isEmpty()) {
            File fileImage = new File(event.getImage_path());
            if (fileImage.exists()) {
                Image imageBook = new Image(fileImage.toURI().toString());
                imageViewBook.setImage(imageBook);
            }
        }
        VBox vBoxImageBook = new VBox(imageViewBook);
        vBoxImageBook.setAlignment(Pos.CENTER);

        Label labelLokasi = new Label("Lokasi");
        labelLokasi.setStyle("-fx-font-size : 16px");
        Label labelWaktu = new Label("Waktu");
        labelWaktu.setStyle("-fx-font-size : 16px");
        Label labelDeskripsi = new Label("Deskripsi");
        labelDeskripsi.setStyle("-fx-font-size : 16px");
        VBox VBoxInfo = new VBox(labelLokasi, labelWaktu, labelDeskripsi);
        VBoxInfo.setStyle("-fx-background-color : red ; -fx-background-width : 30");
        
        Label labelLokasiValue = new Label(": " + event.getLokasi());
        labelLokasiValue.setStyle("-fx-font-size: 16px; -fx-font-weight: normal;"); 
        Label labelWaktuValue = new Label(": " + event.getWaktu());
        labelWaktuValue.setStyle("-fx-font-size: 16px; -fx-font-weight: normal;"); 
        Label labelDeskripsiValue = new Label(": " + event.getDeskripsi());
        labelDeskripsiValue.setStyle("-fx-font-size: 16px; -fx-font-weight: normal;"); 
        labelDeskripsiValue.setMaxWidth(400); 
        labelDeskripsiValue.setWrapText(true);
        VBox vBoxInfoValue = new VBox(labelLokasiValue, labelWaktuValue, labelDeskripsiValue);
        vBoxInfoValue.setStyle("-fx-background-color : blue; -fx-background-width : 20px;");

        HBox lokasi = new HBox(5);
        lokasi.getChildren().addAll(labelLokasi, labelLokasiValue);
        HBox waktu = new HBox(5);
        waktu.getChildren().addAll(labelWaktu, labelWaktuValue);
        HBox deskripsi = new HBox(5);
        deskripsi.getChildren().addAll(labelDeskripsi, labelDeskripsiValue);

        VBox info = new VBox(5);
        info.getChildren().addAll(lokasi, waktu, deskripsi);
        info.setPadding(new Insets(0, 0, 0, 20));        

        VBox vBoxMainContent = new VBox(labelTitle, vBoxTitleInfo, vBoxImageBook, info);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(15);
        vBoxMainContent.setPrefWidth(620);

        ScrollPane scrollPane = new ScrollPane(vBoxMainContent);
        scrollPane.setFitToWidth(true);

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getUserNavbar(stage, id), scrollPane);

        Header header = new Header();
        VBox root = new VBox(header.getHeader(), hBoxContent);
        stage.getScene().setRoot(root);
    }

}
