public class ChessModel {	 
    private ChessPiece[][] board;
	private Player player;
	

	// declare other instance variables as needed

	public ChessModel() {
		board = new ChessPiece[8][8];
		player = Player.WHITE;

		// example of how to create and set a couple pieces on board initially
		board[0][3] = new Queen(Player.BLACK);
		board[0][4] = new King(Player.BLACK);
        board[7][3] = new Queen(Player.WHITE);
		board[7][4] = new King(Player.WHITE);

		//TODO: finish this method
	

	}

	public boolean isComplete() {
		// TODO: implement this method
		return false;
	}

	public boolean isValidMove(Move move) {
		// TODO:  implement this method
		return true;
	}

	public void move(Move move) {
		// TODO:  implement this method
		// after this board should be updated appropriately
		// don't forget to update pawn to queen if necessary
	}

	public boolean inCheck(Player p) {
		// TODO:  implement this method
		return false;
	}


	public Player currentPlayer() {
		return player;
	}

	public int numRows() {
		return 8;
	}

	public int numColumns() {
		return 8;
	}

	public ChessPiece pieceAt(int row, int column) {		
		return board[row][column];
	}

	public void setNextPlayer() {
		player = player.next();
	}

	public void setPiece(int row, int column, ChessPiece piece) {
		board[row][column] = piece;
	}

	public void undo() {
		// TODO: implement this method
		// undo the last move that has not yet been undone (should handle mutliple undos)
	}

	public void AI() {
		/* TODO: implement this method (manually graded)
		 * Write a simple AI set of rules in the following order. 
		 * a. Check to see if you are in check.
		 * 		i. If so, get out of check by moving the king or placing a piece to block the check 
		 * 
		 * b. Attempt to put opponent into check (or checkmate). 
		 * 		i. Attempt to put opponent into check without losing your piece
		 *		ii. Perhaps you have won the game. 
		 *
		 *c. Determine if any of your pieces are in danger, 
		 *		i. Move them if you can. 
		 *		ii. Attempt to protect that piece. 
		 *
		 *d. Move a piece (pawns first) forward toward opponent king 
		 *		i. check to see if that piece is in danger of being removed, if so, move a different piece.
		 */

	}
}
