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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author DANI-PC
 */
public class DashbaordDesignController implements Initializable {
    ArrayList<Integer> al=new ArrayList<Integer>();
     @FXML
    private Pane dashboard;
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
    private Pane marketpane;
    @FXML
    private Label date;
    @FXML
    private Pane dashboard1;
    @FXML
    private PieChart piechart;
    @FXML
    private Button closebtn;
    @FXML
    private Button minbutton;
    @FXML
    private Pane cardashpane;
    @FXML
    private Pane workerdashclick;
    @FXML
    private Label tcpane;
    @FXML
    private Label carl;
    @FXML
    private Label workl;
    @FXML
    private Label compkr;
    public void time(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), ev -> {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        
                    LocalDateTime now = LocalDateTime.now();
                    date.setText(dtf.format(now));
                   
                    
    }));
    timeline.setCycleCount(1);
    timeline.play();
    }
    public void piechart(){
        Timeline time = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {
                          ObservableList<PieChart.Data> pieChartData = 
                FXCollections.observableArrayList(
                    new PieChart.Data("Assessed Cars", ass),
                    new PieChart.Data("Purchased Cars", pur),
                    new PieChart.Data("Sold Cars", sold)
                    );
         
        piechart.setTitle("Cars Records");
        piechart.setData(pieChartData); 
        
                     }));
                     time.setCycleCount(1);
                     time.play();
    }
    connection c;
    int total=0;
    int cartotal=0;
    int ass=0;
    int pur=0;
    int sold=0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        time();
       
              
        c=new connection();
       c.connect();
       try{
           c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select * from Informers WHERE d='n'");
           while(c.rs.next()){
               total++;
           }
           c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select * from Agents WHERE d='n'");
           while(c.rs.next()){
               total++;
           }
           c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select * from Mechanic WHERE d='n'");
           while(c.rs.next()){
               total++;
           }
       }catch(Exception e){
           e.printStackTrace();
       }
       
       try{
           c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select * from Car WHERE d='n' and status='pur'");
           while(c.rs.next()){
               cartotal++;
           }
       }catch(Exception e){
           e.printStackTrace();
       }
       try{
           System.out.println("insise");
           c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select * from Commission WHERE d='n' and status='Not Paid'");
           while(c.rs.next()){
               System.out.println(totall);
               totall+=Integer.parseInt(c.rs.getString("commission"));
           }
       }catch(Exception e){
            e.printStackTrace();
       }
       compkr.setText(Integer.toString(totall)+" pkr");
       carl.setText(Integer.toString(cartotal));
        workl.setText(Integer.toString(total));
        
        try{
            c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select * from Car WHERE d='n' and status='Assessed'");
            while(c.rs.next()){
                ass++;
            }
            
             c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select * from Car WHERE d='n' and status='pur'");
            while(c.rs.next()){
                pur++;
            }
            
             c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select * from Car WHERE d='n' and status='sold'");
            while(c.rs.next()){
                sold++;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
              ObservableList<PieChart.Data> pieChartData = 
                FXCollections.observableArrayList(
                    new PieChart.Data("Assessed Cars", ass),
                    new PieChart.Data("Purchased Cars", pur),
                    new PieChart.Data("Sold Cars", sold)
                    //new PieChart.Data("Customers", 50)
                    );
                               
         
        piechart.setTitle("Cars Records");
        piechart.setData(pieChartData); 
        piechart();
        
    }    
    
   
int totall=0;
    @FXML
    private void homepaneexit(MouseEvent event) {
       
    }

    @FXML
    private void homepaneenter(MouseEvent event) {
        
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
    Parent root;
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
    private void cardashclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("DisplayCars.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
    private void wdashclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/worker.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
    private void tcdashclick(MouseEvent event) {
         try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/Commission.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    
}
