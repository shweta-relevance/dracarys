import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class LoginServlet extends HttpServlet {
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
			
			// Set the response MIME type of the response message
			response.setContentType("text/html");
			// Allocate a output writer to write the response message into the network socket
			PrintWriter out = response.getWriter();			
			 
			 try { 
				UserBean user = new UserBean(); 
				user.setUserName(request.getParameter("un")); 
				user.setPassword(request.getParameter("pw"));
				
				user = UserDAO.login(user); 
				
				if (user.isValid()) 
				{ 
					HttpSession session = request.getSession(true); 
					session.setAttribute("currentSessionUser",user); 
					response.sendRedirect("dashboard.jsp"); //logged-in page 
				} 
				else 
				{
					response.sendRedirect("invalidLogin.jsp"); //error page 
				}
				
			} catch (Throwable theException) { 
				System.out.println(theException); 
			}
      
   }
}