package handtohand.Scene;

import handtohand.controllers.UserControl;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignUpScene extends Tampil {
    Stage stage;

    public SignUpScene(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void show() {
        Pane leftPane = new Pane();
        leftPane.getStyleClass().add("rectangle");

        VBox signupgreet = new VBox(-15);
        Label create = new Label("Create");
        create.getStyleClass().add("label");
        Label youraccount = new Label("Your Account");
        youraccount.getStyleClass().add("label");
        signupgreet.getChildren().addAll(create, youraccount);
        signupgreet.setLayoutX(95);
        signupgreet.setLayoutY(99);

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

        Label labelStatus = new Label();
        labelStatus.getStyleClass().add("label");

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

        Button signup = new Button("SIGN UP");
        signup.getStyleClass().add("buttonsignup");
        signup.setOnAction(e -> {
            String usernameText = usernamefield.getText();
            String passwordText = passwordfield.getText();

            if (usernameText.isEmpty() && passwordText.isEmpty()) {
                labelStatus.setText("Data tidak boleh kosong!");
                return;
            }
            if (UserControl.registerUser(usernameText, passwordText)) {
                SignInScene signinscene = new SignInScene(stage);
                signinscene.show();
            } else {
                labelStatus.setText("Gagal mendaftar. Pastikan data yang diisi benar!");
            }
            
        });

        VBox userpass = new VBox(25);
        userpass.getChildren().addAll(userbox, passwordbox);
        userpass.setLayoutX(91);
        userpass.setLayoutY(213);

        VBox newmember = new VBox(17);
        newmember.getChildren().addAll(signupgreet, userpass);
        newmember.setLayoutX(91);
        newmember.setLayoutY(99);

        VBox signupnew = new VBox(40);
        signupnew.getChildren().addAll(newmember, signup, labelStatus);
        signupnew.setLayoutX(91);
        signupnew.setLayoutY(120);
        signupnew.setAlignment(Pos.CENTER);

        Pane rightPane = new Pane();
        rightPane.getStyleClass().add("rectangleright");

        VBox greetsignin = new VBox(-10);
        Label heygood = new Label("Hey, Good to");
        heygood.getStyleClass().add("labelb");
        Label seeyou = new Label("See You Again");
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

        Button gosignin = new Button("SIGN IN");
        gosignin.getStyleClass().add("buttongo");
        gosignin.setOnAction(e -> {
            SignInScene signinscene = new SignInScene(stage);
            signinscene.show();
        });

        VBox rightone = new VBox(17);
        rightone.getChildren().addAll(greetsignin, randomword);
        rightone.setLayoutX(130);
        rightone.setLayoutY(110);
        rightone.setAlignment(Pos.CENTER);

        VBox rightwo = new VBox(35);
        rightwo.getChildren().addAll(rightone, gosignin);
        rightwo.setLayoutX(130);
        rightwo.setLayoutY(170);
        rightwo.setAlignment(Pos.CENTER);

        leftPane.getChildren().add(signupnew);
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
