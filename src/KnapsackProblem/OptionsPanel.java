package KnapsackProblem;

import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class OptionsPanel extends JPanel {

	private JRadioButton zeroTo1;
	private JRadioButton zeroToN;
	private ButtonGroup group1;
	
	private JRadioButton dynamic;
	private JRadioButton bruteForce;
	private JRadioButton graphSearch;
	private JRadioButton graphSearchRecursive;
	private ButtonGroup group2;
	
	private JTextField weightLimit;
	private JTextField numItems;
	
	private JTable items;
	private ItemsTableModel itemsModel;
	
	public OptionsPanel() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(10,10,10,10));
		
		//choose between 0-1 and 0-N
		JPanel op1 = new JPanel(new FlowLayout());
		
//		JLabel op1Label = new JLabel("Amount of Each Item:");
//		op1.add(op1Label);
		
		zeroTo1 = new JRadioButton("0-1");
		zeroTo1.setSelected(true);
		zeroToN = new JRadioButton("0-N");
		op1.add(zeroTo1);
		op1.add(zeroToN);
		
		group1 = new ButtonGroup();
		group1.add(zeroTo1);
		group1.add(zeroToN);
		
		add(op1);
		
		//choose algorithm
		JPanel op2 = new JPanel(new FlowLayout());
		
//		JLabel op2Label = new JLabel("Algorithm:");
//		op2.add(op2Label);
		
		dynamic = new JRadioButton("Dynamic Programming");
		dynamic.setSelected(true);
		bruteForce = new JRadioButton("Brute Force");
		graphSearch = new JRadioButton("Graph Search");
		graphSearchRecursive = new JRadioButton("Graph Search Recursive");
		op2.add(dynamic);
		op2.add(bruteForce);
		op2.add(graphSearch);
		op2.add(graphSearchRecursive);
		
		group2 = new ButtonGroup();
		group2.add(dynamic);
		group2.add(bruteForce);
		group2.add(graphSearch);
		group2.add(graphSearchRecursive);
		
		add(op2);
		
		//weight limit
		JPanel op3 = new JPanel(new FlowLayout());
		
		JLabel op3Label = new JLabel("Weight Limit:");
		op3.add(op3Label);
		
		weightLimit = new JTextField(10);
		weightLimit.setText("0");
		op3.add(weightLimit);
		
		add(op3);
		
		//number of unique items
		JPanel op4 = new JPanel(new FlowLayout());
		
		JLabel op4Label = new JLabel("Number of Items:");
		op4.add(op4Label);
		
		numItems = new JTextField(10);
		numItems.setText("0");
		op4.add(numItems);
		
		add(op4);
		
		//items table
		itemsModel = new ItemsTableModel();
		items = new JTable(itemsModel);
		add(new JScrollPane(items));
	}
}
