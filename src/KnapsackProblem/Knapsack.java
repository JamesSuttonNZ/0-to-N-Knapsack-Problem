package KnapsackProblem;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextArea;

public class Knapsack {

	private int[] weights;
	private int[] values;
	private int[] amount;
	private int[] choices; 
	private int weightLimit;
	
	public Knapsack(int n, int lim) {
		this.weights = new int[n];
		this.values = new int[n];
		this.amount = new int[n];
		this.weightLimit = lim;
		
		if(values.length != weights.length || values.length != amount.length){
			throw new Error("number of values and weights needs to be the same");
		}
		
		System.out.println("Weights: "+Arrays.toString(weights));
		System.out.println("Values: "+Arrays.toString(values));
		System.out.println("Weight Limit: "+weightLimit+"\n");
		
		final long startTime = System.currentTimeMillis();
		knapsack();
		final long endTime = System.currentTimeMillis();

		System.out.println("\nTotal execution time: " + (endTime - startTime) + "ms");
		
	}
	
	/**
	 * Creates dynamic programming table
	 */
	private void knapsack() {
		
		int[][] V = new int[values.length][weightLimit+1];
		
		for(int row = 0; row < values.length; row++){
			for(int col = 0; col < weightLimit+1; col++){
				if(row == 0){
					if(weights[row] <= col && weights[row] <= weightLimit){
						V[row][col] = values[row];
					}
				}
				else{
					int above = V[row-1][col];
					if(col-weights[row] < 0){
						V[row][col] = above;
					}else{
						V[row][col] = Math.max(V[row-1][col], (V[row-1][col-weights[row]]+values[row]));
					}
				}
			}
		}
		
		//prints table (commented out for consistency of execution time)
		System.out.println("Table:");
		for (int[] row : V){
			System.out.println(Arrays.toString(row));
		}
		
		recovery(V);
	}

	/**
	 * recovers the chosen values from the table
	 * @param V
	 */
	private void recovery(int[][] V) {
		//recovery
		choices = new int[values.length];
		int row = values.length-1;
		int col = weightLimit;
		int totValue = 0;
		int totWeight = 0;
		while(row > 0){
			int score = V[row][col];
			int above = V[row-1][col];
			if(score == above){
				choices[row] = 0;
				row--;
			}
			else{
				choices[row] = 1;
				col = col - weights[row];
				totValue += values[row];
				totWeight += weights[row];
				row--;	
			}
		}
		
		//check if we can take first row object
		if(totWeight+weights[row] <= weightLimit){
			choices[row] = 1;
			totValue += values[row];
			totWeight += weights[row];
		}
		
		System.out.println("\nChoices: "+Arrays.toString(choices));
		System.out.println("Total Weight of chosen objects: "+totWeight);
		System.out.println("Total Value of chosen objects: "+totValue);
	}

	public void calculate(JTextArea textArea) {
		// TODO Auto-generated method stub
		
	}
}
