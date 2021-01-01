package algorithmTemplates;

import java.util.Arrays;
import java.util.Random; 

public class KnuthShuffle<T> {
	private T[] array; 
	private int size; 
	
	KnuthShuffle(int n) {
		array = (T[]) new Object[n]; 
		size = n; 
	}
	
	public void swap(int i, int j) {
		T placeholder = array[i]; 
		array[i] = array[j]; 
		array[j] = placeholder; 
	}
	
	public void shuffle() {
		for(int i = 1; i < array.length; i++) {
			Random rand = new Random(); 
			
			swap(i, rand.nextInt(i)); 
		}
	}
	
	public void setValue (int index, T value) {
		array[index] = value; 
	}
	
	public T[] getArray() {
		return array; 
	}
	
	
	public static void main(String[] args) {
		KnuthShuffle<Integer> array = new KnuthShuffle<Integer>(10); 
		
		for(int i = 0; i < 10; i++) {
			array.setValue(i, i);
		}
		
		array.shuffle(); 
		
		System.out.println(Arrays.toString(array.getArray()));
		
	}

}
