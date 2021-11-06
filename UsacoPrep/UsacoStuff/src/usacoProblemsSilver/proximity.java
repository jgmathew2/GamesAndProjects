package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: proximity
 */
import java.util.*;
import java.io.*;

public class proximity {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("proximity.in"));
	    HashSet<Double> window = new HashSet<Double>(); 
	    
	    
	    int n = in.nextInt(); 
	    int k = in.nextInt(); 
	    int maxBreed = -1; 
	    double[] breeds = new double[n];
	    
	    for(int i = 0; i < n; i++) {
	    	double breed = in.nextInt(); 
	    	breeds[i] = breed; 
	    	
	    	if(breed > maxBreed && window.contains(breed)) {
	    		maxBreed = (int) breed; 
	    		breeds[i] += 0.1; 
	    		window.add(breed + 0.1);
	    		
	    	}
	    	
	    	window.add(breed); 
	    	
	    	if(i >= k) {
	    		window.remove(breeds[i - k]); 
	    	}
	    }
	    
	    
	   
	    in.close();
	
	    int result = maxBreed;
	    PrintWriter out = new PrintWriter(new File("proximity.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}
