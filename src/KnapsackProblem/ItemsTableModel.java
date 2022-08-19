package KnapsackProblem;

import javax.swing.table.AbstractTableModel;

public class ItemsTableModel extends AbstractTableModel {

	private String[] columnNames = { "Weight", "Value", "Amount" };
	private Object[][] data;
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 10;
	}
	
	@Override
	public String getColumnName(int col) {
        return columnNames[col];
    }

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
