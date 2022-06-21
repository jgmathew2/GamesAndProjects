package usacoProblemsSilver;

import java.util.ArrayDeque;

import java.util.*; 

public class Soulmates2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		
		int N = in.nextInt(); 
		
		for(int i = 0; i < N; i++) {
			long current = in.nextLong(); 
			
			long target = in.nextLong(); 
			
			int numSteps = 0; 
			
			long minSteps = Integer.MAX_VALUE; 
			
			while(current != target) {
				
				if(target > current) {
					minSteps = Math.min(minSteps, numSteps + target - current); 
					
					if(target % 2 == 1) {
						numSteps++;
						target--; 
					}
					
					target /=2; 
					numSteps++; 
				}
				else {
					if(current % 2 == 1) {
						numSteps++;
						current++; 
					}
					
					current /=2; 
					numSteps++; 
				}
			}
			
			minSteps = Math.min(minSteps, numSteps); 
			
			System.out.println(minSteps); 
			
		}
		in.close(); 
		
	}
	
	static class Cow {
		long personality; 
		int length; 
		
		Cow(long personality, int length) {
			this.personality = personality; 
			this.length = length; 
		}
		
		Cow multiply() {
			return new Cow(personality * 2, length + 1); 
		}
		
		Cow divide() {
			if(personality % 2 == 0)  return new Cow(personality / 2, length + 1); 
			else return new Cow(personality, length + 1); 
		}
		
		Cow add() {
			return new Cow(personality + 1, length + 1); 
		}
	}

}