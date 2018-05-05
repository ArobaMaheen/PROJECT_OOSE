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
import javafx.scene.control.Label;
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
public class CompanyBuyingController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    connection c;
    @FXML
    private Label id;
    @FXML
    private Label name;
    @FXML
    private Label year;
    @FXML
    private Label price;
    @FXML
    private Label mil;
    @FXML
    private Label sid;
    @FXML
    private Label sname;
    @FXML
    private Label pno;
    @FXML
    private Label addr;
    @FXML
    private Button save;
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
    private Button back;
    @FXML
    private Button closebtn;
    @FXML
    private Button minbutton;
    @FXML
    private Label date;
    @FXML
    private ImageView img;
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
        c=new connection();
        c.connect();
        
        
        try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where ID='"+NewClass.id+"' and d='n'");
            
            c.rs.next();
            
            String name=c.rs.getString("name");
            String year=c.rs.getString("model");
            String price=c.rs.getString("price");
            
            String mil=c.rs.getString("mil");
            
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Seller where ID='"+NewClass.id+"'");
            System.out.println(NewClass.id);
             c.rs.next();
            
            String names=c.rs.getString("name");
            String pno=c.rs.getString("pno");
            String addr=c.rs.getString("addr");
            
            this.name.setText(name);
            this.id.setText(NewClass.id);
            this.price.setText(price);
            this.mil.setText(mil);
            this.year.setText(year);
            this.sid.setText(NewClass.id);
            this.sname.setText(names);
            this.pno.setText(pno);
            this.addr.setText(addr);
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }    
Parent root;
byte[] image;
    @FXML
    private void savee(ActionEvent event) {
        try{
            c.st=c.con.createStatement();
               DateFormat df = new SimpleDateFormat("dd/MM/yy");
Date dateobj = new Date();
        String date=df.format(dateobj);
            c.st.executeUpdate("UPDATE Car SET Status='pur', date='"+date+"' where ID='"+NewClass.id+"'");
              boolean b=true;
          /*  try {
                 image = new byte[(int) f.length()];
                FileInputStream in = new FileInputStream(f);
                
                in.read(image);
            } catch (Exception ex) {
                b=false;
                
                System.out.println("No Image");
            }
            if(b){
            c.ps=c.con.prepareStatement("UPDATE Seller SET image=? WHERE ID='"+NewClass.id+"'");
            c.ps.setBytes(1, image);
            c.ps.executeUpdate();
            }
            */
          
          
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
            c.st.executeUpdate("UPDATE Seller SET image='"+l+"' WHERE ID='"+NewClass.id+"'");
            
            
        }catch(Exception exx){
            exx.printStackTrace();
        }
            System.out.println("Done Updating");
            
             root = FXMLLoader.load(getClass().getResource("DisplayCars.fxml"));
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
    private void backbtn(ActionEvent event) {
         try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/DisplayCars.fxml"));
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
            } catch (Exception ex) {
               ex.printStackTrace();
            }
    }

    
}
