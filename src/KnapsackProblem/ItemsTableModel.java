package KnapsackProblem;

import javax.swing.table.AbstractTableModel;

public class ItemsTableModel extends AbstractTableModel {

	private String[] columnNames = { "Weight", "Value", "Amount" };
	private Object[][] data = { {3,7,1}, {4,6,1}, {5,5,1}, {6,4,1}, {7,3,1}};
	private boolean zeroToN = false;
	
	public boolean isZeroToN() {
		return zeroToN;
	}

	public void setZeroToN(boolean zeroToN) {
		this.zeroToN = zeroToN;
		fireTableChanged(null);
	}

	@Override
	public int getColumnCount() {
		if(zeroToN) {
			return 3;
		}
		return 2;
	}

	@Override
	public int getRowCount() {
		if(data != null) {
			return data.length;
		}
		return 0;
	}
	
	@Override
	public String getColumnName(int col) {
        return columnNames[col];
    }

	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	@Override
	public void setValueAt(Object obj, int row, int col) {
		data[row][col] = obj;
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return true;
	}

}
