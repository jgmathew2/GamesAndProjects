package usacoProblemsSilver; 

/*
ID:johangma
LANG: JAVA
TASK: perimeter
 */
import java.util.*;
import java.io.*;

//completed 
public class perimeter {
	static boolean[][] beenTo; 
	static char[][] grid; 
	static int N;
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("perimeter.in"));
	    N = in.nextInt(); 
	    
	    
	    
	    in.nextLine(); 
	    
	    grid = new char[N + 2][N + 2]; 
	    
	    beenTo = new boolean[N + 2][N + 2]; 
	    
	    for(int i = 0; i < grid.length; i++) {
	    	char[] gridRow = new char[N]; 
	    	if(i != 0) {
		    	try {
		    	gridRow = in.nextLine().toCharArray(); 
		    	}
		    	catch(Exception e) {}
		    }
	    	for(int j = 0; j < grid.length; j++) {
	    		if(i == 0 || j == 0 || i == N + 1 || j == N + 1) {
	    			grid[i][j] = '.';
	    		}
	    		else grid[i][j] = gridRow[j - 1]; 
	
	    	}
	    }
	    int area = 0; 
	    int perimeter = 0; 
	    
	    char[][] hello = grid; 
	    
	    for(int i = 0; i < grid.length; i++) {
	    	for(int j = 0; j < grid.length; j++) {
	    		if(beenTo[i][j]) continue; 
	    		Blob blob = findStats(i, j); 
	    		
	    		if(blob.area > area) {
	    			area = blob.area; 
	    			perimeter = blob.perimeter; 
	    		}
	    		
	    		else if(blob.area == area) {
	    			perimeter = Math.min(perimeter, blob.perimeter); 
	    		}
	    		
	    		boolean[][] placeholder = beenTo; 
	    		
	    		int idk = 0; 
	    	}
	    }
	    in.close(); 
	    
	   
	
	    
	    PrintWriter out = new PrintWriter(new File("perimeter.out")); 
	
	    System.out.println(area);
	    System.out.println(perimeter);
	    out.print(area + " ");
	    out.print(perimeter);
	    out.close();
	}
 	
 	static Blob findStats(int startR, int startC) {
 		if(grid[startR][startC] == '.') return new Blob(0, 0); 
 		
 		int area = 0; 
 		int perimeter = 0; 
 		
 		Deque<Cell> queue = new ArrayDeque<Cell>(); 
 		
 		queue.add(new Cell(startR, startC)); 
 		
 		while(!queue.isEmpty()) {
 			Cell cell = queue.remove(); 
 			
 			int r = cell.r; 
 			int c = cell.c; 
 			
 		
 			
 			
 			if(grid[r][c] == '.') {
 				perimeter++; 
 				continue; 
 			}
 			
 			if(beenTo[r][c]) continue; 
 			
 			beenTo[r][c] = true; 
 			area++; 
 			
 			queue.add(new Cell(r + 1, c)); 
 			queue.add(new Cell(r - 1, c)); 
 			queue.add(new Cell(r, c + 1)); 
 			queue.add(new Cell(r, c - 1)); 
 			/*
 			queue.add(new Cell(r + 1, c + 1)); 
 			queue.add(new Cell(r + 1, c - 1)); 
 			queue.add(new Cell(r - 1, c + 1)); 
 			queue.add(new Cell(r - 1, c - 1)); 
 			
 			*/
 			
 		}
 		
 		//beenTo = new boolean[N + 2][N + 2]; 
 		
 		return new Blob(area, perimeter); 
 	}
 	
 	static class Blob {
 		int perimeter; 
 		int area; 
 		
 		Blob(int a, int p) {
 			perimeter = p; 
 			area = a; 
 		}
 	}
 	
 	static class Cell {
 		int r; 
 		int c; 
 		
 		Cell(int r, int c) {
 			this.r = r; 
 			this.c = c; 
 		}
 	}
}
