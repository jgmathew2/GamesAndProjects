package usacoProblemsSilver;
import java.util.*;
import java.io.*;

public class herding {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("herding.in"));
	    
	    ArrayList<Integer> spacesBetween = new ArrayList<Integer>(); 
	    HashMap<Integer, Region> map = new HashMap<Integer, Region>(); 
	    
	    int N = in.nextInt(); 
	    

	    int[]  positions = new int[N]; 
	    
	    int previous = in.nextInt(); 
	    
	    positions[0] = in.nextInt(); 
	    
	    for(int i = 1; i < N; i++) {
	    	int next = in.nextInt(); 
	    	spacesBetween.add(next-previous - 1); 
	    	positions[i] = next; 
	    	
	    	previous = next; 
	    }
	    
	    in.close(); 
	    Arrays.sort(positions);
	    int sum = 0; 
	    
	    for(int i = 1; i < spacesBetween.size() - 1; i++)  {
	    	sum += spacesBetween.get(i); 
	    }
	    
	    int maxMoves = Math.max(sum + spacesBetween.get(0), sum + spacesBetween.size() - 1); 

	    //Finish of Calculating Max Time 
	    
	    sum += spacesBetween.get(0); 
	    sum += spacesBetween.get(spacesBetween.size() - 1); 
	    
	    previous = positions[0]; 
	    
	    for(int i = 0; i < positions.length; i++) {
	    	
	    }
	
	
	    PrintWriter out = new PrintWriter(new File("herding.out")); 
	    out.println(maxMoves); 

	
	    out.close();
	}
 	
 	static class Region {
 		int size; 
 		int spaceBehind; 
 		int spaceInFront; 
 		
 	
 	}
 	
}
