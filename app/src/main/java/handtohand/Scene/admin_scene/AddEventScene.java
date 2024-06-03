package handtohand.Scene.admin_scene;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import handtohand.Scene.components.Header;
import handtohand.Scene.components.Navbar;
import handtohand.controllers.InformasiControl;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddEventScene{
    Stage stage;
    File selectedImageFile;


    public AddEventScene(Stage stage){
        this.stage = stage;
    }

    public void show(int id) {
        Label labelTitle = new Label("Tambah Informasi");
        labelTitle.setStyle("-fx-font-size : 16px");
        
        Label labelTitleInfo = new Label("Nama Kegiatan");
        TextField textFieldTitleInfo = new TextField();
        labelTitleInfo.setStyle("-fx-font-size : 16px");
        VBox vBoxTitle = new VBox(labelTitleInfo, textFieldTitleInfo);
        
        Label labelLokasi = new Label("Lokasi");
        TextField textFieldLokasi = new TextField();
        labelLokasi.setStyle("-fx-font-size : 16px");
        VBox vBoxLokasi = new VBox(labelLokasi, textFieldLokasi);
        
        Label labelWaktu = new Label("Waktu");
        TextField textFiteldWaktu = new TextField();
        labelWaktu.setStyle("-fx-font-size : 16px");
        VBox vBoxWaktu = new VBox(labelWaktu, textFiteldWaktu);
        
        Label labelDeskripsi = new Label("Deskripsi");
        TextArea textFieldDeskripsi = new TextArea();
        textFieldDeskripsi.setPromptText("Deskripsi");
        textFieldDeskripsi.getStyleClass().add("text-field-wide");
        textFieldDeskripsi.setMaxWidth(300);
        textFieldDeskripsi.setMaxHeight(150);
        textFieldDeskripsi.setWrapText(true); 
        textFieldDeskripsi.setPrefColumnCount(20); 
        labelDeskripsi.setStyle("-fx-font-size : 16px");
        VBox vBoxDeskripsi = new VBox(labelDeskripsi, textFieldDeskripsi);   

        Button buttonUploadImage = new Button("Upload Gambar");
        ImageView imageViewEvent = new ImageView();
        imageViewEvent.setFitHeight(200);
        imageViewEvent.setPreserveRatio(true);
        VBox vBoxImage = new VBox(buttonUploadImage, imageViewEvent);

        Button buttonAddEvent = new Button("Tambah Informasi");
        buttonAddEvent.setPrefWidth(200);

        VBox vBoxMainContent = new VBox(labelTitle, vBoxTitle, vBoxLokasi, vBoxWaktu, vBoxDeskripsi,
                 vBoxImage, buttonAddEvent);
        vBoxMainContent.setPadding(new Insets(10, 10, 20, 10));
        vBoxMainContent.setSpacing(10);
        vBoxMainContent.setPrefWidth(700);

        ScrollPane scrollPane = new ScrollPane(vBoxMainContent);
        scrollPane.setFitToWidth(true);

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getAdminNavbar(stage, id), scrollPane);

        Header header = new Header();
        VBox root = new VBox(header.getHeader(), hBoxContent);
        stage.getScene().setRoot(root);

        buttonAddEvent.setOnAction(e -> {
            String tittle = textFieldTitleInfo.getText();
            String lokasi = textFieldLokasi.getText();
            String waktu = textFiteldWaktu.getText();
            String deskripsi = textFieldDeskripsi.getText();

            String imagePath = null;
            if (selectedImageFile != null) {
                try {
                    imagePath = saveImage(selectedImageFile);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

            boolean isSuccessfulAddBook = InformasiControl.addEvent(tittle, imagePath, lokasi, waktu, deskripsi);
            if (isSuccessfulAddBook) {
                AdminHomeScene adminHomeScene = new AdminHomeScene(stage);
                adminHomeScene.show(id);
            }
        });

        buttonUploadImage.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                selectedImageFile = file;
                Image image = new Image(file.toURI().toString());
                imageViewEvent.setImage(image);
            }
        });
    }

    private String saveImage(File imageFile) throws IOException {
        String targetDirPath = "src/main/resources/images";
        File targetDir = new File(targetDirPath);

        File targetFile = new File(targetDir + "/" + imageFile.getName());
        try (FileInputStream in = new FileInputStream(imageFile);
                FileOutputStream out = new FileOutputStream(targetFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
        return targetFile.getPath();
    }

}

