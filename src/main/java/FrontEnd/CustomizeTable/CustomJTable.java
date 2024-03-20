package FrontEnd.CustomizeTable;

import java.awt.Component;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;

public class CustomJTable extends JTable {

    public CustomJTable() {
        super(new DefaultTableModel(new Object[][]{}, new String[]{}));
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void initializeColumns(ArrayList<String> columnNames) {
        String[] columnArray = new String[columnNames.size()];
        columnArray = columnNames.toArray(columnArray);
        ((DefaultTableModel) getModel()).setColumnIdentifiers(columnArray);
    }

    public int getClickedID() {
        int idColumnIndex = getColumnIndexByName("ID");
        if (idColumnIndex == -1) {
            throw new IllegalArgumentException("Column 'ID' not found");
        }

        int selectedRow = getSelectedRow();
        if (selectedRow != -1) {
            return (int) getValueAt(selectedRow, idColumnIndex);
        }
        return -1;
    }

    private int getColumnIndexByName(String columnName) {
        TableColumnModel columnModel = getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            if (columnModel.getColumn(i).getHeaderValue().equals(columnName)) {
                return i;
            }
        }
        return -1; // Column not found
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component component = super.prepareRenderer(renderer, row, column);
        if (isRowSelected(row)) {
            component.setBackground(getSelectionBackground());
            component.setForeground(getSelectionForeground());
        } else {
            component.setBackground(getBackground());
            component.setForeground(getForeground());
        }
        return component;
    }
}
