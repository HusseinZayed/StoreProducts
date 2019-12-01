/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javafx.animation.FillTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author hussein
 */

//this class is HBox i create node and add it
public class AnimationText_RightScreen extends HBox {
    
    Text text = new Text("Company FC ");

    public AnimationText_RightScreen() {
    
        
        text.setFont(new Font("Tahoma", 40));
        text.setStroke(Color.DARKCYAN);
        
        FillTransition fillTransition = new FillTransition();
        fillTransition.setDuration(Duration.seconds(1.5));
        
        fillTransition.setShape(text);
        fillTransition.setFromValue(Color.FORESTGREEN);  
      
        fillTransition.setToValue(Color.DARKTURQUOISE); 
        
        fillTransition.setCycleCount(-1);
        fillTransition.setAutoReverse(true);
        fillTransition.play();
        this.getChildren().add(text);
        this.setAlignment(Pos.CENTER);
    }
        
}
