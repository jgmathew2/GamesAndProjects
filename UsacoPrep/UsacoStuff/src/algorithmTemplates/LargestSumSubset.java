package algorithmTemplates;
/**
* @author Johan
 * @version Creation time: Jan 31, 2021 1:15:28 PM
 * Class Description
*/
public class LargestSumSubset {
	
	public static void main(String[] args) {
		int[] array = new int[] {100, 10, -1, -2, 10, -1, -10};
		
		System.out.println(findSubsetSum(array)); 
		
		
		
	}
	
	static int findSubsetSum(int[] array) {
		
		int currSum = array[0]; 
		int maxSum = array[0];
		
		for(int i = 1; i < array.length; i++) {
			if(array[i] > currSum) currSum = array[i]; 
			else currSum += array[i]; 
			
			if(currSum > maxSum) maxSum = currSum; 
		}
		
		return maxSum; 
	}

}
