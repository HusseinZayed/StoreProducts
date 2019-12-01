

package Controller;

import Model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductControl {
    
    Statement state ;
    
    public void insert(Product product)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();
            state.executeUpdate("INSERT INTO `product` ( `name`, `number`, `price`) VALUES ( '"+product.getName()+"' , "+product.getNumber()+","+product.getPrice()+");");
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();
            state.executeUpdate("Delete FROM `product` WHERE id = " + id);
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(Product product)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();
            state.executeUpdate("UPDATE product set  `name` = "+"'"+product.getName()+"'"+", `number` = "+product.getNumber() +", `price` = " + product.getPrice() +" WHERE id = "+product.getId() );
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // return all data as observable list because table parmetar is observable
   public ObservableList<Product> getAllProduct()
   {
        ObservableList<Product> product =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT * FROM product");
            
            
           
            while(result.next())
            {
             // if define object out while will store last row n time
             Product pr = new Product();   
             pr.setId(result.getInt(1));
             pr.setName(result.getString(2));
             pr.setNumber(result.getInt(3));
             pr.setPrice(result.getInt(4));
             product.add(pr);            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       return product;
   }
   
       // return data which i search about it as observable list because table parmetar is observable
   public ObservableList<Product> search(String name)
   {
        ObservableList<Product> product =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT * FROM product WHERE name LIKE '%"+name+"%';");
            
            
           
            while(result.next())
            {
             // if define object out while will store last row n time
             Product pr = new Product();   
             pr.setId(result.getInt(1));
             pr.setName(result.getString(2));
             pr.setNumber(result.getInt(3));
             pr.setPrice(result.getInt(4));
             product.add(pr);            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       return product;
   }
   
  
}
