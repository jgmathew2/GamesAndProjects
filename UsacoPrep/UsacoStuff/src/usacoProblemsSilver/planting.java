package usacoProblemsSilver;

/*
ID:johangma
LANG: JAVA
TASK: planting
 */
import java.util.*;
import java.io.*;

public class planting {
 	public static void main(String[] args) throws Exception {
 		
	    Scanner in = new Scanner(new File("planting.in"));
	    
	    Field[] fields = new Field[in.nextInt()];
	    
	    for(int i = 0; i < fields.length; i++) {
	    	fields[i].index = i; 
	    }
	    
	    for(int i = 0; i < fields.length - 1; i++) {
	    	int field1 = in.nextInt(); 
	    	int field2 = in.nextInt();
	    	
	    	fields[field1].addPath(field2);
	      	fields[field2].addPath(field1);
	    }
	    
	    in.close();
	
	    int result = 0;
	    PrintWriter out = new PrintWriter(new File("planting.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	static class Field {
 		int type; 
 		int index; 
 		static int numOfPaths = 0; 
 		
 		int[] connected; 
 		
 		void addPath(int newPath) {
 			connected[numOfPaths] = newPath; 
 			
 			numOfPaths++; 
 		}
 		
 		
 	}
}


