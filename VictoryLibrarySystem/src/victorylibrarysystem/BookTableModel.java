/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package victorylibrarysystem;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;


public class BookTableModel extends AbstractTableModel {
    private List<Book> books = new ArrayList<>();
    private String[] columnNames = {"Book ID", "Title", "Author", "Year"};

    public void addBook(Book book) {
        books.add(book);
        fireTableDataChanged();
    }

    public void removeBook(int index) {
        books.remove(index);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = books.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return book.getId();
            case 1:
                return book.getTitle();
            case 2:
                return book.getAuthor();
            case 3:
                return book.getYear();
            default:
                return null;
        }
    }

    public void setValueAt(int rowIndex, int columnIndex, Object value) {
        Book book = books.get(rowIndex);
        switch (columnIndex) {
            case 0:
                book.setId((Integer) value);
                break;
            case 1:
                book.setTitle((String) value);
                break;
            case 2:
                book.setAuthor((String) value);
                break;
            case 3:
                book.setYear((Integer) value);
                break;
            default:
                throw new IndexOutOfBoundsException("Invalid column index");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            default:
                throw new IndexOutOfBoundsException("Invalid column index");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
}
