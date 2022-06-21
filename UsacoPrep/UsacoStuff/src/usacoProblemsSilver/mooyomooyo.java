package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: mooyomooyo
 */
import java.util.*;

import usacoProblemsSilver.multimoo2.Cell;

import java.io.*;

public class mooyomooyo {
	static int[][] grid; 
	static int n; 
	static int k; 
 	public static void main(String[] args) throws Exception {
	    //Scanner in = new Scanner(new File("mooyomooyo.in"));
	   // in.close();
	    
	    
	    grid = new int[][] {
	    	{1, 2, 3, 4 },
	    	{0, 3, 9, 5 },
	    	{0, 0, 4, 3 },
	    	{0, 0, 0, 0 }
	    };
	    
	    n = 4;k = 4; 
	    		
	    	
	    
	    
	    
	    for(int i = 0; i < n; i++) {
	    	for(int j = 0; j < k; j++) {
	    		System.out.print(grid[i][j] + ", ");
	    	}
	    	
	    	System.out.println(); 
	    }
	    
	
	    int result = 0;
	   // PrintWriter out = new PrintWriter(new File("mooyomooyo.out")); 
	
	    //System.out.println(result);
	    //out.println(result);
	    //out.close();
	}
 	
 	static void fill(int startX, int startY) {
 		boolean[][] visited = new boolean[n][k]; 
 		
 		int digit = grid[startX][startY]; 
 	
 		
 		Deque<Cell> queue = new ArrayDeque<Cell>(); 
 		
 		queue.add(new Cell(startX, startY)); 
 		int count; 
 		
 		while(!queue.isEmpty()) {
 			Cell curr = queue.remove(); 
 			
 			int currX = curr.x; 
 			int currY = curr.y; 
 			int currDigit; 
 			try {
 				currDigit = grid[currX][currY]; 
 			}
 			catch(Exception e) {continue;}
 			
 			if(currDigit != digit) continue; 
 			if(visited[currX][currY]) continue; 
 			
 			grid[currX][currY] = 0; 
 			visited[currX][currY] = true; 
 			
 			queue.add(new Cell(currX + 1, currY)); 
 			queue.add(new Cell(currX - 1, currY)); 
 			queue.add(new Cell(currX, currY + 1)); 
 			queue.add(new Cell(currX, currY - 1)); 
 			
 		}
 	}
 	
 	static void fall() {
 		for(int i = 0; i < k; i++) {
 			int fallDist = 0; 
 			for(int j = n - 1; j > 0; j--) {
 				if(grid[j][i] == 0) fallDist++; 
 			}
 			
 			for(int j = n - 1; j >= fallDist; j--) {
 				grid[j][i] = grid[j - fallDist][i]; 
 				
 			}
 			for(int j = fallDist - 1; j >= 0; j--) {
 				grid[j][i] = 0; 
 			}
 		}
 	}
 	static class Cell {
		int x; 
		int y; 
	
		
		Cell(int x, int y) {
			this.x = x; 
			this.y = y; 
		}
	}
 	
}
