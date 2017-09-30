package ui;

import Library.*;

import javax.swing.table.AbstractTableModel;
import java.util.List;


public class AuthTableModel extends AbstractTableModel {


    private static final int  Auth_NAME_COL=0;
    private static final int Country_COL=1;
    private static final int ID_COL=2;
    private String[] columnNames={"AuthorName","Country","ID"};
    private List<Author> auth;
    public AuthTableModel(List<Author> theauth)
    {
        auth=theauth;
    }



    @Override
    public int getRowCount() {
        return auth.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Author tmpauth=auth.get(rowIndex);
        switch (columnIndex)
        {
            case ID_COL:return  tmpauth.GetAuID();
            case Auth_NAME_COL:return tmpauth.GetAuthorName();
            case Country_COL:return  tmpauth.GetAuCountry();
            default: return tmpauth.GetAuthorName();
        }
    }
}
