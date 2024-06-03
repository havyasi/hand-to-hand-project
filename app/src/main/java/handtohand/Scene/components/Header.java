package handtohand.Scene.components;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Header {
    public HBox getHeader() {

        Label labelTitle = new Label("Hand to Hand");
        labelTitle.setTextFill(Color.WHITE);
        labelTitle.setFont(Font.font("Popins", FontWeight.BLACK, 30));
        VBox vBoxTitle = new VBox(labelTitle);
        vBoxTitle.setAlignment(Pos.CENTER);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox header = new HBox(spacer, vBoxTitle);
        header.setBackground(new Background(new BackgroundFill(Color.web("#070F2B"), null, null)));
        header.setPadding(new Insets(10, 15, 15, 15));
        return header;
    }
}
