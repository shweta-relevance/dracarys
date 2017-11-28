import java.sql.*; 
import java.util.*; 

public class ConnectionManager {
	static Connection con; 
	static String url; 
	
	public static Connection getConnection() 
	{ 
		try 
		{ 
			
			Class.forName("com.mysql.jdbc.Driver");
			try 
			{ 
				con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/dracrys","root","");  
			} 
			catch (SQLException ex) 
			{ 
				ex.printStackTrace(); 
			} 
		} 
		catch(Exception e) 
		{ 
			System.out.println(e); 
		} 
		
		return con; 
	} 
}