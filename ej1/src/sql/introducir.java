package sql;

import java.sql.*;


public class introducir {

 
	  public void introducir(String nombre, String apellido, int edad) {
    try{
    
      String aajdriver = "com.mysql.cj.jdbc.Driver";
      String aajurl = "jdbc:mysql://localhost/aajhospital";
      Class.forName(aajdriver);
      Connection aajconn = DriverManager.getConnection(aajurl, "root", "");

  
      String aajquery = " insert into pacientes (nombre, apellido, edad)"
        + " values (?, ?, ?)";
      PreparedStatement aajpreparedStmt = aajconn.prepareStatement(aajquery);
      aajpreparedStmt.setString (1, nombre);
      aajpreparedStmt.setString   (2, apellido);
      aajpreparedStmt.setInt(3, edad);

     
      aajpreparedStmt.execute();
      
      aajconn.close();
    }
    catch (Exception e)
    {
      System.err.println("error");
      System.err.println(e.getMessage());
    }
  }
}


