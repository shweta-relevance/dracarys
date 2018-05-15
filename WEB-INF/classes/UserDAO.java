import java.text.*; 
import java.util.*; 
import java.sql.*; 

public class UserDAO { 
	
	static Connection currentCon = null; 
	
	static ResultSet rs = null; 
	
	public static UserBean login(UserBean bean) 
	{ //preparing some objects for connection 
		Statement stmt = null; 
		String username = bean.getUsername(); 
		String password = bean.getPassword(); 
		String searchQuery = "select * from user where username='" + username + "' AND password='" + password + "'"; 
		// "System.out.println" prints in the console; Normally used to trace the process 
		System.out.println("Your user name is " + username); 
		System.out.println("Your password is " + password); 
		System.out.println("Query: "+searchQuery); 
		
		try { 
			//connect to DB 
			currentCon = ConnectionManager.getConnection(); 
			stmt=currentCon.createStatement(); 
			rs = stmt.executeQuery(searchQuery); 
			boolean more = rs.next(); 
			// if user does not exist set the isValid variable to false 
			if (!more) 
			{ 
				System.out.println("Sorry, you are not a registered user! Please sign up first"); 
				bean.setValid(false); 
			} //if user exists set the isValid variable to true 
			else if (more) 
			{ 
				int id = rs.getInt("id"); 
				int user_role_id = rs.getInt("user_role_id");
				boolean active = rs.getBoolean("active");
				System.out.println("Welcome your id is " + id); 
				bean.setId(id); 
				bean.setUserRoleId(user_role_id); 
				bean.setActive(active); 
				bean.setValid(true); 
			} 
		} 
		catch (Exception ex) 
		{ 
			System.out.println("Log In failed: An Exception has occurred! " + ex); 
		} 
		//some exception handling 
		finally 
		{ 
			if (rs != null) 
			{ 
				try 
				{ 
					rs.close(); 
				} 
				catch (Exception e) {} 
				
				rs = null; 
			} 
		
			if (stmt != null) 
			{ 
				try 
				{ 
					stmt.close(); 
				} 
				catch (Exception e) {} 
				
				stmt = null; 
			} 
			
			if (currentCon != null) 
			{ 
				try 
				{ 
					currentCon.close(); 
				} 
				catch (Exception e) { }
				
				currentCon = null; 
			} 
		} 
		
		return bean; 
	} 
}