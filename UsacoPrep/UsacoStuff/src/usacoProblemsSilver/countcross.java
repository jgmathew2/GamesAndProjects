package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: countcross
 */
import java.util.*;
import java.io.*;

public class countcross {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("countcross.in"));
		
		//Scanner in = new Scanner(System.in); 
		
		int N = in.nextInt(); 
		int K = in.nextInt(); 
		int R = in.nextInt(); 
		
		ArrayList<Integer> groups = new ArrayList<Integer>();  
		
		for(int i = 0; i < 10000; i++) {groups.add(1);}
		
		int[][] field = new int[2 * N - 1][2 * N - 1]; 
		
		for(int i = 0; i < R; i++) {
			int x1 = (in.nextInt() - 1) * 2; 
			int y1 = (in.nextInt() - 1) * 2;
			int x2 = (in.nextInt()- 1) * 2; ; 
			int y2 = (in.nextInt() - 1) * 2; 
			
			field[(x1 + x2) / 2][(y1 + y2) / 2] = 1; 
		}
		
		Cow[] cows = new Cow[K]; 
		
		for(int i = 0; i < K; i++) {
			int xcoord = (in.nextInt() -1) * 2; 
			int ycoord = (in.nextInt() - 1) * 2; 
			
			cows[i] = new Cow(xcoord, ycoord); 
			
			field[xcoord][ycoord] = 2; 
		}
		
		
		Deque<Grid> queue = new ArrayDeque<Grid>(); 
		
		HashSet<Grid> beenTo = new HashSet<Grid>(); 
		int numConnected = 1; 
		
		queue.add(new Grid(cows[0].x, cows[0].y)); 
		
		HashSet<Cow> visitedCows = new HashSet<Cow>(); 
		int currgroup = 0; 
		
		while(numConnected < K) {
			if(queue.isEmpty()) {
				INNER: for(int i = 0; i < K; i++) {
					if(!visitedCows.contains(cows[i]))  {
						queue.add(new Grid(cows[i].x, cows[i].y)); 
						break INNER; 
					}
				}
				currgroup++; 
				
				continue; 
				
			}
			Grid curr = queue.remove(); 
			
			if(beenTo.contains(curr)) continue; 
			
			beenTo.add(curr); 
			
			int x = curr.x; 
			int y = curr.y; 
			
			if(x >= field.length || y >= field.length || x < 0 || y < 0) continue; 
			
			if(field[x][y] == 1) continue; 
			else if(field[x][y] == 2) {
				visitedCows.add(new Cow(x, y)); 
				int a =groups.get(currgroup); 
				
				groups.set(currgroup, a + 1);
				numConnected++; 
			}
			
			queue.add(new Grid(x + 1, y)); 
			queue.add(new Grid(x - 1, y)); 
			queue.add(new Grid(x, y + 1)); 
			queue.add(new Grid(x, y - 1)); 
			
			
			
		}
		
		
		
		in.close();
		


		int result = 0;
		int usedCows = 0; 
		for(int i = 0; i < groups.size(); i++) {
			if(groups.get(i) == 0) break; 
			usedCows += groups.get(i);
			if(usedCows > K) break; 
			result += groups.get(i) * (K - usedCows); 
		}
		
		PrintWriter out = new PrintWriter(new File("countcross.out"));

		System.out.println(result);
		out.println(result);
		out.close();
	}
	
	static class Cow {
		int x, y; 
		
		Cow(int x, int y) {
			this.x = x; 
			this.y = y; 
		}
		
		public boolean equals(Object o) {
			if(o instanceof Cow) {
				Cow other = (Cow) o; 
				
				if(this.x == other.x && this.y == other.y) return true; 
				else return false; 
			}
			else return false; 
		}
		
		public int hashCode() {
			return 89 * x + 97 & y; 
		}
	}
	
	static class Grid {
		int x; 
		int y; 
		Grid(int x, int y) {
			this.x = x; 
			this.y = y; 
		}
		
		public boolean equals(Object o) {
			if(o instanceof Grid) {
				Grid other = (Grid) o; 
				
				if(this.x == other.x && this.y == other.y) return true; 
				else return false; 
			}
			else return false; 
		}
		
		public int hashCode() {
			return 89 * x + 97 & y; 
		}
	}
}
