package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: billboard
 */
import java.util.*;
import java.io.*;

public class billboard {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("billboard.in"));
	    int[][] grid = new int[20][20]; 
	    for(int i = 1; i < 4; i++) {
	    	int firstx = in.nextInt(); 
	    	int firsty = in.nextInt();
	    	int secondx = in.nextInt(); 
	    	int secondy = in.nextInt(); 
	    	
	    	for(int x = firstx; x <= secondx; x++) {
	    		for(int y = firsty; y <= secondy; y++) {
	    			
	    			grid[x + 9][y + 9] += i; 
	    			
	    		}
	    	}
	    }
	    in.close();
	
	    int result = 0;
	    
	    for(int i = 0; i < grid.length; i++) {
	    	for(int j = 0; j < grid.length; j++) {
	    		if(grid[i][j] < 4 && grid[i][j] != 2 && grid[i][j] != 0) {
	    			result++; 
	    		}
	    		System.out.print(grid[i][j] + ", "); 
	    	}
	    	System.out.println(); 
	    }
	    PrintWriter out = new PrintWriter(new File("billboard.out")); 
	
	    System.out.println(result);
	    
	    out.println(result + 1);
	    out.close();
	}
}
