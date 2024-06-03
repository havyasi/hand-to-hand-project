package handtohand.Scene.components;

import handtohand.Scene.SignInScene;
import handtohand.Scene.SignUpScene;
import handtohand.Scene.admin_scene.AddEventScene;
import handtohand.Scene.admin_scene.AdminHomeScene;
import handtohand.Scene.admin_scene.ListEventScene;
import handtohand.Scene.user_scene.EventListScene;
import handtohand.Scene.user_scene.HomeScene;
import handtohand.Scene.user_scene.MyProfile;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Navbar {
    public VBox getAdminNavbar(Stage stage, int userid) {
        Button buttonHome = new Button("Dashboard");
        Button buttonListEvent = new Button("List Event");
        Button buttonAddBook = new Button("Tambah Event");

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        Button buttonLogout = new Button("Logout");
        buttonLogout.getStyleClass().add("button-logout");

        VBox navbar = new VBox(buttonHome, buttonListEvent, buttonAddBook, spacer, buttonLogout);
        navbar.setBackground(new Background(new BackgroundFill(Color.web("#070F2B"), null, null)));
        navbar.setPrefWidth(200);
        navbar.setPrefHeight(600);
        navbar.getStyleClass().add("navbar");
        navbar.setPadding(new Insets(30, 0, 0, 39));


        navbar.getStylesheets().add(getClass().getResource("/Styles/navbar.css").toExternalForm());
        
        buttonHome.setOnAction(e -> {
            AdminHomeScene adminHomeScene = new AdminHomeScene(stage);
            adminHomeScene.show(userid);
        });

        buttonListEvent.setOnAction(e -> {
            ListEventScene listEventScene = new ListEventScene(stage);
            listEventScene.show(userid);
        });

        buttonAddBook.setOnAction(e -> {
            AddEventScene addEveAddEventScene = new AddEventScene(stage);
            addEveAddEventScene.show(userid);
        });

        buttonLogout.setOnAction(e -> {
            SignInScene signInScene = new SignInScene(stage);
            signInScene.show();
        });
        return navbar;
    }

    public VBox getUserNavbar(Stage stage, int id) {
        Button buttonHome = new Button("Dashboard");
        Button buttonListEvent = new Button("List Informasi");

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        Button buttonProfile = new Button("My Profile");
        Button buttonLogout = new Button("Logout");
        buttonLogout.getStyleClass().add("button-logout");

        VBox navbar = new VBox(buttonHome, buttonListEvent, spacer, buttonProfile, buttonLogout);
        navbar.setBackground(new Background(new BackgroundFill(Color.web("#070F2B"), null, null)));
        navbar.setPrefWidth(200);
        navbar.setPrefHeight(600);
        navbar.setPadding(new Insets(30, 0, 0, 10));
        navbar.getStyleClass().add("navbar");

        navbar.getStylesheets().add(getClass().getResource("/Styles/navbar.css").toExternalForm());

        buttonHome.setOnAction(e -> {
            HomeScene homeScene = new HomeScene(stage);
            homeScene.show(id);
        });

        buttonListEvent.setOnAction(e -> {
            EventListScene eventListScene = new EventListScene(stage);
            eventListScene.show(id);
        });

        buttonProfile.setOnAction(e -> {
            MyProfile myProfile = new MyProfile(stage);
            myProfile.show(id);
        });

        buttonLogout.setOnAction(e -> {
            SignUpScene signUpScene = new SignUpScene(stage);
            signUpScene.show();
        });
        return navbar;
    }
}
