import static java.lang.Math.abs;
/********************************************************************************************************************* 
 * 
 * Class Knight: object that contains all attributes for a 
 * piece of type "Knight," including what a valid move for a
 * "Knight" is, it's type ("Knight"), and what player owns it.
 * Inherits from super class "ChessPiece."
 * 
 * 
 * @author Owen Wheeler
 * @author Alex Young
 * @version Winter 2022
 * 
*********************************************************************************************************************/
public class Knight extends ChessPiece {


	/****************************************************************************************************************
	 * 
	 * Constructor for a "Knight Piece"
	 * @param player that attributes the piece to a player.
	 * black or white.
	 * 
	 ****************************************************************************************************************/
	public Knight(Player player) {
		super(player);
	}


	/********************************************************************************************************************************
	 * 
	 * Method that gets the type of the piece, "Knight"
	 * @return String: "Knight"
	 * 
	*********************************************************************************************************************************/
	public String type() {
		return "Knight";
	}


	/*********************************************************************************************************************************
	 * 
	 * Helper method that checks if the move is valid for a "Knight" piece
	 * @param move the move that is being attempted by player
	 * move contains from location and to location
	 * @param board takes in the current chess board
	 * @return boolean
	 * set to true if it is a valid move for knight
	 * false otherwise
	 * 
	 *********************************************************************************************************************************/
	private boolean knightIsValidMove(Move move, ChessPiece[][] board){

		/** boolean variable to hold whether the move
		 * the piece is making is valid or not
		 * true if the move is valid
		 * false otherwise
		 */
		boolean valid = false;

		/** integer variable to hold the difference of the row the
		 * piece is moving to and the row the piece is moving from
		 */
		int rowDiff = move.toRow - move.fromRow;

		/** integer variable to hold the difference of the column the
		 * piece is moving to and the column the piece is moving from
		 */
		int colDiff = move.toColumn - move.fromColumn;


		//makes sure knight is moving to new column and row
		if((abs(rowDiff) > 0) && (abs(colDiff) > 0)){

			//checks if knight is moving only one row
			if(abs(rowDiff) == 1){

				// checks if the piece is is moving 2 columns
				if(abs(colDiff) == 2){

					/** boolean valid set to true if
					 * piece is moving 1 row and 2 columns
					 */
					valid = true;
				}
			}
			//checks if knight is moving two rows
			if(abs(rowDiff) == 2){

				// checks if piece is moving 1 column
				if(abs(colDiff) == 1){

					/** valid set to true if piece is moving
					 * 2 rows and 1 column
					 */
					valid = true;
				}
			}
		}

		/** returns boolean "valid"
		 * true if the move is valid for a knight,
		 * false otherwise
		 */
		return valid;
	}



	/*********************************************************************************************************************************
	 * 
	 * Method that checks if the move is valid for a "Knight" piece
	 * uses helper method "knightIsValidMove"
	 * @param move the move that is being attempted by player
	 * move contains from location and to location
	 * @param board takes in the current chess board
	 * @return boolean
	 * set to true if it is a valid move for knight
	 * false otherwise
	 * 
	 *********************************************************************************************************************************/
	public boolean isValidMove(Move move, ChessPiece[][] board)
	{
		
				/** boolean variable for if it is a valid move, 
				 * initialized to false unless it meets the criteria provided below
				 *  */
				boolean validMove = false;

				// checks if the move passes the parent ChessPiece class's isValidMove function
				if (super.isValidMove(move, board))
				{

					/** checks if it is a valid move for a knight by
					 * using the helper method "knightIsValidMove()"
					 */
					if(knightIsValidMove(move, board))
					{

						/**  returns true if the move is valid for 
						 * a general chess piece and a knight chess piece
						 * */
						return true;
					}
					else{/* the place the current player is trying to move is not valid for a knight */}
				}
				else{/* the move is not valid in the super class ChessPiece */}
				
				// returns valid move as false unless it met the criteria and was set to true
				return validMove;
	}



}
