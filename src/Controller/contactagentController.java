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
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author DANI-PC
 */
public class contactagentController implements Initializable {

    @FXML
    public Pane dashboard;
    @FXML
    private Button sendbtn;
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
    private Label sendlabel;
    @FXML
    private ComboBox<String> selectcar;
    @FXML
    private ComboBox<String> selectpurpose;
    @FXML
    private TextArea messtextarea;
    @FXML
    private ScrollPane scr;
    MultiSelectTableView tv=new MultiSelectTableView();
    connection c=new connection();
    @FXML
    private Button b;
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
        // TODO
        time();
        NewClass.pp=dashboard;
        
        TableColumn<contacttable,String> id=new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn<contacttable,String> name=new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<contacttable,String> pno=new TableColumn<>("P.No");
        pno.setCellValueFactory(new PropertyValueFactory<>("pno"));
        
        TableColumn<contacttable,String> email=new TableColumn<>("Email");
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        TableColumn<contacttable,String> zone=new TableColumn<>("Zone");
        zone.setCellValueFactory(new PropertyValueFactory<>("zone"));
        
        TableColumn<contacttable,String> date=new TableColumn<>("Date Joined");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
         TableColumn<contacttable,String> cnic=new TableColumn<>("CNIC");
        cnic.setCellValueFactory(new PropertyValueFactory<>("cnic"));
        
         TableColumn<contacttable,String> addr=new TableColumn<>("Address");
       addr.setCellValueFactory(new PropertyValueFactory<>("addr"));
       
       ObservableList ol=FXCollections.observableArrayList();
       
       c.connect();
       
       try{
           c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select * from Agents");
           
           while(c.rs.next()){
               ol.add(new contacttable(c.rs.getString("name"),c.rs.getString("ID"),c.rs.getString("cnic"),c.rs.getString("addr"),c.rs.getString("pno"),c.rs.getString("zone"),c.rs.getString("email"),c.rs.getString("startdate")));
           }
           
           tv.setItems(ol);
           tv.getColumns().addAll(id,name,email,pno,zone,date,addr,cnic);
           scr.setContent(tv);
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       c.connect();
       
       try{
           c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select * from Car where Status='pur' and d='n'");
           
           while(c.rs.next()){
               selectcar.getItems().add(c.rs.getString("ID")+"- "+c.rs.getString("name"));
           }
           selectcar.getSelectionModel().selectFirst();
           
           selectpurpose.getItems().addAll("Send Details Of Car","Request");
           selectpurpose.getSelectionModel().selectFirst();
       }catch(Exception e){
           e.printStackTrace();
       }
       
        
        
        
        
        
    }    
     
    public void transitionetc() throws IOException{
         GaussianBlur gaussianBlur = new GaussianBlur();       
      
      //Setting the radius to apply the Gaussian Blur effect  
      gaussianBlur.setRadius(10.5); 
       
      //Applying Gaussian Blur effect to the text 
      dashboard.setEffect(gaussianBlur);
        TranslateTransition tt=new TranslateTransition(Duration.seconds(1), sendbtn);
        ScaleTransition st=new ScaleTransition(Duration.seconds(1), sendbtn);
        st.setToX(0);
        st.setToY(0);
        st.play();              
        tt.setToX(350); 
        tt.play();
        Parent root=FXMLLoader.load(getClass().getResource("emailconfirmation.fxml"));
        Scene sc=new Scene(root);
        Stage sat=new Stage();
        sat.setScene(sc);
        sat.initModality(Modality.APPLICATION_MODAL);
        sat.initStyle(StageStyle.UNDECORATED);
        NewClass.pq=sat;
        sat.showAndWait();
        System.out.println("ss");
        
    }
    public void sendmail(String sender,String pass, String to) throws AddressException, MessagingException{
        try{
        String host="smtp.gmail.com";
       
            System.out.println(sender+pass+to);
        
        String from="visualstudio880@gmail.com";
        String Messagetext=messtextarea.getText();
        boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(sender));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            //msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(Messagetext);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, sender, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
  
    
    @FXML
    private void sendbtnclick(ActionEvent event) throws IOException, MessagingException {
      
        ObservableList<contacttable> ol=tv.getSelectionModel().getSelectedItems();
        String oemail="";
        String opass="";
        System.out.println(ol.get(0).email);
        
        try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Owner");
            c.rs.next();
            
            oemail=c.rs.getString("email");
            opass=c.rs.getString("password");
            System.out.println(opass);
            System.out.println(oemail);
            for(int i=0 ; i<ol.size();i++){
                sendmail(oemail,opass,ol.get(i).email);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
       // sendmail();
        transitionetc();
        
        
        
        
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


    @FXML
    private void sbexit(MouseEvent event) {
        RotateTransition rt=new RotateTransition(Duration.seconds(0.3), sendbtn);
        rt.setToAngle(0);
        rt.play();
        sendlabel.setVisible(false);
    }

    @FXML
    private void sbenter(MouseEvent event) {
        RotateTransition rt=new RotateTransition(Duration.seconds(0.3), sendbtn);
        rt.setToAngle(360);
        rt.play();
        sendlabel.setVisible(true);
    }

    @FXML
    private void bb(ActionEvent event) {
        String car=Character.toString(selectcar.getValue().charAt(0));
        String pur=selectpurpose.getValue();
        String mes="";
        try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where ID='"+car+"'");
            
            c.rs.next();
            if(pur.equals("Send Details Of Car")){
            mes="/*GENERATED MESSAGE*/\n\n"
                    + "Car ID   =   "+c.rs.getString("ID")+"\n"
                    + "Car Name   =   "+c.rs.getString("name")+"\n"
                    + "Car Color   =   "+c.rs.getString("color")+"\n"
                    + "Car Model   =   "+c.rs.getString("model")+"\n"
                    + "Car Tank   =   "+c.rs.getString("tank")+"\n"
                    + "Car Feul   =   "+c.rs.getString("feultype")+"\n"
                    + "Car Date Of Purchase   =   "+c.rs.getString("doip")+"\n"
                    + "Car Milleage   =   "+c.rs.getString("mil")+"\n"
                    + "Car Price   =   "+c.rs.getString("price")+"\n"
                    + "Car Location   =   "+c.rs.getString("location")+"\n"
                    + "Car NumberPlate   =   "+c.rs.getString("nplate")+"\n"
                    + "Car Date Added   =   "+c.rs.getString("date")+"\n\n"
                    + "Please Find Buyer For This Car\nThankYou\n\n"
                    + "/*GENERATED MESSAGE*/";
            }else if(pur.equals("Request")){
               mes="/*GENERATED MESSAGE*/\n\n"
                    + "Car ID   =   "+c.rs.getString("ID")+"\n"
                    + "Car Name   =   "+c.rs.getString("name")+"\n"
                    + "Car Color   =   "+c.rs.getString("color")+"\n"
                    + "Car Model   =   "+c.rs.getString("model")+"\n\n"
                    + "Any Buyer Found For This Car?\n\n"
                    + "/*GENERATED MESSAGE*/";
            }
           messtextarea.setText(mes);
        }catch(Exception e){
            
        }
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
    
}
