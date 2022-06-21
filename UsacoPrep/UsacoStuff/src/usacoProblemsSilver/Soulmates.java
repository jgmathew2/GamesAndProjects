package usacoProblemsSilver;


import java.util.*; 
public class Soulmates {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		
		int N = in.nextInt(); 
		
		for(int i = 0; i < N; i++) {
			Cow start = new Cow(in.nextLong(), 0);
			
			long target = in.nextLong(); 
			
			Deque<Cow> journey = new ArrayDeque<Cow>(); 
			HashSet<Long> beenTo = new HashSet<Long>(); 
			
			
			journey.add(start); 
			
			while(!journey.isEmpty()) {
				Cow current = journey.remove(); 
				long personality = current.personality; 
				
				if(personality == target) {
					System.out.println(current.length); 
					break; 
				}
				
				if(beenTo.contains(personality)) continue; 
				
				beenTo.add(personality); 
				
				journey.add(current.add()); 
				if(personality < target) {
					journey.add(current.multiply()); 
				}
				
				if(personality % 2 == 0) journey.add(current.divide()); 
				
				
			}
			
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
