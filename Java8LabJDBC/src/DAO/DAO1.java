package DAO;

import Library.Library;
import  Library.Author;
import java.sql.*;


public class DAO1 {
    private Connection myConn;

    public DAO1() throws Exception {
        myConn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433", "java", "qwe123");

    }

    public void InsertLibr(Library libr) throws SQLException {
        PreparedStatement myStat = null;
        try {
            myStat = myConn.prepareStatement("INSERT  INTO Library1(ID,[Название книги],[Дата издания],[Название издательства]) VALUES (?,?,?,?)");
            myStat.setInt(1, libr.GetID());
            myStat.setString(2, libr.Getbookname());
            myStat.setInt(3, libr.GetDate());
            myStat.setString(4, libr.GetPublish());
            myStat.executeUpdate();
        } finally {
            DAOUtils.close(myStat);
        }
    }

    public void ShowLibr() throws Exception {
        Statement st = myConn.createStatement();
        ResultSet rs = st.executeQuery("SELECT Library1.[Название книги], Author.[Имя автора], Library1.[Дата издания], Library1.[Название издательства]\n" +
                "FROM     Author INNER JOIN\n" +
                "                  Library1 ON Author.ID = Library1.ID");
        int columns = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                System.out.print(rs.getString(i) + "\t|");
            }
            System.out.println();
        }
    }


    public void InsertAuthor(Author auth) throws SQLException {
        PreparedStatement myStat = null;
        try {
            myStat = myConn.prepareStatement("insert into Author([Имя автора],[Страна происхождения],ID) VALUES (?,?,?)");
            myStat.setString(1, auth.GetAuthorName());
            myStat.setString(2, auth.GetAuCountry());
            myStat.setInt(3, auth.GetAuID());
            myStat.executeUpdate();
        } finally {
            DAOUtils.close(myStat);
        }
    }

    public void SelectYear(int year) throws SQLException {

        Statement st = myConn.createStatement();
        ResultSet rs = st.executeQuery("SELECT Library1.[Название книги], Author.[Имя автора], Library1.[Дата издания], Library1.[Название издательства]\n" +
                "FROM     Author INNER JOIN\n" +
                "                  Library1 ON Author.ID = Library1.ID\n" +
                "WHERE  (Library1.[Дата издания] =" + year + ") OR\n" +
                "                  (Library1.[Дата издания] =" + (year - 1) + ")");
        int columns = rs.getMetaData().getColumnCount();
        // myStat.setString(1,auth.GetAuthorName());
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                System.out.print(rs.getString(i) + "\t|");
            }
            System.out.println();
        }
    }

    public void SelectAuthor(int N) throws SQLException {
        Statement st = myConn.createStatement();
        try {
            ResultSet rs = st.executeQuery(
                    " select distinct  Author.[Имя автора],Author.[Страна происхождения]    from Author INNER JOIN\n" +
                            "                  Library1 ON Author.ID = Library1.ID     \n" +
                            "\t\t\t\t  where dbo.FKolTov(Author.[Имя автора])=" + N + " or " + "dbo.FKolTov(Author.[Имя автора])>" + N);
            int columns = rs.getMetaData().getColumnCount();
            // myStat.setString(1,auth.GetAuthorName());
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t|");
                }
                System.out.println();
            }
        } catch (Exception e) {
            ResultSet rs = st.executeQuery(
                    "create function FKolTov(@p varchar(50)) returns int \n" +
                            "as\n" +
                            " begin\n" +
                            "    declare @rc int =(select count(*) from Author INNER JOIN\n" +
                            "                  Library1 ON Author.ID = Library1.ID\n" +
                            "    where Author.[Имя автора]= isnull(@p, Author.[Имя автора]));\n" +
                            "    return @rc;\n" +
                            " end;  \n" +
                            " go   \n");
        }
    }

    public void ShowAuth() throws Exception {
        Statement st = myConn.createStatement();
        ResultSet rs = st.executeQuery("SELECT distinct [Имя автора], [Страна происхождения]\n" +
                "FROM     Author");
        int columns = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                System.out.print(rs.getString(i) + "\t|");
            }
            System.out.println();
        }
    }

    public void DeleteAllBooks(int year) throws Exception
    {
        Statement st=myConn.createStatement();
        ResultSet rs=st.executeQuery("Delete from Library1  where Library1.[Дата издания]>"+year);
    }

}
