import static java.lang.Math.abs;
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
		boolean valid = false;
		int rowDiff = move.toRow - move.fromRow;
		int colDiff = move.toColumn - move.fromColumn;
		//makes sure knight is moving to new column and row
		if((abs(rowDiff) > 0) && (abs(colDiff) > 0)){
			//checks if knight is moving only one row
			if(abs(rowDiff) == 1){
				if(abs(colDiff) == 2){
					valid = true;
				}
			}
			//checks if knight is moving two rows
			if(abs(rowDiff) == 2){
				if(abs(colDiff) == 1){
					valid = true;
				}
			}
		}
		return valid;
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
