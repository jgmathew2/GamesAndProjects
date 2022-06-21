package usacoProblemsSilver;

import java.util.*;


public class ConnectingBarns {
	static HashSet<Field> beenTo = new HashSet<Field>(); 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		
		int T = in.nextInt(); 
		
		for(int i = 0; i < T; i++) {
			int N = in.nextInt(); 
			int M = in.nextInt(); 
			
			Field[] fields = new Field[N];
			
			for(int j = 0; j < fields.length; j++) {
				fields[j] = new Field(j); 
			}
			for(int j = 0; j < M; j++) {
				int A = in.nextInt() - 1; 
				int B = in.nextInt() - 1; 
				
				fields[A].neighbors.add(fields[B]); 
				fields[B].neighbors.add(fields[A]); 
			}
			
			
			ArrayList<Integer> startRegion = new ArrayList<Integer>(); 
			
			
			Deque<Field> queue = new ArrayDeque<Field>(); 
			
			queue.add(fields[0]); 
			
			while(!queue.isEmpty()) {
				Field currField = queue.remove(); 
				
				if(beenTo.contains(currField)) continue; 
				beenTo.add(currField); 
				
				startRegion.add(currField.index); 
				
				for(Field neighbor : currField.neighbors) {
					queue.add(neighbor); 
				}
				
			} 
			
			ArrayList<Integer> endRegion = new ArrayList<Integer>(); 
			
			queue.add(fields[N - 1]); 
			
			while(!queue.isEmpty()) {
				Field currField = queue.remove(); 
				
				if(beenTo.contains(currField)) continue; 
				beenTo.add(currField); 
				
				endRegion.add(currField.index); 
				
				for(Field neighbor : currField.neighbors) {
					queue.add(neighbor); 
				}
				
			}
			
		
			
			int minCost = (int) Math.pow(findMinDistance(startRegion, endRegion), 2); 
			
			
			for(int j = 0; j < fields.length; j++) {
				if(beenTo.contains(fields[j])) continue; 
				
				minCost = Math.min(minCost, findCost(fields, j, startRegion, endRegion)); 
			}
			
			System.out.println(minCost); 
			
		
			
		}
		
		
	}
	
	static int findCost(Field[] fields, int start, ArrayList<Integer> startRegion, ArrayList<Integer> endRegion) {

		

		
		Deque<Field> queue = new ArrayDeque<Field>(); 
		
		queue.add(fields[start]); 
		
		ArrayList<Integer> region = new ArrayList<Integer>(); 
		
		while(!queue.isEmpty()) {
			Field currField = queue.remove(); 
			
			if(beenTo.contains(currField)) continue; 
			beenTo.add(currField); 
			region.add(currField.index); 
			
			for(Field neighbor : currField.neighbors) {
				queue.add(neighbor); 
			}
			
		}
		
		return (int)(Math.pow(findMinDistance(startRegion, region), 2) + 
				Math.pow(findMinDistance(endRegion, region), 2)); 
		
		
	}
	
	static int findMinDistance(ArrayList<Integer> region1, ArrayList<Integer> region2) {
		Collections.sort(region1);
		Collections.sort(region2);
		
		int index1 = 0; 
		int index2 = 0; 
		
		int minDifference = Integer.MAX_VALUE; 
		
		while(index1 < region1.size() && index2 < region2.size()) {
			minDifference = Math.min(minDifference, Math.abs(region1.get(index1) - region2.get(index2))); 
			
			if(region1.get(index1) > region2.get(index2)) {
				index2++; 
			}
			else index1++; 
		}
		
		return minDifference; 
	}
	
	static class Field {
		int index; 
		
		Field(int index) {
			this.index = index; 
		}
		
		HashSet<Field> neighbors = new HashSet<Field>(); 
	}

}
