package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: hopscotch
 */
import java.util.*;
import java.io.*;

public class hopscotch {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("hopscotch.in"));
	    char[][] grid = new char[in.nextInt()][in.nextInt()]; 
	    in.nextLine(); 
	    for(int i = 0; i < grid.length; i++) {
	    	grid[i] = in.nextLine().toCharArray(); 
	    }
	    in.close();
	    
	    ArrayDeque<HopscotchSquare> queue = new ArrayDeque<HopscotchSquare>();
	    
	    queue.add(new HopscotchSquare(0, 0, grid[0][0]));
	    
	    int paths = 0; 
	    
	    while(queue.isEmpty() == false) {
	    	HopscotchSquare square = queue.pop();
	    	
	    	int possibleR = square.r + 1; 
	    	int possibleC = square.c + 1; 
	    	
	    	for(int i = possibleR; i < grid.length; i++) {
	    		for(int j = possibleC; j < grid[i].length; j++) {
	    			if(grid[i][j] != square.color) {
	    				if(i == grid.length - 1 && j == grid.length - 1) paths++; 
	    				else queue.add(new HopscotchSquare(i, j, grid[i][j])); 
	    			}
	    		}
	    	}
	    }
	    
	    
	    
	    
	
	    int result = paths;
	    PrintWriter out = new PrintWriter(new File("hopscotch.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}

class HopscotchSquare {
	char color; 
	int r; 
	int c; 
	
	HopscotchSquare(int r, int c, char color) {
		this.r = r;
		this.c = c; 
		this.color = color; 
	}
}
