public class ChessModel {	 
    private ChessPiece[][] board;
	private Player player;
	

	// declare other instance variables as needed


	/***************************************************************************************************
		 * 
		 * Constructor for a chess model that creates a board,
		 * full with the pieces in their staring location,
		 * and also sets the current player to white.
		 * 
	 ***************************************************************************************************/
	public ChessModel() {

		/** sets the board variable to a new board that has
		 * 8 rows and 8 columns
		 */
		board = new ChessPiece[8][8];

		/** sets the player variable to White for the start
		 * of the game
		 */
		player = Player.WHITE;


		/** 
		 * The next section of the constructor sets all the piece
		 * to their correct starting location
		 */


		/************* PAWNS **************************/	
		board[6][0] = new Pawn(Player.WHITE);
		board[6][1] = new Pawn(Player.WHITE);
		board[6][2] = new Pawn(Player.WHITE);
		board[6][3] = new Pawn(Player.WHITE);
		board[6][4] = new Pawn(Player.WHITE);
		board[6][5] = new Pawn(Player.WHITE);
		board[6][6] = new Pawn(Player.WHITE);
		board[6][7] = new Pawn(Player.WHITE);
		board[1][0] = new Pawn(Player.BLACK);
		board[1][1] = new Pawn(Player.BLACK);
		board[1][2] = new Pawn(Player.BLACK);
		board[1][3] = new Pawn(Player.BLACK);
		board[1][4] = new Pawn(Player.BLACK);
		board[1][5] = new Pawn(Player.BLACK);
		board[1][6] = new Pawn(Player.BLACK);
		board[1][7] = new Pawn(Player.BLACK);
		/***********************************************/


		/*********** Knights ***************************/
		board[7][1] = new Knight(Player.WHITE);
		board[7][6] = new Knight(Player.WHITE);
		board[0][1] = new Knight(Player.BLACK);
		board[0][6] = new Knight(Player.BLACK);
		/**********************************************/


		/*********** Bishops **************************/
		board[7][2] = new Bishop(Player.WHITE);
		board[7][5] = new Bishop(Player.WHITE);
		board[0][2] = new Bishop(Player.BLACK);
		board[0][5] = new Bishop(Player.BLACK);
		/**********************************************/


		/************ Rooks ***************************/
		board[0][0] = new Rook(Player.BLACK);
		board[0][7] = new Rook(Player.BLACK);
		board[7][0] = new Rook(Player.WHITE);
		board[7][7] = new Rook(Player.WHITE);
		/**********************************************/


		/******** Kings & Queens **********************/
		board[0][3] = new Queen(Player.BLACK);
		board[0][4] = new King(Player.BLACK);
        board[7][3] = new Queen(Player.WHITE);
		board[7][4] = new King(Player.WHITE);
	}


	/*********************************************************************************************************************************
		
		 * Helper method for isComplete(),
		 * checks if the king has any available moves
		 * to get out of check, or to get out of checkmate
		 * @return boolean
		 * set to true if the king has no moves available
		 * to stay out of check,
		 * false otherwise
		
	 *********************************************************************************************************************************/
	private boolean kingNoMoves() {
		
		boolean complete = true;;

		if(currentPlayer() == Player.BLACK)
		{
			// loops through all the rows in the chess board
			for (int kingRow = 0; kingRow < 8; kingRow++)
			{
				// loops through all the columns in the chess board
				for (int kingCol = 0; kingCol < 8; kingCol++)
				{
					// checks if the piece at each space is a king
					if(pieceAt(kingRow, kingCol) != null && pieceAt(kingRow, kingCol).type().equals("King"))
					{
						// if the piece at a space is a king, checks if it is black
						if(pieceAt(kingRow, kingCol).player() == Player.BLACK)
						{
							
								// loops through all the rows
								for (int row = 0; row < 8; row++)
								{
									// loops through all the columns
									for (int col = 0; col < 8; col++)
									{
										// creates Move "m" from king location to location being checked
										Move m = new Move(kingRow,kingCol,row,col);

										// checks if the move is valid for a chess piece
										if(isValidMove(m))
										{
											return false;
										}
										else{/* the space at board[row][column] is null - do nothing*/}
									}
								}
						}
					}
				}
			}
		}
		// current player is white
		else
		{
			// loops through all the rows in the chess board
			for (int r = 0; r < 8; r++)
			{
				// loops through all the columns in the chess board
				for (int c = 0; c < 8; c++)
				{
					// checks if the piece at each space is a king
					if(pieceAt(r, c) != null && pieceAt(r, c).type().equals("King"))
					{
						// if the piece at a space is a king, checks if it is black
						if(pieceAt(r, c).player() == Player.WHITE)
						{
								// loops through all the rows
								for (int row = 0; row < 8; row++)
								{
									// loops through all the columns
									for (int col = 0; col < 8; col++)
									{
										// creates Move "m" from king location to location being checked
										Move m = new Move(r,c,row,col);

										// checks if the move is valid for a king
										if(isValidMove(m))
										{
											return false;
										}
										else{/* the space at board[row][column] is null - do nothing*/}
									}
								}
						}
					}
				}
			}
		}




		
		return complete;
	}


	/*********************************************************************************************************************************
	 
		* Helper method for isComplete(), 
		* checks if there is a move available
		* if player cannot move without invoking check,
		* then it is checkmate
		* @return boolean
		* set to true if there is no move available for a piece
		* to get out of check,
		* false otherwise
	 
	 *********************************************************************************************************************************/
	private boolean noOtherMoves() {
		
		/** creating a boolean variable to hold
		 * whether any piece has a move that will
		 * get the current player out of check
		 */
		boolean complete = true;
		
		/** checks if the current player is black */
		if(currentPlayer() == Player.BLACK)
		{
			// loops through all the rows in the chess board
			for (int r = 0; r < 8; r++)
			{
				// loops through all the columns in the chess board
				for (int c = 0; c < 8; c++)
				{
					// checks if the piece at each space is a king
					if(pieceAt(r, c) != null)
					{
						// if the piece at a space is black
						if(pieceAt(r, c).player() == Player.BLACK)
						{
								// loops through all the rows
								for (int row = 0; row < 8; row++)
								{
									// loops through all the columns
									for (int col = 0; col < 8; col++)
									{

										// creates Move "m" from piece's location to location being checked
										Move m = new Move(r,c,row,col);

										// checks if the move is valid for a piece
										if(isValidMove(m))
										{
											return false;
										}
										else{/* the space at board[row][column] is null - do nothing*/}
									}
								}
						}
					}
				}
			}
		}
		// current player is white
		else
		{
			// loops through all the rows in the chess board
			for (int r = 0; r < 8; r++)
			{
				// loops through all the columns in the chess board
				for (int c = 0; c < 8; c++)
				{
					// checks if the piece at each space is a king
					if(pieceAt(r, c) != null)
					{
						// if the piece at a space is white
						if(pieceAt(r, c).player() == Player.WHITE)
						{
							
							// loops through all the rows
							for (int row = 0; row < 8; row++)
							{
								// loops through all the columns
								for (int col = 0; col < 8; col++)
								{
									// creates Move "m" from piece location to location being checked
									Move m = new Move(r,c,row,col);

									// checks if the move is valid for a piece
									if(isValidMove(m))
									{
										return false;
									}
									else{/* the space at board[row][column] is null - do nothing*/}
								}
							}
						}
					}
				}
			}
		}
		return complete;


	}


	/*********************************************************************************************************************************
	
		* Method that checks if the game is over
		* by checkmate, or king taken
		* Uses helper methods kingNoMoves(), noOtherMoves(), and isNoKing()
		* @return boolean
		* set to true if the game is complete
		* false otherwise
	
	 *********************************************************************************************************************************/
	public boolean isComplete() {

		boolean complete = false;
		

			if(kingNoMoves())
			{
				if(noOtherMoves())
				{
					complete = true;
				}
			}
		
		
		
		return complete;
	}


	/***************************************************************************************************************

		* This method is used to check if a move is valid at a whole game level
		* Checks if the move is valid for a general chess piece, 
		* a specific chess piece,
		* and also makes sure the move does not put the player into check
		* @param move A move object is passed in, which contains a from location
		* in rows and columns, and a to location also in rows and columns.
		* @return boolean: true if move is valid, false otherwise

	***************************************************************************************************************/
	public boolean isValidMove(Move move) {
		
		/** create boolean variable 
		 * set to true if move is valid
		 * false otherwise
		 */
		boolean validMove = false;

		/** checks if the starting location in move has a piece there */
		if(board[move.fromRow][move.fromColumn] != null)
		{

			/** checks if the move is valid for a general chess piece */
			if(pieceAt(move.fromRow, move.fromColumn).isValidMove(move, board))
			{
						ChessPiece piece = pieceAt(move.fromRow, move.fromColumn);
						ChessPiece other = pieceAt(move.toRow,move.toColumn);

						setPiece(move.toRow, move.toColumn, pieceAt(move.fromRow, move.fromColumn));

						board[move.fromRow][move.fromColumn] = null;

						if(!(inCheck(currentPlayer())))
						{
							validMove = true;
							board[move.fromRow][move.fromColumn] = piece;
							board[move.toRow][move.toColumn] = other;
						}
						else
						{
							board[move.fromRow][move.fromColumn] = piece;
							board[move.toRow][move.toColumn] = other;
						}
			}
		}
		return validMove;
	}


	/***************************************************************************************************************

		* This method is used to carry out the move stored in move on
		* the game board. Updates players position and board accordingly
		* and also promotes a pawn if they have reached the end of the board
		* @param move the current move object that has a from location in
		* rows and columns, and a to location also in rows and columns

	***************************************************************************************************************/
	public void move(Move move) {
		
			/** checks if the move is valid for the chess piece */
			if(isValidMove(move))
			{
				
				/** checks if the piece is a pawn */
				if(pieceAt(move.fromRow, move.fromColumn).type().equals("Pawn"))
				{

					/** checks if the piece is black */
					if(currentPlayer() == Player.BLACK)
					{
						setNextPlayer();

						/** checks if the pawn is moving to the last row */
						if(move.toRow == 7){

							/** places a new queen where the pawn was moving to */
							board[move.toRow][move.toColumn] = new Queen(Player.BLACK);

							/** erases the pawn from it's original position */
							board[move.fromRow][move.fromColumn] = null;
							

					
						}
						/** the pawn is not moving to the end of the board */
						else
						{
							setPiece(move.toRow, move.toColumn, pieceAt(move.fromRow, move.fromColumn));

							board[move.fromRow][move.fromColumn] = null;

						
						}
					}
					/** the piece is not black */
					else
					{
						setNextPlayer();
						/** checks if the pawn is moving to the last row */
						if(move.toRow == 0){

							board[move.toRow][move.toColumn] = new Queen(Player.WHITE);

							/** erases the pawn from it's original position */
							board[move.fromRow][move.fromColumn] = null;

						
						}
						/** the pawn is not moving to the end of the board */
						else
						{
							
							// sets the piece to the location it's moving to
							setPiece(move.toRow, move.toColumn, pieceAt(move.fromRow, move.fromColumn));

							// erases the piece from it's original location
							board[move.fromRow][move.fromColumn] = null;

						
						}
					}
				}
				else
				{
					setNextPlayer();
					/** sets the piece to the location it's is moving to */
					setPiece(move.toRow, move.toColumn, pieceAt(move.fromRow, move.fromColumn));

					// erases the piece from its original location
					board[move.fromRow][move.fromColumn] = null;

				}
			}
			else
			{/** the move is not valid and cannot be carried out */	}



		
		// after this board should be updated appropriately
		// don't forget to update pawn to queen if necessary
	}


	/***************************************************************************************************************

		* This method is used to check if a player is in check from their opponent
		* If the King does not move, it can be taken and the game is over
		* @param p The player whose check is in question is passed in
		* @return boolean: true if player is in check, false otherwise

	***************************************************************************************************************/
	public boolean inCheck(Player p) {
		
		// create boolean variable to return true if Player "p's" king is in check
		// false otherwise
		boolean isCheck = false;

		// checks if the Player "p" is Black
		if(p == Player.BLACK)
		{
			// loops through all the rows in the chess board
			for (int r = 0; r < 8; r++)
			{
				// loops through all the columns in the chess board
				for (int c = 0; c < 8; c++)
				{
					// checks if the piece at each space is a king
					if(pieceAt(r, c) != null && pieceAt(r, c).type().equals("King"))
					{
						// if the piece at a space is a king, checks if it is black
						if(pieceAt(r, c).player() == Player.BLACK)
						{
							// loops through all the rows
							for (int row = 0; row < 8; row++)
							{
								// loops through all the columns
								for (int col = 0; col < 8; col++)
								{
									// creates Move "m" from space checked from loop to King
									Move m = new Move(row,col,r,c);

									if(board[row][col] != null)
									{
										// checks if the piece in question can move to the location of the king
										if(isValidMove(m))
										{
											return true;
										}
									}
									else{/* the space at board[row][column] is null - do nothing*/}
								}
							}
						}
						else{/* the king at space (r,c) is not black */}
					}
					else{/* the piece at (r,c) is not of type King */}
				} 
			}
		}
		// the player is white
		else
		{
			// loops through all the rows in the chess board
			for (int r = 0; r < 8; r++)
			{
				// loops through all the columns in the chess board
				for (int c = 0; c < 8; c++)
				{
					// checks if the piece at each space is a king
					if(pieceAt(r, c) != null && pieceAt(r, c).type().equals("King"))
					{
						// if the piece at a space is a king, checks if it is black
						if(pieceAt(r, c).player() == Player.WHITE)
						{
							// loops through all the rows
							for (int row = 0; row < 8; row++)
							{
								// loops through all the columns
								for (int col = 0; col < 8; col++)
								{
									// creates Move "m" from space checked from loop to King
									Move m = new Move(row,col,r,c);

									if(board[row][col] != null)
									{
										// checks if the piece in question can move to the location of the king
										if(isValidMove(m))
										{
											return true;
										}
									}
									else{/* the space at board[row][column] is null - do nothing*/}
								}
							}
						}
						else{/* the king at space (r,c) is not white */}
					}
					else{/* the piece at (r,c) is not of type King */}
				} 
			}
		}
		return isCheck;
	}


	/************************************************************************************************************
	 
		* method to get the current player
		* @return player whose turn it is
	
	*************************************************************************************************************/
	public Player currentPlayer() {
		return player;
	}


	/*************************************************************************************************************
	 
		* method to get the number of rows
		* @return int 8, number of rows on chessboard
	
	*************************************************************************************************************/
	public int numRows() {
		return 8;
	}


	/************************************************************************************************************
	
		* method to get the number of columns
		* @return int 8, number of columns on chessboard
	
	**************************************************************************************************************/
	public int numColumns() {
		return 8;
	}



	/***************************************************************************************************************

		* This method is used to check what piece is at a certain spot
		* @param row the row of the space to be checked
		* @param column the column of the space to be checked
		* @return the board at a certain location, either a chess piece or null

	***************************************************************************************************************/
	public ChessPiece pieceAt(int row, int column) {		
		return board[row][column];
	}


	/***************************************************************************************************************

		* This method is used to set the turn to the next player

	***************************************************************************************************************/
	public void setNextPlayer() {
		player = player.next();
	}


	/***************************************************************************************************************

		* This method is used to set a chess piece to a certain location
		* @param row the row of the space the piece will be set to
		* @param column the column of the space the piece will be set to

	***************************************************************************************************************/
	public void setPiece(int row, int column, ChessPiece piece) {
		board[row][column] = piece;
	}



	public void undo() {
		// TODO: implement this method
		// undo the last move that has not yet been undone (should handle mutliple undos)



		// create an arrayList of moves
		// create an arrayList of pieces that the the player has moved to, stores a piece or null if the space was open

		// add move to arrayList once it's been made
		// add piece to arrayList if another piece moves there, adds null if there was no piece there

		// if undo is called, does reverse move, and resets piece if applicable

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
