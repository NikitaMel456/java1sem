package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAOUtils {
    public static  void  close(Connection myConn, Statement mySt, ResultSet myRs) throws SQLException{
        if(myRs!=null){
            myRs.close();
        }
        if(mySt!=null){
            mySt.close();
        }
        if(myConn!=null){
            myConn.close();
        }
    }

    public static void close(Statement mySt,ResultSet myRs)throws  SQLException{
        close(null,mySt,myRs);
    }

    public static  void close(Statement mySt)throws SQLException{
        close(null,mySt,null);
    }
}
