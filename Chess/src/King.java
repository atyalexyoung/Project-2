/********************************************************************************************************************* 
 * 
 * Class King: object that contains all attributes for a 
 * piece of type "King," including what a valid move for a
 * "King" is, it's type ("King"), and what player owns it.
 * Inherits from super class "ChessPiece."
 * 
 * 
 * @author Alex Young
 * @version Winter 2022
 * 
*********************************************************************************************************************/
public class King extends ChessPiece {


	/****************************************************************************************************************
	 * 
	 * Constructor for a "King Piece"
	 * @param player that attributes the piece to a player.
	 * black or white.
	 * 
	 ****************************************************************************************************************/
	public King(Player player) {
		super(player);
	}


	/****************************************************************************************************************
	 * 
	 * Method that that gets the type of the piece.
	 * @return String, "King"
	 * 
	 ***************************************************************************************************************/
	public String type() {
		return "King";
	}


	/***************************************************************************************************************

	* This method is a helper method for isValidMove and is
	* used to check if the move in question
	* is valid for the chess piece type "King"
	* @param move the position the king is starting 
	* and the postion it is attempting to move to
	* @param board the current board of chess pieces
	* @return boolean, true if it is a valid move for a King,
	* false otherwise

	***************************************************************************************************************/
	private boolean kingIsValidMove(Move move, ChessPiece[][] board){


		// set boolean variable for if the move is valid or not
		boolean validMove = false;

		/** integer variable to hold the difference of the row the
		 * piece is moving to and the row the piece is moving from
		 */
		int rowDiff = move.toRow - move.fromRow;

		/** integer variable to hold the difference of the column the
		 * piece is moving to and the column the piece is moving from
		 */
		int colDiff = move.toColumn - move.fromColumn;


		// checks if the move is 1 space in any direction
		if(Math.abs(rowDiff) <= 1 && Math.abs(colDiff) <= 1)
		{
			// checks if the location the piece is moving to has a piece there
			if(board[move.toRow][move.toColumn] == null)
			{
				/** sets boolean to true if the King is moving 1 space
				 * and there is no piece there
				 */
				validMove = true;
			}
			else
			{ /** the location the king is attempting to move has a player there */

				/** checks if the location the king is attempting to move to
				 * has an enemy pice there
				 */
				if(board[move.toRow][move.toColumn].player() == player().next())
				{
					/** boolean to true if the location the king is moving to
					 * has an enemy piece and not an allied piece
					 */
					validMove = true;
				}
			}
		}

		/** returns the validMove boolean,
		 * true if it is a valid move for a king
		 * false otherwise
		 */
		return validMove;
	}


	/***************************************************************************************************************

	* This method is used to check if the move in question is valid
	* for the chess piece by using the super class isValidMove() method
	* and the helper kingIsValidMove() method.
	* @param move the position the King is starting 
	* and the postion it is attempting to move to
	* @param board the current board of chess pieces
	* @return boolean, true if it is a valid move for a King,
	* false otherwise

	***************************************************************************************************************/
	public boolean isValidMove(Move move, ChessPiece[][] board) {

		/** boolean variable for if it is a valid move, 
		 * initialized to false unless it meets the criteria provided below
		 * */
		boolean validMove = false;

		/**checks if the move passes the parent 
		 * ChessPiece class's isValidMove function
		 * */
		if (super.isValidMove(move, board))
		{
			/** checks if the move is valid for a King by using the 
			 * kingIsValid() helper method
			 */
			if(kingIsValidMove(move, board))
			{
				/** returns true if move is valid for a general chess piece
				 * and for a King piece
				 */
				return true;
			}
			else{/* the place the current player is trying to move is not one space away from the king */}
		}
		else{/* the move is not valid in the super class ChessPiece */}
		
		// returns valid move as false unless it met the criteria and was set to true
		return validMove;
	}


}