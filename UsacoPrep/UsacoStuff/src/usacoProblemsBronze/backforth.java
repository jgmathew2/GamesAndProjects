package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: 
 */
import java.util.*;
import java.io.*;

public class backforth {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("backforth.in"));
	    int[] barn1B = new int[10];
	    int[] barn2B = new int[11]; 
	    
	    for(int i = 0; i < 10; i++) {
	    	barn1B[i] = in.nextInt(); 
	    }
	    for(int i = 0; i < 10; i++) {
	    	barn2B[i] = in.nextInt(); 
	    }
	    in.close();
	    Set<Integer> solutions = new HashSet<Integer>(); 
	    
	    for(int tues = 0; tues < 10; tues++) {
	    	int firstBarnMilk = 1000; 
	    	int tuesBucket = barn1B[tues]; 
	    	firstBarnMilk -= tuesBucket; 
	    	barn2B[10] = tuesBucket; 
	    	barn1B[tues] = 0; 
	    	for(int wed = 0; wed < 11; wed++) {
	    		int wedBucket = barn2B[wed]; 
	    		firstBarnMilk += wedBucket; 
	    		barn1B[tues] = wedBucket; 
	    		barn2B[wed] = 0; 
	    		for(int thurs = 0; thurs < 10; thurs++) {
	    			int thursBucket = barn1B[thurs]; 
		    		firstBarnMilk -= thursBucket; 
		    		barn2B[wed] = thursBucket; 
		    		barn1B[thurs] = 0; 
	    			for(int fri = 0; fri < 11; fri++) {
	    				firstBarnMilk += barn2B[fri];
	    				solutions.add(firstBarnMilk); 
	    				firstBarnMilk -= barn2B[fri]; 
	    			}
	    			barn1B[thurs] = thursBucket; 
	    			firstBarnMilk += thursBucket; 
	    		}
	    		barn2B[wed] = wedBucket;
	    		firstBarnMilk -= wedBucket; 
	    	}
	    	barn1B[tues] = tuesBucket; 
	    	barn2B[10] = 0; 
	    }
	
	    int result = solutions.size(); 
	    PrintWriter out = new PrintWriter(new File("backforth.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}
