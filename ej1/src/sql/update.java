package sql;
import java.sql.*;

public class update {  
public void update(String aajquery){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection aajcon=DriverManager.getConnection("jdbc:mysql://localhost/aajhospital", "root", "");

       
            PreparedStatement aajstmt = aajcon.prepareStatement(aajquery);

            aajstmt.executeUpdate();
            aajcon.close();

        }catch (Exception e) {
            System.err.println("Error personalizado");
            System.err.println(e.getMessage());
        }

}
}