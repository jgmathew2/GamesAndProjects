
import java.util.Arrays;

public class Utils {

	public static void main(String[] args) {
		Utils.println(new int[]{1, 2, 3}, "hello World", new String[][]{{"Hi"}});

	}
	static void println(Object...values) {
		for(Object v: values) {
			if(v instanceof int[]) {
		         int[] array = (int[])v;
		         System.out.println(Arrays.toString(array));
		    }
			else if(v instanceof double[]) {
				System.out.println(Arrays.toString((double[])v));
			}
			else if(v instanceof Object[]) {
				Object[] array = (Object[])v;
				for(Object vv : array) {
					println(vv);
				}

			}
			else {
				System.out.println(v);
			}

		}
	}


}

