/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import autosaleandpurchasemanagmentsystemfull.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Furqan Parvaz
 */
public class WorkerinfoinputController implements Initializable {

    @FXML
    private Pane dashboard;
    @FXML
    private TextField name;
    @FXML
    private TextField address;
    @FXML
    private TextField cnic;
    @FXML
    private TextField zone;
    @FXML
    private TextField email;
    @FXML
    private TextField number;
    @FXML
    private ComboBox<String> worktypemenu;
    @FXML
    private Button save;
    @FXML
    private Button cancel;
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
    private ImageView img;
    @FXML
    private Label date;

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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        time();
        worktypemenu.getItems().addAll("Informers","Agents","Mechanic");
        worktypemenu.getSelectionModel().selectFirst();
        number.setEditable(true);
       // number.setText("fff");
        number.setDisable(false);
        ev.setVisible(false);
        
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
        
    }

    @FXML
    private void wmouseenter(MouseEvent event) {
        
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
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/DisplayCars.fxml"));
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
        transformsize(1, 0.3, markico);
        marketpane.setStyle("-fx-border-style: none");
    }

    @FXML
    private void markpaneenter(MouseEvent event) {
         transformsize(1.5, 0.3, markico);
        marketpane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
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
    private void commissionpaneclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/Commission.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    connection c;
    byte[] image;
    Parent root;
    @FXML
    private void sve(ActionEvent event) {
        String [] emails= {"@gmail.com","@yahoo.com","@rocketmail.com","@hotmail.com","@live.com"};
      String em=email.getText();
      Boolean val=false;
      for(int i=0 ; i<emails.length;i++){
      val=em.endsWith(emails[i]);
          System.out.println(val);
          if(val){
              break;
          }
      
      }
      if(val){
        c=new connection();
        c.connect();
        String n=name.getText();
        String cnic=this.cnic.getText();
        String z=zone.getText();
        String no=number.getText();
        
        String ad=address.getText();
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
Date dateobj = new Date();
Boolean b=true;

        String date=df.format(dateobj);
        try{
              
            try {
                image = new byte[(int) f.length()];
                FileInputStream in = new FileInputStream(f);
                
                in.read(image);
            } catch (Exception ex) {
                image=new byte[5];
                b=false;
               ex.printStackTrace();
            }
            if(b){
            c.st=c.con.createStatement();
            c.ps=c.con.prepareStatement("INSERT INTO "+worktypemenu.getValue()+" VALUES(?,?,?,?,?,?,?,?,?)");
           c.ps.setString(1, n);
           c.ps.setString(2, no);
           c.ps.setString(3, cnic);
           c.ps.setString(4, ad);
           c.ps.setString(5, em);
           c.ps.setString(6, z);
           c.ps.setString(7, date);
           c.ps.setString(8, "n");
          
           c.ps.setBytes(9, image);}else{
                c.st=c.con.createStatement();
            c.ps=c.con.prepareStatement("INSERT INTO "+worktypemenu.getValue()+" VALUES(?,?,?,?,?,?,?,?,?)");
           c.ps.setString(1, n);
           c.ps.setString(2, no);
           c.ps.setString(3, cnic);
           c.ps.setString(4, ad);
           c.ps.setString(5, em);
           c.ps.setString(6, z);
           c.ps.setString(7, date);
            c.ps.setString(8, "n");
                c.ps.setNull(9, java.sql.Types.BINARY);
            }
           c.ps.executeUpdate();
         //   c.st.executeUpdate("Insert into "+worktypemenu.getValue()+" (name,pno,cnic,startdate,addr,zone,email,d) values('"+n+"','"+no+"','"+cnic+"','"+date+"','"+ad+"','"+z+"','"+em+"','n')");
             try {
            root = FXMLLoader.load(getClass().getResource("worker.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Scene s=new Scene(root);
        NewClass.p.setScene(s);
        }catch(Exception e){
            e.printStackTrace();
        }
      }else{
          ev.setDisable(false);
          ev.setVisible(true);
          
      }
    }
File f;
    @FXML
    private void imac(MouseEvent event) {
         FileChooser fc=new FileChooser();
         fc.setTitle("Choose image");
         f= fc.showOpenDialog(NewClass.p);
          try {
                BufferedImage bufferedImage = ImageIO.read(f);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                img.setImage(image);
            } catch (IOException ex) {
               ex.printStackTrace();
            }
      
    }
@FXML
private Label ev;
    @FXML
    private void cenbtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/worker.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }
    
}
