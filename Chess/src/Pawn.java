/********************************************************************************************************************* 
 * 
 * Class Pawn: object that contains all attributes for a 
 * piece of type "Pawn," including what a valid move for a
 * "Pawn" is, it's type ("Pawn"), and what player owns it.
 * Inherits from super class "ChessPiece."
 * 
 * 
 * @author Alex Young
 * @author Owen Wheeler
 * @version Winter 2022
 * 
*********************************************************************************************************************/
public class Pawn extends ChessPiece {


	/****************************************************************************************************************
	 * 
	 * Constructor for a "Pawn Piece"
	 * @param player that attributes the piece to a player.
	 * black or white.
	 * 
	 ****************************************************************************************************************/
	public Pawn(Player player) {
		super(player);
	}


	/********************************************************************************************************************************
	 * 
	 * Method that gets the type of the piece, "Pawn"
	 * @return String: "Pawn"
	 * 
	*********************************************************************************************************************************/
	public String type() {
		return "Pawn";
	}

	
	/***************************************************************************************************************

	* Helper method for isValidMove and is used to check
	* if the move in question is valid for the chess piece of type "Pawn"
	* @param move the position the Pawn is starting 
	* and the postion it is attempting to move to
	* @param board the current board of chess pieces
	* @return boolean, true if it is a valid move for a Pawn,
	* false otherwise

	***************************************************************************************************************/
	private boolean pawnIsValidMove(Move move, ChessPiece[][] board)
	{

		
		/**
		 * creating integer variable to represent the difference
		 * in the number of rows from the row the piece is moving to
		 * and the row the piece is moving from
		 */
		int rowDiff = move.toRow - move.fromRow;

		/**
		 * creating integer variable to represent the difference
		 * in the number of columns from the column the piece is moving to
		 * and the column the piece is moving from
		 */
		int colDiff = move.toColumn - move.fromColumn;


		/** boolean variable for if the move is valid or no
		 * by the piece. Set to false unless the criteria below is met
		 */
		boolean validMove = false;


		// checks if player is black
		if(this.player() == Player.BLACK)
		{
			// checks if the move is forward
			if(rowDiff > 0)
			{
				// checks if diagonal move
				if(rowDiff - Math.abs(colDiff) == 0)
				{	
					// checks that the diagonal move is not more than 1
					if(rowDiff == 1 && Math.abs(colDiff) == 1)
					{
						// checks if the diagonal move contains an enemy player
						if(board[move.toRow][move.toColumn] != null && board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player())
						{
							validMove = true;
						}
						else{/* the position the pawn is moving to has an allied player or no player
						 	 is invalid move for pawn */}
					}
					else{/* the diagonal move is not 1 */}
				}
				// the move is not diagonal
				else
				{
					// checks if in starting position
					if(move.fromRow == 1)
					{
						// checks if the move is less than or equal to 2 and forward
						if(rowDiff <= 2 && colDiff == 0)
						{
							// if the pawn is moving forward 2
							if(rowDiff == 2)
							{
								// checks if there is no player in the way
								if(board[move.toRow][move.toColumn] == null && board[move.toRow - 1][move.fromColumn] == null)
								{
									validMove = true;
								}
							}
							// the pawn is only moving 1 space
							else
							{
								if(board[move.toRow][move.toColumn] == null)
								{
									validMove = true;
								}
							}
						}
					}
					// the pawn is not in the starting position
					else
					{
						// checks if the pawn is moving forward 1 and sideways none
						if(rowDiff == 1 && colDiff == 0)
						{
							// checks if the place the pawn is trying to move has no player there
							if(board[move.toRow][move.toColumn] == null)
							{
								validMove = true;
							}
						}
					}
				}
			}
		}
		// player is white
		else
		{
			// checks if the move is forward
			if(rowDiff < 0)
			{
				// checks if diagonal move
				if(Math.abs(rowDiff) - Math.abs(colDiff) == 0)
				{	
					// checks that the diagonal move is not more than 1
					if(rowDiff == -1 && Math.abs(colDiff) == 1)
					{
						// checks if the diagonal move contains and enemy player
						if(board[move.toRow][move.toColumn] != null && board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player())
						{
							validMove = true;
						}
					}
				}
				// the move is not diagonal
				else
				{
					// checks if in starting position
					if(move.fromRow == 6)
					{
						// checks if the move is less than or equal to 2 and forward
						if(rowDiff >= -2 && colDiff == 0)
						{
							// if the pawn is moving forward 2
							if(rowDiff == -2)
							{
								// checks if there is no player in the way
								if(board[move.toRow][move.toColumn] == null && board[move.fromRow - 1][move.fromColumn] == null)
								{
									validMove = true;
								}
							}
							// Pawn is moving forward 1
							else
							{
								if(board[move.toRow][move.toColumn] == null)
								{
									validMove = true;
								}
							}
						}
					}
					// the pawn is not in the starting position
					else
					{
						// checks if the pawn is moving forward 1 and sideways none
						if(rowDiff == -1 && colDiff == 0)
						{
							// checks if the place the pawn is trying to move has no player there
							if(board[move.toRow][move.toColumn] == null)
							{
								validMove = true;
							}
						}
					}

				}
			}
		}
		return validMove;
	}


	/*********************************************************************************************************************************
	 * Method that checks if the move is valid for a "Pawn" piece
	 * uses helper method "pawnIsValidMove()," and the super class
	 * "isValidMove()" method.
	 * @param move the move that is being attempted by player
	 * move contains from location and to location of the piece
	 * @param board takes in the current chess board
	 * @return boolean
	 * set to true if it is a valid move for pawn,
	 * false otherwise
	 *********************************************************************************************************************************/
	public boolean isValidMove(Move move, ChessPiece[][] board)
		{
			
			boolean isValidMove = false;
			
			
			if(super.isValidMove(move, board) == true)
			{
				if(pawnIsValidMove(move, board) == true)
				{

					isValidMove = true;
				}
			}
			return isValidMove;
		}	
}	
			
		