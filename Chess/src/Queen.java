import static java.lang.Math.abs;

public class Queen extends ChessPiece {

	public Queen(Player player) {
		super(player);
	}

	public String type() {
		return "Queen";
	}
	private boolean isQueenValidMove(Move move, ChessPiece[][] board){
		boolean valid = false;
		int rowDiff = move.toRow - move.fromRow;
		int colDiff = move.toColumn - move.fromColumn;
		int inc;
		//checks if queen is moving in same row/column (not diagonally)
		if(abs(rowDiff) != abs(colDiff)){
		if(abs(rowDiff) > 0){
			//checks if queen is increasing or decreasing rows
			if(rowDiff > 0){
				inc = 1;
			}else{
				inc = -1;
			}
			for(int i = move.fromRow + inc; i != move.toRow; i += inc){
				if(board[i][move.fromColumn] == null){
					valid = true;
				}
				else{
					valid = false;
					break;
				}
			}
			if (abs(rowDiff) == 1){
				valid = true;
			}
			if(abs(colDiff) != 0){
				valid = false;
			}
		}
		//checks if queen is moving left to right
		if(abs(colDiff) > 0){
			//checks if queen is increasing or decreasing rows
			if(colDiff > 0){
				inc = 1;
			}else{
				inc = -1;
			}
			for(int i = move.fromColumn + inc; i != move.toColumn; i += inc){
				if(board[move.fromRow][i] == null){
					valid = true;
				}
				else{
					valid = false;
					break;
				}
			}
			if (abs(colDiff) == 1){
				valid = true;
			}
			if(abs(rowDiff) != 0){
				valid = false;
			}
		}
	}
		return valid;
	}
	
	public boolean isValidMove(Move move, ChessPiece[][] board) {
		if(super.isValidMove(move, board) == true){
			if(isQueenValidMove(move, board) == true){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	
	}
}
