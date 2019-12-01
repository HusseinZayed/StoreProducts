
package View;

import Controller.ProductControl;
import Model.Product;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


//this class is VBox i create node and add it
public class LeftScreen extends VBox {
    
    //-------------------------------------------------------------------------------------
    //fields
    Label lb = new Label(" Add New Product ");
    TextField txtName = new TextField();
    TextField txtNumbers = new TextField();
    TextField txtPrice = new TextField();
    Button btnAdd = new Button("ADD");
    Button btnUpdate = new Button("UPDATE");
    Button btnDelete = new Button("DELETE");
    
    ProductControl pc = new ProductControl();
    int ID;
            
    public LeftScreen()
    {
        //----------------------------------------------------------------------------------
        //Design 
        this.getChildren().addAll(lb,txtName,txtNumbers,txtPrice,btnAdd,btnDelete,btnUpdate);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.setSpacing(15);
        this.setStyle("-fx-background-color:#3498db");
         
        btnAdd.setStyle("-fx-background-color:#2ecc71;-fx-text-fill:#FFF;-fx-font-size:18;");
        btnUpdate.setStyle("-fx-background-color:#2ecc71;-fx-text-fill:#FFF;-fx-font-size:18");
        btnDelete.setStyle("-fx-background-color:#2ecc71;-fx-text-fill:#FFF;-fx-font-size:18");
        
        btnAdd.setPrefSize(130, 50);
        btnUpdate.setPrefSize(130, 50);
        btnDelete.setPrefSize(130, 50);
        
        txtName.setPromptText("Entre Name");
        txtNumbers.setPromptText("Entre number");
        txtPrice.setPromptText("Entre price");
        
        txtName.setPrefSize(200,50);
        txtNumbers.setPrefSize(200,50);
        txtPrice.setPrefSize(200,50);
        
        txtName.setFont(Font.font(20));
        txtNumbers.setFont(Font.font(20));
        txtPrice.setFont(Font.font(20));
        
        lb.setFont(Font.font(25));
        lb.setTextFill(Color.WHITE);
        
        btnAdd.setCursor(Cursor.HAND);
        btnDelete.setCursor(Cursor.HAND);
        btnUpdate.setCursor(Cursor.HAND);
        
        
        //Action 
       //-----------------------------------------------------------------------------------------
        btnAdd.setOnMouseClicked(e->
        {
           Product product = new Product();
          if(!txtName.getText().equals("")&&!txtNumbers.getText().equals("")&&!txtPrice.getText().equals("")){
          product.setName(txtName.getText());
          product.setNumber(Integer.parseInt(txtNumbers.getText()));
          product.setPrice(Integer.parseInt(txtNumbers.getText()));
          
          pc.insert(product);
          
          txtName.setText("");
          txtNumbers.setText("");
          txtPrice.setText("");
          
          MainScreen.right.table.setItems(pc.getAllProduct());
          }
          
        });
        
        btnUpdate.setOnMouseClicked(e->
        {
           Product product = new Product();
          if(!txtName.getText().equals("")&&!txtNumbers.getText().equals("")&&!txtPrice.getText().equals("")){
          product.setName(txtName.getText());
          product.setNumber(Integer.parseInt(txtNumbers.getText()));
          product.setPrice(Integer.parseInt(txtNumbers.getText()));
          product.setId(ID);
          pc.update(product);
          
          txtName.setText("");
          txtNumbers.setText("");
          txtPrice.setText("");
          
          MainScreen.right.table.setItems(pc.getAllProduct());
          }
          
        });
        
       btnDelete.setOnMouseClicked(e->
        {
           Product product = new Product();
          if(!txtName.getText().equals("")&&!txtNumbers.getText().equals("")&&!txtPrice.getText().equals("")){
          product.setName(txtName.getText());
          product.setNumber(Integer.parseInt(txtNumbers.getText()));
          product.setPrice(Integer.parseInt(txtNumbers.getText()));
          product.setId(ID);
          pc.delete(ID);
          
          txtName.setText("");
          txtNumbers.setText("");
          txtPrice.setText("");
          
          MainScreen.right.table.setItems(pc.getAllProduct());
          }
          
        });
         }
        
        
    }

