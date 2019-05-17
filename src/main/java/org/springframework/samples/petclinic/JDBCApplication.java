package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApplication {
	
	public static void main(String[] args) {
		System.out.println("-------- Test de conexión con MySQL ------------");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver en el Classpath");
			e.printStackTrace();
			return;
		}

		System.out.println("Driver instalado y funcionando");
		Connection connection = null;
		Statement statement = null;
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "root");
			if (connection != null)
				System.out.println("Conexión establecida");
			
			statement=connection.createStatement();
			String sql = "SELECT * FROM owners";
			ResultSet rs= statement.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println(rs.getString(2)+ " " +rs.getString(3));
			}
			rs.close();
			
			sql= "INSERT INTO owners (first_name, last_name, address, city, telephone) "
					+ "VALLUES ('Manuel', 'Espinosa', una cualquiera', 'Sevilla', '666999666')";
			statement.executeUpdate(sql);
			
			sql="SELECT * FROM owners WHERE first_name = 'Manuel";
			rs= statement.executeQuery(sql);
			int id=0;
			rs.next();
			id=rs.getInt(1);
			
			rs.close();
			sql= "INSERT INTO pet (name,type_id,owner_id) "
					+ "VALLUES ('Mascota', 1," + id +");";
			statement.executeUpdate(sql);
		    
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
	}

}
