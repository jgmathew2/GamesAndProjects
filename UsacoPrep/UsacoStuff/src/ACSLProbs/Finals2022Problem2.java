package ACSLProbs;

public class Finals2022Problem2 {
	public static void main(String[] args) { 
		
	}
	static int getFace(char c) {
		if(c== 'R') return 0; 
		if(c == 'O') return 1; 
		if(c == 'Y') return 2; 
		if(c == 'P') return 3; 
		if(c == 'B') return 4; 
		if(c == 'G') return 5; 
		
		return -1; 
		
	}
	static char getCFace(int n) {
		if( n == 0) return 'R'; 
		if(n == 1) return 'O'; 
		if(n == 2) return 'Y'; 
		if(n == 3) return 'P'; 
		if(n == 4) return 'B'; 
		if(n == 5) return 'G'; 
		
		return 'A'; 
		
	}
	public static String rotateCube(String start, String moves) {

		
		int startFace = getFace(start.charAt(0)); 
		int startSpot = start.charAt(1) - '0'; 
		
	 
		
		int[] row1 = new int[] {30, 31, 32, 56, 53, 50, 18, 17, 16, 42, 45, 48}; 
		int[] row2 = new int[] {33, 34 ,35, 57, 54, 51, 15, 14, 13, 41, 44, 47}; 
		int[] row3 = new int[] {36, 37, 38, 58, 55, 52, 12, 11, 10, 40, 43, 46}; 
		int[] col1 = new int[] {30, 33, 36, 28, 25, 22, 10, 13, 16, 00, 03, 06}; 
		int[] col2 = new int[] {31, 34, 37, 27, 24, 21, 11, 14, 17, 01, 04, 07}; 
		int[] col3 = new int[] {32, 35, 38, 26, 23, 20, 12, 15, 18, 02, 05, 8};
		int[] oth1 = new int[] {06, 07, 8, 56, 57, 58, 26, 27, 28, 46, 47, 48}; 
		int[] oth2 = new int[] {3, 4, 5, 53, 54, 55, 23, 24, 25, 43, 44, 45}; 
		int[] oth3 = new int[] {0, 1, 2, 50, 51, 52, 20, 21, 22, 40, 41, 42}; 
		
		
		
		String[] commands = moves.split(" "); 
		
		for(int i = 0; i < commands.length; i++) {
			int rotation = commands[i].charAt(2) - '0'; 
			boolean rowTurn = (commands[i].charAt(0) == 'R'); 
			boolean clockwise = (commands[i].charAt(1) == 'C');
			int row = getRow(startSpot); 
			int col = getCol(startSpot); 
			if(startFace == 0) {
				if(clockwise) {
					if(rowTurn) {
						if(row == 0) shiftArrayF(oth3, rotation); 
						if(row == 1) shiftArrayF(oth2, rotation); 
						if(row == 2) shiftArrayF(oth1, rotation); 
					}
					else {
						if(col == 0) shiftArrayR(col1, rotation); 
						if(col == 1) shiftArrayR(col2, rotation); 
						if(col == 2) shiftArrayR(col3, rotation); 
					}
				}
				else {
					if(rowTurn) {
						if(row == 0) shiftArrayR(oth3, rotation); 
						if(row == 1) shiftArrayR(oth2, rotation); 
						if(row == 2) shiftArrayR(oth1, rotation); 
					}
					else {
						if(col == 0) shiftArrayF(col1, rotation); 
						if(col == 1) shiftArrayF(col2, rotation); 
						if(col == 2) shiftArrayF(col3, rotation); 
					}
				}
			}
			if(startFace == 2) {
				if(clockwise) {
					if(rowTurn) {
						if(row == 0) shiftArrayF(oth1, rotation); 
						if(row == 1) shiftArrayF(oth2, rotation); 
						if(row == 2) shiftArrayF(oth3, rotation); 
					}
					else {
						if(col == 0) shiftArrayR(col3, rotation); 
						if(col == 1) shiftArrayR(col2, rotation); 
						if(col == 2) shiftArrayR(col1, rotation); 
					}
				}
				else {
					if(rowTurn) {
						if(row == 0) shiftArrayR(oth1, rotation); 
						if(row == 1) shiftArrayR(oth2, rotation); 
						if(row == 2) shiftArrayR(oth3, rotation); 
					}
					else {
						if(col == 0) shiftArrayF(col3, rotation); 
						if(col == 1) shiftArrayF(col2, rotation); 
						if(col == 2) shiftArrayF(col1, rotation); 
					}
				}
			}
			if(startFace == 3) {
				if(clockwise) {
					if(rowTurn) {
						if(row == 0) shiftArrayR(row1, rotation); 
						if(row == 1) shiftArrayR(row2, rotation); 
						if(row == 2) shiftArrayR(row3, rotation); 
					}
					else {
						if(col == 0) shiftArrayR(col1, rotation); 
						if(col == 1) shiftArrayR(col2, rotation); 
						if(col == 2) shiftArrayR(col3, rotation); 
					}
				}
				else {
					if(rowTurn) {
						if(row == 0) shiftArrayF(row1, rotation); 
						if(row == 1) shiftArrayF(row2, rotation); 
						if(row == 2) shiftArrayF(row3, rotation); 
					}
					else {
						if(col == 1) shiftArrayF(col1, rotation); 
						if(col == 2) shiftArrayF(col2, rotation); 
						if(col == 3) shiftArrayF(col3, rotation); 
					}
				}
			}
			if(startFace == 1) {
				if(clockwise) {
					if(rowTurn) {
						if(row == 0) shiftArrayR(row1, rotation); 
						if(row == 1) shiftArrayR(row2, rotation); 
						if(row == 2) shiftArrayR(row3, rotation); 
					}
					else {
						if(col == 0) shiftArrayR(col3, rotation); 
						if(col == 1) shiftArrayR(col2, rotation); 
						if(col == 2) shiftArrayR(col1, rotation); 
					}
				}
				else {
					if(rowTurn) {
						if(row == 0) shiftArrayF(row1, rotation); 
						if(row == 1) shiftArrayF(row2, rotation); 
						if(row == 2) shiftArrayF(row3, rotation); 
					}
					else {
						if(col == 0) shiftArrayF(col3, rotation); 
						if(col == 1) shiftArrayF(col2, rotation); 
						if(col == 2) shiftArrayF(col1, rotation); 
					}
				}
			}
			if(startFace == 5) {
				if(clockwise) {
					if(rowTurn) {
						if(row == 0) shiftArrayR(row1, rotation); 
						if(row == 1) shiftArrayR(row2, rotation); 
						if(row == 2) shiftArrayR(row3, rotation); 
					}
					else {
						if(col == 0) shiftArrayF(oth1, rotation); 
						if(col == 1) shiftArrayF(oth2, rotation); 
						if(col == 2) shiftArrayF(oth3, rotation); 
					}
				}
				else {
					if(rowTurn) {
						if(row == 0) shiftArrayF(row1, rotation); 
						if(row == 1) shiftArrayF(row2, rotation); 
						if(row == 2) shiftArrayF(row3, rotation); 
					}
					else {
						if(col == 0) shiftArrayR(oth1, rotation); 
						if(col == 1) shiftArrayR(oth2, rotation); 
						if(col == 2) shiftArrayR(oth3, rotation);  
					}
				}
			}
			if(startFace == 4) {
				if(clockwise) {
					if(rowTurn) {
						if(row == 0) shiftArrayR(row1, rotation); 
						if(row == 1) shiftArrayR(row2, rotation); 
						if(row == 2) shiftArrayR(row3, rotation); 
					}
					else {
						if(col == 0) shiftArrayF(oth3, rotation); 
						if(col == 1) shiftArrayF(oth2, rotation); 
						if(col == 2) shiftArrayF(oth1, rotation); 
					}
				}
				else {
					if(rowTurn) {
						if(row == 0) shiftArrayF(row1, rotation); 
						if(row == 1) shiftArrayF(row2, rotation); 
						if(row == 2) shiftArrayF(row3, rotation); 
					}
					else {
						if(col == 0) shiftArrayR(oth3, rotation); 
						if(col == 1) shiftArrayR(oth2, rotation); 
						if(col == 2) shiftArrayR(oth1, rotation);  
					}
				}
			}
				
			
			
		}
		String result = ""; 
		if(startFace == 0) {
			for(int i = 0; i < 3; i++) { 
				int spot = oth3[i]; 
				
				result += ("" + getCFace(spot / 10) + spot % 10); 
			}
			for(int i = 0; i < 3; i++) { 
				int spot = oth2[i]; 
				
				result += ("" + getCFace(spot / 10) + spot % 10); 
			}
			for(int i = 0; i < 3; i++) { 
				int spot = oth1[i]; 
				
				result += ("" + getCFace(spot / 10) + spot % 10); 
			}
		}
		if(startFace == 1) {
			for(int i = 7; i < 9; i++) { 
				int spot = row1[i]; 
				
				result += ("" + getCFace(spot / 10) + spot % 10); 
			}
			for(int i = 7; i < 9; i++) { 
				int spot = row2[i]; 
				
				result += ("" + getCFace(spot / 10) + spot % 10); 
			}
			for(int i = 7; i < 9; i++) { 
				int spot = row3[i]; 
				
				result += ("" + getCFace(spot / 10) + spot % 10); 
			}
		}
		if(startFace == 2) {
			for(int i = 7; i < 9; i++) { 
				int spot = oth3[i]; 
				
				result += ("" + getCFace(spot / 10) + spot % 10); 
			}
			for(int i = 7; i < 9; i++) { 
				int spot = oth2[i]; 
				
				result += ("" + getCFace(spot / 10) + spot % 10); 
			}
			for(int i = 7; i < 9; i++) { 
				int spot = oth1[i]; 
				
				result += ("" + getCFace(spot / 10) + spot % 10); 
			}
		}
		if(startFace == 1) {
			for(int i = 0; i < 3; i++) { 
				int spot = row1[i]; 
				
				result += ("" + getCFace(spot / 10) + spot % 10); 
			}
			for(int i = 0; i < 3; i++) { 
				int spot = row2[i]; 
				
				result += ("" + getCFace(spot / 10) + spot % 10); 
			}
			for(int i = 0; i < 3; i++) { 
				int spot = row3[i]; 
				
				result += ("" + getCFace(spot / 10) + spot % 10); 
			}
		}
		
		return result; 
	
		
		
		
		
		
		
	}
	
	static void shiftArrayF(int[] array, int shift) { 
		
		
		for(int i = 0; i < shift; i++) {
			int[] temp = new int[array.length]; 
			
			for(int j = 0; j < array.length; j++) {
				temp[j] = array[j]; 
			}
			array[0] = temp[array.length - 1]; 
		
			for(int j = 0; j < array.length; j++) {
				array[j + 1] = temp[j]; 
			}
		}
	}
	static void shiftArrayR(int[] array, int shift) { 
		
		
		for(int i = 0; i < shift; i++) {
			int[] temp = new int[array.length]; 
			
			for(int j = 0; j < array.length; j++) {
				temp[j] = array[j]; 
			}
			array[array.length - 1] = temp[0]; 
		
			for(int j = array.length - 1; j > 0; j--) {
				array[j - 1] = temp[j]; 
				
			}
		}
	}
	
	
	
	static int getRow(int n) {
		if( n < 3) return 0; 
		else if(n < 6) return 1; 
		else return 2; 
	}
	
	static int getCol(int n) {
		if(n == 1 || n == 4 || n == 7) return 1; 
		else if(n == 0 || n == 3 || n == 6) return 0; 
		else return 2; 
	}


    

}
