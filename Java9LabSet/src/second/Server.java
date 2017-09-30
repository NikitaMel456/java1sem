package second;



import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Server
{
    ServerSocket serverSocket = new ServerSocket(8667);
    private List<Connection> connections =
            Collections.synchronizedList(new ArrayList<Connection>());

    public Server() throws IOException
    {
    }

    public void SetSocket(int socket) throws IOException
    {
        serverSocket = new ServerSocket(socket);
    }

    public void Run() throws IOException, NamingException
    {
        while (true)
        {
            Socket socket = serverSocket.accept();
            Connection connection = new Connection(socket);
            connections.add(connection);
            connection.start();
        }
    }

    private void closeAll()
    {
        try
        {
            serverSocket.close();

            synchronized (connections)
            {
                for (Connection con : connections)
                {
                    con.close();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private class Connection extends Thread
    {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;

        private String name = "";

        public Connection(Socket socket)
        {
            this.socket = socket;

            try {
                in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

            } catch (IOException e) {
                e.printStackTrace();
                close();
            }
        }

        @Override
        public void run()
        {
            try
            {
                name = in.readLine();
                synchronized(connections)
                {
                    for (Connection con : connections)
                    {
                        con.out.println(name + " подключился [" + socket.getInetAddress() + "]");
                    }
                }

                String str = "";
                while (true)
                {
                    str = in.readLine();
                    if(str.equals("exit"))
                    {
                        break;
                    }

                    synchronized(connections)
                    {
                        for (Connection con : connections)
                        {
                           con.out.println(name + ": " + str);
                        }
                    }
                }

                synchronized(connections)
                {
                    for (Connection con : connections)
                    {
                        con.out.println(name + " покинул чат");
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                close();
            }
        }

        public void close()
        {
            try
            {
                in.close();
                out.close();
                socket.close();

                connections.remove(this);
                if (connections.size() == 0)
                {
                    Server.this.closeAll();
                    System.exit(0);
                }
            }
            catch (Exception e)
            {
                System.err.println("Потоки не были закрыты!");
            }
        }
    }
}
