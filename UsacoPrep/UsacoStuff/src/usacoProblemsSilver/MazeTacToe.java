package usacoProblemsSilver;
/**
* @author Johan
 * @version Creation time: Apr 4, 2021 2:46:50 PM
 * Class Description
*/
import java.util.*; 


public class MazeTacToe {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in); 
		//Scanner in = new Scanner(new File("tictactoe.in"));
		int N = in.nextInt(); 
		in.nextLine(); 
		int[][] grid = new int[N][N]; 
		
		ArrayList<Path> solutions = new ArrayList<Path>(); 
		

		
		for(int i = 0; i < N; i++) {
			String row = in.nextLine(); 
			
			char[] rowChars = row.toCharArray(); 
			
			int counter = 0; 
			
			for(int j = 0; j < rowChars.length; j+=3) {
				if(rowChars[j] == '#') grid[i][counter] = -1; 
				else if(rowChars[j] == '.') grid[i][counter] = 0; 
				else if(rowChars[j] == 'B') grid[i][counter] = -2; 
				else {
					int order = 0; 
					if(rowChars[j] == 'O') order += 600; 
					else if(rowChars[j] == 'M') order += 500; 
					
					order += (rowChars[j + 1] - '0') * 10; 
					
					order += (rowChars[j + 2] - '0'); 
					
					grid[i][counter] = order; 
				}
				
				counter++; 
			}
		}
		
		in.close(); 
		
		ArrayDeque<Path> queue = new ArrayDeque<Path>(); 
		
		int[][] visited = new int[N][N]; 
		
		int startX = 0;
		int startY = 0; 
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(grid[i][j] == -2) {
					startX = i; startY = j; 
				}
			}
		}
		char[][] startboard = new char[3][3]; 
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				startboard[i][j] = ' '; 
			}
		}
		
		Path start = new Path(startX, startY, startboard); 
		
		queue.add(start); 
		
		outer : while(!queue.isEmpty()) {
			Path cell = queue.remove(); 
			int currX = cell.currX; 
			int currY = cell.currY; 
			
			visited[currX][currY]++; 
			
			if(visited[currX][currY] >= 1800) continue;  
			
			if(grid[currX][currY] > 0) {
				char letter = ' '; 
				int value = grid[currX][currY];
				if(value / 100 == 5) {
					letter = 'M'; 
					
				}
				else  {
					letter = 'O'; 
				}
				
				value %= 100; 
				
				int x = value / 10 - 1; 
				
				value %= 10; 
				
				int y = value - 1; 
				
				if(cell.board[x][y] == ' ') cell.board[x][y] = letter; 
				
				if(isSolution(cell.board)) {
					if(solutions.size() == 0) solutions.add(cell); 
					else {
						for(int i = 0; i < solutions.size(); i++) {	
							if(isCopy(solutions.get(i).board, cell.board)) continue outer; 
						}
						
						solutions.add(cell); 
					}
					
					continue; 
					
				
				
				}
				
				
				
			}
			
			if(currX > 0 && grid[currX - 1][currY] != -1) {
				char[][] board = new char[3][3]; 
				
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						board[i][j] = cell.board[i][j]; 
					}
				}
				
				queue.add(new Path(currX - 1, currY, board)); 
			}
			
			
			if(currX < N - 1 && grid[currX + 1][currY] != -1) {
				char[][] board = new char[3][3]; 
				
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						board[i][j] = cell.board[i][j]; 
					}
				}
				queue.add(new Path(currX + 1, currY, cell.board)); 
			}
			
			
			if(currY > 0 && grid[currX ][currY - 1] != -1) {
				char[][] board = new char[3][3]; 
				
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						board[i][j] = cell.board[i][j]; 
					}
				}
				queue.add(new Path(currX , currY - 1, cell.board)); 
			}
			
			
			if(currY < N - 1 && grid[currX ][currY + 1] != -1) {
				char[][] board = new char[3][3]; 
				
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						board[i][j] = cell.board[i][j]; 
					}
				}
				
				queue.add(new Path(currX , currY + 1, cell.board)); 
			}
				
			
			
			
			
			
			
		}
		
		
		int result = solutions.size(); 
		System.out.println(result); 
		
		
	}
	
	static boolean isCopy(char[][] array1, char[][] array2) {
		for(int i = 0; i < array1.length; i++) {
			for(int j = 0; j < array1[0].length; j++) {
				if(array1[i][j] != array2[i][j]) return false; 
			}
		}
		
		return true; 
	}
	
	static boolean isSolution(char[][] TTTboard) {
		for(int i = 0; i < 3; i++) {
			String row = ""; 
			String col = ""; 
			for(int j = 0; j < 3; j++) {
				row += TTTboard[i][j]; 
				col += TTTboard[j][i]; 
			}
			
			if(row.equals("MOO") || row.equals("OOM")) return true; 
			if(col.equals("MOO") || col.equals("OOM")) return true; 	
			
		}
		
		String dag1 = ""; 
		String dag2 = ""; 
		
		dag1 += TTTboard[0][0]; 
		dag1 += TTTboard[1][1]; 
		dag1 += TTTboard[2][2]; 
		dag2 += TTTboard[2][0]; 
		dag2 += TTTboard[1][1]; 
		dag2 += TTTboard[0][2]; 
		
		if(dag1.equals("MOO") || dag1.equals("OOM")) return true; 
		if(dag2.equals("MOO") || dag2.equals("OOM")) return true; 	
		
		return false; 
		
	}
	
	static class Path {
		char[][] board; 
		
		int currX; 
		int currY; 

		
		
		Path(int x, int y, char[][] board) {
			this.board = board;
			currX = x; 
			currY = y; 

		}
		
	}
	

}
