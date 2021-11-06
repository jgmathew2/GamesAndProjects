package usacoProblemsSilver;
/**
* @author Johan
 * @version Creation time: Feb 16, 2021 12:03:22 PM
 * Class Description
*/
import java.util.*;
import java.io.*;

public class cowrace {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("cowrace.in"));
	    
	    int N = in.nextInt(); 
	    int M = in.nextInt(); 
	    Segment[] bessieSegs = new Segment[N]; 
	    Segment[] elsieSegs = new Segment[M]; 
	    in.nextLine(); 
	    
  
	    for(int i = 0; i < N; i++) {
	    	bessieSegs[i] = new Segment(in.nextInt(), in.nextInt()); 
	    }

	    for(int i = 0; i < M; i++) {
        	elsieSegs[i] = new Segment(in.nextInt(), in.nextInt()); 
	    }
	    in.close();
	    
	    int leader = 0; 
	    
	    int bessieDistance = 0; 
	    int elsieDistance = 0; 
	    int bessieSeg = 0; 
	    int elsieSeg = 0; 
	    int turnovers = 0; 
	    
	    while(elsieSeg < elsieSegs.length && bessieSeg < bessieSegs.length) {
	    	Segment bCurrSeg = bessieSegs[bessieSeg]; 
	    	Segment eCurrSeg = elsieSegs[elsieSeg]; 
	    	
	    	bessieDistance += bCurrSeg.speed; 
	    	elsieDistance+= eCurrSeg.speed; 
	    	
	    	bCurrSeg.time--; 
	    	eCurrSeg.time--; 
	
	    	if(bessieDistance > elsieDistance && leader == -1) {
	    		turnovers++; 
	    		leader = 1; 
	    	}
	    	else if(elsieDistance > bessieDistance && leader == 1) {
	    		turnovers++; 
	    		leader = -1; 
	    	}
	    	else if(leader == 0) {
	    		if(elsieDistance > bessieDistance) leader = -1; 
	    		else if(elsieDistance < bessieDistance) leader = 1; 
	    	}
	    	
	    	
	    	if(bCurrSeg.time == 0) {
	    		bessieSeg++; 
	    	}
	    	if(eCurrSeg.time == 0) {
	    		elsieSeg++; 
	    	}
	    }
	    
	    
	    
	    
	    int result = turnovers;
	    PrintWriter out = new PrintWriter(new File("cowrace.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static class Segment {
 		int speed; 
 		int time; 
 		
 		Segment(int speed, int time) {
 			this.speed = speed; 
 			this.time = time; 
 		}; 
 	}
}
