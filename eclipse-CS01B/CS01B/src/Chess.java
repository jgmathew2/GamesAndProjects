

import processing.core.PApplet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



class ChessGridBox extends GridBox {
	int position;
	boolean isBlack;
	boolean isWhitePiece;
	ChessGridBox() {
		super(100);
		
	}
	ChessGridBox(boolean isBlack) {
		super(100);
		
	}
	ChessGridBox(String url) {
		super(url, 100);
	}
	public ChessGridBox chooseColor(boolean isBlack) {
		if(isBlack == true) {
			return new ChessGridBox();
		}
		else {
			return new ChessGridBox("/Users/johan/Desktop/WhiteBox.png");
		}
	}
}
class Piece extends ChessGridBox {
	Piece(String url) {
		super(url);
	}
	Piece() {
		super();
	}
}
class Knight extends Piece {

	Knight(String url) {
		super(url);
	}
	Knight() {
		super();
	}
	Knight chooseBackgroundColor(boolean isBlack) {
		if(isBlack) {
			return new Knight("/Users/johan/Desktop/WhiteKnightOnBlack.png");
		}
		else {
			return new Knight("/Users/johan/Desktop/WhiteKnightOnWhite.png");
		}
	}
	
}
class Bishop extends Piece {
	Bishop(String url) {
		super(url);
	}
	Bishop() {
		super();
	}
	Bishop chooseBackgroundColor(boolean isBlack) {
		if(isBlack) {
			return new Bishop("/Users/johan/Desktop/WhiteBishopOnBlack.png");
		}
		else {
			return new Bishop("/Users/johan/Desktop/WhiteBishopOnWhite.png");
		}
	}
}
class Pawn extends Piece {
	Pawn(String url) {
		super(url);
	}
	Pawn() {
		super();
	}
	Pawn chooseBackgroundColor(boolean isBlack) {
		if(isBlack) {
			return new Pawn("/Users/johan/Desktop/WhitePawnOnBlack.png");
		}
		else {
			return new Pawn("/Users/johan/Desktop/WhitePawnOnWhite.png");
		}
	}
	
}
class BlackPawn extends Pawn {
	BlackPawn(String url) {
		super(url);
	}
	BlackPawn() {
		super();
	}
	@Override
	BlackPawn chooseBackgroundColor(boolean isBlack) {
		if(isBlack) {
			return new BlackPawn("/Users/johan/Desktop/BlackPawnOnBlack.png");
		}
		else {
			return new BlackPawn("/Users/johan/Desktop/BlackPawnOnWhite.png");
		}
	}
}
class King extends Piece {
	King(String url) {
		super(url);
	}
	King() {
		super();
	}
	King chooseBackgroundColor(boolean isBlack) {
		if(isBlack) {
			return new King("/Users/johan/Desktop/WhiteKingOnBlack.png");
		}
		else {
			return new King("/Users/johan/Desktop/WhiteKingOnWhite.png");
		}
	}
}
class Queen extends Piece {
	Queen(String url) {
		super(url);
	}
	Queen() {
		super();
	}
	Queen chooseBackgroundColor(boolean isBlack) {
		if(isBlack) {
			return new Queen("/Users/johan/Desktop/WhiteQueenOnBlack.png");
		}
		else {
			return new Queen("/Users/johan/Desktop/WhiteQueenOnWhite.png");
		}
	}
	
}
class Rook extends Piece  {
	Rook(String url) {
		super(url);
	}
	Rook() {
		super();
	}
	Rook chooseBackgroundColor(boolean isBlack) {
		if(isBlack) {
			return new Rook("/Users/johan/Desktop/WhiteRookOnBlack.png");
		}
		else {
			return new Rook("/Users/johan/Desktop/WhiteRookOnWhite.png");
		}
	}
	
}
public class Chess extends PApplet {
	
	static ChessGridBox[][] board;
	public void setup() {
		Sprite.init(this);
			   	
		background(243, 243, 243);
		size(1450, 800);
		board = new ChessGridBox[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				ChessGridBox gridbox = new ChessGridBox();
				board[i][j] = new ChessGridBox();
			}
		}
		for(int p = 0; p < 8; p++) {
			Pawn pawn = new Pawn();
			board[6][p] = pawn;
		}
		Rook whiteRook = new Rook();
		board[7][0] = whiteRook;
		Rook whiteRook2 = new Rook();
		board[7][7] = whiteRook2;
		Knight whiteKnight = new Knight();
		board[7][1] = whiteKnight;
		Knight whiteKnight2 = new Knight();
		board[7][6] = whiteKnight2;
		Bishop whiteBishop = new Bishop();
		board[7][2] = whiteBishop;
		Bishop whiteBishop2 = new Bishop();
		board[7][5] = whiteBishop2;
		King whiteKing = new King();
		board[7][4] = whiteKing;
		Queen whiteQueen = new Queen();
		board[7][3] = whiteQueen;
		for(int p = 0; p < 8; p++) {
			BlackPawn blackPawn = new BlackPawn();
			board[1][p] = blackPawn;
		}
		
	


	}
	public static void displayPieces() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				ChessGridBox gridbox = board[i][j];
				if(i % 2 == 1) {
					if(j % 2 == 1) {
						if(gridbox instanceof Pawn) {
							Pawn pawn;
							if(gridbox instanceof BlackPawn) {
								pawn = (BlackPawn) gridbox;
							}
							else {
								pawn = (Pawn) gridbox;
								
							}
							pawn = pawn.chooseBackgroundColor(false);
							gridbox = pawn;
						}
						else if(gridbox instanceof Rook) {
							Rook rook = new Rook();
							rook = rook.chooseBackgroundColor(false);
							gridbox = rook;
						}
						else if(gridbox instanceof Knight) {
							Knight knight = new Knight();
							knight = knight.chooseBackgroundColor(false);
							gridbox = knight;
						}
						else if(gridbox instanceof Bishop) {
							Bishop bishop = new Bishop();
							bishop = bishop.chooseBackgroundColor(false);
							gridbox = bishop;
						}
						else if(gridbox instanceof King) {
							King king = new King();
							king = king.chooseBackgroundColor(false);
							gridbox = king;
						}
						else if(gridbox instanceof Queen) {
							Queen queen = new Queen();
							queen = queen.chooseBackgroundColor(false);
							gridbox = queen;
						}
						else gridbox = gridbox.chooseColor(false);
					}
					else {
						if(gridbox instanceof Pawn) {
							Pawn pawn;
							if(gridbox instanceof BlackPawn) {
								pawn = (BlackPawn) gridbox;
							}
							else {
								pawn = (Pawn) gridbox;
							}
							pawn = pawn.chooseBackgroundColor(true);
							gridbox = pawn;
						}
						else if(gridbox instanceof Rook) {
							Rook rook = new Rook();
							rook = rook.chooseBackgroundColor(true);
							gridbox = rook;
						}
						else if(gridbox instanceof Knight) {
							Knight knight = new Knight();
							knight = knight.chooseBackgroundColor(true);
							gridbox = knight;
						}
						else if(gridbox instanceof Bishop) {
							Bishop bishop = new Bishop();
							bishop = bishop.chooseBackgroundColor(true);
							gridbox = bishop;
						}
						else if(gridbox instanceof King) {
							King king = new King();
							king = king.chooseBackgroundColor(true);
							gridbox = king;
						}
						else if(gridbox instanceof Queen) {
							Queen queen = new Queen();
							queen = queen.chooseBackgroundColor(true);
							gridbox = queen;
						}
						else gridbox = gridbox.chooseColor(true);
					}
					
				}
				else {
					if(j % 2 == 1) {
						if(gridbox instanceof Pawn) {
							Pawn pawn;
							if(gridbox instanceof BlackPawn) {
								pawn = (BlackPawn) gridbox;
							}
							else {
								pawn = (Pawn) gridbox;
							}
							pawn = pawn.chooseBackgroundColor(true);
							gridbox = pawn;
						}
						else if(gridbox instanceof Rook) {
							Rook rook = new Rook();
							rook = rook.chooseBackgroundColor(true);
							gridbox = rook;
						}
						else if(gridbox instanceof Knight) {
							Knight knight = new Knight();
							knight = knight.chooseBackgroundColor(true);
							gridbox = knight;
						}
						else if(gridbox instanceof Bishop) {
							Bishop bishop = new Bishop();
							bishop = bishop.chooseBackgroundColor(true);
							gridbox = bishop;
						}
						else if(gridbox instanceof King) {
							King king = new King();
							king = king.chooseBackgroundColor(true);
							gridbox = king;
						}
						else if(gridbox instanceof Queen) {
							Queen queen = new Queen();
							queen = queen.chooseBackgroundColor(true);
							gridbox = queen;
						}
						else gridbox = gridbox.chooseColor(true);
					}
					else {
						if(gridbox instanceof Pawn) {
							Pawn pawn;
							if(gridbox instanceof BlackPawn) {
								pawn = (BlackPawn) gridbox;
							}
							else {
								pawn = (Pawn) gridbox;
							}
							pawn = pawn.chooseBackgroundColor(false);
							gridbox = pawn;
						}
						else if(gridbox instanceof Rook) {
							Rook rook = new Rook();
							rook = rook.chooseBackgroundColor(false);
							gridbox = rook;
						}
						else if(gridbox instanceof Knight) {
							Knight knight = new Knight();
							knight = knight.chooseBackgroundColor(false);
							gridbox = knight;
						}
						else if(gridbox instanceof Bishop) {
							Bishop bishop = new Bishop();
							bishop = bishop.chooseBackgroundColor(false);
							gridbox = bishop;
						}
						else if(gridbox instanceof King) {
							King king = new King();
							king = king.chooseBackgroundColor(false);
							gridbox = king;
						}
						else if(gridbox instanceof Queen) {
							Queen queen = new Queen();
							queen = queen.chooseBackgroundColor(false);
							gridbox = queen;
						}
						else gridbox = gridbox.chooseColor(false);
					}
				}
				
				
				board[i][j] = gridbox;
				gridbox.moveToPoint(375 + 100 * j, 50 + 100 * i);
				gridbox.display();
							
		    }
	    }
	}
	public void draw() {
		background(0, 0, 243);
		final PlayableArea area = new PlayableArea();
		area.moveToPoint(725, 400);
		area.display();
		Chess.displayPieces();
		
		JFrame frame = new JFrame("Input White Turn");
		JPanel panel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField textField = new JTextField("Piece Current Position");
		JTextField textField2 = new JTextField("Destination");
		JLabel label = new JLabel("To");
		JLabel possiblyIllegal = new JLabel("");
		JButton button = new JButton("Submit");
		panel.add(textField);
		panel.add(label);
		panel.add(textField2);
		panel.add(button);
		panel.add(possiblyIllegal);
	
	
		
		frame.add(panel);
	
		frame.setSize(300, 300);	
		frame.setVisible(true);
		String currentPiecePosition = "";
		String destination = "";
		
		AlertSubmitSynchronizer.getInstance().setAlertSubmitDone(false);
		SimpleActionListener listener = new SimpleActionListener(currentPiecePosition, destination, textField, textField2, frame);
		button.addActionListener(listener);
		synchronized(AlertSubmitSynchronizer.getInstance().getAlertSubmitLock()) {
			while(!AlertSubmitSynchronizer.getInstance().isAlertSubmitDone()) {
				try {
					AlertSubmitSynchronizer.getInstance().getAlertSubmitLock().wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
		currentPiecePosition = SimpleActionListener.pieceCurrentPosition;
		destination = SimpleActionListener.destination;
		ChessGridBox selected = new ChessGridBox();
		currentPiecePosition.trim();
		int currentColumn = 0;
		int currentRow = 0;
		if(currentPiecePosition.length() == 2 && destination.length() == 2) {
			char column = currentPiecePosition.charAt(0);
			String fakeRow = currentPiecePosition.substring(1); 
			
			currentRow = Integer.parseInt(fakeRow);		
			currentColumn = Character.getNumericValue(column);
			selected = board[8 - currentRow][currentColumn - 10];
			board[8 - currentRow][currentColumn - 10] = new ChessGridBox();
		
			
			
		}
		boolean legal = true;
		if(selected instanceof Piece) {
			
			if(destination.length() == 2 && currentPiecePosition.length() == 2) {
				char column = destination.charAt(0);
				String fakeRow = destination.substring(1); 
				int row = 0;
				try {
					row = Integer.parseInt(fakeRow);
				}
				catch(Exception e) {}
				int actualColumn = Character.getNumericValue(column);
				
				if(selected instanceof Knight) {
					legal = false;
					if(row == currentRow + 2 && actualColumn == currentColumn + 1 || row == currentRow + 2 && actualColumn == currentColumn - 1 ||
							row == currentRow - 2 && actualColumn == currentColumn + 1 || row == currentRow - 2 && actualColumn == currentColumn - 1 ||
							row == currentRow - 1 && actualColumn == currentColumn + 2 || row == currentRow - 1 && actualColumn == currentColumn - 2 ||
							row == currentRow + 1 && actualColumn == currentColumn + 2 || row == currentRow + 1 && actualColumn == currentColumn - 2 ) legal = true;
						
				}
				if(selected instanceof Rook) {
					legal = false;
					if(actualColumn == currentColumn || currentRow ==row ) {
						legal = true;
						for(int i = 0; i < actualColumn - 11; i++) {
							if(board[8 - row][i] instanceof Piece) legal = false;
						}
						for(int j = 0; j < row - 1; j++) {
							if(board[7 + j - row][actualColumn - 10] instanceof  Piece) { legal = false;
								
							}
						}
						
					}
				}
				if(selected instanceof King) {
					legal = false;
					if(currentColumn == actualColumn) {
						if(currentRow == row + 1 || currentRow == row - 1) legal = true;
					}
					if(row == currentRow) {	
						if(currentColumn == actualColumn - 1 || currentColumn == actualColumn + 1) legal = true;
					}
					if((currentColumn == actualColumn - 1 || currentColumn == actualColumn + 1) && (currentRow == row - 1 || currentRow == row + 1)) legal = true ;
				}
					
				
				if(selected instanceof Pawn) {
					 if(selected instanceof BlackPawn) {
						 if(currentRow != row + 1 || actualColumn != currentColumn || board[8 - row][actualColumn - 10] instanceof Piece)  {
							 legal = false;
							 if(currentRow == 7 && currentRow == row + 2) {
								 legal = true;
							 }
							 if(currentRow == row + 1 && (currentColumn == actualColumn + 1 || currentColumn == actualColumn - 1) && board[8 - row][actualColumn - 10] instanceof Piece) {
								 legal = true;
							 }
							 if(currentRow == row + 1 && (currentColumn == actualColumn + 1 || currentColumn == actualColumn - 1) && 
									 board[7 - row][actualColumn - 10] instanceof Piece
									 && currentRow == 4 && board[8 - row][actualColumn - 10] instanceof Piece == false) {
								 legal = true;
								 board[7 - row][actualColumn - 10] = new ChessGridBox();
							 }
						 }
						 if(row == 1 && legal == true) {
							 selected = new Queen();
						 }
						 
						 
						 
					 }
					 else {
						 if(currentRow != row - 1 || actualColumn != currentColumn) {
							 legal = false;
							 if(currentRow == 2 && currentRow == row - 2) {
								 legal = true;
							 }
							 if(currentRow == row - 1 && (currentColumn == actualColumn + 1 || currentColumn == actualColumn - 1) && board[8 - row][actualColumn - 10] instanceof Piece) {
								 legal = true;
							 }
							 if(currentRow == row - 1 && (currentColumn == actualColumn + 1 || currentColumn == actualColumn - 1) && 
									 board[9 - row][actualColumn - 10] instanceof Piece
									 && currentRow == 5 && board[8 - row][actualColumn - 10] instanceof Piece == false) {
								 legal = true;
								 board[9 - row][actualColumn - 10] = new ChessGridBox();
							 }
						 }
						 if(row == 8 && legal == true) {
							 selected = new Queen();
						 }
						 
					 }
				}
				
				
				
				
				
				if(legal == true) {
					board[8 - row][actualColumn - 10] = selected;
				}
				
				else {
					possiblyIllegal.setText("Illegal Move");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					board[8 - currentRow][currentColumn - 10] = selected;
					
				}
				
				
				
			
			}
			
			
		
			
		}
		SimpleActionListener.pieceCurrentPosition = "";
		SimpleActionListener.destination = "";	
		Chess.displayPieces();
		
		
	
	}
	
}


