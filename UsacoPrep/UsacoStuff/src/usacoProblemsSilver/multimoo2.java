package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: multimoo
 */
import java.util.*;
import java.io.*;

public class multimoo2 {
	static boolean[][] visited; 
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("multimoo.in"));
	    int n = in.nextInt(); 
	    
	    int[][] grid = new int[n][n]; 
	    visited = new boolean[n][n]; 
	    
	    for(int i = 0; i < n; i++) {
	    	for(int j = 0; j < n; j++) {
	    		grid[i][j] = in.nextInt(); 
	    	}
	    }
	    in.close();
	    
	    ArrayList<Integer> regions = new ArrayList<Integer>(); 
	    
	    for(int i = 0; i < n; i++) {
	    	for(int j = 0; j < n; j++) {
	    		if(!visited[i][j]) regions.add(findRegion(grid, i, j)); 
	    	}
	    }
	    
	    Collections.sort(regions);
	    
	
	    int result = regions.get(regions.size() - 1);
	    PrintWriter out = new PrintWriter(new File("multimoo.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static int findRegion(int[][] grid, int startX, int startY) {
 		int digit = grid[startX][startY]; 
 		int count = 0; 
 		
 		Deque<Cell> queue = new ArrayDeque<Cell>(); 
 		
 		queue.add(new Cell(startX, startY)); 
 		
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
 			
 			count++; 
 			visited[currX][currY] = true; 
 			
 			queue.add(new Cell(currX + 1, currY)); 
 			queue.add(new Cell(currX - 1, currY)); 
 			queue.add(new Cell(currX, currY + 1)); 
 			queue.add(new Cell(currX, currY - 1)); 
 			
 		}
 		
 		return count; 
 		
 	
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
