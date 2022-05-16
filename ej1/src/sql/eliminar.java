package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class eliminar {
	//@param asignamos los valos de tanto nuestra conexion, como el usuario que vamos utilizar y contraseña  
static final String aajDB_URL = "jdbc:mysql://localhost:3306/aajhospital";
	static final String aajUSER = "root";
	static final String aajPASS = "";
	
	public void eliminar1(){

		try( Connection aajconn = DriverManager.getConnection(aajDB_URL,aajUSER,aajPASS); 
				Statement aajstm = aajconn.createStatement(); ) {
		//@param introducimos la sentencia sql para ejecutarla 	
			String aajsql = "DELETE FROM pacientes where nombre = 'Pedro'";
			aajstm.executeUpdate(aajsql);
			System.out.println("Registros borrados");
			
			
		}catch(SQLException e) {
			System.out.println(e);
		}	
	}
}