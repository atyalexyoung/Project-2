import static java.lang.Math.abs;

/********************************************************************************************************************* 
 * 
 * Class Rook: object that contains all attributes for a 
 * piece of type "Rook," including what a valid move for a
 * "Rook" is, it's type ("Rook"), and what player owns it.
 * Inherits from super class "ChessPiece."
 * 
 * 
 * @author Owen Wheeler
 * @version Winter 2022
 * 
*********************************************************************************************************************/
public class Rook extends ChessPiece {


	/****************************************************************************************************************
	 * 
	 * Constructor for a "Rook Piece"
	 * @param player that attributes the piece to a player.
	 * black or white.
	 * 
	 ****************************************************************************************************************/
	public Rook(Player player) {
		super(player);
	}


	/********************************************************************************************************************************
	 * Method that gets the type of the piece, "Rook"
	 * @return String: "Rook"
	*********************************************************************************************************************************/
	public String type() {
		return "Rook";
	}
	

	/***************************************************************************************************************

	* This method is a helper method to use for checking a valid move
	* used to check if the move in question
	* is valid for the chess piece type "Rook"
	* @param move the position the rook is starting 
	* and the postion it is attempting to move to
	* @param board the current board of chess pieces
	* @return boolean, true if it is a valid move for a rook
	* false otherwise

	***************************************************************************************************************/
	private boolean isRookValidMove(Move move, ChessPiece[][] board){
		boolean valid = false;
		int rowDiff = move.toRow - move.fromRow;
		int colDiff = move.toColumn - move.fromColumn;
		int inc;
		//checks if rook is moving up and down
		if(abs(rowDiff) > 0){
			//checks if rook is increasing or decreasing rows
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
		//checks if rook is moving left to right
		if(abs(colDiff) > 0){
			//checks if rook is increasing or decreasing rows
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
		return valid;
	}


	/***************************************************************************************************************

	* This method is used to check if the move in question
	* is valid for the chess piece by using the super class isValidMove method
	* and the helper isRookValidMove method
	* @param move the position the rook is starting 
	* and the postion it is attempting to move to
	* @param board the current board of chess pieces
	* @return boolean, true if it is a valid move for a rook
	* false otherwise

	***************************************************************************************************************/
	public boolean isValidMove(Move move, ChessPiece[][] board) {
		if (super.isValidMove(move, board) == true){
		if (isRookValidMove(move, board) == true){
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
