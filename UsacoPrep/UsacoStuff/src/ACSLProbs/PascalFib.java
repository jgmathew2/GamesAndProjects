package ACSLProbs;
import java.util.*; 

public class PascalFib {
	public static void main(String[] args) {
		System.out.println(countUniqueNumbers(8));
	}
	
	static int countUniqueNumbers(int fib) {
		int numRows = numFib(fib); 
		
		ArrayList<ArrayList<Integer>> pascal = generate(numRows); 
		
		
		HashSet<Integer> uniques = new HashSet<Integer>();
		HashSet<Integer> seen = new HashSet<Integer>(); 
		
		int row = numRows; 
		int column = 0; 
		
		while(numRows > 2) {
			
		
			while(true) {
				try {
					int current = pascal.get(row).get(column); 
					
					if(seen.contains(current)) {
						if(uniques.contains(current)) uniques.remove(current); 
					}
					else {
						uniques.add(current); 
						seen.add(current); 
					}
				}
				
				catch(Exception e) {
					break; 
				}
				
				row--; 
				column++; 
				
			}
			
			numRows--; 
			row = numRows; 
			column = 0; 
			
		
		
		}
		return uniques.size(); 
		
		
	}
	
	static ArrayList<ArrayList<Integer>> generate(int rows) {
		ArrayList<ArrayList<Integer>> pascal = new ArrayList<ArrayList<Integer>>(); 
		
		int currRows = 2; 
		
		ArrayList<Integer> row1 = new ArrayList<Integer>(); 
		row1.add(1); 
		
		pascal.add(row1); 
		
		ArrayList<Integer> row2 = new ArrayList<Integer>(); 
		
		row2.add(1); 
		row2.add(1); 
		pascal.add(row2); 
		
		while(currRows < rows + 1) {
			ArrayList<Integer> row = new ArrayList<Integer>(); 
			
			row.add(1); 
			
			ArrayList<Integer> previous = pascal.get(currRows - 1); 
			
			for(int i = 0; i + 1 < previous.size(); i++) {
				row.add(previous.get(i) + previous.get(i + 1)); 
			}
			
			row.add(1); 
			
			currRows++; 
			pascal.add(row); 
			
		
		}
		
		return pascal; 
	}
	
	
	
	
	
	
	static int numFib(int input) {
		int prev1 = 1; 
		int prev2 = 1; 
		int next = 2; 
		int current = 2; 
		while(input != next) { 
			current++; 
			int temp = prev2; 
			prev2 = next;
			prev1 = temp; 
			next = prev1 + prev2; 
		}
		
		return current; 
	}

}
