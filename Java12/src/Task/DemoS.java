package Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by Никита on 05.06.2017.
 */
@WebServlet("/DemoServlet")
public class DemoS extends HttpServlet {
    public DemoS(){super();}
    public void init()throws ServletException{}
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

        response.setContentType("text/html");
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd  hh:mm:ss a zzz");
        response.getWriter().print("Current date and time is "+formatForDateNow.format(dateNow));
        response.getWriter().println("<br>"+"protocol: " + request.getProtocol());
        response.getWriter().println("<br>"+"client IP: " + request.getRemoteAddr());
        response.getWriter().println("<br>"+"client name: " + request.getRemoteUser());
        response.getWriter().println("<br>"+"method: " + request.getMethod());
        response.getWriter().println("<br>"+"URL: " + request.getRequestURL());
        response.getWriter().println("<br>"+"information about header");
        Enumeration<String> e = request.getHeaderNames();
        while(e.hasMoreElements()) {
            String name = e.nextElement();
            String value = request.getHeader(name);
            response.getWriter().println("<br>"+name + ":  " + value);

        }
    }
    public void destroy(){
        super.destroy();
    }
}
