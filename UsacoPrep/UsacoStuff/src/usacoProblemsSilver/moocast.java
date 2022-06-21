package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: moocast
 */
import java.util.*;
import java.io.*;


public class moocast {
	static HashSet<Cow> beenTo = new HashSet<Cow>(); 
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("moocast.in"));
	    int N = in.nextInt(); 
	    int[] range = new int[N]; 
	    Cow[] cows = new Cow[N]; 
	    
	    for(int i = 0; i < N; i++) {
	    	cows[i] = new Cow(); 
	    	cows[i].x = in.nextInt(); 
	    	cows[i].y = in.nextInt(); 
	    	cows[i].range = in.nextInt(); 
	    }
	    
	    for(int i = 0; i < cows.length; i++) {
	    	for(int j = 0; j < cows.length; j++) {
	    		if(i == j) continue; 
	    		
	    		if(reachable(cows[i].x, cows[i].y, cows[i].range, cows[j].x, cows[j].y)) {
	    			cows[i].reachable.add(cows[j]); 
	    		}
	    	}
	    }
 	    
	    in.close();
	
	    int result = 0;
	    
	    for(int i = 0; i < cows.length; i++) {
	    	result = Math.max(result, signal(cows[i])); 
	    	beenTo.clear(); 
	    }
	    PrintWriter out = new PrintWriter(new File("moocast.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static int signal(Cow current) {
 		if(beenTo.contains(current)) return 0; 
 		int count = 1; 
 		for(Cow neighbor: current.reachable) {
 			count += signal(neighbor); 
 		}
 		
 		return count; 
 	}
 	
 	static boolean reachable(int startX, int startY, int range, int destX, int destY) {
 		double distance = Math.pow(destX - startX, 2) + Math.pow(destY - startY, 2);
 		
 		if(Math.sqrt(distance) < range) return true; 
 		else return false; 
 	}
 	
 	static class Cow {
 		HashSet<Cow> reachable = new HashSet<Cow>(); 
 		int x; 
 		int y; 
 		int range; 
 		
  	}
}
