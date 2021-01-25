package usacoProblemsSilver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class DanceMooves {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    //Scanner in = new Scanner(new File("dancemooves.in"));
	    
	    Cow[] cows = new Cow[in.nextInt()]; 
	    
	    for(int i = 0; i < cows.length; i++) {
	    	cows[i] = new Cow(i); 
	    	cows[i].visited.add(i); 
	    }
	    
	    int K = in.nextInt(); 
	    
	    int[][] swaps = new int[K][2];
	    
	    for(int i = 0; i < K; i++) {
	    	swaps[i][0] = in.nextInt() - 1; 
	    	swaps[i][1] = in.nextInt() - 1; 
	    }
	    
	
	    for(int j = 0; j < K/2 + 1; j++) {
		    for(int i = 0; i < K; i++) {
		    	int cow1 = swaps[i][0]; 
		    	int cow2 = swaps[i][1]; 
		    	
		    	cows[cow1].visited.add(cow2); 
		    	cows[cow2].visited.add(cow1); 
		    	
		    	swap(cows, cow1, cow2); 
		    }
	    }
	    
	    in.close(); 
	    
	    Arrays.sort(cows);
	    
	    for(int i = 0; i < cows.length; i++) {
	    	System.out.println(cows[i].visited.size()); 
	    }
	    
	    
	    
	    
	}
	
	static class Cow implements Comparable<Cow> {
		int index; 
		HashSet<Integer> visited = new HashSet<Integer>(); 
		
		Cow(int index) {
			this.index = index; 
		}

		public int compareTo(Cow cow) {
			return this.index - cow.index; 
			
		}
	}
	
	static void swap(Cow[] array, int i, int j) {
		Cow cow = array[i]; 
		
		array[i] = array[j]; 
		
		array[j] = cow; 
	}

}
