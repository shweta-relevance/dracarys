public class Test {

 public static void main(String[] args) {
  
   try { 
    UserBean user = new UserBean(); 
    user.setUserName("admin"); 
    user.setPassword("admin"); 
    
    user = UserDAO.login(user); 
    System.out.println("Hello");
    System.out.println(user);
    
    
   } catch (Throwable theException) { 
    System.out.println(theException); 
   }
   
 }
}