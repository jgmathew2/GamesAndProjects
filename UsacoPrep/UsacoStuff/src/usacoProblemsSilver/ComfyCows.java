package usacoProblemsSilver;
/**
* @author Johan
 * @version Creation time: Feb 28, 2021 1:35:11 PM
 * Class Description
*/

import java.io.File;
import java.util.*;

public class ComfyCows {
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("comfycows.in"));
		int N = in.nextInt();
		
		Cow[][] grid = new Cow[1002][1002];
		ArrayList<Cow> cows = new ArrayList<Cow>(); 
		for(int i = 0; i < N; i++) {
			int cowX = in.nextInt() + 1; 
			int cowY = in.nextInt() + 1; 
			cows.add(new Cow(cowX, cowY)); 
			
			grid[cowX][cowY] = new Cow(cowX, cowY); 
			
			ArrayList<Cow> deleteList = new ArrayList<Cow>(); 
			
			Deque<Cow> queue = new ArrayDeque<Cow>(cows); 
			
			//queue.add(cows.get(0)); 
			
			boolean[][] beenTo = new boolean[grid.length][grid.length]; 
			
			while(!queue.isEmpty()) {
				Cow cow = queue.remove(); 
				
				if(beenTo[cow.x][cow.y]) continue;
				else beenTo[cow.x][cow.y] = true; 
				
				if(comfy(cow, grid) == false) {
					continue; 
					/*
					if(grid[cow.x + 1][cow.y] != null && beenTo[cow.x + 1][cow.y] == false)   queue.add(grid[cow.x + 1][cow.y]); 
					if(grid[cow.x - 1][cow.y] != null && beenTo[cow.x - 1][cow.y] == false)  queue.add(grid[cow.x - 1][cow.y]); 
					if(grid[cow.x][cow.y + 1] != null && beenTo[cow.x][cow.y + 1] == false)  queue.add(grid[cow.x][cow.y + 1]); 
					if(grid[cow.x][cow.y - 1] != null && beenTo[cow.x][cow.y - 1] == false)  queue.add(grid[cow.x][cow.y - 1]);
					*/ 
					
				}
				else {
					if(grid[cow.x + 1][cow.y] != null); 
					else {
						deleteList.add(new Cow(cow.x + 1, cow.y)); 
						grid[cow.x + 1][cow.y] = new Cow(cow.x + 1, cow.y); 
						queue.add(new Cow(cow.x + 1, cow.y)); 
					}
					if(grid[cow.x - 1][cow.y] != null); 
					else {
						deleteList.add(new Cow(cow.x - 1, cow.y)); 
						grid[cow.x - 1][cow.y] = new Cow(cow.x - 1, cow.y); 
						queue.add(new Cow(cow.x - 1, cow.y)); 
					}
					if(grid[cow.x][cow.y + 1] != null); 
					else {
						deleteList.add(new Cow(cow.x, cow.y + 1)); 
						grid[cow.x][cow.y + 1] = new Cow(cow.x - 1, cow.y + 1); 
						queue.add(new Cow(cow.x , cow.y + 1)); 
					}
					if(grid[cow.x][cow.y - 1] != null); 
					else {
						deleteList.add(new Cow(cow.x, cow.y - 1)); 
						grid[cow.x][cow.y - 1] = new Cow(cow.x - 1, cow.y - 1); 
						queue.add(new Cow(cow.x , cow.y - 1)); 
					}
				}
				
			}
			System.out.println(deleteList.size()); 
			
			for(int j = 0; j < deleteList.size(); j++) {
				grid[deleteList.get(j).x][deleteList.get(j).y] = null; 
			}
			
			deleteList = null; 
			
		}
		in.close(); 
		
		
		
	}
	
	static class Cow {
		int x; 
		int y; 
		
		Cow(int x, int y) {
			this.x = x; 
			this.y = y; 
		}
	}
	
	static boolean comfy(Cow cow, Cow[][] grid) {
		int adj = 0; 
		if(cow.x + 1 < grid.length && grid[cow.x + 1][cow.y] != null)  adj++; 
		if(cow.x - 1 >= 0 && grid[cow.x - 1][cow.y] != null)  adj++; 
		if(cow.y + 1 < grid.length &&grid[cow.x][cow.y + 1] != null)  adj++; 
		if(cow.y - 1 >= 0 &&grid[cow.x][cow.y - 1] != null)  adj++; 
		
		if(adj == 3) return true;
		else return false; 
	}

}
