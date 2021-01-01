package ctyAlgsAssignments;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private boolean[] open;
	private final int n; 
	
	private int openSites; 
	

	private final WeightedQuickUnionUF union;  
	
	public Percolation(int n) {
		this.n = n; 
		
		open = new boolean[n * n + 2]; 
		open[0] = true; 
		open[n * n + 1] = true; 
		
		openSites = 0; 

		
		union = new WeightedQuickUnionUF(n * n + 2); 
		
		
		
	
	}


	
	public void open(int row, int col)  {
		if(row <= 0 || row > n || col <= 0 || col > n ) throw (new IllegalArgumentException()); 
		int selected = n * (row - 1) + col; 
		boolean status = open[selected]; 
		
		if (!status) {
			
			open[selected] = true; 
			
			openSites++;
			
			if (open[selected + 1]) quickUnion(selected, selected + 1);
			
			if (open[selected - 1]) quickUnion(selected, selected - 1); 
			
			
			try {
				if (open[selected + n]) {
					quickUnion(selected, selected + n); 
				}
			}
			catch(IndexOutOfBoundsException e) {
				quickUnion(selected, n * n + 1); 
			}
			

		
			try {
				if (open[selected - n]) {
					quickUnion(selected, selected - n); 
				}
			}
			catch(IndexOutOfBoundsException e) {
				quickUnion(0, selected); 
				
			}
		}
	}
	
	public boolean isOpen(int row, int col) {
		return open[n * (row - 1) + col]; 
	}
	
	public boolean isFull(int row, int col) {
		return connectedUnion(0, n * (row - 1) + col); 
	}
	
	public int numberOfOpenSites() {
		return openSites; 
	}
	
	
	
	public boolean percolates() {
		
		return connectedUnion(0, n * n + 1); 
		
	}
	
	private boolean connectedUnion(int p, int q) {
		return union.find(p) == union.find(q);  
	}
	
	private void quickUnion(int p, int q)  {
		union.union(p, q);
		
	}


}
