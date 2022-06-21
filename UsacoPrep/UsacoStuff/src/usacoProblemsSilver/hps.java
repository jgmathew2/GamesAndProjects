package usacoProblemsSilver; 

/*
ID:johangma
LANG: JAVA
TASK: hps
 */
import java.util.*;
import java.io.*;

//completed
public class hps {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("hps.in"));
	    ArrayList<Integer> HRegions = new ArrayList<Integer>(); 
	    ArrayList<Integer> PRegions = new ArrayList<Integer>(); 
	    ArrayList<Integer> SRegions = new ArrayList<Integer>(); 
	    HRegions.add(0); 
	    PRegions.add(0); 
	    SRegions.add(0); 
	    
	    int N = in.nextInt(); 
	    in.nextLine(); 
	    int currChar = in.nextLine().charAt(0); 
	    int regionSize = 1; 
	    for(int i = 0; i < N - 1; i++) {
	    	char next = in.nextLine().charAt(0); 
	    	
	    	if(next == currChar) {
	    		regionSize++; 
	    	}
	    	else {
	    		if(currChar == 'H') {
	    			HRegions.add(HRegions.get(HRegions.size() - 1) + regionSize);
	    			PRegions.add(PRegions.get(PRegions.size() - 1)); 
	    			SRegions.add(SRegions.get(SRegions.size() - 1)); 
	    		}
	    		else if(currChar == 'P') {
	    			HRegions.add(HRegions.get(HRegions.size() - 1) );
	    			PRegions.add(PRegions.get(PRegions.size() - 1)+ regionSize); 
	    			SRegions.add(SRegions.get(SRegions.size() - 1)); 
	    		}
	    		else if(currChar == 'S') {
	    			HRegions.add(HRegions.get(HRegions.size() - 1) );
	    			PRegions.add(PRegions.get(PRegions.size() - 1)); 
	    			SRegions.add(SRegions.get(SRegions.size() - 1)+ regionSize); 
	    		}
	    		
	    		regionSize = 1; 
	    		currChar = next; 
	    	}
	    }
	    
	    if(currChar == 'H') {
			HRegions.add(HRegions.get(HRegions.size() - 1) + regionSize);
			PRegions.add(PRegions.get(PRegions.size() - 1)); 
			SRegions.add(SRegions.get(SRegions.size() - 1)); 
		}
		else if(currChar == 'P') {
			HRegions.add(HRegions.get(HRegions.size() - 1) );
			PRegions.add(PRegions.get(PRegions.size() - 1)+ regionSize); 
			SRegions.add(SRegions.get(SRegions.size() - 1)); 
		}
		else if(currChar == 'S') {
			HRegions.add(HRegions.get(HRegions.size() - 1) );
			PRegions.add(PRegions.get(PRegions.size() - 1)); 
			SRegions.add(SRegions.get(SRegions.size() - 1)+ regionSize); 
		}
	    in.close();
	    
	    int numRegions = HRegions.size(); 
	    int result = 0;
	    
	    for(int i = 1; i < numRegions; i++) {
	    	int Hprev = HRegions.get(i - 1); 
	    	int HAff = HRegions.get(numRegions - 1) - HRegions.get(i - 1); 
	    	int Pprev = PRegions.get(i - 1); 
	    	int PAff = PRegions.get(numRegions - 1) - PRegions.get(i - 1); 
	    	int Sprev = SRegions.get(i - 1); 
	    	int SAff = SRegions.get(numRegions - 1) - SRegions.get(i - 1); 
	    	
	    	result = Math.max(result, Hprev + HAff);  
	    	result = Math.max(result, Hprev + PAff);
	    	result = Math.max(result, Hprev + SAff);
	    	result = Math.max(result, Sprev + HAff);  
	    	result = Math.max(result, Sprev + PAff);
	    	result = Math.max(result, Sprev + SAff);
	    	result = Math.max(result, Pprev + HAff);  
	    	result = Math.max(result, Pprev + PAff);
	    	result = Math.max(result, Pprev + SAff);
	    }
	
	
	    PrintWriter out = new PrintWriter(new File("hps.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}
