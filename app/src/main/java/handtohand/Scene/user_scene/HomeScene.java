package handtohand.Scene.user_scene;

import handtohand.Scene.components.Header;
import handtohand.Scene.components.Navbar;
import handtohand.controllers.UserControl;
import handtohand.model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HomeScene {
    private Stage stage;

    public HomeScene(Stage stage) {
        this.stage = stage;
    }

    public void show(int id) {
        User user = UserControl.getUserById(id);

        Label labelTitle = new Label("Dashboard");
        labelTitle.setFont(Font.font("System", FontWeight.BOLD, 24));

        Label labelWelcome = new Label("Welcome to Hand to Hand");
        labelWelcome.setFont(Font.font("Poppins", FontWeight.BOLD, 28));
        Label welcome2 = new Label(user.getUsername()); 
        welcome2.setFont(Font.font("Poppins", 25));
        VBox vBoxWelcome = new VBox(labelWelcome, welcome2);
        vBoxWelcome.setAlignment(Pos.CENTER);
        vBoxWelcome.setPadding(new Insets(145, 0, 0, 0));
        vBoxWelcome.setSpacing(5);

        VBox vBoxMainContent = new VBox(labelTitle, vBoxWelcome);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(10);
        vBoxMainContent.setPrefWidth(620);

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getUserNavbar(stage, id), vBoxMainContent);

        Header header = new Header();
        VBox root = new VBox(header.getHeader(), hBoxContent);
        stage.getScene().setRoot(root);
    }
}
