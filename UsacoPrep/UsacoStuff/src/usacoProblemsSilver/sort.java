package usacoProblemsSilver;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
* @author Johan
 * @version Creation time: Apr 3, 2021 12:28:24 PM
 * Class Description
*/
public class sort {
 	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(new File("sort.in"));
	    int[] array = new int[in.nextInt()]; 
	    Hello[] copy = new Hello[array.length]; 
	    
	    for(int i = 0; i < array.length; i++) {
	    	array[i] = in.nextInt(); 
	    	copy[i] = new Hello(array[i], 0, i); 
	    }
	    in.close();
	    
	    Arrays.sort(copy); 
	    
	    for(int i = 0; i < copy.length; i++) {
	    	Hello hello = copy[i]; 
	    	
	    	hello.next = i; 
	    }
	    
	    int biggestDiff = 0; 
	    
	    for(int i = 0; i < copy.length; i++) {
	    	Hello hello = copy[i]; 
	    	if(copy[hello.original].value == hello.value) continue; 
	    	if(biggestDiff < Math.abs(hello.next - hello.original)) biggestDiff = Math.abs(hello.next - hello.original); 
	    }
	
	    int result = biggestDiff + 1;
	    PrintWriter out = new PrintWriter(new File("sort.out")); 
	
	    System.out.println(result);
	    out.println(result);
	    out.close();
	}
 	
 	static class Hello implements Comparable<Hello> {
 		int value; 
 		int next; 
 		int original; 
 		
 		
 		Hello(int value, int next, int original) {
 			this.value = value; 
 			this.next = next; 
 			this.original = original; 
 			
 		}
 		
 		public int compareTo(Hello hello) {
 			
 			if(this.value - hello.value != 0) {
 				return this.value - hello.value; 
 			}
 			else {
 				return this.original - hello.original; 
 			}
 		}
 	}
}
