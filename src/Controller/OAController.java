/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import autosaleandpurchasemanagmentsystemfull.*;
import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.IOException;
import java.lang.Thread.State;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.concurrent.Worker;
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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author DANI-PC
 */
public class OAController implements Initializable {

    @FXML
    private Pane dashboard;
    @FXML
    private WebView wv;
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
    private WebEngine We;
    @FXML
    private Button olx;
    @FXML
    private ProgressBar pbar;
    @FXML
    private Label date;
    @FXML
    private ComboBox<String> c;
    @FXML
    private Button by;
    @FXML
    private TextArea teaa;
    @FXML
    private ImageView img;
    /**
     * Initializes the controller class.
     */
    public void time(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), ev -> {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        
                    LocalDateTime now = LocalDateTime.now();
                    date.setText(dtf.format(now));
                   
                    
    }));
    timeline.setCycleCount(1);
    timeline.play();
    }
    connection co;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        We=wv.getEngine();
        pbar.setOpacity(0);
        time();
        
        co=new connection();
        co.connect();
        
        try{
            co.st=co.con.createStatement();
             co.rs=co.st.executeQuery("Select * from Car where d='n' and status='pur'");
            while(co.rs.next()){
            c.getItems().add(co.rs.getString("ID")+"- "+co.rs.getString("name"));
                    }
        }catch(Exception e){
            e.printStackTrace();
        }
        c.getSelectionModel().selectFirst();
      
          
        
        
        
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

    private void closebtnac(ActionEvent event) {
        NewClass.p.close();
    }

    private void minbutact(ActionEvent event) {
     NewClass.p.setIconified(true);
    }

    @FXML
    private void olx(ActionEvent event) {
        FadeTransition ff=new FadeTransition(Duration.seconds(1), pbar);
            ff.setToValue(1);
            ff.play();
        pbar.progressProperty().bind(We.getLoadWorker().progressProperty());
        
        We.load("https://www.olx.com.pk/posting/?fillBaseCategory=84");
        
       
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
    private void cc(ActionEvent event) {
        
        
    }

    @FXML
    private void byt(ActionEvent event) {
        String car="";
        try{
        Integer.parseInt(Character.toString(c.getValue().charAt(1)));
         car=Character.toString(c.getValue().charAt(0))+Character.toString(c.getValue().charAt(1));
        }catch(Exception e){
         car=Character.toString(c.getValue().charAt(1));}
        
        
        String mes="";
        try{
            co.st=co.con.createStatement();
            co.rs=co.st.executeQuery("Select * from Car where ID='"+car+"'");
            
            co.rs.next();
               try{
            byte[] fileByte=co.rs.getBytes("image");
             ByteArrayInputStream in = new ByteArrayInputStream(fileByte);
             Image i=new Image(in);
             img.setImage(i);
            }catch(Exception e){
                e.printStackTrace();
            }
            mes=""
                  
                    + "Car Name   =   "+co.rs.getString("name")+"\n"
                    + "Car Color   =   "+co.rs.getString("color")+"\n"
                    + "Car Model   =   "+co.rs.getString("model")+"\n"
                    + "Car Tank   =   "+co.rs.getString("tank")+"\n"
                    + "Car Feul   =   "+co.rs.getString("feultype")+"\n"
                    + "Car Date Of Purchase   =   "+co.rs.getString("doip")+"\n"
                    + "Car Milleage   =   "+co.rs.getString("mil")+"\n"
                    + "Car Price   =   "+co.rs.getString("price")+"\n"
                    + "Car Location   =   "+co.rs.getString("location")+"\n"
                    + "Car NumberPlate   =   "+co.rs.getString("nplate")+"\n"
                    + "Car Date Added   =   "+co.rs.getString("date")+"\n\n"
                    + "Interested Buyers Please Contact 0331-2823521\nThankYou\n\n"
                    + "/*GENERATED MESSAGE*/";
          
           teaa.setText(mes);
         
        }catch(Exception e){
            e.printStackTrace();
        }
    }
   
   
    }
    

