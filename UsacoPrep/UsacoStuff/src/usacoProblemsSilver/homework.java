package usacoProblemsSilver;


/*
ID:johangma
LANG: JAVA
TASK: homework
 */
import java.util.*;
import java.io.*;

public class homework {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("homework.in"));
	    //Scanner in = new Scanner(System.in); 
	    
	    
	    int N = in.nextInt(); 
	    int[] prefixSums  = new int[N]; 
	    prefixSums[0] = in.nextInt(); 
	    Grade[] grades = new Grade[N]; 
	    grades[0] = new Grade(0, prefixSums[0]); 
	    
	    
	    for(int i = 1; i < N; i++) {
	    	int currValue = in.nextInt(); 
	    	prefixSums[i] = prefixSums[i - 1] + currValue;
	    	grades[i] = new Grade(i, currValue);
	    }
	    
	    ArrayList<Integer> solutions = new ArrayList<Integer>(); 
	    
	    Arrays.sort(grades);
	    
	    int maxAverage = 0; 
	    for(int i = 0; i < N - 2; i++) {
	    	
	    	int currSum = prefixSums[prefixSums.length - 1] - prefixSums[i]; 
	    	int a = 0; 
	    	while(a < N) {
	    		if(grades[a].position > i) {
	    			a = grades[a].value; 
	    			break; 
	    		}
	    		a++; 
	    	}
	    	
	    	currSum -= a; 
	    	int currAverage = currSum / (N - i - 2);
	    	if(currAverage > maxAverage) {
	    		solutions.clear(); 
	    		solutions.add(i + 1); 
	    		
	    		maxAverage = currAverage; 
	    	}
	    	else if(currAverage == maxAverage) solutions.add(i + 1); 
	    	
	    }
	    in.close();
	    

	    PrintWriter out = new PrintWriter(new File("homework.out")); 
	
	    
	    for(int i = 0; i < solutions.size(); i++) {
	    	out.println(solutions.get(i)); 
	    	System.out.println(solutions.get(i)); 
	    	
	    }
	
	    out.close();
	}
 	
 	static class Grade implements Comparable<Grade> {
 		int position; 
 		int value; 
 		
 		public int compareTo(Grade other) {
 			return this.value - other.value; 
 		
 		}
 		
 		Grade(int position, int value) {
 			this.position = position; 
 			this.value = value; 
 		}
 		
 	}
 	
}



