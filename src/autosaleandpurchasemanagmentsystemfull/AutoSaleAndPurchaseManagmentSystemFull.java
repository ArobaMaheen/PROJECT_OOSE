/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autosaleandpurchasemanagmentsystemfull;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Furqan Parvaz
 */
public class AutoSaleAndPurchaseManagmentSystemFull extends Application {
    Stage s;
    Parent root;
    
    @Override
    public void start(Stage stage) throws Exception {
        System.gc();
          root = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
        s=stage;
        s.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        NewClass nc=new NewClass();
        nc.p=s;
       /* FadeTransition f=new FadeTransition(Duration.millis(3000), root);
        f.setFromValue(0.0);
        f.setToValue(1.0);
        f.play();
        stage.initStyle(StageStyle.TRANSPARENT);
       scene.setFill(Color.TRANSPARENT);*/
        s.setScene(scene);
        s.show();
    }
    public void sets(String name){
        
        try {
            root = FXMLLoader.load(getClass().getResource(name));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Scene scene = new Scene(root);
        s.setScene(scene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
