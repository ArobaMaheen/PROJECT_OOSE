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
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class CARSINTERController implements Initializable {
connection c=new connection();
      
    @FXML
    private Label idL;
    @FXML
    private Label carownerL;
    @FXML
    private TextField mil;
    @FXML
    private TextField Doip;
    @FXML
    private TextField CarOwner;
    @FXML
    private TextField carname;
    
    @FXML
    private TextField SName;
    @FXML
    private Label snameL;
    @FXML
    private TextField Pno;
    @FXML
    private TextField add;
    @FXML
    private TextField Model;
    @FXML
    private TextField CarColor;
    @FXML
    private Label colorL;
    @FXML
    private Label nameL;
    @FXML
    private Label modelL;
    @FXML
    private Label milL;
    @FXML
    private Label priceL;
    @FXML
    private TextField loc;
    @FXML
    private TextField price;
    @FXML
    private Label locL;
    @FXML
    private TextField TankCapacity;
    @FXML
    private Label capL;
    @FXML
    private TextField FuelType;
    @FXML
    private Label feulT;
    @FXML
    private Label infName;
    @FXML
    private ComboBox<String> infcombo;
    @FXML
    private TextField numberplate;
    @FXML
    private TextField id;
    @FXML
    private Button save;
    @FXML
    private Button cancel;
    @FXML
    private ImageView img;
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
    private Label nameL1;
    @FXML
    private Button closebtn;
    @FXML
    private Button minbutton;
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
    try {
        // TODO
        c=new connection();
        c.connect();
        c.st=c.con.createStatement();
         c.rs=c.st.executeQuery("SELECT TOP 1 * FROM Car ORDER BY ID DESC");
        c.rs.next();
        id.setEditable(false);
       id.setText(Integer.toString(Integer.parseInt(c.rs.getString("ID"))+1));
       id.setDisable(true);
    } catch (SQLException ex) {
        Logger.getLogger(CARSINTERController.class.getName()).log(Level.SEVERE, null, ex);
    }
       
        time();
         DateFormat df = new SimpleDateFormat("dd/MM/yy");
Date dateobj = new Date();
        System.out.println(df.format(dateobj));
        c.connect();
        LinkedList<String> ll=new LinkedList<String>();
          try {
          c.st=c.con.createStatement();
          c.rs=c.st.executeQuery("Select * from Informers where d='n'");
          while(c.rs.next()){
              ll.add(c.rs.getString("name"));
          }
         } catch (SQLException ex) {
           ex.printStackTrace();
         }
          
          
          
          infcombo.getItems().addAll(ll);
          infcombo.getSelectionModel().selectFirst();
       
          
          
    }    
Parent root;
byte[] image;
    @FXML
    private void SaveAll(ActionEvent event) {
        String name=this.carname.getText();
        String model=this.Model.getText();
        String color=this.CarColor.getText();
        String tank=this.TankCapacity.getText();
        String feul=this.FuelType.getText();
        String owner=this.CarOwner.getText();
        String doip=this.Doip.getText();
        String mil=this.mil.getText();
        String price=this.price.getText();
        String loc=this.loc.getText();
        String sName=this.SName.getText();
        String pno=this.Pno.getText();
        String add=this.add.getText();
        String com=infcombo.getValue();
        String nplate=numberplate.getText();
        System.out.println(com);
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
Date dateobj = new Date();
        String date=df.format(dateobj);
        
        try {
            c.st=c.con.createStatement();
          c.rs=c.st.executeQuery("Select * from Informers where Name='"+com+"'");
          c.rs.next();
          String infID=c.rs.getString("id");
            
            boolean b=true;
            try {
                 image = new byte[(int) f.length()];
                FileInputStream in = new FileInputStream(f);
                
                in.read(image);
            } catch (Exception ex) {
                b=false;
                
               ex.printStackTrace();
            }
            if(b){
          c.ps=c.con.prepareStatement("INSERT INTO Car VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           c.ps.setString(1, name);
           c.ps.setString(2, color);
           c.ps.setString(3, model);
           c.ps.setString(4, tank);
           c.ps.setString(5, feul);
           c.ps.setString(6, owner);
           c.ps.setString(7, doip);
           c.ps.setString(8, mil);
           c.ps.setString(9, price);
           c.ps.setString(10, loc);
           c.ps.setString(11, nplate);
           c.ps.setString(12, date);
           c.ps.setString(13, infID);
           c.ps.setString(14, "Assessed");
           c.ps.setString(15, "n");
            c.ps.setNull(16, java.sql.Types.VARCHAR);
            }else{
                c.ps=c.con.prepareStatement("INSERT INTO Car VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           c.ps.setString(1, name);
           c.ps.setString(2, color);
           c.ps.setString(3, model);
           c.ps.setString(4, tank);
           c.ps.setString(5, feul);
           c.ps.setString(6, owner);
           c.ps.setString(7, doip);
           c.ps.setString(8, mil);
           c.ps.setString(9, price);
           c.ps.setString(10, loc);
           c.ps.setString(11, nplate);
           c.ps.setString(12, date);
           c.ps.setString(13, infID);
           c.ps.setString(14, "Assessed");
           c.ps.setString(15, "n");
           c.ps.setNull(16, java.sql.Types.NVARCHAR);
                
            }
     //      c.st.executeUpdate("INSERT INTO Car VALUES('"+name+"','"+color+"','"+model+"','"+tank+"','"+feul+"','"+owner+"','"+doip+"','"+mil+"','"+price+"','"+loc+"','"+nplate+"','"+date+"','"+infID+"','Assessed','n')");
      c.ps.executeUpdate();
     c.st=c.con.createStatement();
           c.st.executeUpdate("INSERT INTO Seller VALUES('"+sName+"','"+pno+"','"+add+"',null)");
         } catch (SQLException ex) {
           ex.printStackTrace();
         }
        
        try{
            FileInputStream fis=new FileInputStream(f);
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from imagename");
            String l="0";
            while(c.rs.next()){
                l=c.rs.getString("id");
            }
            
            l=Integer.toString(Integer.parseInt(l)+1);
            int cursor;
            String path="resource/"+l+".jpg";
             FileOutputStream fos=new FileOutputStream(path);
              while((cursor = fis.read())!=-1){
            fos.write(cursor);
          
        }
                fis.close();
            fos.close();
             c.st=c.con.createStatement();
            c.st.executeUpdate("INSERT INTO imagename values('"+l+"')");
               c.st=c.con.createStatement();
            c.st.executeUpdate("UPDATE Car SET image='"+l+"' WHERE ID='"+Integer.toString(Integer.parseInt(id.getText())+1)+"'");
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
           try {
            root = FXMLLoader.load(getClass().getResource("DisplayCars.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        Scene scene = new Scene(root);
        NewClass.p.setScene(scene); 
        
        
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
        
    }

    @FXML
    private void carpmouseenter(MouseEvent event) {
        
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

    @FXML
    private void closebtnac(ActionEvent event) {
        NewClass.p.close();
    }

    @FXML
    private void minbutact(ActionEvent event) {
        NewClass.p.setIconified(true);
    }

    @FXML
    private void cancelAct(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/DisplayCars.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }
  
    
}
