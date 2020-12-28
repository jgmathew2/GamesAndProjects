package usacoProblemsBronze;

import java.util.Scanner;

public class flowers {
	public static void main(String[] args) {
		 
		 Scanner in = new Scanner(System.in);
		 
		 int[] flowers = new int[in.nextInt()]; 
		
		
		 
		 for(int i = 0; i < flowers.length; i++) {
			 flowers[i] = in.nextInt(); 
		 }
		 
		 in.close(); 
		 
		 
		
		
		 
		 
		 
		 int averages = flowers.length; 
		 
		 for(int i = 0; i < flowers.length; i++) {
			 inner: for(int j = i + 1; j < flowers.length; j++) {
				 double sum = 0; 
				 
				 for(int c = i; c <= j; c++) {
					 sum += flowers[c]; 
				 }
				 
				 for(int c = i; c <= j; c++) {
					 if(flowers[c] == sum / (j - i + 1)) {
						 averages++; 
						 continue inner; 
					 }
				 }
			 }
		 }
		 
		 System.out.println(averages); 
		 
		 
	}
	
}
