package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: cowdance
 */
import java.util.*;
import java.io.*;

public class cowdance {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("cowdance.in"));
	    int[] routines = new int[in.nextInt()]; 
	    
	    int maxTime = in.nextInt(); 
	    
	    for(int i = 0; i < routines.length; i++) {
	    	routines[i] = in.nextInt(); 
	    }
	    in.close();
	
	    int result = 0;
	    PrintWriter out = new PrintWriter(new File("cowdance.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	private static boolean inTime(int[] routines, int maxTime, int k) {
 		int time; 
 		int[] stage = new int[k]; 
 		
 		for(int i = 0; i < k; i++) {
 			stage[i] = routines[i]; 
 		}
 		
 		for(int i = k; i < routines.length; i++) {
 			int index = findSmallest(stage); 
 		}
 		
 		return true; 

 		
 	}
 	
 	private static int findSmallest(int[] array) {
 		int smallest = array[0];
 		int index = 0; 
 		
 		for(int i = 1; i < array.length; i++) {
 			if(array[i] < smallest) {
 				index = i; 
 				smallest = array[i]; 
 			}
 		}
 		
 		return index; 
 	}
 	
}
