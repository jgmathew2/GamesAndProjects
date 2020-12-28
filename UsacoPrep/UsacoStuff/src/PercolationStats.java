import java.util.Random;

public class PercolationStats {
	private int n; 
	private int trials; 
	
	
	public PercolationStats(int n, int trials)  {
		if(n <= 0 || trials <= 0) throw (new IllegalArgumentException()); 
		
		this.trials = trials; 
		this.n = n; 
	}
	
	public double mean() {
		int remainingTrials = trials; 
		
		double total = 0; 
		
		while(remainingTrials >= 0) {
			Percolation trial = new Percolation(n); 
			
			
			while(!trial.percolates()) {

				Random rand = new Random();
					
				int selectedRow = rand.nextInt(n) + 1; 
				
				int selectedCol = rand.nextInt(n) + 1; 
				
				trial.open(selectedRow, selectedCol);
			}
			
			
			total += (double) (trial.numberOfOpenSites() / (n * n));
			remainingTrials--; 
		}
		
		return total / trials; 
	}
	
	
	public static void main(String[] args) {
		PercolationStats test = new PercolationStats(2, 10); 
		
		
		System.out.println(test.mean()); 
	}
	
	

}
