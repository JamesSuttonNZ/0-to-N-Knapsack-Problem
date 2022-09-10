package KnapsackProblem;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class OptionsPanel extends JPanel {
	
	private JPanel itemAmountPanel, algoPanel, numItemsPanel, weightLimitPanel;

	private JRadioButton zeroTo1, zeroToN, dynamic, bruteForce, graphSearch, graphSearchRecursive;
	private ButtonGroup group1, group2;
	
	private JTextField weightLimit, numItems;
	
	private JButton createTableBtn;
	
	private JTable items;
	private ItemsTableModel itemsModel;
	
	private Knapsack knapsack;
	
	public OptionsPanel() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(10,10,10,10));
		
		//choose between 0-1 and 0-N
		itemAmountPanel = new JPanel(new FlowLayout());
//		JLabel op1Label = new JLabel("Amount of Each Item:");
//		op1.add(op1Label);
		zeroTo1 = new JRadioButton("0-1");
		zeroTo1.setSelected(true);
		zeroToN = new JRadioButton("0-N");
		itemAmountPanel.add(zeroTo1);
		itemAmountPanel.add(zeroToN);
		
		zeroTo1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dynamic.setSelected(true);
				bruteForce.setEnabled(false);
				graphSearch.setEnabled(false);
				graphSearchRecursive.setEnabled(false);
				itemsModel.setZeroToN(false);
			}	
		});
		
		zeroToN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				bruteForce.setEnabled(true);
				graphSearch.setEnabled(true);
				graphSearchRecursive.setEnabled(true);
				itemsModel.setZeroToN(true);
			}
			
		});
		group1 = new ButtonGroup();
		group1.add(zeroTo1);
		group1.add(zeroToN);
		add(itemAmountPanel);
		
		//choose algorithm
		algoPanel = new JPanel(new FlowLayout());
//		JLabel op2Label = new JLabel("Algorithm:");
//		op2.add(op2Label);
		dynamic = new JRadioButton("Dynamic Programming");
		dynamic.setSelected(true);
		bruteForce = new JRadioButton("Brute Force");
		bruteForce.setEnabled(false);
		graphSearch = new JRadioButton("Graph Search");
		graphSearch.setEnabled(false);
		graphSearchRecursive = new JRadioButton("Graph Search Recursive");
		graphSearchRecursive.setEnabled(false);
		algoPanel.add(dynamic);
		algoPanel.add(bruteForce);
		algoPanel.add(graphSearch);
		algoPanel.add(graphSearchRecursive);
		group2 = new ButtonGroup();
		group2.add(dynamic);
		group2.add(bruteForce);
		group2.add(graphSearch);
		group2.add(graphSearchRecursive);
		add(algoPanel);
		
		//number of unique items
		numItemsPanel = new JPanel(new FlowLayout());
		JLabel op3Label = new JLabel("Number of Items:");
		numItemsPanel.add(op3Label);
		numItems = new JTextField(10);
		numItems.setText("0");
//		numItems.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				System.out.println(numItems.getText());
//			}
//			
//		});

//		numItems.addFocusListener(new FocusListener() {
//
//			@Override
//			public void focusGained(FocusEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void focusLost(FocusEvent arg0) {
//				System.out.println(numItems.getText());
//			}
//			
//		});
		numItemsPanel.add(numItems);
		add(numItemsPanel);
		
		//create table button
		createTableBtn = new JButton("Create Table");
		createTableBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int nItems = Integer.parseInt(numItems.getText());
				int wLim = Integer.parseInt(weightLimit.getText());
				knapsack = new Knapsack(nItems, wLim);
				
				Object[][] data = { {3,7,1}, {4,6,1}, {5,5,1}, {6,4,1}, {7,3,1}};
				itemsModel.setData(data);
				
			}
			
		});
		add(createTableBtn);
		
		//items table
		Object[][] data = { {3,7,1}, {4,6,1}, {5,5,1}};
		itemsModel = new ItemsTableModel(data);
		items = new JTable(itemsModel);
		add(new JScrollPane(items));
		
		
		//weight limit
		weightLimitPanel = new JPanel(new FlowLayout());
		JLabel op4Label = new JLabel("Weight Limit:");
		weightLimitPanel.add(op4Label);
		weightLimit = new JTextField(10);
		weightLimit.setText("20");
		weightLimitPanel.add(weightLimit);
		add(weightLimitPanel);
	}
}
