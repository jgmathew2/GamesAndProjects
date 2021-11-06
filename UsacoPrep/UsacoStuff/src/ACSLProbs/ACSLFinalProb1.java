package ACSLProbs;
/**
* @author Johan
 * @version Creation time: May 29, 2021 11:22:22 AM
 * Class Description
*/
public class ACSLFinalProb1 {
	
	public static void main(String[] args) {
		System.out.println(find_king_status("Ra1 Pb5 Pc5 Rc3 Bd6 Qg4 Kb7")); 
	}
	
	public static String find_king_status(String pieces) {
        int[][][] piecesCoord = new int[6][8][2]; 
        
        for(int i = 0; i < 6; i++) {
        	for(int j = 0; j < 8; j++) {
        		piecesCoord[i][j] =null; 
        	}
        }
        
        String[] piecesArray = pieces.split(" ");
        
        for(int i = 0; i < piecesArray.length; i++) {
            char[] piece = piecesArray[i].toCharArray();
            
            int row = piece[2] - '1' + 1; 
            int col = piece[1] - 'a' + 1; 
            
            if(piece[0] == 'K') {
                piecesCoord[0][0] = new int[]{col, row}; 
            }
            
            if(piece[0] == 'P') {
                int j = 0; 
                while(j < 8) {
                    if(piecesCoord[1][j] != null) j++;
                    else break; 
                }
                
                piecesCoord[1][j] = new int[]{col, row};
            }
            
            if(piece[0] == 'N') {
                if(piecesCoord[2][0] != null) {
                    piecesCoord[2][1] = new int[]{col, row};
                }
                else piecesCoord[2][0] = new int[]{col, row};
            } 
            if(piece[0] == 'B') {
                if(piecesCoord[3][0] != null) {
                    piecesCoord[3][1] = new int[]{col, row};
                }
                else piecesCoord[3][0] = new int[]{col, row};
            }
            if(piece[0] == 'R') {
                if(piecesCoord[4][0] != null) {
                    piecesCoord[4][1] = new int[]{col, row};
                }
                else piecesCoord[4][0] = new int[]{col, row};
            }
            if(piece[0] == 'Q') {
                piecesCoord[5][0] = new int[]{col, row}; 
            }
        }
        int kingRow = piecesCoord[0][0][1]; 
        int kingCol = piecesCoord[0][0][0];
        boolean safe = true; 
        
        if(inCheck(piecesCoord, kingCol, kingRow) == 1) safe = false; 
        
        boolean escape = false; 
        
        if(inCheck(piecesCoord, kingCol + 1, kingRow) == 0) escape = true; 
        if(inCheck(piecesCoord, kingCol - 1, kingRow) == 0) escape = true; 
        if(inCheck(piecesCoord, kingCol, kingRow + 1) == 0) escape = true; 
        if(inCheck(piecesCoord, kingCol, kingRow - 1) == 0) escape = true;
        if(inCheck(piecesCoord, kingCol + 1, kingRow + 1) == 0) escape = true; 
        if(inCheck(piecesCoord, kingCol + 1, kingRow - 1) == 0) escape = true; 
        if(inCheck(piecesCoord, kingCol - 1, kingRow - 1) == 0) escape = true; 
        if(inCheck(piecesCoord, kingCol - 1, kingRow + 1) == 0) escape = true;
        
        if(escape && safe) return "SAFE"; 
        if(!escape && safe) return "STALEMATE"; 
        if(escape && !safe) return "CHECK"; 
        if(!escape && !safe) return "CHECKMATE"; 
        
        return ""; 
     
        
        
    }
    
    public static int inCheck(int[][][] piecesCoord, int c, int r) {
        //inCheck = 1
        //nonInCheck = 0 
        //neither = 2; 
        if(c > 8 || c < 1 || r > 8 || r < 1) return 2; 
        
        for(int i = 0; i < 8; i++) {
        	if(piecesCoord[1][i] == null) break; 
            if(piecesCoord[1][i][1] == r - 1 && (piecesCoord[1][i][0] == c - 1 || piecesCoord[1][i][0] == c + 1)) return 1; 
        }
        
        int[][] board = new int[9][9]; 
        
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 8; j++) {
            	if(piecesCoord[i][j] == null) continue;
                board[piecesCoord[i][j][0]][piecesCoord[i][j][1]] = i + 1;  
            }
        }
        
        int copyC = c - 1; 
        int copyR = r; 
        
        while(copyC > 0) {
            if(board[copyC][copyR] == 5 || board[copyC][copyR] == 6) return 1; 
            else if(board[copyC][copyR] != 0 && board[copyC][copyR] != 1) break;  
            copyC--; 
        }
        
        copyC = c + 1; 
        
        while(copyC < 9 ) {
            if(board[copyC][copyR] == 5 || board[copyC][copyR] == 6) return 1; 
            else if(board[copyC][copyR] != 0 && board[copyC][copyR] != 1) break;  
            copyC++; 
        }
        
        copyC = c; 
        copyR = r - 1; 
        
        while(copyR > 0) {
            if(board[copyC][copyR] == 5 || board[copyC][copyR] == 6) return 1; 
            else if(board[copyC][copyR] != 0 && board[copyC][copyR] != 1) break;  
            copyR--; 
        }
        
        copyR = r + 1; 
        
        while(copyR < 9 ) {
            if(board[copyC][copyR] == 5 || board[copyC][copyR] == 6) return 1; 
            else if(board[copyC][copyR] != 0 && board[copyC][copyR] != 1) break;  
            copyR++; 
        }
        
        copyR = r + 1; 
        copyC = c + 1; 
        
        while(copyR < 9 && copyC < 9) {
            if(board[copyC][copyR] == 4 || board[copyC][copyR] == 6) return 1; 
            else if(board[copyC][copyR] != 0 && board[copyC][copyR] != 1) break;  
            copyR++; 
            copyC++; 
        }
        copyR = r - 1; 
        copyC = c - 1; 
        
        while(copyR > 0 && copyC > 0) {
            if(board[copyC][copyR] == 4 || board[copyC][copyR] == 6) return 1; 
            else if(board[copyC][copyR] != 0 && board[copyC][copyR] != 1) break;  
            copyR--; 
            copyC--; 
        }
        
        copyR = r + 1; 
        copyC = c - 1; 
        
        while(copyR < 9 && copyC > 0) {
            if(board[copyC][copyR] == 4 || board[copyC][copyR] == 6) return 1; 
            else if(board[copyC][copyR] != 0 && board[copyC][copyR] != 1) break;  
            copyR++; 
            copyC--; 
        }
        
        copyR = r - 1; 
        copyC = c + 1; 
        
        while(copyR > 0 && copyC < 9) {
            if(board[copyC][copyR] == 4 || board[copyC][copyR] == 6) return 1; 
            else if(board[copyC][copyR] != 0 && board[copyC][copyR] != 1) break;  
            copyR--; 
            copyC++; 
        }
        
        return 2; 
        
    }

}
