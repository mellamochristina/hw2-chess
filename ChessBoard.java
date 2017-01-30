import java.util.LinkedList;

public class ChessBoard {
	int boardSize;
	LinkedList<ChessPiece> pieces = new LinkedList<ChessPiece>();
	
	ChessBoard (int boardSize){
		this.boardSize = boardSize;
	}
	
	//Add chess piece to linked list
	void addPiece(ChessPiece piece) {
		pieces.add(piece);
	}
	
	//Makes sure that no pieces are placed in the same square 
	boolean validatePieces () {
		for (int i = 0; i < pieces.size(); i++) {
			ChessPiece currentPiece = pieces.get(i);
			for (int j = 0; j < pieces.size(); j++) {
				//Makes sure that you aren't comparing the same pieces 
				if (j != i) {
					ChessPiece nextPiece = pieces.get(j);
					if (currentPiece.col == nextPiece.col && currentPiece.row == nextPiece.row) {
						return false;
					}
				}
			}
		}
		return true;
	}
	// if there is not exactly one black and one white king, return false
	boolean validateKings () {
		boolean whiteKing = false;
		int white = 0;
		boolean blackKing = false;
		int black = 0;
		for (int i = 0; i < pieces.size(); i ++ ) {
			ChessPiece c = pieces.get(i);
			if (c.piece == 'k') {
				whiteKing = true;
				white++;
			}
			if (c.piece == 'K') {
				blackKing = true;
				black++;
			}
		}
		if (whiteKing && blackKing) {
			if (white == 1 && black == 1) {
				return true;
			}
		}
		return false;
	}

	
	//Returns a string of the type of chess piece from coordinates of 2nd line of input
	//Returns "-" if no piece is found at query square
	String querySquare(int col, int row) {
		for (ChessPiece piece : pieces) {
			if (piece.col == col && piece.row == row) {
				return Character.toString(piece.piece);
			}
		}
		return "-";
	}
	
	//Returns string of attacking pieces' type, col, row to analysis.txt
	String determineAttackPieces() {
		return "-";
	}
}
