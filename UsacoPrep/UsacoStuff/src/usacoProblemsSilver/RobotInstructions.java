package usacoProblemsSilver;

import java.util.*;
import java.io.*;

public class RobotInstructions {
	
	static int[] solution; 
	static HashSet<Long> allPaths; 
	static int[] codes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 
				59, 61, 67, 71, 73, 79, 83, 89, 97, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157
				, 163, 167, 173}; 
	
 	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in); 
	    
	    int N = in.nextInt(); 
	    
	    int[][] instructions = new int[N][2]; 
	    
		allPaths = new HashSet<Long>();  
	    
	    solution = new int[N]; 
	    
	    int destX = in.nextInt(); 
	    int destY = in.nextInt(); 
	    
	    for(int i = 0; i < instructions.length; i++) {
	    	instructions[i][0] = in.nextInt(); 
	    	instructions[i][1] = in.nextInt(); 
	    }
	 
	    
	    in.close();
	    
	    simulate2(0, 0, 0, new HashSet<Integer>(), instructions, destX, destY, 1); 
	    
	    
	
	    for(int i = 0; i < solution.length; i++) {
	    	System.out.println(solution[i]); 
	    }
	    
	  
	    
	
	 
	}
 	
 	static void simulate2(int currX, int currY, int currStep, HashSet<Integer> used,
 			int[][] instructions, int destX, int destY, long code) {
 		
 		
 		
 		if(allPaths.contains(code)) return; 
 		else allPaths.add(code); 
 		
 		if(currX == destX && currY == destY) {
 	
 			solution[currStep - 1]++; 
 			

 		}
 		
 		if(currStep == solution.length) return; 
 		
 		
 		
 		for(int i = 0; i < solution.length; i++) {
 			if(!used.contains(i)) {
 				int moveX = instructions[i][0]; 
 				int moveY = instructions[i][1]; 
 				
 				used.add(i); 
 				
 				simulate2(currX + moveX, currY + moveY, currStep + 1, used, instructions,destX, destY, 
 						code * codes[i]); 
 				
 				used.remove(i); 
 			}
 		}
 	}
 	

 	
}
 	