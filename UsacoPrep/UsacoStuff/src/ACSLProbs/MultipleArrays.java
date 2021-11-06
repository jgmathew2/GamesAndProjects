package ACSLProbs;
/**
* @author Johan
 * @version Creation time: Mar 14, 2021 11:39:08 AM
 * Class Description
*/

import java.util.*; 
public class MultipleArrays {
	
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>(); 
		
		array.add("6 2 7 4 6 1 5 7 5 6 7 8"); 
		array.add("4 8 6 4 4 5 7 2 7 6 5 4"); 
		array.add("3 6 9 2 4 8 2 6 3 2 1 4"); 
		array.add("4 3 5 7 6 8 9 1 2 4 3 5");
		
		String string = "3 4"; 
		
		System.out.println(sumOfMinAlongPath(string, array)); 
	}
	

	    /*
	     * Complete the 'sumOfMinAlongPath' function below.
	     *
	     * The function is expected to return an INTEGER.
	     * The function accepts following parameters:
	     *  1. STRING dim
	     *  2. STRING_ARRAY arrays
	     */

    public static int sumOfMinAlongPath(String dim, List<String> arrays) {
        int sum = 0; 
        String[] coordStrings = dim.split(" "); 
        
 
        
        int xConstr = Integer.parseInt(coordStrings[0]); 
        int yConstr = Integer.parseInt(coordStrings[1]); 
        
        int[][][] grid = new int[xConstr][yConstr][arrays.size()]; 
        
        for(int i = 0; i < arrays.size(); i++) {
            String[] array = arrays.get(i).split(" "); 
            for(int a = 0; a < xConstr; a++) {
                for(int b = 0; b < yConstr; b++) {
                
                    grid[a][b][i] = Integer.parseInt(array[(a * yConstr) + b]);
                }
            }
        }
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        ArrayList<GridSpot> path = new ArrayList<GridSpot>(); 
        
        path.add(new GridSpot(0, 0, 0)); 
        
        int currX = 0; 
        int currY = 0; 
        
        while(visited[currX][currY] == false) {
            ArrayList<GridSpot> adjacent = new ArrayList<GridSpot>(); 
            
            if(currX - 1 >= 0 && currY - 1 >= 0) {
                for(int i = 0; i < grid[0][0].length; i++) {
                    adjacent.add(new GridSpot(currX - 1, currY - 1, grid[currX - 1][currY - 1][i])); 
                }
            }
            if(currX - 1 >= 0 && currY + 1 < grid[0].length) {
                for(int i = 0; i < grid[0][0].length; i++) {
                    adjacent.add(new GridSpot(currX - 1, currY + 1, grid[currX - 1][currY + 1][i])); 
                }
            }
            if(currX - 1 >= 0) {
                for(int i = 0; i < grid[0][0].length; i++) {
                    adjacent.add(new GridSpot(currX - 1, currY, grid[currX - 1][currY][i])); 
                }
            }
            if(currY - 1 >= 0) {
                for(int i = 0; i < grid[0][0].length; i++) {
                    adjacent.add(new GridSpot(currX, currY - 1, grid[currX][currY - 1][i])); 
                }
            }
            if(currY + 1 < grid[0].length) {
                for(int i = 0; i < grid[0][0].length; i++) {
                    adjacent.add(new GridSpot(currX, currY + 1, grid[currX][currY + 1][i])); 
                }
            }
            if(currX + 1 < grid.length) {
                for(int i = 0; i < grid[0][0].length; i++) {
                    adjacent.add(new GridSpot(currX + 1, currY, grid[currX + 1][currY][i])); 
                }
            }
            
            if(currX + 1 < grid.length && currY + 1 < grid[0].length) {
                for(int i = 0; i < grid[0][0].length; i++) {
                    adjacent.add(new GridSpot(currX + 1, currY + 1, grid[currX + 1][currY + 1][i])); 
                }
            }
            if(currX + 1 < grid.length && currY - 1 >= 0) {
                for(int i = 0; i < grid[0][0].length; i++) {
                    adjacent.add(new GridSpot(currX + 1, currY - 1, grid[currX + 1][currY - 1][i])); 
                }
            }
            
            GridSpot next = findBigUnique(adjacent); 
            
            visited[currX][currY] = true; 
            
            path.add(next); 
            
            currX = next.x; 
            currY = next.y; 
            
        }
        path.remove(path.size() - 1); 
        for(int i = 0; i < path.size(); i++) {
            sum += findSmallest(grid, path.get(i).x, path.get(i).y); 
        }
        
        return sum; 
    }
    
    static GridSpot findBigUnique(ArrayList<GridSpot> array) {
        for(int i = 0; i < array.size() - 1; i++) {
           	int placeholder = array.get(i).value;
           	boolean copy = false;
            for(int j = i + 1; j < array.size(); j++) {
            	 
                if(array.get(j).value == placeholder) {
                    copy = true; 
                    array.remove(j);
                    j--; 
                }
            }
            if(copy) {
            	array.remove(i);
            	i--; 
            }
        }
        int biggest = Integer.MIN_VALUE; 
        GridSpot biggestGridSpot = array.get(0); 
        for(int i = 0; i < array.size(); i++) {
            if(array.get(i).value > biggest) {
                biggest = array.get(i).value; 
                biggestGridSpot = array.get(i); 
            }
                
        }
        
        return biggestGridSpot; 
    }
    
    static int findSmallest(int[][][] array, int x, int y) {
        int smallest = Integer.MAX_VALUE; 
        for(int i = 0; i < array[x][y].length; i++) {
            if(array[x][y][i] < smallest) smallest = array[x][y][i]; 
        }
        
        return smallest; 
    }
    
    static class GridSpot {
        int x; 
        int y; 
        int value; 
        
        GridSpot(int x, int y, int value) {
            this.x = x; 
            this.y = y; 
            this.value = value; 
        }
    }

	

}
