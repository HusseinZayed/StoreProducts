
package View;

import static java.awt.SystemColor.text;
import javafx.util.Duration;
import javafx.animation.RotateTransition;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


//this class is HBox i create node and add it
public class AnimationRect_ReightScreen extends HBox {
    
        Rectangle rectangle = new Rectangle();

    public AnimationRect_ReightScreen() {
    
        
        
        
        rectangle.setHeight(50);
        rectangle.setWidth(50);
        
        
        rectangle.setArcWidth(15); 
        rectangle.setArcHeight(15); 
        rectangle.setFill(Color.LIMEGREEN);
        rectangle.setStroke(Color.BLACK);
        
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.seconds(1.5));
        
        rotateTransition.setNode(rectangle);
        rotateTransition.setByAngle(180);
        rotateTransition.setCycleCount(-1);
        rotateTransition.setAutoReverse(true);
        rotateTransition.play();
        
        this.getChildren().addAll(rectangle);
    }
}
