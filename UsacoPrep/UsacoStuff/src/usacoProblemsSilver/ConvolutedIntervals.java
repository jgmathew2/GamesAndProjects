package usacoProblemsSilver;


import java.util.*; 


public class ConvolutedIntervals {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt(); 
		int M = in.nextInt(); 
		
		HashMap<Integer, Integer> AMap = new HashMap<Integer, Integer>(); 
		HashMap<Integer, Integer> BMap = new HashMap<Integer, Integer>(); 
		
		
		for(int i = 0; i < N; i++) {
			int a = in.nextInt(); 
			int b = in.nextInt(); 
			try {
			AMap.put(a, AMap.get(a) + 1);
			BMap.put(b, BMap.get(b) + 1);
			}
			catch(Exception e) {
				AMap.put(a, 1); 
				BMap.put(b, 1); 
			}
		}
		
		for(int k = 0; k < 2 * M + 1; k++) {
			int total = (int)Math.pow(N, 2);
			
			for(int x : AMap.keySet()) {
				for(int y: AMap.keySet()) {
					if(x + y > k) total -= AMap.get(x) * AMap.get(y);  
				}
			}
			for(int x : BMap.keySet()) {
				for(int y: BMap.keySet()) {
					if(x + y < k) total -= BMap.get(x) * BMap.get(y);  
				}
			}
			
			System.out.println(total); 
		}
				
	}

}
