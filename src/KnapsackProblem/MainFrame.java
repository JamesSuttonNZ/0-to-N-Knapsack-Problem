package KnapsackProblem;

import java.awt.BorderLayout;

import javax.swing.*;

public class MainFrame extends JFrame {
	
	private JTextArea textArea;
	private JButton btn;
	
	
	public MainFrame() {
		super("Knapsack Problem");
		
		setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		btn = new JButton("Click Me!");
		
		add(new OptionsPanel(), BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
