package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: CLASS_NAME
 */
import java.util.*;
import java.io.*;

public class cowntagion {

    
    
 	public static void main(String[] args) throws Exception {
	    //Scanner in = new Scanner(System.in);
	    Scanner in = new Scanner(new File("cowntagion.in"));
	    
	    int numCows = in.nextInt(); 
	    int[] fastestRoutes = new int[numCows + 1]; 
	    
	    for(int i = 2; i < fastestRoutes.length; i++) {
	    	fastestRoutes[i] = -1; 
	    }
;	    
	    int[][] bridges = new int[numCows][2];
	    

	    
	    for(int i = 0; i < bridges.length - 1; i++) {
	    	bridges[i][0] = in.nextInt(); 
	    	bridges[i][1] = in.nextInt(); 
	    	Arrays.sort(bridges[i]);
	    }
	    
	    int time = 0; 
	    int k = 0; 
	    
	    while(Math.pow(2, k) < numCows) k++; 
	    time = k; 
	    
	    
	    //Arrays.sort(bridges);
	    
	    
	    System.out.println(Arrays.toString(bridges)); 
	    
	    /*
	    int[] unions = new int[numCows]; 
	    

	    
	    
	    for(int i = 0; i < distance.length; i++) {
	    	if(distance[i] != 1) distance[i] = Integer.MAX_VALUE; 
	    	
	    	unions[i] = i; 
	    }
	    
	    distance[0] = 0; 
	    
	    */
	    
	    
	    
	    
	}
 	/*
	static void quickUnion(int[] unions, int p, int q)  {
		if(distance[p] > distance[q]) {
 			int away = distance[q] + 1; 
 			
 			int i = unions[p]; 
 			int previous = p; 
 			
 			unions[p] = q; 
 			distance[p] = away; 
 			
 			while(away < distance[i] && i != unions[i]) {
 				away++; 
 				int j = i; 
 				i = unions[j];
 				unions[j] = previous; 
 				distance[j] = away; 
 				previous = j;	
 				
 			}
 		}
		else if(distance[p] < distance[q]) {
 			int away = distance[p] + 1; 
 			
 			int i = unions[q]; 
 			int previous = q; 
 			
 			unions[q] = p; 
 			distance[q] = away; 
 			
 			while(away < distance[i] && i != unions[i]) {
 				away++; 
 				int j = i; 
 				i = unions[j];
 				unions[j] = previous; 
 				distance[j] = away; 
 				previous = j;	
 				
 			}
 		}
		else {
			//TODO: Figure out how to get the bridge that q connected to to still be connected to q. 
			unions[q] = unions[p]; 
		}
		/*
		int i = unions[p]; 
		int j = unions[q]; 
		
		
		while(i != unions[i] || j != unions[j]) {
			unions[i] = unions[unions[i]]; 
			unions[j] = unions[unions[j]]; 
			i = unions[i]; 
			j = unions[j]; 
		}	

	}
*/
}

