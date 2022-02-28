import static java.lang.Math.abs;

/********************************************************************************************************************* 
 * 
 * Class Queen: object that contains all attributes for a 
 * piece of type "Queen," including what a valid move for a
 * "Queen" is, it's type ("Queen"), and what player owns it.
 * Inherits from super class "ChessPiece."
 * 
 * 
 * @author Alex Young
 * @version Winter 2022
 * 
*********************************************************************************************************************/
public class Queen extends ChessPiece {


	/****************************************************************************************************************
	 * 
	 * Constructor for a "Queen Piece"
	 * @param player that attributes the piece to a player.
	 * black or white.
	 * 
	 ****************************************************************************************************************/
	public Queen(Player player) {
		super(player);
	}


	/********************************************************************************************************************************
	 * 
	 * Method that gets the type of the piece, "Queen"
	 * @return String: "Queen"
	 * 
	*********************************************************************************************************************************/
	public String type() {
		return "Queen";
	}



	/***************************************************************************************************************

	* Helper method for isQueenValidMove and is used to check
	* if the move in question is valid for the chess piece of type "Rook"
	* The "Queen" piece has the movement of both a "Rook" and "Bishop"
	* and this helper method checks half of the valid moves available
	* for a "Queen."
	* @param move the position the Queen is starting 
	* and the postion it is attempting to move to
	* @param board the current board of chess pieces
	* @return boolean, true if it is a valid move for a Rook,
	* false otherwise

	***************************************************************************************************************/
	private boolean rookIsValidMove(Move move, ChessPiece[][] board)
	{
		boolean valid = false;
		int rowDiff = move.toRow - move.fromRow;
		int colDiff = move.toColumn - move.fromColumn;
		int inc;
		//checks if queen is moving in same row/column (not diagonally)
		if(abs(rowDiff) != abs(colDiff)){
		if(abs(rowDiff) > 0){
			//checks if queen is increasing or decreasing rows
			if(rowDiff > 0){
				inc = 1;
			}else{
				inc = -1;
			}
			for(int i = move.fromRow + inc; i != move.toRow; i += inc){
				if(board[i][move.fromColumn] == null){
					valid = true;
				}
				else{
					valid = false;
					break;
				}
			}
			if (abs(rowDiff) == 1){
				valid = true;
			}
			if(abs(colDiff) != 0){
				valid = false;
			}
		}
		//checks if queen is moving left to right
		if(abs(colDiff) > 0){
			//checks if queen is increasing or decreasing rows
			if(colDiff > 0){
				inc = 1;
			}else{
				inc = -1;
			}
			for(int i = move.fromColumn + inc; i != move.toColumn; i += inc){
				if(board[move.fromRow][i] == null){
					valid = true;
				}
				else{
					valid = false;
					break;
				}
			}
			if (abs(colDiff) == 1){
				valid = true;
			}
			if(abs(rowDiff) != 0){
				valid = false;
			}
		}
	}
		return valid;
	}


	/***************************************************************************************************************

	* Helper method for isQueenValidMove and is used to check
	* if the move in question is valid for the chess piece of type "Bishop"
	* The "Queen" piece has the movement of both a "Rook" and "Bishop"
	* and this helper method checks half of the valid moves available
	* for a "Queen."
	* @param move the position the Queen is starting 
	* and the postion it is attempting to move to
	* @param board the current board of chess pieces
	* @return boolean, true if it is a valid move for a Bishop,
	* false otherwise

	***************************************************************************************************************/
	private boolean bishopIsValidMove(Move move, ChessPiece[][] board)
	{
				
	
	boolean valid = false;


	int rowDiff = move.toRow - move.fromRow;
	int colDiff = move.toColumn - move.fromColumn;
	int x = move.fromRow;
	int y = move.fromColumn;
	

	if(Math.abs(rowDiff) == Math.abs(colDiff))
	{
		if(board[move.toRow][move.toColumn] == null || board[move.toRow][move.toColumn].player() == player().next()){
			if(Math.abs(rowDiff) != 1)
			{

				for(int i = Math.abs(rowDiff) - 1; i >= 1; i--)
				{
					if(rowDiff > 0)
					{
						if(colDiff > 0)
						{
							if(board[x + 1][y + 1] == null)
							{
								valid = true;
								x++;
								y++;
							}
							else
							{
								valid = false;
								break;
								
							}
						}
						else if(colDiff < 0)
						{
							if(board[x + 1][y - 1] == null)
							{
								valid = true;
								x++;
								y--;
							}
							else
							{
								valid = false;
								break;
							}
						}
					}
					else if(rowDiff < 0)
					{
						if(colDiff > 0)
						{
							if(board[x - 1][y + 1] == null)
							{
								valid = true;
								x--;
								y++;
							}
							else
							{
								valid = false;
								break;
							}
						}
						else if(colDiff < 0)
						{
							if(board[x - 1][y - 1] == null)
							{
								valid = true;
								x--;
								y--;
							}
							else
							{
								valid = false;
								break;
							}
						}
					}
				}
			}
			else
			{
				valid = true;
			}
		}
	}
	return valid;	


	}

	
	/***************************************************************************************************************

	* Helper method for "isValidMove()" and is used to check
	* if the move in question is valid for the chess piece of type "Queen"
	* Uses helper methods "rookIsValidMove()" and "bishopIsValidMove()"
	* to get the valid move for a "Queen," which has the movement
	* capabilities of both a "Rook" and a "Bishop."
	* @param move the position the Quen is starting 
	* and the postion it is attempting to move to
	* @param board the current board of chess pieces
	* @return boolean, true if it is a valid move for a Queen,
	* false otherwise

	***************************************************************************************************************/
	private boolean isQueenValidMove(Move move, ChessPiece[][] board)
	{
		boolean validMove = false;

		if(bishopIsValidMove(move, board) || rookIsValidMove(move, board))
		{
			validMove = true;
		}
		
		return validMove;
	}


	/*********************************************************************************************************************************
	 * Method that checks if the move is valid for a "Queen" piece.
	 * Uses helper method "rookIsValidMove()," "bishopIsValidMove(),"
	 * and the super class "isValidMove()" method.
	 * @param move the move that is being attempted by player
	 * move contains from location and to location of the piece
	 * @param board takes in the current chess board
	 * @return boolean
	 * set to true if it is a valid move for a "Queen",
	 * false otherwise
	 *********************************************************************************************************************************/
	public boolean isValidMove(Move move, ChessPiece[][] board)
	{
		boolean validMove = false;
		if(super.isValidMove(move, board) == true)
		{
			if(isQueenValidMove(move, board) == true)
			{
				validMove = true;
			}
		}
		return validMove;
	}

}
