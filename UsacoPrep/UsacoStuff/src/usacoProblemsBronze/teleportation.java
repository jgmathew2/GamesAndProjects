package usacoProblemsBronze;

import java.io.File;
import java.io.PrintWriter;
import java.util.*; 

/**
* @author Johan
 * @version Creation time: Feb 28, 2021 9:19:35 AM
 * Class Description
*/

public class teleportation {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("teleportation.in"));
	    
	    int totalDist = 0; 
	    
	    int N = in.nextInt(); 
	    
	    ArrayList<Poop> manure = new ArrayList<Poop>(N); 
	    
	    for(int i = 0; i < N; i++) {
	    	int a = in.nextInt(); 
	    	int b = in.nextInt(); 
	    	
	    	if(distance(a, b) < distance(a, 0)) totalDist += distance(a, b); 
	    	else manure.add(new Poop(a, b)); 
	    }
	    
	    
	    in.close();
	
	    int result = 0;
	    PrintWriter out = new PrintWriter(new File("teleportation.out")); 
	    
	    
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static int distance(int x, int y) {
 		return Math.abs(x - y); 
 	}
 	
 	static class Poop {
 		int loc, dest; 
 		
 		Poop(int loc, int dest) {
 			this.loc = loc; 
 			this.dest = dest; 
 		}
 	}
}
