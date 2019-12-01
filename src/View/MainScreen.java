
package View;

import java.io.InputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


//main screen divide to two part left and right
public class MainScreen extends Application {
    // two VBox (difne it only)
    static LeftScreen left = new LeftScreen();  //static because object from it not show data in table
    static RightScreen right = new RightScreen();//static because object from it not show data in table
    @Override
    public void start(Stage stage) {
        
        
        //create main pane and add to it two VBox
        HBox main = new  HBox();
        main.getChildren().addAll(left,right);
        left.prefWidthProperty().bind(main.widthProperty().multiply(.35));
        right.prefWidthProperty().bind(main.widthProperty().multiply(.65));
       
        
        
        InputStream input = getClass().getResourceAsStream("logo.png");
        Image img = new Image(input);  
        stage.getIcons().add(img);
        stage.setTitle("Company FC");
        
        Scene scene = new Scene(main, 800, 600);
        stage.setScene(scene);    
        stage.show();
    }
    
    public static void main(String [] args)
    {
        launch(args);
    }
}
