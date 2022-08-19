package KnapsackProblem;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		//gui
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}
		});

	}

}
