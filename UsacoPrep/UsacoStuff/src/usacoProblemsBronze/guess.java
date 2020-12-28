package usacoProblemsBronze;

/*
ID:johangma
LANG: JAVA
TASK: guess
 */
import java.util.*;
import java.io.*;

public class guess {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("guess.in"));
	    ArrayList<ArrayList<String>> animals = new  ArrayList<ArrayList<String>>(); 
	    int num = in.nextInt(); 
	    in.nextLine(); 
	    for(int i = 0; i < num; i++) {
	    	String[] descrip = in.nextLine().split(" "); 
	    	ArrayList<String> animal = new ArrayList<String>(); 
	    	for(int j = 2; j < descrip.length; j++) {
	    		animal.add(descrip[j]); 
	    	}
	    	animals.add(animal); 
	    }
	    in.close();
	    int result = 0;
	    
	    for(int i = 0; i < animals.size(); i++) {
	    	for(int j = 0; j < animals.size(); j++) {
	    		if(i == j) continue; 
	    		ArrayList<String> animal1 = animals.get(i); 
	    		ArrayList<String> animal2 = animals.get(j); 
	    		int sims = 0; 
	    		
	    		for(int k = 0; k < animal1.size(); k++) {
	    			if(animal2.contains(animal1.get(k))) {
	    				sims++; 
	    			}
	    		}
	    		
	    		if(sims > result) result = sims; 
	    		
	    	}
	    }
	    
	    
	    PrintWriter out = new PrintWriter(new File("guess.out")); 
	
	    System.out.println(result + 1);
	    out.println(result + 1);
	    out.close();
	}
}
