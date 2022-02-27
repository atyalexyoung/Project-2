public class ChessModel {	 
    private ChessPiece[][] board;
	private Player player;
	

	// declare other instance variables as needed

	public ChessModel() {
		board = new ChessPiece[8][8];
		player = Player.WHITE;

		/********* ALL PAWNS *****************/	
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
		/***********************************/
		/************ knights **************/
		board[7][1] = new Knight(Player.WHITE);
		board[7][6] = new Knight(Player.WHITE);
		board[0][1] = new Knight(Player.BLACK);
		board[0][6] = new Knight(Player.BLACK);
		/***********************************/
		/****************bishops ***********/
		board[7][2] = new Bishop(Player.WHITE);
		board[7][5] = new Bishop(Player.WHITE);
		board[0][2] = new Bishop(Player.BLACK);
		board[0][5] = new Bishop(Player.BLACK);
		/************************************/
		/************** Rooks ***************/
		board[0][0] = new Rook(Player.BLACK);
		board[0][7] = new Rook(Player.BLACK);
		board[7][0] = new Rook(Player.WHITE);
		board[7][7] = new Rook(Player.WHITE);
		/************** Kings & Queens ******/
		board[0][3] = new Queen(Player.BLACK);
		board[0][4] = new King(Player.BLACK);
        board[7][3] = new Queen(Player.WHITE);
		board[7][4] = new King(Player.WHITE);

		//TODO: finish this method
	

	}

	public boolean isComplete() {

		boolean complete = true;

		if(currentPlayer() == Player.BLACK)
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
										// creates Move "m" from king location to location being checked
										Move m = new Move(r,c,row,col);

										// checks if the move is valid for a king
										if(board[row][col].isValidMove(m, board))
										{
											// sets king in location to be checked for checkmate
											//

											setPiece(r,c, pieceAt(row, col));


											// finish move to complete ??????? 




											//
											
											// 
											if(inCheck(currentPlayer()))
											{
												complete = true;
											}
											else
											{
												complete = false;
												break;
											}
										}
										else{/* the space is not a valid move for a king */}
									}
								}
						}
						else{/* the king does not belong to black */}
					}
					else{/* the piece is not a king or there is no piece in that location */}
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
										if(board[row][col].isValidMove(m, board))
										{
											// sets king in location to be checked for checkmate
											setPiece(row, col, pieceAt(r, c));
											
											// 
											if(inCheck(currentPlayer()))
											{
												complete = true;
											}
											else
											{
												complete = false;
												break;
											}
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

	public boolean isValidMove(Move move) {
		// TODO:  implement this method
		
		/** create boolean variable 
		 * set to true if move is valid
		 * false otherwise
		 */
		boolean validMove = false;


		/** checks if attempted move is valid for the piece */
		if(pieceAt(move.fromRow, move.fromColumn).isValidMove(move, board))
		{

			/** sets the piece to the move if valid */
			setPiece(move.toRow, move.toColumn, pieceAt(move.fromRow, move.fromColumn));

			/** checks if that move would cause the player to be in check */
			if(!(inCheck(currentPlayer())))
			{
				validMove = true;
			}
			else{/** the move would cause the player to be in check */}

		}
		else{/** the move is not valid for that piece */}


		return validMove;
	}

	public void move(Move move) {
		// TODO:  implement this method





		
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
										if(pieceAt(row, col).isValidMove(m, board))
										{
											isCheck = true;
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
										if(pieceAt(row, col).isValidMove(m, board))
										{
											isCheck = true;
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


	/**  
	 * method to get the current player
	 * @return player whose turn it is
	*/
	public Player currentPlayer() {
		return player;
	}


	/**  
	 * method to get the number of rows
	 * @return int 8, number of rows on chessboard
	*/
	public int numRows() {
		return 8;
	}


	/**  
	 * method to get the number of columns
	 * @return int 8, number of columns on chessboard
	*/
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
