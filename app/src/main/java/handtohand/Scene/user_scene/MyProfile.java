package handtohand.Scene.user_scene;

import handtohand.Scene.components.Header;
import handtohand.Scene.components.Navbar;
import handtohand.controllers.UserControl;
import handtohand.model.User;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MyProfile {
    private Stage stage;

    public MyProfile(Stage stage) {
        this.stage = stage;
    }

    public void show(int id) {
        User user = UserControl.getUserById(id);

        Label labelTitle = new Label("My Profile");
        labelTitle.setFont(Font.font("Sytem", FontWeight.BOLD, 17));
        labelTitle.setStyle("-fx-font-size : 16px");
        
        
        Label labelUsername = new Label("Username");
        labelUsername.setStyle("-fx-font-size : 16px");
        TextField textFieldUsername = new TextField(user.getUsername());
        textFieldUsername.setEditable(false);
        VBox vBoxUsername = new VBox(labelUsername, textFieldUsername);
        
        Label labelNama = new Label("Nama");
        labelNama.setStyle("-fx-font-size : 16px");
        TextField textFieldNama = new TextField(user.getNama());
        VBox vBoxNama = new VBox(labelNama, textFieldNama);
        
        Label labelProfesi = new Label("Profesi");
        labelProfesi.setStyle("-fx-font-size : 16px");
        TextField textfieldProfesi = new TextField(user.getProfesi());
        VBox vBoxProfesi = new VBox(labelProfesi, textfieldProfesi);
        
        Label labelUsia = new Label("Usia");
        labelUsia.setStyle("-fx-font-size : 16px");
        TextField textFieldUsia = new TextField(String.valueOf(user.getUsia()));
        VBox vBoxAge = new VBox(labelUsia, textFieldUsia);
        
        Label labelHobby = new Label("Hobby");
        labelHobby.setStyle("-fx-font-size : 16px");
        TextField textFieldHobby = new TextField(String.valueOf(user.getUsia()));
        VBox vBoxHobby = new VBox(labelHobby, textFieldHobby);
        
        Label labelMotto = new Label("Motto");
        labelMotto.setStyle("-fx-font-size : 16px");
        TextField textFieldMotto = new TextField(String.valueOf(user.getUsia()));
        VBox vBoxMotto = new VBox(labelMotto, textFieldMotto);

        Button buttonUpdate = new Button("Perbarui Profil");
        buttonUpdate.setPrefWidth(200);

        VBox vBoxMainContent = new VBox(labelTitle, vBoxUsername, vBoxNama, vBoxProfesi, vBoxAge, vBoxHobby, vBoxMotto,buttonUpdate);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(10);
        vBoxMainContent.setPrefWidth(620);

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getUserNavbar(stage, id), vBoxMainContent);

        Header header = new Header();
        VBox root = new VBox(header.getHeader(), hBoxContent);
        stage.getScene().setRoot(root);
    
        buttonUpdate.setOnAction(e -> {
         
            String username = textFieldUsername.getText();
            String name = textFieldNama.getText();
            String profesi = textfieldProfesi.getText();
            int age = Integer.parseInt(textFieldUsia.getText());
            String hobby = textFieldHobby.getText();
            String motto = textFieldMotto.getText();

     
            boolean isSuccessfulUpdateUser = UserControl.updateUser(id, username, name, profesi, motto, hobby,age);
            if (isSuccessfulUpdateUser) {
                HomeScene homeScene = new HomeScene(stage);
                homeScene.show(id);
            }
        });
    }

}
