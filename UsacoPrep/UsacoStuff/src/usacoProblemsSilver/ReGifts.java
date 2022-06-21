package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: ReGifts
 */
import java.util.*;
import java.io.*;

public class ReGifts {
	static int[] bestPossible;
	static int N; 
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(System.in);
	    
	   N = in.nextInt(); 
	    
	   
	   int x = N; 
	   bestPossible = new int[N]; 
	    
	    HashSet<Integer> used = new HashSet<Integer>(); 
	    HashSet<Integer> completed = new HashSet<Integer>(); 
	    
	    
	    int[][] favorites = new int[N][N]; 
	    

	    
	    for(int i = 0 ; i < N; i++) {
	    	
	    	bestPossible[i] = i; 
	    	for(int j = 0; j < N; j++) {
	    		int current = in.nextInt() - 1; 
	    		favorites[i][current] = j; 
	    		
	    		if(j == 0 && current == i) {
	    			used.add(current); 
	    			completed.add(i); 
	    		
	    		}
	    	}
	    }
	    
	    in.close();
	    
	    ArrayList<Integer> order = new ArrayList<Integer>(); 
	    
	    for(int i = 0; i < bestPossible.length; i++) {
	    	order.add(bestPossible[i]); 
	    }
	    
	    simulate(favorites, used, completed, order, 0); 
	    
	    for(int i = 0; i < bestPossible.length; i++) {
	    	System.out.println(bestPossible[i] + 1); 
	    }
	    

	



	}
 	
 	static void simulate(int[][] favorites, 
 				HashSet<Integer> used, HashSet<Integer> completed, 
 				ArrayList<Integer> order, int currIndex) {
 		
 		if(used.size() == N) {
 			for(int i = 0; i < order.size(); i++) {
 				int currGift = order.get(i); 
 				
 				if(favorites[i][currGift] < favorites[i][bestPossible[i]]) {
 					bestPossible[i] = currGift; 
 				}
 				
 				if(favorites[i][currGift] == 0) {
 					completed.add(i); 
 				}
 			}
 			
 			return; 
 		}
 		
 		if(completed.contains(currIndex)) {
 			order.set(currIndex, bestPossible[currIndex]); 
 			
 			used.add(bestPossible[currIndex]); 
 			simulate(favorites, used, completed, order, currIndex + 1); 
 		}
 		for(int i = 0; i < N; i++) {
 			if(used.contains(i)) continue; 
 			
 			if(favorites[currIndex][i] > favorites[currIndex][bestPossible[currIndex]]) continue; 
 			
 			used.add(i); 
 			order.set(currIndex, i); 
 			
 			simulate(favorites, used, completed, order, currIndex + 1); 
 			
 			used.remove(i); 
 			
 		}
 		
 		
 	}
 	

 	
 	
}
