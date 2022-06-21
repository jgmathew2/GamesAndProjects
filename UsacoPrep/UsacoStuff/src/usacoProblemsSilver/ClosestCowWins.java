package usacoProblemsSilver;

import java.util.*; 
import java.io.*; 
public class ClosestCowWins {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		
		ArrayList<Integer> locations = new ArrayList<Integer>(); 
		
		
		
		int K = in.nextInt(); 
		int nhoj = in.nextInt(); 
		int cows = in.nextInt(); 
		
		int[][] patches = new int[K][2]; 
		int[] enemies = new int[nhoj]; 
		
		for(int i = 0 ;i < K; i++) {
			patches[i][0] = in.nextInt(); 
			patches[i][1] = in.nextInt(); 
		}
		
		for(int i = 0; i < nhoj; i++) {
			enemies[i] = in.nextInt(); 
		}
		
		
		int lastEnemy = Integer.MIN_VALUE; 
		int nextEnemy = enemies[0]; 
		int currSum = 0; 
		for(int i = 0; i < patches.length; i++) {
			
		}
		
	
		
		
		Collections.sort(locations);
		
		int sum = 0; 
		int used = 0; 
		while(cows > 0) {
			sum += locations.get(locations.size() - 1 - used); 
			used++; 
			cows--; 
		}
		
		
		
		
		int result = sum; 
		System.out.println(result); 
	}
	
	static int findBest(int lastE, int nextE, int[][] patches) {
		return 0; 
	}
	
	
	
	
	
	
	

}
