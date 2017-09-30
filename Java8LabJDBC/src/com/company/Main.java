package com.company;
import Library.*;
import DAO.DAO1;
public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
Library qq=new Library();
qq.ID=1;
qq.bookname="QQQQ";
qq.date= Integer.parseInt("2012");
qq.publishing="EU Publ";

Author auth=new Author();
auth.Author_name="J.Rolling";
auth.Author_country="GB";
auth.ID=1;
DAO1 con=new DAO1();
      //  con.InsertLibr(qq);
      //  con.InsertAuthor(auth);
        con.ShowLibr();
con.SelectYear(2011);
con.SelectAuthor(2);
con.ShowAuth();
    }
}
