
/********************************************************************************************************************* 
 * 
 * Class Bishop: object that contains all attributes for a 
 * piece of type "Bishop," including what a valid move for a
 * "Bishop" is, it's type ("Bishop"), and what player owns it.
 * Inherits from super class "ChessPiece."
 * 
 * 
 * @author Alex Young
 * @author Owen Wheeler
 * @version Winter 2022
 * 
*********************************************************************************************************************/
public class Bishop extends ChessPiece {



	/****************************************************************************************************************
	 * 
	 * Constructor for a "Bishop Piece"
	 * @param player that attributes the piece to a player.
	 * black or white.
	 * 
	 ****************************************************************************************************************/
	public Bishop(Player player) {
		super(player);
	}


	/****************************************************************************************************************
	 * 
	 * Method that that gets the type of the piece.
	 * @return String, "Bishop"
	 * 
	 ***************************************************************************************************************/
	public String type() {
		return "Bishop";
	}


	/***************************************************************************************************************

	* This method is a helper method to use for checking a valid move
	* used to check if the move in question
	* is valid for the chess piece type "Bishop"
	* @param move the position the bishop is starting 
	* and the postion it is attempting to move to
	* @param board the current board of chess pieces
	* @return boolean, true if it is a valid move for a bishop
	* false otherwise

	***************************************************************************************************************/
	private boolean bishopIsValidMove(Move move, ChessPiece[][] board){
		
		// creating boolean variable initialized to false
		boolean valid = false;

		/** creating a variable to hold the difference between
		 * the row the piece is moving to and the row the piece
		 * is moving from*/
		int rowDiff = move.toRow - move.fromRow;

		/** creating a variable to hold the difference between
		 * the column the piece is moving to and the column the piece
		 * is moving from*/
		int colDiff = move.toColumn - move.fromColumn;

		/** initializing a variable to hold
		 * the row the piece is moving from */
		int x = move.fromRow;

		/** initializing a variable to hold
		 * the column the piece is moving from */
		int y = move.fromColumn;
		



		/** In this next section of code:
		 * Checks if bishop is moving diagonal,
		 * and the space it is moving to does not have an allied piece.
		 * Then uses for loop to check the spaces between the bishop 
		 * and the space it is moving to for pieces in the way.
		 * Inside the for loop it checks which direction the piece is moving
		 * and increments or decrements the row or column to be checked,
		 * depending on the direction of the move.
		 */





		/** checks if the move in question is diagonal */
		if(Math.abs(rowDiff) == Math.abs(colDiff))
		{

			/** checks if the location the piece is moving to does not have an allied piece there */
			if(board[move.toRow][move.toColumn] == null || board[move.toRow][move.toColumn].player() == player().next()){

				/** checks if the diagonal move is not 1 in any direction */
				if(Math.abs(rowDiff) != 1)
				{

					/** loop to iterate the number of spaces the piece is moving */
					for(int i = Math.abs(rowDiff) - 1; i >= 1; i--)
					{

						/** checks if the move in question is increasing row */
						if(rowDiff > 0)
						{

							/** checks if the move in question is increasing column */
							if(colDiff > 0)
							{

								/** checks if space has a piece there */
								if(board[x + 1][y + 1] == null)
								{
									/** sets boolean "valid" true if there is no piece in the space */
									valid = true;
									/** increments the row to be checked */
									x++;
									/** increments the column to be checked */
									y++;
								}
								else /** the space in question has a piece there */
								{
									/** sets "valid" to false
									 * not a valid move for a bishop
									 */
									valid = false;

									/** break to exit the loop */
									break;
									
								}
							}
							/** checks if the move is increases row and decreases column */
							else if(colDiff < 0)
							{

								/** checks if the space of row x and column y has a piece there */
								if(board[x + 1][y - 1] == null)
								{

									/** sets valid to true if there is no piece in space */
									valid = true;
									/** increments x (row) to be checked */
									x++;
									/** decrements y (column) to be checked */
									y--;
								}
								else /** the space has a piece there */
								{
									/** sets valid to false
									 * not a valid move for a bishop
									 */
									valid = false;

									/** break to end loop */
									break;
								}
							}
						}
						/** checks if move decreases row */
						else if(rowDiff < 0)
						{

							/** checks if the move increases column */
							if(colDiff > 0)
							{

								/** checks if the space at row x and column y has a piece there */
								if(board[x - 1][y + 1] == null)
								{

									/** sets "valid" to true if there is no piece there*/
									valid = true;

									/** decrements x (row) to be checked */
									x--;

									/** increments y (column) to be checked */
									y++;
								}
								else /** the space in question has a piece there */
								{
									/** sets valid to false
									 * not a valid move for a bishop
									 */
									valid = false;

									/** break to end the loop */
									break;
								}
							}
							/** checks if the move decreases column */
							else if(colDiff < 0)
							{

								/** checks if the space of row x and column y has a piece there */
								if(board[x - 1][y - 1] == null)
								{

									/** sets valid to true if there is no piece in the space */
									valid = true;

									/** decrements the row to be checked */
									x--;

									/** decrements the column to be checked */
									y--;
								}
								else /** there is a piece in the space in question */
								{

									/** sets valid to false
									 * not a valid move for a bishop
									 */
									valid = false;

									/** break to end the loop */
									break;
								}
							}
						}
					}
				}
				else /** if the move is 1 it is a valid move
				* already checked if the space the piece is moving to is valid
				*/
				{

					/** sets valid to true */
					valid = true;
				}
			}
		}

		/** returns the boolean valid
		 * true if move is valid for a bishop
		 * false otherwise
		 */
		return valid;	
	}


	/***************************************************************************************************************

	* This method is used to check if the move in question
	* is valid for the chess piece by using the super class isValidMove method
	* and the helper bishopIsValidMove method
	* @param move the position the bishop is starting 
	* and the postion it is attempting to move to
	* @param board the current board of chess pieces
	* @return boolean, true if it is a valid move for a bishop
	* false otherwise

	***************************************************************************************************************/
	public boolean isValidMove(Move move, ChessPiece[][] board) {

		// checks if the move passes the parent ChessPiece class's isValidMove function
		if (super.isValidMove(move, board))
		{
			if(bishopIsValidMove(move, board))
			{
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
