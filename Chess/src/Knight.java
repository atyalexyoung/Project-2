import static java.lang.Math.abs;
public class Knight extends ChessPiece {


	
	public Knight(Player player) {
		super(player);
	}


	/********************************************************************************************************************************
	 * Method that gets the type of the piece, "Knight"
	 * @return String: "Knight"
	*********************************************************************************************************************************/
	public String type() {
		return "Knight";
	}


	/*********************************************************************************************************************************
	 * Helper method that checks if the move is valid for a "knight" piece
	 * @param move the move that is being attempted by player
	 * move contains from location and to location
	 * @param board takes in the current chess board
	 * @return boolean
	 * set to true if it is a valid move for knight
	 * false otherwise
	 *********************************************************************************************************************************/
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



	/*********************************************************************************************************************************
	 * Method that checks if the move is valid for a "knight" piece
	 * uses helper method "knightIsValidMove"
	 * @param move the move that is being attempted by player
	 * move contains from location and to location
	 * @param board takes in the current chess board
	 * @return boolean
	 * set to true if it is a valid move for knight
	 * false otherwise
	 *********************************************************************************************************************************/
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
