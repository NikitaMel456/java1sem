package ui;

import Library.Library;

import javax.swing.table.AbstractTableModel;
import java.util.List;


public class LibraTableModel extends AbstractTableModel {

    public static  final  int OBJECT_COL=-1;
    private static final int ID_COL=0;
    private static final int  BOOK_NAME_COL=1;
    private static final int DATE_COL=2;
    private static final int PUBLISH_COL=3;

    private String[] columnNames={"ID","BookName","Date","Name of Publishing"};
    private List<Library> libra;

    public LibraTableModel(List<Library> thelibr)
    {
        libra=thelibr;
    }

    @Override
    public int getRowCount() {
        return libra.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Library tmplibra=libra.get(rowIndex);
       switch (columnIndex)
       {
           case ID_COL:return  tmplibra.GetID();
           case BOOK_NAME_COL:return tmplibra.Getbookname();
           //case AUTHOR_NAME_COL:return  tmplibra.GetAuthorname();
           case DATE_COL:return  tmplibra.GetDate();
           case PUBLISH_COL:return  tmplibra.GetPublish();
           default: return tmplibra.Getbookname();
       }

    }
}
