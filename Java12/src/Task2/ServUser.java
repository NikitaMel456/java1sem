package Task2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Никита on 08.06.2017.
 */
@WebServlet(name="auth",urlPatterns = "/UserServlet")
public class ServUser  extends HttpServlet{
   //private Connection myconn;



    public void init(){}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

//    boolean trigger=false;
    String nameuse="";
    int countenters=1;
        response.getWriter().println("Hello ");
        response.getWriter().print(new Date().toString());
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd  hh:mm:ss a zzz");
        response.getWriter().println("<br>"+"Enter time  "+formatForDateNow.format(request.getSession().getCreationTime()));
        response.getWriter().println("<br>"+"Number of enters  "+countenters);


        Cookie cookie=new Cookie("User",countenters++ +" Time accessed "+formatForDateNow.format(request.getSession().getCreationTime()));
      //  response.getWriter().println();



    }
    public void destroy() {
    }
}
