package usacoProblemsSilver;
/**
* @author Johan
 * @version Creation time: Apr 3, 2021 3:01:31 PM
 * Class Description
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.*; 


public class multimoo {
	
	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("multimoo.in"));
	    int N = in.nextInt(); 
	    int[][] grid = new int[N][N]; 
	    boolean[][] visited = new boolean[N][N]; 
	    
	    for(int i = 0; i < N; i++) {
	    	for(int j = 0; j < N; j++) {
	    		grid[i][j] = in.nextInt(); 
	    	}
	    }
	    
	    in.close();
	    
	    ArrayList<Cell> regions = new ArrayList<Cell>(); 
	    ArrayDeque<Cell> queue = new ArrayDeque<Cell>(); 
	    
	    queue.add(new Cell(0, 0)); 
	    
	    int currDigit = grid[0][0]; 
	    
	    regions.add(new Cell(0, 0)); 
	    
	    while(!queue.isEmpty()) {
	    	Cell curr = queue.remove(); 
	   
	    	int currX = curr.x; 
	    	int currY = curr.y; 
	    	
	    	if(visited[currX][currY]) continue; 
	    	
	    	if(grid[currX][currY] != currDigit) {
	    		currDigit = grid[currX][currY]; 
	    		regions.add(new Cell(currX, currY)); 
	    	}
	    	visited[currX][currY] = true; 
	    	
	    	if(currX != 0) {
	    		if(grid[currX - 1][currY] != currDigit) queue.add(new Cell(currX - 1, currY));
	    		else queue.push(new Cell(currX - 1, currY)); 
	    	}
			if(currX != grid.length - 1) {
				if(grid[currX + 1][currY] != currDigit) queue.add(new Cell(currX + 1, currY));
				else queue.push(new Cell(currX + 1, currY));
			}
			if(currY != 0) {
				if(grid[currX][currY - 1] != currDigit) queue.add(new Cell(currX, currY - 1));
				queue.push(new Cell(currX, currY  - 1)); 
			}
			if(currY != grid.length - 1) {
				if(grid[currX][currY + 1] != currDigit) queue.add(new Cell(currX, currY + 1));
				queue.push(new Cell(currX, currY + 1)); 
			}
	    }
	    
	    visited = new boolean[N][N]; 
	    
	    int singleMax = 0; 
	    int doubleMax = 0; 
	    
	    for(int i = 0; i < regions.size(); i++) {
	    	Cell cell = regions.get(i); 
	    	visited = new boolean[N][N]; 
	    	int singleSize = findRegion(grid[cell.x][cell.y], grid, cell.x, cell.y, false, visited, -1);
	    	
	    	if(singleSize > singleMax) singleMax = singleSize; 
	    	visited = new boolean[N][N]; 
	    	
	    	int doubleSize = findRegion(grid[cell.x][cell.y], grid, cell.x, cell.y, true, visited, -1);
	    	
	    	if(doubleSize > doubleMax) doubleMax = doubleSize; 
	    }
	
	    int result = singleMax;
	    PrintWriter out = new PrintWriter(new File("multimoo.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    System.out.println(doubleMax);
	    out.println(doubleMax); 
	    out.close();
	}
	
	
	static int findRegion(int digit, int[][] grid, int startX, int startY, boolean firstflood, boolean[][] visited, int prevDigit) {
		
		ArrayDeque<Cell> queue = new ArrayDeque<Cell>(); 
		
		ArrayList<Integer> adjacent = new ArrayList<Integer>(); 
		
		int size = 0; 
		
		queue.add(new Cell(startX, startY)); 
		
		while(!queue.isEmpty()) {
			Cell curr = queue.remove(); 
			int currX = curr.x; 
			int currY = curr.y; 
			if(visited[currX][currY]) continue; 
			if(grid[currX][currY] != digit) {
				if(firstflood) {
					adjacent.add(findRegion(grid[currX][currY], grid, currX, currY, false, visited, digit));
					continue; 
				}
				else if(grid[currX][currY] != prevDigit) continue; 
			}
			
			size++; 
			
			visited[currX][currY] = true;
			
			
			if(currX != 0) queue.add(new Cell(currX - 1, currY)); 
			if(currX != grid.length - 1) queue.add(new Cell(currX + 1, currY));
			if(currY != 0) queue.add(new Cell(currX, currY  - 1)); 
			if(currY != grid.length - 1) queue.add(new Cell(currX, currY + 1)); 
			
			
		}
		Collections.sort(adjacent);
		if(firstflood) size += adjacent.get(adjacent.size() - 1); 
		return size; 
		
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


