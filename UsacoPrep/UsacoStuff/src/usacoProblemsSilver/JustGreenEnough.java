package usacoProblemsSilver;
/**
* @author Johan
 * @version Creation time: Feb 28, 2021 4:48:39 PM
 * Class Description
*/

import java.io.File;
import java.util.*; 


public class JustGreenEnough {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in); 
		//Scanner in = new Scanner(new File("justgreen.in")); 
		
		int N = in.nextInt(); 
		
		int[][] greeness = new int[N][N]; 
		
		int photos = 0; 
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				greeness[i][j] = in.nextInt(); 
				
			}
		}
		
	
		for(int i = 0; i < greeness.length; i++) {
			for(int j = i; j < greeness.length; j++) {
				inner: for(int k = 0; k < greeness.length; k++) {
					for(int l = k; l < greeness.length; l++) {
						int value = works(i, j, k, l, greeness);
						if(value == 1) photos++; 
						else if(value == -1) {
							continue inner; 
						}
					}
				}
			}
		}
		
		System.out.println(photos); 
		
		
	}
	
	static int works(int x1, int x2, int y1, int y2, int[][] grid) {
		
		boolean hundredthing = false; 
		for(int i = x1; i <= x2; i++) {
			for(int j = y1; j <= y2; j++) {
				if(grid[i][j] < 100) return -1; 
				
				if(grid[i][j] == 100) hundredthing = true; 
			}
		}
		
		if(hundredthing) return 1; 
		else return 0; 
		
	}
	

}
