package usacoProblemsSilver;

import java.util.Scanner;

public class stuckrut2 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		 //Scanner in = new Scanner(new File("stuckrut.in"));
		 
		RutCow2[] cows = new RutCow2[in.nextInt()];
		 
		int[] eaten = new int[cows.length]; 
		 
		in.nextLine(); 
		 
		for(int i = 0; i < cows.length; i++) {
			cows[i] = new RutCow2(); 
			String[] values = in.nextLine().split(" "); 
			 
			cows[i].dir = values[0].charAt(0); 
			 
			cows[i].x = Integer.parseInt(values[1]); 
			 
			cows[i].y = Integer.parseInt(values[2]); 
		}
		in.close(); 
		
	}

}
class RutCow2 implements Comparable<RutCow>{
	char dir; 
	int x; 
	int y;
	
	public int compareTo(RutCow cow) {
		if(cow.dir != this.dir) {
			if(cow.dir == 'N') return 1; 
			else return -1; 
		}
		else if(cow.dir == 'N') {
			if(cow.x > this.x) return -1; 
			else if(cow.x < this.x) return 1; 
			else return 0; 
		}
		else {
			if(cow.y > this.y) return -1; 
			else if(cow.y < this.y) return 1; 
			else return 0; 
		}
	}
}

