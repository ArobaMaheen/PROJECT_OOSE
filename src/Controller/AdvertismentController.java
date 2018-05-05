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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author DANI-PC
 */
public class AdvertismentController implements Initializable {

    @FXML
    private Pane dashboard;
    @FXML
    private Pane OA;
    @FXML
    private Pane w;
    @FXML
    private Label o;
    @FXML
    private Label a;
    @FXML
    private Pane agent;
    @FXML
    private Label ca;
    @FXML
    private Pane dol;
    @FXML
    private Label sb;
    
    @FXML
    private Pane homeico;
    @FXML
    private Label cars;
    @FXML
    private Pane carico;
    @FXML
    private Label workers;
    @FXML
    private Pane workerico;
    @FXML
    private Label marketing;
    @FXML
    private Pane markico;
    @FXML
    private Label commission;
    @FXML
    private Pane commico;
    @FXML
    private Label hometext;
    @FXML
    private Pane HomePane;
    @FXML
    private Pane carpane;
    @FXML
    private Pane workerpane;
    @FXML
    private Pane compane;
    @FXML
    private Pane marketpane;
    @FXML
    private Pane contac;
    @FXML
    private Pane sbazar;
    @FXML
    private Label date;
    @FXML
    private Button closebtn;
    @FXML
    private Button minbutton;
    
public void time(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), ev -> {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        
                    LocalDateTime now = LocalDateTime.now();
                    date.setText(dtf.format(now));
                   
                    
    }));
    timeline.setCycleCount(1);
    timeline.play();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        time();
        // TODO
    }    

    @FXML
    private void ome(MouseEvent event) {
        a.setStyle("-fx-text-fill:    #539ec9;");
        o.setStyle("-fx-text-fill:   #539ec9;");
        w.setStyle("-fx-background-color:    #539ec9;");
    }

    @FXML
    private void omh(MouseEvent event) {
        o.setStyle("-fx-text-fill:     #1F3E50;");
        a.setStyle("-fx-text-fill:     #1F3E50;");
        w.setStyle("-fx-background-color:     #1F3E50;");
    }

    @FXML
    private void came(MouseEvent event)
    {
         ca.setStyle("-fx-text-fill:    #539ec9;");
         agent.setStyle("-fx-background-color:    #539ec9;");
    }

    @FXML
    private void camh(MouseEvent event) 
    {
        ca.setStyle("-fx-text-fill:     #1F3E50;");
        agent.setStyle("-fx-background-color:     #1F3E50;");
    }

    @FXML
    private void sbme(MouseEvent event) 
    {
        dol.setStyle("-fx-background-color:    #539ec9;");
        sb.setStyle("-fx-text-fill:   #539ec9;");
    }

    @FXML
    private void sbmh(MouseEvent event)
    {
        dol.setStyle("-fx-background-color:     #1F3E50;");
        sb.setStyle("-fx-text-fill:     #1F3E50;");
    }

     @FXML
    private void homepaneexit(MouseEvent event) {
        transformsize(1, 0.3, homeico);
        HomePane.setStyle("-fx-border-style: none");
    }
Parent root;
    @FXML
    private void homepaneenter(MouseEvent event) {
        transformsize(1.5, 0.3, homeico);
        HomePane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }

    @FXML
    private void carpmouseexit(MouseEvent event) 
    {
        transformsize(1, 0.3, carico);
        carpane.setStyle("-fx-border-style: none");
         
    }

    @FXML
    private void carpmouseenter(MouseEvent event) {
        transformsize(1.5, 0.3, carico);
        carpane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }

    public void transformsize(double size,double duration,Node node){
        ScaleTransition st=new ScaleTransition(Duration.seconds(duration),node);
        st.setToX(size);
        st.setToY(size);
        st.play();
    }
    @FXML
    private void wmouseexit(MouseEvent event) {
        transformsize(1, 0.3, workerico);
        workerpane.setStyle("-fx-border-style: none");
    }

    @FXML
    private void wmouseenter(MouseEvent event) {
        transformsize(1.5, 0.3, workerico);
        workerpane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }


    @FXML
    private void commouseexit(MouseEvent event) {
        transformsize(1, 0.3, commico);
        compane.setStyle("-fx-border-style: none");
    }

    @FXML
    private void commouseenter(MouseEvent event) {
        transformsize(1.5, 0.3, commico);
        compane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }

    @FXML
    private void homepaneclick(MouseEvent event) {
         try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/DashbaordDesign.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }
   
    @FXML
    private void carpaneclick(MouseEvent event) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("DisplayCars.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        
    }

    @FXML
    private void workerpaneclick(MouseEvent event) {
         try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/worker.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
    private void markpaneexit(MouseEvent event) {
        
    }

    @FXML
    private void markpaneenter(MouseEvent event) {
         
    }

    @FXML
    private void marketpaneclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/Advertisment.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }
    @FXML
    private void sbmouseclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/sundaybazar.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
    private void closebtnac(ActionEvent event) {
        NewClass.p.close();
    }

    @FXML
    private void minbutact(ActionEvent event) {
     NewClass.p.setIconified(true);
    }

    @FXML
    private void oamouseclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/oA.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
    private void camouseclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/contactagent.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
    private void commissionpaneclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/Commission.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }
}
    
    

