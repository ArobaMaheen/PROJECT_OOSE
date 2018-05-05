/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import autosaleandpurchasemanagmentsystemfull.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Furqan Parvaz
 */
public class SundaybazarController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    connection c;
    TableView tv;
    @FXML
    private ScrollPane scr;
    @FXML
    private Button closebtn;
    @FXML
    private Button minbutton;
    @FXML
    private Button del;
    @FXML
    private Label date;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        TableColumn<sundaytable,String> carid=new TableColumn<>("Car ID");
        carid.setCellValueFactory(new PropertyValueFactory<>("carid"));
        
        TableColumn<sundaytable,String> carname=new TableColumn<>("Car Name");
        carname.setCellValueFactory(new PropertyValueFactory<>("carname"));
        
        TableColumn<sundaytable,String> date=new TableColumn<>("Date");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        TableColumn<sundaytable,String> charges=new TableColumn<>("Charges");
        charges.setCellValueFactory(new PropertyValueFactory<>("charges"));
        c=new connection();
        c.connect();
        try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from SundayBazaar where d='n'");
            ObservableList<sundaytable> ol=FXCollections.observableArrayList();
            while(c.rs.next()){
                ol.add(new sundaytable(c.rs.getString("carid"),c.rs.getString("carname"),c.rs.getString("date"),c.rs.getString("charge")));
            }
            tv=new TableView();
            tv.setItems(ol);
            tv.getColumns().addAll(carid,carname,date,charges);
           scr.setContent(tv);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
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
    
    @FXML
    private void ad(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("sundaybazaradd.fxml"));
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        Scene s=new Scene(root);
        NewClass.p.setScene(s);
        
    }

    

    @FXML
    private void delete(ActionEvent event) {
         sundaytable ee=(sundaytable)tv.getSelectionModel().getSelectedItem();
        String id=ee.carid;
        String a=ee.charges;
        String d=ee.date;
        
        
        try{
            c.st=c.con.createStatement();
            c.st.executeUpdate("UPDATE SundayBazaar SET d='y' where carid='"+id+"' and charge='"+a+"' and date='"+d+"'");
            
              
        
        
            
        }catch(Exception e){
            e.printStackTrace();
        }
         try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/sundaybazar.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
    private void ads(ActionEvent event) {
    }
    
}
