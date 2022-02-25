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


	private boolean knightIsValidMove(Move move, ChessPiece[][] board)
	{

		// creates variable set to the location the current player is trying to move to
		

		// set boolean variable for if the move is valid or not
		boolean validMove = false;


		int rowDiff = move.toRow - move.fromRow;
		int colDiff = move.toColumn - move.fromColumn;

		// checks if the position the current player is trying to move to is valid for a "Knight" piece
		// first checks space right 1 and up 1
		if((Math.abs(rowDiff) == 3 && Math.abs(colDiff) == 2) || (Math.abs(rowDiff) == 2 && Math.abs(colDiff) == 3))
		{
			if(board[move.toRow][move.toColumn] == null || board[move.toRow][move.toColumn].player() == player().next())
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


	public boolean isValidMove(Move move, ChessPiece[][] board)
	{
		
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
