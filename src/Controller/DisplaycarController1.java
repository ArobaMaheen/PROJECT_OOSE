/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import autosaleandpurchasemanagmentsystem.Views.*;
import autosaleandpurchasemanagmentsystemfull.NewClass;
import autosaleandpurchasemanagmentsystemfull.Recipt;
import autosaleandpurchasemanagmentsystemfull.connection;
import com.reportmill.shape.RMDocument;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Furqan Parvaz
 */
public class DisplaycarController1 implements Initializable {

    @FXML
     ScrollPane scroo;
    @FXML
     AnchorPane anc;
    @FXML
     Button Upbtn;
    @FXML
     Button Addbtn;
    @FXML
     Button Deletebtn;
TableView tv=new TableView<>();
     connection c;
    @FXML
     ComboBox<String> cat;
    @FXML
     Pane HomePane;
    @FXML
     Label hometext;
    @FXML
     Pane homeico;
    @FXML
     Pane carpane;
    @FXML
     Label cars;
    @FXML
     Pane carico;
    @FXML
     Pane workerpane;
    @FXML
     Label workers;
    @FXML
     Pane workerico;
    @FXML
     Pane marketpane;
    @FXML
     Label marketing;
    @FXML
     Pane markico;
    @FXML
     Pane compane;
    @FXML
     Label commission;
    @FXML
     Pane commico;
    @FXML
     Button closebtn;
    @FXML
     Button minbutton;
    @FXML
     Label date;
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
        System.gc();
        time();
        c=new connection();
       c.connect();
          
        TableColumn<tablecar,String> name=new TableColumn<tablecar, String>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setMinWidth(110);
        TableColumn<tablecar,String> id=new TableColumn<tablecar, String>("ID");
      id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.setMinWidth(110);
        TableColumn<tablecar,String> year=new TableColumn<tablecar, String>("Year");
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        year.setMinWidth(110);
        TableColumn<tablecar,String> color=new TableColumn<tablecar, String>("Color");
       color.setCellValueFactory(new PropertyValueFactory<>("color"));
        color.setMinWidth(110);
        TableColumn<tablecar,String> price=new TableColumn<tablecar, String>("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        price.setMinWidth(110);
        TableColumn<tablecar,Button> b=new TableColumn<tablecar, Button>("Purchase");
       b.setCellValueFactory(new PropertyValueFactory<>("b"));
       b.setMinWidth(115);
        ObservableList<tablecar> ol= FXCollections.observableArrayList();
        try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where Status='assessed' and d='n'");
            while(c.rs.next()){
                Button but=new Button("Purchase");
                but.setStyle("-fx-background-color:  #1F3E50;-fx-text-fill:white;");
                
                but.setOnMouseEntered(ex->{
                    but.setStyle("-fx-background-color:#6CBBD9;-fx-text-fill:white;");
                });
                but.setOnMouseExited(ex->{
                    but.setStyle("-fx-background-color:#1F3E50;-fx-text-fill:white;");
                });
                but.setOnAction(e->{
                    System.out.println("in");
                    ObservableList<TableColumn> oll=tv.getColumns();
                      
                     
                          TableColumn tc=oll.get(oll.size()-1);
                          
                          for(int i=0;i<tv.getItems().size();i++){
                              System.out.println("in loop");
                          if(but==tc.getCellData(i)){
                              System.out.println("in if");
                              TableColumn tcc=oll.get(oll.size()-6);
                            
                             String cc=(String)tcc.getCellData(i);
                             NewClass.id=cc;
                                  try {
                                      root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/CompanyBuying.fxml"));
                                  } catch (IOException ex) {
                                     ex.printStackTrace();
                                  }
                                  Scene s=new Scene(root);
                                  NewClass.p.setScene(s);
                              System.out.println(cc);
                             break;
                          }
                
                
                }});
                ol.add(new tablecar(c.rs.getString("id"),c.rs.getString("name"),c.rs.getString("model"),c.rs.getString("color"),c.rs.getString("price"),but));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        tv.setItems(ol);
        tv.getColumns().addAll(id,name,year,color,price,b);
        tv.setMinWidth(707);
        scroo.setContent(tv);
        cat.getItems().addAll("Assessed Cars","Purchased Cars","Sold Cars");
        
        cat.getSelectionModel().selectFirst();
        cat.setOnAction(e -> 
        {
            if(cat.getValue().equals("Assessed Cars")){
                tv.getItems().clear();
                try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where Status='assessed' and d='n'");
            
            while(c.rs.next()){
                Button but=new Button("Purchase");
                but.setStyle("-fx-background-color:  #1F3E50;-fx-text-fill:white;");
                
                but.setOnMouseEntered(ex->{
                    but.setStyle("-fx-background-color:#6CBBD9;-fx-text-fill:white;");
                });
                but.setOnMouseExited(ex->{
                    but.setStyle("-fx-background-color:#1F3E50;-fx-text-fill:white;");
                });
                but.setOnAction(ex->{
                    System.out.println("in");
                    ObservableList<TableColumn> oll=tv.getColumns();
                      
                     
                          TableColumn tc=oll.get(oll.size()-1);
                          
                          for(int i=0;i<tv.getItems().size();i++){
                              System.out.println("in loop");
                          if(but==tc.getCellData(i)){
                              System.out.println("in if");
                              TableColumn tcc=oll.get(oll.size()-6);
                            
                             String cc=(String)tcc.getCellData(i);
                             NewClass.id=cc;
                                  try {
                                      root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/CompanyBuying.fxml"));
                                  } catch (IOException exp) {
                                     exp.printStackTrace();
                                  }
                                  Scene s=new Scene(root);
                                  NewClass.p.setScene(s);
                              System.out.println(cc);
                             break;
                          }
                
                             
                }});
                ol.add(new tablecar(c.rs.getString("id"),c.rs.getString("name"),c.rs.getString("model"),c.rs.getString("color"),c.rs.getString("price"),but));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        tv.setItems(ol);
            }else if(cat.getValue().equals("Purchased Cars")){
                tv.getItems().clear();
                  try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where Status='pur' and d='n'");
            while(c.rs.next()){
                 Button but=new Button("Sell");
                 but.setStyle("-fx-background-color:  #1F3E50;-fx-text-fill:white;");
                
                but.setOnMouseEntered(ex->{
                    but.setStyle("-fx-background-color:#6CBBD9;-fx-text-fill:white;");
                });
                but.setOnMouseExited(ex->{
                    but.setStyle("-fx-background-color:#1F3E50;-fx-text-fill:white;");
                });
                but.setOnAction(ex->{
                    System.out.println("in");
                    ObservableList<TableColumn> oll=tv.getColumns();
                      
                     
                          TableColumn tc=oll.get(oll.size()-1);
                          
                          for(int i=0;i<tv.getItems().size();i++){
                              System.out.println("in loop");
                          if(but==tc.getCellData(i)){
                              System.out.println("in if");
                              TableColumn tcc=oll.get(oll.size()-6);
                            
                             String cc=(String)tcc.getCellData(i);
                             NewClass.id=cc;
                                  try {
                                      root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/CompanySelling_1.fxml"));
                                  } catch (IOException exp) {
                                     exp.printStackTrace();
                                  }
                                  Scene s=new Scene(root);
                                  NewClass.p.setScene(s);
                              System.out.println(cc);
                             break;
                          }
                 
                
                }});
                ol.add(new tablecar(c.rs.getString("id"),c.rs.getString("name"),c.rs.getString("model"),c.rs.getString("color"),c.rs.getString("price"),but));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        tv.setItems(ol);
            }else if(cat.getValue().equals("Sold Cars")){
                tv.getItems().clear();
                  try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where Status='sold' and d='n'");
            
            
            while(c.rs.next()){
                 Button but=new Button("Generate Invoice");
            
            but.setStyle("-fx-background-color:  #1F3E50;-fx-text-fill:white;");
                
                but.setOnMouseEntered(ex->{
                    but.setStyle("-fx-background-color:#6CBBD9;-fx-text-fill:white;");
                });
                but.setOnMouseExited(ex->{
                    but.setStyle("-fx-background-color:#1F3E50;-fx-text-fill:white;");
                });
                
                but.setOnAction((event) -> {
                     System.out.println("in");
                    ObservableList<TableColumn> oll=tv.getColumns();
                      
                     
                          TableColumn tc=oll.get(oll.size()-1);
                          
                          for(int i=0;i<tv.getItems().size();i++){
                              System.out.println("in loop");
                          if(but==tc.getCellData(i)){
                              System.out.println("in if");
                              TableColumn tcc=oll.get(oll.size()-6);
                            
                             String cc=(String)tcc.getCellData(i);
                             NewClass.id=cc;
                                  //after id
                                  try{
                                      c.st=c.con.createStatement();
                                      c.rs=c.st.executeQuery("Select * from Buyer where ID='"+NewClass.id+"'");
                                      c.rs.next();
                                      
                                       String bname=c.rs.getString("name");
                                        String bcnic=c.rs.getString("cnic");
                            String baddr=c.rs.getString("addr");
                            String bno=c.rs.getString("pno");
                             c.st=c.con.createStatement();
                                      c.rs=c.st.executeQuery("Select * from Owner");
                                      c.rs.next();
                              String sname=c.rs.getString("name");
                                        String scnic=c.rs.getString("cnic");
                            String saddr=c.rs.getString("addr");
                            String sno=c.rs.getString("pno");
                            
                             c.st=c.con.createStatement();
                                      c.rs=c.st.executeQuery("Select * from Car where ID='"+NewClass.id+"'");
                                      c.rs.next();
                                 String cname=c.rs.getString("name");
                                 String ccolor=c.rs.getString("color");
                                 String cmanu=c.rs.getString("tank");
                                 String cmodel=c.rs.getString("model");
                                 String cowner=c.rs.getString("carowner");
                                 String clocation=c.rs.getString("location");
                                     String cfeul=c.rs.getString("feultype");
                                         String ctank="2000";
                                     String doip=c.rs.getString("doip");
                                  String cmil=c.rs.getString("mil");
                                  String date=c.rs.getString("date");
                                 String pricee=c.rs.getString("price");
                                 
                                  
                                 Recipt r=new Recipt( bname, bcnic,baddr, bno,sname,scnic, saddr,  sno,  cname,  ccolor,  cmanu,  cmodel,  cowner,  clocation,  cfeul,  ctank,  doip,  cmil, date, pricee);
                                      RMDocument rm=new RMDocument(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/Myreport.rpt"));
            RMDocument rep=rm.generateReport(r);
        rep.write("C:\\Users\\Furqan Parvaz\\Documents\\NetBeansProjects\\re.jpg");
        NewClass.r=r;
        Stage p=new Stage();
         try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/repor.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        p.setScene(scene);
        p.show();
        
        
                                  }catch(Exception ex){
                                      ex.printStackTrace();
                                  }
                                  
                                  
                                  
                             break;
                }
                    
                          }
                });
                
           
                ol.add(new tablecar(c.rs.getString("id"),c.rs.getString("name"),c.rs.getString("model"),c.rs.getString("color"),c.rs.getString("price"),but));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        tv.setItems(ol);
            }
        });
        TablePosition pos;
        tv.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
    
    public void handle(MouseEvent event) {
        if (event.getClickCount() == 2){
            NewClass.ol=tv.getItems();
           NewClass.a=tv.getSelectionModel().getSelectedIndex();
            System.out.println(tv.getSelectionModel().getSelectedIndex());
            tablecar tc=(tablecar)tv.getSelectionModel().getSelectedItem();
            autosaleandpurchasemanagmentsystemfull.NewClass.id=tc.id;
            try{
                if(cat.getValue().equals("Sold Cars"))
                root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/phada_1.fxml"));
                else
                    root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/phada.fxml"));
            }catch(Exception e){
                e.printStackTrace();
            }
            Scene s=new Scene(root);
            NewClass.p.setScene(s);
        }
      
          }
        });
        
    }    

    @FXML
     void upbtnaction(ActionEvent event) {
        tablecar tcc=(tablecar)tv.getSelectionModel().getSelectedItem();
        NewClass.id=tcc.id;
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/CarUpdate.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        
    }
Parent root;
    @FXML
     void addbtnaction(ActionEvent event) {
        
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/CARSINTER.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        
    }

    @FXML
     void Delbtnaction(ActionEvent event) {
        tablecar ee=(tablecar)tv.getSelectionModel().getSelectedItem();
        String id=ee.id;
        
        
        try{
            c.st=c.con.createStatement();
            c.st.executeUpdate("UPDATE Car SET d='y' where ID='"+id+"'");
            
              
        
        
            
        }catch(Exception e){
            e.printStackTrace();
        }
         try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/DisplayCars.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        
        
    }

   public void build(){
       
       
   }
   
    @FXML
     void homepaneexit(MouseEvent event) {
       transformsize(1, 0.3, homeico);
         HomePane.setStyle("-fx-border-style: none");
    }

    @FXML
     void homepaneenter(MouseEvent event) {
        transformsize(1.5, 0.3, homeico);
        HomePane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }


    @FXML
     void carpmouseexit(MouseEvent event) {
        
    }

    @FXML
     void carpmouseenter(MouseEvent event) {
        
    }

    public void transformsize(double size,double duration,Node node){
        ScaleTransition st=new ScaleTransition(Duration.seconds(duration),node);
        st.setToX(size);
        st.setToY(size);
        st.play();
    }
    @FXML
     void wmouseexit(MouseEvent event) {
        transformsize(1, 0.3, workerico);
        workerpane.setStyle("-fx-border-style: none");
    }

    @FXML
     void wmouseenter(MouseEvent event) {
        transformsize(1.5, 0.3, workerico);
        workerpane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }


    @FXML
     void commouseexit(MouseEvent event) {
        transformsize(1, 0.3, commico);
        compane.setStyle("-fx-border-style: none");
    }

    @FXML
     void commouseenter(MouseEvent event) {
        transformsize(1.5, 0.3, commico);
        compane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }

    @FXML
     void homepaneclick(MouseEvent event) {
          try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/DashbaordDesign.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        
    }
    
    @FXML
     void carpaneclick(MouseEvent event) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/DisplayCars.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        
    }

    @FXML
     void workerpaneclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/worker.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
     void markpaneexit(MouseEvent event) {
        transformsize(1, 0.3, markico);
        marketpane.setStyle("-fx-border-style: none");
    }

    @FXML
     void markpaneenter(MouseEvent event) {
         transformsize(1.5, 0.3, markico);
        marketpane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }

    @FXML
     void marketpaneclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/Advertisment.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
     void commissionpaneclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/Commission.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
     void closebtnac(ActionEvent event) {
        NewClass.p.close();
    }

    @FXML
     void minbutact(ActionEvent event) {
        NewClass.p.setIconified(true);
    }
  
    
}
