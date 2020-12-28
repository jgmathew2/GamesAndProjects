package algorithmTemplates;

public class QuickFind {
	public static void main(String[] args) {
		int[] unions = new int[10];
		int[] size = new int[unions.length]; 
		
		for(int i = 0; i < unions.length; i++) {
			unions[i] = i; 
		}
		
		quickUnion(unions, size, 4, 3);
		quickUnion(unions, size, 3, 8);
		quickUnion(unions, size, 2, 7); 
		quickUnion(unions, size, 6, 5); 
		quickUnion(unions, size, 4, 9); 
		quickUnion(unions, size, 2, 1); 
		System.out.println(connectedUnion(unions, 8, 9));
		System.out.println(connectedUnion(unions, 5, 0)); 
		quickUnion(unions, size, 5, 0); 
		quickUnion(unions, size, 6, 1); 
		quickUnion(unions, size, 3, 6); 
		
		for(int i = 0; i < unions.length; i++) {
			System.out.print(unions[i] + ", ");
		}
	}
	
	public static boolean connectedUnion(int[] unions, int p, int q) {
		int i = unions[p]; 
		int j = unions[q];
		
		
		
		while(i != unions[i] || j != unions[j]) {
			
			i = unions[i]; 
	
			j = unions[j]; 
		}
		
		if(i == j) return true;
		else return false; 
	}
	
	public static void quickUnion(int[] unions, int[] size, int p, int q)  {
		int i = unions[p]; 
		int j = unions[q]; 
		
		
		while(i != unions[i] || j != unions[j]) {
			unions[i] = unions[unions[i]]; 
			unions[j] = unions[unions[j]]; 
			i = unions[i]; 
			j = unions[j]; 
		}
		
		if(size[i] > size[j]) {
			unions[j] = unions[i]; 
			size[j]++; 
		}
		else {
			unions[i] = unions[j]; 
			if(size[i] == size[j]) size[j]++; 
			
			size[i]++; 
		}
		
		
	}

}
