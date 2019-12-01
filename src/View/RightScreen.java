
package View;

import Controller.ProductControl;
import Model.Product;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javax.imageio.ImageIO;


//create VBox
 public class RightScreen extends VBox {
    
     //--------------------------------------------------------------------------------
     //fields
    HBox search = new HBox();
    TextField txtSearch = new TextField();   
    TableView<Product> table = new TableView();
    InputStream input = getClass().getResourceAsStream("search.png");
    Image img = new Image(input, 18, 18, true, true);  //resize to image
    Button btnSearch = new Button("search", new ImageView(img));
    ProductControl pc = new ProductControl();
    
    public RightScreen() 
    {
        
        //---------------------------------------------------------------------------
        //design 
        search.getChildren().addAll(new AnimationRect_ReightScreen(),txtSearch,btnSearch);       
        this.getChildren().addAll(new AnimationText_RightScreen(),search,table);
        this.setPadding(new Insets(20));
        this.setSpacing(20);
        this.setAlignment(Pos.TOP_CENTER);
        search.setAlignment(Pos.CENTER);
        search.setSpacing(15);
        
        btnSearch.setStyle("-fx-background-color:#2ecc71;-fx-text-fill:#FFF;-fx-font-size:14");        
        btnSearch.setPrefSize(90, 33);
        txtSearch.setPromptText("search .... ");       
        txtSearch.setPrefSize(200,30);
        txtSearch.setFont(Font.font(20));
        btnSearch.setCursor(Cursor.HAND);
        table.setPrefHeight(500);
        
        //put head row in table               TableColumn(name column)
        TableColumn<Product,Integer> id = new TableColumn("ID");
        TableColumn<Product,String> name = new TableColumn("Name");
        TableColumn<Product,Integer> number = new TableColumn("Number");
        TableColumn<Product,Integer> price = new TableColumn("Price");
        
        //refere to attribute 
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        table.getColumns().addAll(id,name,number,price);
        //show data
        table.setItems(pc.getAllProduct());
        
        id.prefWidthProperty().bind(table.widthProperty().multiply(.2));
        name.prefWidthProperty().bind(table.widthProperty().multiply(.4));
        number.prefWidthProperty().bind(table.widthProperty().multiply(.2));
        price.prefWidthProperty().bind(table.widthProperty().multiply(.2));
        
        
        //-------------------------------------------------------------------------------
        //Action
        table.setOnMouseClicked(e->
        {
            Product product =  table.getSelectionModel().getSelectedItem();
            MainScreen.left.txtName.setText(product.getName());
            MainScreen.left.txtNumbers.setText(product.getNumber()+"");
            MainScreen.left.txtPrice.setText(product.getPrice()+"");
            MainScreen.left.ID=product.getId();
        }
        );
        
        btnSearch.setOnMouseClicked(e->
        {
            table.setItems(pc.search(txtSearch.getText()));
        }
        );
        
    }
    
    
}
