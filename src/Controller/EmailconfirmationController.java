/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import autosaleandpurchasemanagmentsystemfull.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;

/**
 * FXML Controller class
 *
 * @author DANI-PC
 */
public class EmailconfirmationController implements Initializable {

    @FXML
    private Button confirmbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
Parent root;
    @FXML
    private void btn(ActionEvent event) {
      
        GaussianBlur gaussianBlur = new GaussianBlur();       
      
      //Setting the radius to apply the Gaussian Blur effect  
      gaussianBlur.setRadius(0.0); 
       
      //Applying Gaussian Blur effect to the text 
      NewClass.pp.setEffect(gaussianBlur);
      
        try {
            root = FXMLLoader.load(getClass().getResource("contactagent.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Scene s=new Scene(root);
       NewClass.p.setScene(s);
       NewClass.pq.close();
        
    }
    
}
