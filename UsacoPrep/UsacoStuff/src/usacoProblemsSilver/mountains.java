package usacoProblemsSilver;
/*
ID:johangma
LANG: JAVA
TASK: mountains
 */
import java.util.*;
import java.io.*;

//completed 
public class mountains {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("mountains.in"));
	    HashSet<Mountain> obscuring = new HashSet<Mountain>(); 
	    int N = in.nextInt(); 
	    
	    OUTER : for(int i = 0; i < N; i++) {
	    	int middle = in.nextInt(); 
	    	int height = in.nextInt(); 
	    	
	    	Mountain current = new Mountain(middle - height, middle + height); 
	    	HashSet<Mountain> removal = new HashSet<Mountain>(); 
	    	INNER: for(Mountain mountain : obscuring) {
	    		Mountain obscurer = isObscuring(mountain, current); 
	    		if(obscurer == null) continue INNER; 
	    		if(obscurer.equals(mountain)) continue OUTER; 
	    		else if(obscurer.equals(current)) {
	    			removal.add(mountain);  
	    			
	    			
	    		}
	    		
	    	}
	    	obscuring.add(current); 
	    	obscuring.removeAll(removal); 
	    
	    }
	    in.close();
	
	    int result = obscuring.size();
	    PrintWriter out = new PrintWriter(new File("mountains.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static class Mountain {
 		int start; 
 		int end; 
 		
 		Mountain(int a, int b) {
 			start = a; 
 			end = b; 
 		}
 	}
 	
 	static Mountain isObscuring(Mountain a, Mountain b) {
 		if(a.start >= b.start && a.end <= b.end) return b; 
 		else if(a.start <= b.start && a.end >= b.end) return a; 
 		else return null; 
 	}
}
