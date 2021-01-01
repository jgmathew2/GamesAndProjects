package ctyAlgsAssignments;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom; 

public class PercolationStats {
	private final double[] results; 
	
	
	public PercolationStats(int n, int trials)  {
		if(n <= 0 || trials <= 0) throw (new IllegalArgumentException()); 
		
		results = new double[trials]; 
		
		int remainingTrials = trials - 1; 
		
		while(remainingTrials >= 0) {
			Percolation trial = new Percolation(n); 
			
			while(!trial.percolates()) {
					
				int selectedRow = StdRandom.uniform(n) + 1; 
				
				int selectedCol = StdRandom.uniform(n) + 1; 
				
				trial.open(selectedRow, selectedCol);
			}
			
			double trialProb = trial.numberOfOpenSites(); 
			trialProb /= (n * n); 
			
			results[remainingTrials] = trialProb;
			remainingTrials--; 
			
		}
	}
	
	public double mean() {
		return StdStats.mean(results); 
	}
	
	public double stddev() {
		return StdStats.stddev(results); 
	}
	
	public double confidenceLo() {
		return this.mean() - 2 * this.stddev(); 
	}
	
	public double confidenceHi() {
		return this.mean() + 2 * this.stddev(); 
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]); 
		int t = Integer.parseInt(args[1]); 
		
		PercolationStats experiment = new PercolationStats(n, t); 
		
		System.out.println("mean() = " + experiment.mean()); 
		System.out.println("stddev() = " + experiment.stddev()); 
		System.out.print("95% confidence interval = [" + experiment.confidenceLo() + ", "); 
		System.out.print(experiment.confidenceHi() + "]"); 
	}
	

	
	

}
