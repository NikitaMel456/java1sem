package Task2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Никита on 08.06.2017.
 */
@WebServlet("/Register")
public class SessionServlet extends HttpServlet{
    public void init(){}
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection myconn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433", "java", "qwe123");
            // myconn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433", "java", "qwe123");
            PreparedStatement newstat=myconn.prepareStatement("Insert into Users (Login, Password, ID) VALUES (?,?,?)");
            newstat.setString(1,request.getParameter("Login"));
            newstat.setString(2,request.getParameter("Password"));
            newstat.setInt(3,Integer.parseInt( request.getParameter("ID")));
      newstat.executeUpdate();
      response.getWriter().println("Successful registration");
      response.sendRedirect("User.jsp");
        }
catch (Exception e)
{
    response.getWriter().println(e.getMessage());
}
    }
}
