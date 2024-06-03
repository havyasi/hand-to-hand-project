
package handtohand;

import handtohand.Scene.SignUpScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage stage){

        SignUpScene signup = new SignUpScene(stage);
        signup.show();

    }
       
    public static void main(String[] args) {
        launch(args);
        
    }
   
}
