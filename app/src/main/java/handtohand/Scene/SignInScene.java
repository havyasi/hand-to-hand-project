package handtohand.Scene;

import handtohand.Scene.admin_scene.AdminHomeScene;
import handtohand.Scene.user_scene.HomeScene;
import handtohand.controllers.UserControl;
import handtohand.model.User;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SignInScene extends Tampil{
    Stage stage;

    public SignInScene(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void show() {
        Pane leftPane = new Pane();
        leftPane.getStyleClass().add("rectangle");

        VBox signingreet = new VBox(-15);
        Label create = new Label("Login to");
        create.getStyleClass().add("label");
  
        Label youraccount = new Label("Your Account");
        youraccount.getStyleClass().add("label");
        signingreet.getChildren().addAll(create, youraccount);
        signingreet.setLayoutX(95);
        signingreet.setLayoutY(99);

        VBox userbox = new VBox(5);
        Label username = new Label("Username");
        username.setLayoutX(93);
        username.setLayoutY(213);
        username.getStyleClass().add("labelup");
        TextField usernamefield = new TextField();
        usernamefield.getStyleClass().add("textfield");
        usernamefield.setPrefWidth(310);
        usernamefield.setPrefHeight(45);
        usernamefield.setLayoutX(91);
        usernamefield.setLayoutY(246);

        userbox.getChildren().addAll(username, usernamefield);
        userbox.setLayoutX(91);
        userbox.setLayoutY(213);

        VBox passwordbox = new VBox(5);
        Label password = new Label("Password");
        password.getStyleClass().add("labelup");
        password.setLayoutX(93);
        password.setLayoutY(335);
        PasswordField passwordfield = new PasswordField();
        passwordfield.getStyleClass().add("textfield");
        passwordfield.setPrefWidth(310);
        passwordfield.setPrefHeight(45);
        passwordfield.setLayoutX(91);
        passwordfield.setLayoutY(367);

        passwordbox.getChildren().addAll(password, passwordfield);
        passwordbox.setLayoutX(91);
        passwordbox.setLayoutY(335);

        Label labelStatus = new Label();

        Button signin = new Button("SIGN IN");
        signin.getStyleClass().add("buttonsignup");
        signin.setOnAction(e -> {
            String usernameText = usernamefield.getText();
            String passwordText = passwordfield.getText();

            if (usernameText.isEmpty() && passwordText.isEmpty()) {
                labelStatus.setText("Email dan password harus diisi!!!!!!!!!!!!!!!!!!!!!");
                return;
            }
            User user = UserControl.login(usernameText, passwordText);
            if (user != null) {
                int id = user.getId();
                String role = user.getRole();
                if (role.equals("admin")){
                    AdminHomeScene adminHomeScene = new AdminHomeScene(stage);
                    adminHomeScene.show(id);
                    
                }else{
                    HomeScene homeScene = new HomeScene(stage);
                    homeScene.show(id);
                }
            } else {
                
            }      
        });

        VBox userpass = new VBox(25);
        userpass.getChildren().addAll(userbox, passwordbox);
        userpass.setLayoutX(91);
        userpass.setLayoutY(213);

        VBox newmember = new VBox(17);
        newmember.getChildren().addAll(signingreet, userpass);
        newmember.setLayoutX(91);
        newmember.setLayoutY(99);

        VBox signinnew = new VBox(40);
        signinnew.getChildren().addAll(newmember, signin);
        signinnew.setLayoutX(91);
        signinnew.setLayoutY(120);
        signinnew.setAlignment(Pos.CENTER);

        Pane rightPane = new Pane();

        rightPane.getStyleClass().add("rectangleright");

        VBox greetsignin = new VBox(-10);
        Label heygood = new Label("Welcome to");
        heygood.getStyleClass().add("labelb");
        Label seeyou = new Label("Hand to Hand");
        seeyou.getStyleClass().add("labelb");
        greetsignin.getChildren().addAll(heygood, seeyou);
        greetsignin.setLayoutX(130);
        greetsignin.setLayoutY(110);
        greetsignin.setAlignment(Pos.CENTER);

        VBox randomword = new VBox(5);
        Label random1 = new Label("Enter your personal details");
        random1.getStyleClass().add("random");
        Label random2 = new Label("and start your journey with us!");
        random2.getStyleClass().add("random");
        randomword.getChildren().addAll(random1, random2);
        randomword.setLayoutX(130);
        randomword.setLayoutY(110);
        randomword.setAlignment(Pos.CENTER);

        Button gosignup = new Button("SIGN UP");
        gosignup.setFont(Font.font("Poppins", FontWeight.BOLD, 20));
        gosignup.setBorder(new Border(
                new BorderStroke(
                        Color.web("#F0EBE3"), BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(2))));
        gosignup.setPrefWidth(170);
        gosignup.setPrefHeight(50);
        gosignup.setBackground(new Background(new BackgroundFill(Color.web("#070F2B"), new CornerRadii(10), null)));
        gosignup.setTextFill(Color.web("#F0EBE3"));
        gosignup.setLayoutX(668);
        gosignup.setLayoutY(300);
    
        gosignup.setOnAction(e -> {
            SignUpScene signupscene = new SignUpScene(stage);
            signupscene.show();
        });

        VBox rightone = new VBox(17);
        rightone.getChildren().addAll(greetsignin, randomword);
        rightone.setLayoutX(130);
        rightone.setLayoutY(110);
        rightone.setAlignment(Pos.CENTER);

        VBox rightwo = new VBox(35);
        rightwo.getChildren().addAll(rightone, gosignup);
        rightwo.setLayoutX(130);
        rightwo.setLayoutY(170);
        rightwo.setAlignment(Pos.CENTER);

        leftPane.getChildren().add(signinnew);
        rightPane.getChildren().add(rightwo);

        HBox hbox = new HBox(leftPane, rightPane);
    
        leftPane.prefWidthProperty().bind(hbox.widthProperty().divide(2));
        rightPane.prefWidthProperty().bind(hbox.widthProperty().divide(2));

        Scene scene = new Scene(hbox, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("/Styles/Style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}