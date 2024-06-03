package handtohand.Scene.user_scene;

import java.io.File;
import java.util.List;

import handtohand.Scene.components.Header;
import handtohand.Scene.components.Navbar;
import handtohand.controllers.InformasiControl;
import handtohand.model.EventInformasion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class EventListScene {
    Stage stage;

    public EventListScene(Stage stage){
        this.stage = stage;
    }

    public void show(int id){
        List<EventInformasion> eventsData = InformasiControl.getAllInfo();

        Label labelTitle = new Label("List Informasi");
        labelTitle.setFont(Font.font("Sytem", FontWeight.BOLD, 24));
        labelTitle.setStyle("-fx-font-size: 24px;");

        GridPane gridPaneBooks = new GridPane();

        gridPaneBooks.setHgap(10);
        gridPaneBooks.setVgap(10);
        gridPaneBooks.setPadding(new Insets(10));

        int column = 0;
        int row = 0;

        for (EventInformasion event : eventsData) {
            ImageView imageViewEvent = new ImageView();
            imageViewEvent.setFitHeight(100);
            imageViewEvent.setPreserveRatio(true);
            if (event.getImage_path() != null && !event.getImage_path().isEmpty()) {
                File fileImage = new File(event.getImage_path());
                if (fileImage.exists()) {
                    Image imageBook = new Image(fileImage.toURI().toString());
                    imageViewEvent.setImage(imageBook);
                }
            }
            VBox vBoxImageEvent = new VBox(imageViewEvent);
            vBoxImageEvent.setPadding(new Insets(10));
            vBoxImageEvent.setAlignment(Pos.CENTER);

            Label eventTitle = new Label(event.getTitle());
            eventTitle.setFont(Font.font("System", FontWeight.BOLD, 20));
            eventTitle.setStyle("-fx-font-size: 15px;"); 
            
            Label labelLokasi = new Label(event.getLokasi());
            labelLokasi.setStyle("-fx-font-size: 15px;"); 
            VBox vBoxEventText = new VBox(eventTitle, labelLokasi);
            vBoxEventText.setPadding(new Insets(10, 15, 15, 15));
            vBoxEventText.setSpacing(5);
            vBoxEventText.setAlignment(Pos.CENTER);

            VBox vBoxEvent = new VBox(vBoxImageEvent, vBoxEventText);
            vBoxEvent.setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-border-radius: 5px;");
            vBoxEvent.setPrefWidth(200);
            vBoxEvent.setPrefHeight(100);

            vBoxEvent.setOnMouseClicked(e -> {
                EventdetailScene eventDetailScene = new EventdetailScene(stage);
                eventDetailScene.show(id, event.getId());
            });

            gridPaneBooks.add(vBoxEvent, column, row);

            column++;
            if (column == 3) {
                column = 0;
                row++;
            }
        }

        VBox vBoxMainContent = new VBox(labelTitle, gridPaneBooks);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(10);
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
