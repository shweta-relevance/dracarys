import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserFilter implements Filter {
    protected ServletContext servletContext;
	protected HttpServletRequest req;
 
    public void init(FilterConfig filterConfig) {
        servletContext = filterConfig.getServletContext();
    }
 
    public void doFilter(
        ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
     
        if (!isAuth()) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return; //break filter chain, requested JSP/servlet will not be executed
        }
     
        //propagate to next element in the filter chain, ultimately JSP/ servlet gets executed
        chain.doFilter(request, response);        
    }
	
	public void destroy() {}  
 
    /**
     * logic to accept or reject access to the page, check log in status
     * @return true when authentication is deemed valid
     */
    protected  boolean isAuth() {
		
		HttpSession session = req.getSession(true); 
		
		UserBean currentUser = (UserBean) session.getAttribute("currentSessionUser");
		
		return currentUser.isValid();
	}
	
	
 
}