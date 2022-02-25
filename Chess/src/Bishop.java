import static java.lang.Math.abs;
public class Bishop extends ChessPiece {

	public Bishop(Player player) {
		super(player);
	}

	public String type() {
		return "Bishop";
	}
	private boolean bishopHelper(Move move, ChessPiece[][] board, int row, int col){
		if((move.toRow == row) && (move.toColumn == col)){
			return true;
		}
		if(board[row][col] != null )
		if(board[row][col] == null){
			return bishopHelper(move, board, row + 1, col + 1);
		}

		return bishopHelper(move, board, row, col);
	}
	
	private boolean bishopIsValidMove(Move move, ChessPiece[][] board){
		
	boolean valid = false;
	int rowDiff = move.toRow - move.fromRow;
	int colDiff = move.toColumn - move.fromColumn;
	
//checks to make sure bishop is moving diagonally
if(abs(rowDiff) == abs(colDiff)){
//checks each spot in bishops path

}


	return valid;	
}
	public boolean isValidMove(Move move, ChessPiece[][] board) {

		// boolean variable for if it is a valid move, initialized to false unless it meets the criteria provided below
		boolean validMove = false;

		// checks if the move passes the parent ChessPiece class's isValidMove function
		if (super.isValidMove(move, board))
		{
			if(bishopIsValidMove(move, board))
			{
				return true;
			}
			else{/* the place the current player is trying to move is not one space away from the king */}
		}
		else{/* the move is not valid in the super class ChessPiece */}
		
		// returns valid move as false unless it met the criteria and was set to true
		return validMove;
	


		/*

			if (super is valid move == true){
				if (move is diagonal ((NW),(NE),(SW),(SE)))
					if (no allied player in the way)
						if (enemy player in the way)
							take their place 
							return true
						else (no enemy player in the way)
							return true;
							
					else (allied player in the way)
						return false
				else (move is not diagonal)
					return false

			}
			else (super isValidMove == false)
				return false;




		*/


	}
	
}
