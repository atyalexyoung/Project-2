public class Knight extends ChessPiece {

	public Knight(Player player) {
		super(player);
	}

	public String type() {
		return "Knight";
	}







	// **************************************************************************************************************************************************************

	//    HELPER METHOD THAT CHECKS IF THE MOVE IS VALID FOR A "KING" PIECE
	//    RETURNS A BOOLEAN
	//    TAKES IN A MOVE AND BOARD AS PARAMETERS

	// **************************************************************************************************************************************************************


	private boolean knightIsValidMove(Move move, ChessPiece[][] board){

		// creates variable set to the location the current player is trying to move to
		ChessPiece toPosition = board[move.toRow][move.toColumn];

		// set boolean variable for if the move is valid or not
		boolean validMove = false;

		// checks if the position the current player is trying to move to is valid for a "King" piece
		// first checks space right 1 and up 1
		if(toPosition == board[move.fromRow + 2][move.fromColumn + 3] || 
			// checks the space left 1 and down 1
			toPosition == board[move.fromRow + 2][move.fromColumn - 3] ||
			// checks the space right 1 and down 1
			toPosition == board[move.fromRow - 2][move.fromColumn + 3] ||
			// checks the space left one and up 1
			toPosition == board[move.fromRow - 2][move.fromColumn - 3] ||
			// checks the space up 1
			toPosition == board[move.fromRow + 3][move.fromColumn + 2] ||
			//checks the space down 1
			toPosition == board[move.fromRow + 3][move.fromColumn - 2] ||
			// checks the space right 1
			toPosition == board[move.fromRow - 3][move.fromColumn + 2] ||
			// checks the space left 1
			toPosition == board[move.fromRow - 3][move.fromColumn - 2])
		{
			// sets varibale to true if it is 1 space in any direction
			validMove = true;
		}
		else{/* it is not 1 space in any direction and therefore not a valid move for a king */}
		
		// returns that the valid move is false unless it meets the criteria provided in above "if-statements"
		return validMove;

	}










	// ****************************************************************************************************************************************************************

	// METHOD THAT RETURNS A BOOLEAN IF THE MOVE IS VALID FOR A KING PIECE AND FOR ANY CHESS PIECE
	// TAKES IN A MOVE AND BOARD AS PARAMETERS

	// ****************************************************************************************************************************************************************


	public boolean isValidMove(Move move, ChessPiece[][] board){
		
				// boolean variable for if it is a valid move, initialized to false unless it meets the criteria provided below
				boolean validMove = false;

				// checks if the move passes the parent ChessPiece class's isValidMove function
				if (super.isValidMove(move, board))
				{
					if(knightIsValidMove(move, board))
					{
						return true;
					}
					else{/* the place the current player is trying to move is not valid for a knight */}
				}
				else{/* the move is not valid in the super class ChessPiece */}
				
				// returns valid move as false unless it met the criteria and was set to true
				return validMove;
	}



}
