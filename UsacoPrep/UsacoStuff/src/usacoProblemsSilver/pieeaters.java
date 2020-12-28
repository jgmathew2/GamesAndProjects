package usacoProblemsSilver;
//package usacoProblems;

/*
ID:johangma
LANG: JAVA
TASK: pieaters
 */
import java.util.*;
import java.io.*;

public class pieeaters {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("pieaters.in"));
	    int pieNum = in.nextInt(); 
	    int cowNum = in.nextInt(); 
	    PieEater[][] cows = new PieEater[pieNum + 1][cowNum]; 
	    boolean[] eaten = new boolean[pieNum]; 
	    
	    for(int i = 0; i < eaten.length; i++) {
	    	eaten[i] = false; 
	    }
	    
	    for(int i = 0; i < cows.length; i++) {
	    	for(int j = 0; j < cows[i].length; j++) {
	    		cows[i][j] = new PieEater(0, 0, -1); 
	    	}
	    }
	    
	    for(int i = 0; i < cowNum; i++) {
	    	PieEater cow = new PieEater(in.nextInt(), in.nextInt(), in.nextInt());
	    	int j = 0; 
	    	while(cows[cow.higher - cow.lower + 1][j].higher != -1) j++; 
	    	
	    	cows[cow.higher - cow.lower + 1][j] = cow; 
	    }
	    
	    for(int i = 0; i < cows.length; i++) {
	    	if(cows[i] != null) Arrays.sort(cows[i]);
	    }
	    
	    
	    in.close();
	    
	    int totalWeight1 = 0; 
	    
	    for(int i = 0; i < cows.length; i++) {
	    	for(int j = cows[i].length - 1; j >= 0; j--) {
	    		boolean canEat = false;
	    		
	    		for(int c = cows[i][j].lower; c <=  cows[i][j].higher; c++) {
	    			if(eaten[c - 1] == false) {
	    				canEat = true;
	    				eaten[c - 1] = true; 
	    			}
	    		}
	    		if(canEat) totalWeight1 += cows[i][j].weight; 
	    	}
	    }
	
	    int result = totalWeight1;
	    PrintWriter out = new PrintWriter(new File("pieaters.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
}

class PieEater implements Comparable<PieEater> {
	int lower; 
	int higher; 
	int weight; 
	
	PieEater(int weight, int lower, int higher) {
		this.lower = lower; 
		this.higher = higher; 
		this.weight = weight; 
	}
	
	
	public int compareTo(PieEater p) {
		if(p == null) return 1; 
		
		if(this.weight < p.weight) return -1; 
		else if(this.weight > p.weight) return 1; 
		else return 0; 
	}


}
