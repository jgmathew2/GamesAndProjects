

import java.util.Arrays;

public class Lesson1 {
	public static void main(String[] args) {
		System.out.println("Hello World");
		for(int i = 0; i < 100; i++) {
			//System.out.println(i);
		
		}
		System.out.println(sum(3,5));
		//new Keyword creates new instance of something
		int[] a = new int[]{1,2,3};
		
		int[] b = new int[] {1,2,3};
		System.out.println(a==b);
		// two instances of int[] but two different arrays saved in different places
		//a and b are not the same instance
		//== checks if two things are the same instance
		int[] c = a;
		//three int[] variables;
		//no NEW keyword, so there are only two instances.
		a[0] = 10;
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(c));
	}
	static int sum(int a, int b) {
	return a+b;
	
	}

}

