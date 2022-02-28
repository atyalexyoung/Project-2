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

		// creates variable set to the location the current player is trying to move to
		

		// set boolean variable for if the move is valid or not
		boolean validMove = false;


		int rowDiff = move.toRow - move.fromRow;
		int colDiff = move.toColumn - move.fromColumn;

		// checks if the position the current player is trying to move to is valid for a "King" piece
		// first checks space right 1 and up 1


		// checks if the move is 1 space in any direction
		if(Math.abs(rowDiff) <= 1 && Math.abs(colDiff) <= 1)
		{
			if(board[move.toRow][move.toColumn] == null)
			{
				validMove = true;
			}
			else
			{
				if(board[move.toRow][move.toColumn].player() == player().next())
				{
					validMove = true;
				}
			}
		}
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

		// boolean variable for if it is a valid move, initialized to false unless it meets the criteria provided below
		boolean validMove = false;

		// checks if the move passes the parent ChessPiece class's isValidMove function
		if (super.isValidMove(move, board))
		{
			if(kingIsValidMove(move, board))
			{
				return true;
			}
			else{/* the place the current player is trying to move is not one space away from the king */}
		}
		else{/* the move is not valid in the super class ChessPiece */}
		
		// returns valid move as false unless it met the criteria and was set to true
		return validMove;
	}


}