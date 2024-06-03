package handtohand.Scene.admin_scene;

import java.util.List;

import handtohand.Scene.components.Header;
import handtohand.Scene.components.Navbar;
import handtohand.controllers.InformasiControl;
import handtohand.model.EventInformasion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ListEventScene {
    Stage stage;

    public ListEventScene(Stage stage) {
        this.stage = stage;
    }

    public void show(int Id) {
        List<EventInformasion> eventsData = InformasiControl.getAllInfo();

        Label labelTitle = new Label("List Informasi");
        labelTitle.setFont(Font.font("System", FontWeight.BOLD, 24));
        labelTitle.setStyle("-fx-font-size : 16px");

        ObservableList<EventInformasion> infos = FXCollections.observableArrayList();
        infos.addAll(eventsData);

        TableView<EventInformasion> tableViewEvents = new TableView<>();
        
        TableColumn<EventInformasion, String> columnId = new TableColumn<>("Id");
        TableColumn<EventInformasion, String> columnTitle = new TableColumn<>("Judul Kegiatan");
        TableColumn<EventInformasion, String> columnLocation = new TableColumn<>("Lokasi");
        TableColumn<EventInformasion, String> columnTime = new TableColumn<>("Waktu");
        TableColumn<EventInformasion, String> columnDescription = new TableColumn<>("Deskripsi");

        columnId.setPrefWidth(40);
        columnTitle.setPrefWidth(180);
        columnLocation.setPrefWidth(120);
        columnTime.setPrefWidth(120);
        columnDescription.setPrefWidth(100);

        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnLocation.setCellValueFactory(new PropertyValueFactory<>("lokasi"));
        columnTime.setCellValueFactory(new PropertyValueFactory<>("waktu"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        
        columnId.setStyle("-fx-font-size: 14px;");
        columnTitle.setStyle("-fx-font-size: 14px;");
        columnLocation.setStyle("-fx-font-size: 14px;");
        columnTime.setStyle("-fx-font-size: 14px;");
        columnDescription.setStyle("-fx-font-size: 14px;");
        
        tableViewEvents.getColumns().addAll(columnId, columnTitle, columnLocation, columnTime, columnDescription);
        tableViewEvents.setStyle("-fx-font-size: 14px;");

        tableViewEvents.setItems(infos);
  
        VBox vBoxMainContent = new VBox(labelTitle, tableViewEvents);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(10);
        vBoxMainContent.setPrefWidth(620);

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getAdminNavbar(stage, Id), vBoxMainContent);

        Header header = new Header();
        VBox root = new VBox(header.getHeader(), hBoxContent);
        stage.getScene().setRoot(root);
    }
}

