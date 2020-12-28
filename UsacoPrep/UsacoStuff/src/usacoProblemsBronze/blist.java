package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: blist
 */
import java.util.*;
import java.io.*;

public class blist {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("blist.in"));
	    int[][] cows = new int[1000][2]; 
	    int numCows = in.nextInt(); 
	    int highestBucket = 0; 
	    int numBuckets = 0; 
	    
	    for(int i = 0; i < numCows; i++) {
	    	int start = in.nextInt(); 
	    	cows[start][0] = in.nextInt(); 
	    	int buckets = in.nextInt(); 
	    	numBuckets+= buckets; 
	    	cows[start][1] = buckets; 
	    }
	    
	    int[] buckets = new int[numBuckets]; 
	    in.close();
	    int counter = 0; 
		int i = 0; 
	    while(counter < numCows) {
	    	while(cows[i][0] == 0) {
	    
	    		for(int j = 0; j < numBuckets; j++) {
	    			if(i == buckets[j]) buckets[j] = 0; 
	    		}
	    		i++; 
	    	}
	    	
	    	counter++; 
	    	int[] currCow = cows[i]; 
	    	int neededBuckets = currCow[1]; 
	    	
	    	for(int k = 0; k < neededBuckets; k++) {
	    		int a = k; 
	    		while(buckets[a] != 0) a++; 
	    		if(a >= highestBucket ) highestBucket = a; 
	    		buckets[a] = currCow[0]; 
	    	}
	    	
	    	i++; 
	    	
	    }
	
	    int result = highestBucket;
	    PrintWriter out = new PrintWriter(new File("blist.out")); 
	
	    System.out.println(result + 1);
	    out.println(result + 1);
	    out.close();
	}
}