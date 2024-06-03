package handtohand.Scene.admin_scene;




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

public class AdminHomeScene {
    private Stage stage;

    public AdminHomeScene(Stage stage) {
        this.stage = stage;
    }

    public void show(int id) {
        User admin = UserControl.getUserById(id);

        Label labelTitle = new Label("Dashboard");
        labelTitle.setFont(Font.font("Poppins", FontWeight.BOLD, 24));

        Label labelWelcome = new Label("Selamat Datang Admin");
        labelWelcome.setFont(Font.font("Poppins", FontWeight.BOLD, 28));
        Label labelName = new Label(admin.getUsername());
        labelName.setFont(Font.font("Poppins", 22));
        VBox vBoxWelcome = new VBox(labelWelcome, labelName);
        vBoxWelcome.setAlignment(Pos.CENTER);
        vBoxWelcome.setPadding(new Insets(145, 0, 0, 0));
        vBoxWelcome.setSpacing(5);

        VBox vBoxMainContent = new VBox(labelTitle, vBoxWelcome);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(10);
        vBoxMainContent.setPrefWidth(620);

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getAdminNavbar(stage, id), vBoxMainContent);

        Header header = new Header();
        VBox root = new VBox(header.getHeader(), hBoxContent);
        stage.getScene().setRoot(root);
        /* ==> INSTANCE LAYOUT END <== */
    }

}
