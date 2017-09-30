package Task2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Никита on 12.06.2017.
 */
@WebFilter(filterName = "AuthorisationFilter",urlPatterns = "/auth")
public class AuthorisationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        boolean trigger=false;
        String nameuse="";
        int countenters=1;
       try{HttpServletResponse responce=(HttpServletResponse) resp;
           HttpServletRequest request=(HttpServletRequest) req;
        String url = "jdbc:sqlserver:LENOVO-PC;DatabaseName=JAVA;integratedSecurity=true";

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection myconn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433", "java", "qwe123");
        Statement newstat=myconn.createStatement();
        Statement newstat1=myconn.createStatement();
        ResultSet log1=newstat.executeQuery("SELECT Login from dbo.Users");
        ResultSet pas=newstat1.executeQuery("SELECT Password from dbo.Users");
        int columns =log1.getMetaData().getColumnCount();
        while(log1.next() && pas.next()){
            for(int i =1;i<=columns;i++)
            {
                if(req.getParameter("userName").equals(log1.getString(i).toString())&&
                        req.getParameter("userPass").equals(pas.getString(i).toString()))
                {nameuse=log1.getString(i);trigger=true;}

            }

        }
           if (trigger) {
              // SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd  hh:mm:ss a zzz");


             //Cookie cookie=new Cookie("User",countenters++ +" Time accessed "+formatForDateNow.format(new Date().toString()));
((HttpServletResponse) resp).sendRedirect("User.jsp");
           } else {
               //response.getWriter().println("invalid login or password");
               ((HttpServletResponse) resp).sendRedirect("Register.jsp");
           }
        chain.doFilter(req, resp);}
        catch(Exception e) {e.getMessage();}    }

    public void init(FilterConfig config) throws ServletException {

    }

}
