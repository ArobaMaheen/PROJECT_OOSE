/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import autosaleandpurchasemanagmentsystemfull.*;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Furqan Parvaz
 */
public class SundaybazaraddController implements Initializable {

    @FXML
    private Button cancel;
public void time(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), ev -> {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        
                    LocalDateTime now = LocalDateTime.now();
                    date.setText(dtf.format(now));
                   
                    
    }));
    timeline.setCycleCount(1);
    timeline.play();
    }
    @FXML
    private TextField charges;
    @FXML
    private ComboBox<String> car;
    @FXML
    private Button sve;

    connection c=new connection();
    @FXML
    private Pane HomePane;
    @FXML
    private Label hometext;
    @FXML
    private Pane homeico;
    @FXML
    private Pane carpane;
    @FXML
    private Label cars;
    @FXML
    private Pane carico;
    @FXML
    private Pane workerpane;
    @FXML
    private Label workers;
    @FXML
    private Pane workerico;
    @FXML
    private Pane marketpane;
    @FXML
    private Label marketing;
    @FXML
    private Pane markico;
    @FXML
    private Pane compane;
    @FXML
    private Label commission;
    @FXML
    private Pane commico;
    @FXML
    private Label date;
    @FXML
    private Button closebtn;
    @FXML
    private Button minbutton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        time();
        c.connect();
        
        try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where status='pur' and d='n'");
            
            while(c.rs.next()){
                car.getItems().add(c.rs.getString("ID")+"- "+c.rs.getString("name"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
Parent root;
    @FXML
    private void save(ActionEvent event) {
        String com=charges.getText();
        String id=Character.toString(car.getValue().charAt(0));
        String name="";
        
        for(int i=3;i<car.getValue().length();i++){
            name+=Character.toString(car.getValue().charAt(i));
        }
        System.out.println(name);
        
        try{
            c.st=c.con.createStatement();
             DateFormat df = new SimpleDateFormat("dd/MM/yy");
Date dateobj = new Date();
        String d=df.format(dateobj);
            c.st.executeUpdate("INSERT INTO SundayBazaar values('"+id+"','"+name+"','"+d+"','"+com+"','n')");
            
              try {
            root = FXMLLoader.load(getClass().getResource("sundaybazar.fxml"));
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        Scene s=new Scene(root);
        NewClass.p.setScene(s);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    @FXML
    private void homepaneexit(MouseEvent event) {
        transformsize(1, 0.3, homeico);
        HomePane.setStyle("-fx-border-style: none");
    }

    @FXML
    private void homepaneenter(MouseEvent event) {
        transformsize(1.5, 0.3, homeico);
        HomePane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }

    @FXML
    private void carpmouseexit(MouseEvent event) {
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
    private void closebtnac(ActionEvent event) {
        NewClass.p.close();
    }

    @FXML
    private void minbutact(ActionEvent event) {
         NewClass.p.setIconified(true);
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

    @FXML
    private void cancel(ActionEvent event) {
        
    }
    
}
