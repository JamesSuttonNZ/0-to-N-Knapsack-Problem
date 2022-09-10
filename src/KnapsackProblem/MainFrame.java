package KnapsackProblem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame {
	
	private JTextArea textArea;
	private JButton btn;
	private OptionsPanel optPanel;
	
	public MainFrame() {
		super("Knapsack Problem");
		
		setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		btn = new JButton("Calculate");
		optPanel = new OptionsPanel();
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//knapsack.calculate(textArea);
			}
			
		});
		
		add(optPanel, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
