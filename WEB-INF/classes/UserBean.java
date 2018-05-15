public class UserBean { 
	private String username; 
	private String password; 
	private int id; 
	private int user_role_id; 
	private boolean active; 
	public boolean valid;
	
	public int getId() 
	{ 
		return id; 
	} 
	
	public void setId(int newId) 
	{ 
		id = newId; 
	}

	public int getUserRoleId() 
	{ 
		return user_role_id; 
	} 
	
	public void setUserRoleId(int newUserRoleId) 
	{ 
		user_role_id = newUserRoleId; 
	} 
	
	public String getPassword() 
	{ 
		return password; 
	} 
	
	public void setPassword(String newPassword) 
	{ 
		password = newPassword; 
	} 
	
	public String getUsername() 
	{ 
		return username; 
	} 
	
	public void setUserName(String newUsername) 
	{ 
		username = newUsername; 
	} 
	
	public boolean isActive() 
	{ 
		return active; 
	} 
	public void setActive(boolean newActive) 
	{ 
		active = newActive; 
	} 
	
	public boolean isValid() 
	{ 
		return valid; 
	} 
	
	public void setValid(boolean newValid) 
	{ 
		valid = newValid; 
	} 
	
	public String toString()
	{
		return "Username:"+this.getUsername()+" Password:"+this.getPassword()+" id:"+this.getId();
	}
}