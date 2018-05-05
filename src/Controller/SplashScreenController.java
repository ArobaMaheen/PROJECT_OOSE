/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import autosaleandpurchasemanagmentsystemfull.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author DANI-PC
 */
public class SplashScreenController implements Initializable {

    @FXML
    private SVGPath car;
    private Label per;

    /**
     * Initializes the controller class.
     */
    int i=0;
    Stage s;
    Scene ss;
    @FXML
    private Rectangle back;
    @FXML
    private SVGPath p;
    @FXML
    private Label name;
    
    @Override
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ScaleTransition sc=new ScaleTransition(Duration.seconds(5), car);
        sc.setToX(8);
        sc.setToY(8);
        sc.play();
        FillTransition f=new FillTransition(Duration.seconds(2), car, Color.web("#539ec9"), Color.WHITE);
        f.setCycleCount(Animation.INDEFINITE);
        f.setAutoReverse(true);
        f.play();
        
    
    
    FillTransition fff=new FillTransition(Duration.seconds(1), back, Color.web("#1F3E50"), Color.web("#539ec9"));
    
    fff.setCycleCount(Animation.INDEFINITE);
    fff.setAutoReverse(true);
    fff.play();
        RotateTransition tr=new RotateTransition(Duration.seconds(1),p);
        tr.setByAngle(360);
        
        tr.setCycleCount(Animation.INDEFINITE);
        //tr.setAutoReverse(true);
        tr.play();
        
        FadeTransition ftt=new FadeTransition(Duration.seconds(5), name);
        
        ftt.setToValue(1);
        ftt.play();
        FadeTransition ft=new FadeTransition(Duration.seconds(5), p);
        
        ft.setToValue(1);
        ft.play();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {
         try {
            root = FXMLLoader.load(getClass().getResource("DashbaordDesign.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene s=new Scene(root);          
         NewClass.p.setScene(s);
                    NewClass.p.setX(100);
                    NewClass.p.setY(50);
    }));
    timeline.setCycleCount(1);
    timeline.play();
    }    
        Parent root;
    private void s(MouseEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
        //root.setClip(car);
        s.initStyle(StageStyle.TRANSPARENT);
ss.setFill(Color.TRANSPARENT);
        ss=new Scene(root);
        s.setScene(ss);
        s.show();
    }
    
}
