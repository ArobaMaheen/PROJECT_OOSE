/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import autosaleandpurchasemanagmentsystemfull.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class CarUpdateController implements Initializable {

    @FXML
    private Label idL;
    @FXML
    private Label carownerL;
    @FXML
    private TextField id;
    @FXML
    private TextField mil;
    @FXML
    private TextField Doip;
    @FXML
    private TextField CarOwner;
    @FXML
    private TextField carname;
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
    private Button save;
    @FXML
    private Button cancel;
    @FXML
    private TextField SName;
    @FXML
    private Label snameL;
    @FXML
    private TextField Pno;
    @FXML
    private TextField add;
    @FXML
    private TextField numberplate;
connection c;
    /**
     * Initializes the controller class.
     */
String odate;
String status;
    @FXML
    private Button closebtn;
    @FXML
    private Button minbutton;
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
    private Label date;
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
       
     
        id.setEditable(false);
        id.setText(NewClass.id);
             c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Informers");
            
           while(c.rs.next()){
               infcombo.getItems().add(c.rs.getString("name"));
           }
            
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where ID='"+NewClass.id+"' AND d='n'");
            c.rs.next();
             try{
            String imgn=c.rs.getString("image");
             File ff=new File("resource/"+imgn+".jpg");
             FileInputStream fis=new FileInputStream(ff);
             Image i=new Image(fis);
             img.setImage(i);
            }catch(Exception e){
                System.out.println("No Image");
            }
            
            String iid=c.rs.getString("informerid");
            id.setText(c.rs.getString("ID"));
            carname.setText(c.rs.getString("name"));
            Model.setText(c.rs.getString("model"));
            CarColor.setText(c.rs.getString("color"));
            TankCapacity.setText(c.rs.getString("tank"));
            FuelType.setText(c.rs.getString("feultype"));
            CarOwner.setText(c.rs.getString("carowner"));
            numberplate.setText(c.rs.getString("nplate"));
            Doip.setText(c.rs.getString("doip"));
            mil.setText(c.rs.getString("mil"));
            price.setText(c.rs.getString("price"));
            loc.setText(c.rs.getString("location"));
           odate=c.rs.getString("date");
           status=c.rs.getString("Status");
            
             c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Informers where ID='"+iid+"'");
            c.rs.next();
            infcombo.getSelectionModel().select(c.rs.getString("name"));
             c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Seller where ID='"+id.getText()+"'");
             c.rs.next();
             SName.setText(c.rs.getString("name"));
             Pno.setText(c.rs.getString("pno"));
             add.setText(c.rs.getString("addr"));
             
            
        }catch(Exception e){
            e.printStackTrace();
        }
     
        save.setOnAction(e->{
            
            id.getText();
            String cname=carname.getText();
           String cmodel= Model.getText();
           String ccolor= CarColor.getText();
           String ctank= TankCapacity.getText();
           String cfuel= FuelType.getText();
           String cowner= CarOwner.getText();
           String cplate= numberplate.getText();
           String cdoip= Doip.getText();
           String cmil= mil.getText();
           String cprice= price.getText();
           String cloc= loc.getText();
           
           String sname=SName.getText();
           String spno= Pno.getText();
           String sadd= add.getText();
           
           String inf=infcombo.getValue();
           
            try {
            c.st=c.con.createStatement();
          c.rs=c.st.executeQuery("Select * from Informers where Name='"+inf+"'");
          c.rs.next();
          String infID=c.rs.getString("id");
          c.st=c.con.createStatement();
           
           c.st.executeUpdate("UPDATE Car SET name='"+cname+"' ,color='"+ccolor+"', model='"+cmodel+"', tank='"+ctank+"', feultype='"+cfuel+"', carowner='"+cowner+"', doip='"+cdoip+"', mil='"+cmil+"', price='"+cprice+"', location='"+cloc+"', nplate='"+cplate+"', date='"+odate+"', informerid='"+infID+"', Status='"+status+"' WHERE ID='"+NewClass.id+"'");
           c.st=c.con.createStatement();
           c.st.executeUpdate("UPDATE Seller SET name='"+sname+"', pno='"+spno+"', addr='"+sadd+"' WHERE ID='"+NewClass.id+"'");
           if(b){
           
           
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
            c.st.executeUpdate("UPDATE Car SET image='"+l+"' WHERE ID='"+Integer.toString(Integer.parseInt(id.getText()))+"'");
            
            
        }catch(Exception exx){
            exx.printStackTrace();
        }
           }
         } catch (SQLException ex) {
           ex.printStackTrace();
         }
        
           try {
            root = FXMLLoader.load(getClass().getResource("DisplayCars.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        Scene scene = new Scene(root);
        NewClass.p.setScene(scene); 
           
        
        
        
        });
        
        
    }    
       Parent root;
byte[] image;
File f;
    Boolean b=false;
    @FXML
    private void imac(MouseEvent event) {
        
         FileChooser fc=new FileChooser();
         fc.setTitle("Choose image");
         f= fc.showOpenDialog(NewClass.p);
          try {
                BufferedImage bufferedImage = ImageIO.read(f);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                img.setImage(image);
                b=true;
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
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/commission.fxml"));
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
