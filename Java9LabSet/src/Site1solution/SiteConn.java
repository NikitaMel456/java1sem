package Site1solution;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class SiteConn {
    public static void TryConn()
    {
        String urlName="http://www.onliner.com";
        int timeout=10_000;
        URL url;
        try{
            url=new URL(urlName);
            final URLConnection connection=url.openConnection();
            connection.setConnectTimeout(timeout);
            System.out.println(urlName+" content type: "+"\n"+
                    connection.getContentType()+"\n"+
                    connection.getClass()+"\n"+
                    connection.getContentLength());
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
