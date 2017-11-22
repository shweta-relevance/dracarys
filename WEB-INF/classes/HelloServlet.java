import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class HelloServlet extends HttpServlet {
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
 
      // Set the response MIME type of the response message
      response.setContentType("text/html");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
 
      Connection conn = null;
      Statement stmt = null;
	  // Write the response message, in an HTML page
      try {
         out.println("<html>");
         out.println("<head><title>Hello, World</title></head>");
         out.println("<body>");
         out.println("<h1>Hello, world!</h1>");  // says Hello
         // Echo client's request information
         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
         out.println("<p>Protocol: " + request.getProtocol() + "</p>");
         out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
         // Generate a random number upon each request
         out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
		 
		 conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/evente?useSSL=false", "root", "pass1234");
			
		stmt = conn.createStatement();
		
		 String sqlStr = "select id, name from district ";
		 
		 out.println("<p>You query is: " + sqlStr + "</p>");
		 
		 ResultSet rset = stmt.executeQuery(sqlStr); 
		 
		 int count = 0;
         while(rset.next()) {
            // Print a paragraph <p>...</p> for each record
            out.println("<p>" + rset.getString("id")
                 + ", " + rset.getString("name") + "</p>");
            count++;
         }
         out.println("<p>==== " + count + " records found =====</p>");
		 
         out.println("</body></html>");
      } catch (SQLException ex) {
            ex.printStackTrace();
      } finally {
            out.close();  // Always close the output writer
      }
   }
}