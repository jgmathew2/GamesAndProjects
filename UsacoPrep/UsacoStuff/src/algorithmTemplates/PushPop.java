package algorithmTemplates;

import java.util.Arrays;

public class PushPop<T> {
	
	T[] array; 
	
	PushPop () {
		array = (T[]) new Object[10];  
	}
	
	T[] resizeArray (int newLength, int start ) {
		
		T[] resized = (T[]) new Object[newLength];
		
		for(int i = start; i < newLength && i < array.length; i++) {
			resized[i] = array[i - start];
		}
		
		return resized; 
	}
	
	void add(T value) {
		if(array[array.length - 1] != null) {
			array = resizeArray(array.length * 2, 1); 
		}
		
		array[0] = value; 
	}
	
	void push(T value, int size) {
		if(array[array.length - 1] != null) {
			array = resizeArray(array.length * 2, 0); 
			
			array[size] = value; 
		}
		else array[size] = value;
	
	}
	
	T removeFirst() {
		T placeholder = array[0];
		
		resizeArray(array.length, 1); 
		
		return placeholder; 
	}
	
	T pop(int size) {
		if(size - 1 == array.length / 4) {
			array = resizeArray(array.length / 2, 0); 
			
			T placeholder = array[size - 1];
			
			array[size - 1] = null; 
			
			return placeholder; 
		}
		else {
			T placeholder = array[size - 1]; 
			
			array[size - 1] = null; 
			
			return placeholder; 
		}
	}
	
	public static void main(String[] args) {
		PushPop<Integer> stack = new PushPop<Integer>(); 
		stack.array = new Integer[] { 5, 8, 3, 6, 9}; 
		
		stack.push(4, 5);
		
		stack.push(5, 6); 
		System.out.println(Arrays.toString(stack.array));
		/*
		for(int i = 0; i < stack.array.length; i++) {
			System.out.print(stack.array[i] + ", ");
		}
		*/
		System.out.println(); 
		for(int i = 7; i > 2; i--) {
			stack.pop(i); 
		}
		
		System.out.println(Arrays.toString(stack.array));
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
