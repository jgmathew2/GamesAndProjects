package algorithmTemplates;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		
		int[] test = new int[] {9, 3, 7, 4, 8, 10, 6, 6, 1, 13}; 
		
		QuickSort(test, 0, test.length - 1); 
		
		System.out.println(Arrays.toString(test)); 
	}
	
	public static void QuickSort(int[] array, int start, int end) {
		if(end - start < 2) return; 
		int split = partition(array, start, end); 
		swap(start, split, array); 
		
		QuickSort(array, start, split - 1); 
		QuickSort(array, split + 1, end); 
	}
	
	public static int partition(int[] array, int start, int end) {
		int value = array[start]; 
		
		int down = start + 1; 
		int up = end; 
		
		while(up != down) {
			if(array[down] < value) { 
				down++; 
			}
			if(array[up] > value) up--; 
			
			if(array[up] <= value && array[down] >= value) {
				swap(down, up, array); 
			}
		}
		
		return up; 
		
		
	}
	
	public static void swap(int indexA, int indexB, int[] array) {
		int temp = array[indexA]; 
		array[indexA] = array[indexB]; 
		array[indexB] = temp; 
	}

}
