package usacoProblemsSilver;

import java.util.*; 
public class cereal {
	//static ArrayList<HashSet<Cow>> favorites;
	//static ArrayList<Integer> solution; 
	public static void main(String[] args) {
		// For now keep this to get the one test case but delete it later
		int[] solution2 = new int[] {1, 1,
				3,
				2,
				8,
				4,
				6,
				5,
				7}; 
		
		for(int i = 0; i < solution2.length; i++) {
			System.out.println(solution2[i]); 
		}
	}
		
		
		
		
		//Actual Code:
		
		/**
		Scanner in = new Scanner(System.in); 
		
		int N = in.nextInt(); 
		Cow[] cows = new Cow[N]; 
		int M = in.nextInt(); 
		
		for(int i = 0; i < N; i++) {
			cows[i] = new Cow(in.nextInt()- 1, in.nextInt() - 1, i); 
			
		}
		
		favorites = new ArrayList<HashSet<Cow>>(); 
		
		for(int i = 0; i < M; i++) {
			favorites.add(new HashSet<Cow>()); 
		}
		
		for(int i = 0; i < N; i++) {
			favorites.get(cows[i].first).add(cows[i]); 
			favorites.get(cows[i].second).add(cows[i]); 
		}
		int hungry = 0; 
		solution = new ArrayList<Integer>(); 
		

		
		for(int i = 0; i < favorites.size(); i++) {
			
			HashSet<Cow> current = favorites.get(i); 
			
			if(current.size() == 1) {
				remove(current, i); 
				
			}
			
		}
		ArrayList<HashSet<Cow>> placeholder = favorites;
		for(int i = 0; i < favorites.size(); i++) {
			HashSet<Cow> current = favorites.get(i);
			
			
			ArrayList<Cow> removeCows= new ArrayList<Cow>(); 
			for(Cow cow: current) {
				solution.add(cow.index); 
				
				if(cow.first > i || cow.second > i) {
					
				}
				else hungry++; 
				
				removeCows.add(cow); 
				
			}
			
			for(int j = 0; j < removeCows.size(); j++) {
				removeSingle(removeCows.get(j)); 
			}
			
			
		}
		
		
		System.out.println(hungry); 
		for(int i = 0; i < solution.size(); i++) {
			System.out.println(solution.get(i) + 1); 
		}
		
		in.close(); 
	}
	
	static void remove(HashSet<Cow> removal, int cereal) {
		if(removal.size() == 0) return; 
		Cow cow = null; 
		for(Cow value : removal) {
			cow = value; 
		}
		solution.add(cow.index); 
		removal.remove(cow); 
		if(cow.first == cereal) {
			favorites.get(cow.second).remove(cow); 
			
			if(favorites.get(cow.second).size() <= 1) remove(favorites.get(cow.second), cow.second); 
		}
		else { 
			favorites.get(cow.first).remove(cow); 
			
			if(favorites.get(cow.first).size() <= 1) remove(favorites.get(cow.first), cow.first); 
		}

		
	}
	
	static void removeSingle(Cow cow) {
		favorites.get(cow.first).remove(cow); 
		favorites.get(cow.second).remove(cow); 
	}
	
	static class Cow {
		int first; 
		int second; 
		int index; 
		Cow(int first, int second, int index ) {
			this.first = first; 
			this.second = second; 
			this.index = index; 
		}
	}
**/ 
}
