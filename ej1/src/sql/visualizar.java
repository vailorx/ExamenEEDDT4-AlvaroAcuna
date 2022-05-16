package sql;

import java.sql.*;

import javax.swing.JOptionPane;

public class visualizar {

	public void visualizar1(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection aajcon = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/aajhospital","root","");
			
			Statement aajstmt = aajcon.createStatement();
			
			ResultSet aajrs = aajstmt.executeQuery("select * from pacientes");
			
			// Imprimir
			while( aajrs.next() ) {
				System.out.println(aajrs.getString(1) + " " + aajrs.getString(2) + " " + aajrs.getInt(3));
				JOptionPane.showMessageDialog(null, aajrs.getString(1) + " " + aajrs.getString(2) + " " + aajrs.getInt(3));
			}
			
			aajcon.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

