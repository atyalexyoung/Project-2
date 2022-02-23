public class Bishop extends ChessPiece {

	public Bishop(Player player) {
		super(player);
	}

	public String type() {
		return "Bishop";
	}
	



	private boolean bishopIsValidMove(Move move, ChessPiece[][] board){

		// creates variable set to the location the current player is trying to move to
		ChessPiece toPosition = board[move.toRow][move.toColumn];

		// set boolean variable for if the move is valid or not
		boolean validMove = false;

		int y= move.toRow - move.fromRow;
		int x = move.toColumn - move.fromColumn;

		int absX = Math.abs(x);
		int absY = Math.abs(y);

		

		if(absX == absY)
		{
			



		}







		// checks if the position the current player is trying to move to is valid for a "King" piece
		// first checks space right 1 and up 1
		if(toPosition == board[move.fromRow + x][move.fromColumn + x] || 
			// checks the space left 1 and down 1
			toPosition == board[move.fromRow - 1][move.fromColumn - 1] ||
			// checks the space right 1 and down 1
			toPosition == board[move.fromRow + 1][move.fromColumn - 1] ||
			// checks the space left one and up 1
			toPosition == board[move.fromRow - 1][move.fromColumn + 1] ||
			// checks the space up 1
			toPosition == board[move.fromRow][move.fromColumn + 1] ||
			//checks the space down 1
			toPosition == board[move.fromRow][move.fromColumn - 1] ||
			// checks the space right 1
			toPosition == board[move.fromRow + 1][move.fromColumn] ||
			// checks the space left 1
			toPosition == board[move.fromRow - 1][move.fromColumn])
		{
			// sets varibale to true if it is 1 space in any direction
			validMove = true;
		}
		else
		{/* it is not 1 space in any direction and therefore not a valid move for a king */}
		
		// returns that the valid move is false unless it meets the criteria provided in above "if-statements"
		return validMove;



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
