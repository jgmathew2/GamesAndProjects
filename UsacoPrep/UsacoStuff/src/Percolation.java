import java.util.Random;

public class Percolation {
	private boolean[] open;
	private static int n; 
	
	private static int openSites; 
	
	private int[] unions; 
	private static int[] size;
	
	Percolation(int n) {
		this.n = n; 
		
		open = new boolean[n * n + 2]; 
		open[0] = true; 
		open[n * n + 1] = true; 
		
		unions = new int[n * n + 2];
		size  = new int[n * n + 2]; 
		

		for(int i = 0; i < unions.length; i++) {
			unions[i] = i; 
		}
		
		
	
	}


	
	public void open(int row, int col)  {
		if(row <= 0 || row > n || col <= 0 || col > n ) throw (new IllegalArgumentException()); 
		int selected = n * (row - 1) + col; 
		boolean status = open[selected]; 
		
		if(status == false) {
			
			open[selected] = true; 
			
			openSites++;
			
			if(open[selected + 1]) quickUnion(unions, size, selected, selected + 1);
			
			if(open[selected - 1]) quickUnion(unions, size, selected, selected - 1); 
			
			
			try {
				if(open[selected + n]) {
					quickUnion(unions, size, selected, selected + n); 
				}
			}
			catch(Exception e) {
				quickUnion(unions, size, selected, n * n + 1); 
			}
			

		
			try {
				if(open[selected - n]) {
					quickUnion(unions, size, selected, selected - n); 
				}
			}
			catch(Exception e) {
				quickUnion(unions, size, 0, selected); 
				
			}
		}
	}
	
	public boolean isOpen(int row, int col) {
		return open[10 * (row - 1) + col]; 
	}
	
	public int numberOfOpenSites() {
		return openSites; 
	}
	
	
	
	public boolean percolates() {
		
		return connectedUnion(unions, 0, n * n + 1); 

		
		
		
		
	}
	public boolean connectedUnion(int[] unions, int p, int q) {
		int i = unions[p]; 
		int j = unions[q];
		
		
		
		while(i != unions[i] || j != unions[j]) {
			
			i = unions[i]; 
	
			j = unions[j]; 
		}
		
		if(i == j) return true;
		else return false; 
	}
	
	public void quickUnion(int[] unions, int[] size, int p, int q)  {
		int i = unions[p]; 
		int j = unions[q]; 
		
		
		while(i != unions[i] || j != unions[j]) {
			unions[i] = unions[unions[i]]; 
			unions[j] = unions[unions[j]]; 
			i = unions[i]; 
			j = unions[j]; 
		}
		
		if(size[i] > size[j]) {
			unions[j] = unions[i]; 
			size[j]++; 
		}
		else {
			unions[i] = unions[j]; 
			if(size[i] == size[j]) size[j]++; 
			
			size[i]++; 
		}
		
		
	}
	public static void main(String[] args) {}


}
