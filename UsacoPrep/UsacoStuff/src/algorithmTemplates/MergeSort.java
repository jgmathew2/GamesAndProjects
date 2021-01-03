package algorithmTemplates;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random; 

public class MergeSort<T extends Comparable<T>> {
	GenericComparator<T> comparator; 
	
	MergeSort() {
		comparator = new GenericComparator<T>(); 
	}
	
	
	public T[] mergeSort(T[] array, int start, int end) {
		if(end - start <= 2) {
			return merge(array, start, end); 
		}
		int halfway = (start + end) / 2; 
		
		
		
		array = mergeSort(array, start, halfway); 
		
		array = mergeSort(array, halfway, end); 
	
		
		return merge(array, start, end); 
		
		
		
		
	
	}
	
	
	public T[] merge(T[] array, int start, int end) {
		if(end - start <= 1) return array; 
		
		int halfway = (start + end) / 2; 
		
		T[] newArray = (T[]) new Comparable[array.length]; 
		
		for(int i = 0; i < array.length; i++) {
			newArray[i] = array[i]; 
		}
		
		int i = 0; 
		int j = halfway;
		
		int currentIndex = 0; 
		
		while(i < halfway && j < end) {
			int compare = comparator.compare(newArray[i], newArray[j]); 
	
			if(compare == -1) {
				array[currentIndex] = newArray[i]; 
				i++; 
				currentIndex++; 
			}
			else if(compare == 1){
				array[currentIndex] = newArray[j]; 
				j++; 
				currentIndex++; 
			}
			else {
				array[currentIndex] = newArray[i]; 
				array[currentIndex + 1] = newArray[j]; 
				i++; 
				j++; 
				currentIndex += 2; 
			}
			
		}
		
		while(i < halfway) {
			array[currentIndex] = newArray[i]; 
			i++; 
			currentIndex++; 
		}
		
		while(j < end) {
			array[currentIndex] = newArray[j]; 
			j++; 
			currentIndex++; 
		}
		
		return array; 
	
	}
	
	
	public void swap(T[] array, int i, int j) {
		T placeholder = array[i]; 
		array[i] = array[j]; 
		array[j] = placeholder; 
	}
	
	public static void main(String[] args) {
		MergeSort<Integer> mergeSort = new MergeSort<Integer>(); 
		
		Integer[] array = new Integer[21]; 
		
		Random rand = new Random(); 
		
		for(int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(20); 
		}
		
		System.out.println(Arrays.toString(array)); 
		
		System.out.println(Arrays.toString(mergeSort.mergeSort(array, 0, array.length)));
	}
	
	
	

}

class GenericComparator<T extends Comparable<T>> implements Comparator<T> {
	public int compare(T a, T b) {
		return a.compareTo(b);
	}
}
