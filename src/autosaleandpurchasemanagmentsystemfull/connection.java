package autosaleandpurchasemanagmentsystemfull;
import java.sql.*;

public class connection {

    public Connection con;
    public Statement st;
    public ResultSet rs;
   public PreparedStatement ps;
    public void connect(){
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databaseName=AMS;user=sa;password=12345";
        con=DriverManager.getConnection(url);
        
        
      
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
