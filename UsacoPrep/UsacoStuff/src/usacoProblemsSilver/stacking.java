package usacoProblemsSilver;
/*
ID:johangma
LANG: JAVA
TASK: stacking
 */
import java.util.*;
import java.io.*;

public class stacking {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("stacking.in"));
	    int N = in.nextInt(); 
	    Landmark[] landmarks = new Landmark[in.nextInt() * 2]; 
	    
	    
	    for(int i = 0; i < landmarks.length / 2; i++) {
	    	
	    }
	    in.close();
	
	    int result = 0;
	    PrintWriter out = new PrintWriter(new File("stacking.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	    
	    
	    
 		
 		ArrayList<Size> values = new ArrayList<Size>(); 
 		
 		
	}
 	
 	static double findMedian(ArrayList<Size> values) {
 		Collections.sort(values); 
 		int i = 0; 
 		int j = values.size() - 1; 
 		while(i < j) {
 			if(values.get(i).occur > values.get(j).occur) {
 				values.get(i).occur -= values.get(j).occur; 
 				j--; 
 			}
 			else if(values.get(i).occur < values.get(j).occur) {
 				values.get(j).occur -= values.get(i).occur; 
 				i++; 
 			}
 			else if(values.get(i).occur == values.get(j).occur) {
 				i++; 
 				j--; 
 			}
 		}
 		
 		if(values.get(j).occur > 0) return values.get(j).index; 
 		else if(values.get(i).occur > 0) return values.get(j).index; 
 		else return (double)((values.get(j).index + values.get(j).index)/2); 
 	}
 	
 	static class Size implements Comparable<Size> {
 		int index; 
 		int occur; 
 		
 		public int compareTo(Size size) {
 			return this.index - size.index; 
 		}
 		
 		Size(int index) {
 			this.index = index; 
 		}
 	}
 	
 	static class Landmark implements Comparable<Landmark> {
 		int index; 
 		int value; 
 		
 		public int compareTo(Landmark landmark) {
 			return this.index - landmark.index; 
 		}
 		
 		Landmark(int index) {
 			this.index = index; 
 		}
 	}
 	
}
