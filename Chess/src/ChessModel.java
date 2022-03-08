import java.util.ArrayList;
import java.util.Random;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class ChessModel {	 
    private ChessPiece[][] board;
	private Player player;
	private ArrayList <Move> moves = new ArrayList<>();
	private ArrayList <ChessPiece> undoLocation = new ArrayList<>();
	private ArrayList <Integer> promotions = new ArrayList<>();
	private Move escapeDanger;
	private Move protectMove;
	private ChessPiece pieceInCheck;
	private int turnCounter;
	private int protect;


	

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

							moves.add(move);

							undoLocation.add(board[move.toRow][move.toColumn]);

							promotions.add(1);

							/** places a new queen where the pawn was moving to */
							board[move.toRow][move.toColumn] = new Queen(Player.BLACK);

							/** erases the pawn from it's original position */
							board[move.fromRow][move.fromColumn] = null;
							

					
						}
						/** the pawn is not moving to the end of the board */
						else
						{

							moves.add(move);

							undoLocation.add(board[move.toRow][move.toColumn]);

							promotions.add(0);

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


							moves.add(move);

							undoLocation.add(board[move.toRow][move.toColumn]);

							promotions.add(1);


							board[move.toRow][move.toColumn] = new Queen(Player.WHITE);

							/** erases the pawn from it's original position */
							board[move.fromRow][move.fromColumn] = null;

						
						}
						/** the pawn is not moving to the end of the board */
						else
						{
							moves.add(move);

							undoLocation.add(board[move.toRow][move.toColumn]);

							promotions.add(0);


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

					moves.add(move);

					undoLocation.add(board[move.toRow][move.toColumn]);

					promotions.add(0);


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
		* @param Player The player whose check is in question is passed in
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


	public void undo(){
	
		/** new reference for the last element in moves ArrayList
		 * this is the move that was last made
		 */
		Move undoMove = moves.get(moves.size()-1);

		/** new reference for the last element in undoLocation ArrayList
		 * this is the piece that was at a move's to location
		 */
		ChessPiece undoPiece = undoLocation.get(undoLocation.size()-1);

		Integer promotion = promotions.get(promotions.size()-1);

		/** creates new reference for the undo move
		 * switches the "from row" and "from column" to 
		 * the "to row" and "to column", and switches the 
		 * "to row" and "to column" to the new "from row"
		 * and "from column"
		 */
		int undoFromRow = undoMove.toRow;
		int undoFromColumn = undoMove.toColumn;
		int undoToRow = undoMove.fromRow;
		int undoToColumn = undoMove.fromColumn;

		if(promotion == 1)
		{
			/** sets the piece that was moved to it's precious location */
			board[undoToRow][undoToColumn] = new Pawn(player.next());
		
			/** sets the piece that was in the spot before the move
			 * back into it's place. Can be null
			 */
			setPiece(undoFromRow, undoFromColumn, undoPiece);



			/** removes the undo move from the moves ArrayList */
			moves.remove(moves.size()-1);

			/** removes the piece replaced by the undo from the
			 * undoLocation ArrayList
			 */
			undoLocation.remove(undoLocation.size()-1);

			/** removes the last moves promotion */
			promotions.remove(promotions.size()-1);

			setNextPlayer();
		}
		/** the move was not a promotion (0) */
		else
		{

			/** sets the piece that was moved to it's precious location */
			setPiece(undoToRow, undoToColumn, pieceAt(undoFromRow, undoFromColumn));
		
			/** sets the piece that was in the spot before the move
			 * back into it's place. Can be null
			 */
			setPiece(undoFromRow, undoFromColumn, undoPiece);



			/** removes the undo move from the moves ArrayList */
			moves.remove(moves.size()-1);

			/** removes the piece replaced by the undo from the
			 * undoLocation ArrayList
			 */
			undoLocation.remove(undoLocation.size()-1);

			/** removes the last moves promotion */
			promotions.remove(promotions.size()-1);
			
			setNextPlayer();
		}

	}










	/***************************************************************************************************************

		* This is a helper method for AI, to check if a piece at
		* a location is in danger of being attacked
		* @param row the row of the piece to be checked if in danger
		* @param column the column of the piece to be checked if in danger

	***************************************************************************************************************/
	private boolean inDanger(int row, int col)
	{

		boolean inDanger = false;

		// loop through every space on board
		for(int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{
				if(pieceAt(x, y) != null)
				{
					// checks if the piece at location being checked is white
					if(pieceAt(x, y).player() == Player.WHITE)
					{
						Move attack = new Move(x, y, row, col);
						
						if(isValidMove(attack))
						{
							return true;
						}
						else
						{/** the move is not valid for piece attacking queen */}
					}
				}
			}
		}
		return inDanger;
	}


	/***************************************************************************************************************

		* This is a helper method for AI, to check if a piece at
		* a location can escape from being in danger
		* @param row the row of the piece to be checked
		* @param column the column of the piece to be checked

	***************************************************************************************************************/
	private boolean escapeDanger(int fromRow, int fromCol)
	{

		boolean canEscape = false;

		for(int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{
				// creates Move "m" from piece's location to location being checked
				Move escape = new Move(fromRow,fromCol,x,y);

				// checks if the move is valid for a piece
				if(isValidMove(escape))
				{
					
					ChessPiece piece = board[fromRow][fromCol];
					ChessPiece other = board[x][y];

					setPiece(x, y, piece);

					board[fromRow][fromCol] = null;

					if(inDanger(x, y))
					{
						setPiece(fromRow, fromCol, piece);

						board[x][y] = other;

					}
					else
					{
						setPiece(fromRow, fromCol, piece);

						board[x][y] = other;

						escapeDanger = escape;

						return true;
					}
				}
			}
		}

		return canEscape;

				
	}


	/***************************************************************************************************************

		* This is a helper method for AI, to check if a piece at
		* a location can be protected from danger
		* @param row the row of the piece to be checked
		* @param column the column of the piece to be checked
		* @return boolean, true if the piece can be protected,
		* false otherwise

	***************************************************************************************************************/
	private boolean protectPiece(int row, int col)
	{
		//check for sacrifice for queen

		boolean canProtect = false;

		// loops through all the rows in the chess board
		for (int x = 0; x < 8; x++)
		{
			// loops through all the columns in the chess board
			for (int y = 0; y < 8; y++)
			{
				// checks if the piece at each space is a king
				if(pieceAt(x, y) != null)
				{
					// if the piece at a space is black
					if(pieceAt(x, y).player() == Player.BLACK)
					{
							// loops through all the rows
							for (int rows = 0; rows < 8; rows++)
							{
								// loops through all the columns
								for (int columns = 0; columns < 8; columns++)
								{

									// creates Move "m" from piece's location to location being checked
									Move helpPiece = new Move(x,y,rows,columns);

									if(isValidMove(helpPiece))
									{

										ChessPiece piece = board[x][y];
										ChessPiece other = board[rows][columns];
					
										setPiece(rows, columns, piece);

										board[x][y] = null;


										// checks if the move is valid for a piece
										if(inDanger(row, col))
										{

											setPiece(x, y, piece);

											board[rows][columns] = other;

										}
										else
										{
											setPiece(x, y, piece);

											board[rows][columns] = other;

											protectMove = helpPiece;

											return true;
										}
									}
								}
							}
					}
				}
			}
		}
		return canProtect;
	}


	/***************************************************************************************************************

		* This is a helper method for AI, to check if a piece at
		* a location is in danger, and if a move can be made to
		* avoid the danger. Uses helper methods inDanger(),
		* escapeDanger(), and protectPiece()
		* @param type The type of piece to be checked
		* @return boolean, true if the piece can escape danger,
		* false otherwise

	***************************************************************************************************************/
	private boolean checkPiece(String type)
	{

		boolean check = false;

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
						// checks if queen is in danger
						if(pieceAt(r, c).type() == type)
						{
							if(inDanger(r, c))
							{
								if(escapeDanger(r,c))
								{
									pieceInCheck = pieceAt(r, c);
									return true;
								}
								else if(protectPiece(r, c))
								{
									pieceInCheck = pieceAt(r, c);
									return true;
								}
							}
						}
					}
				}
			}
		}
		return check;
	}
	

	/***************************************************************************************************************

		* This is a helper method for AI, to check if a piece in danger
		* would put another piece in danger if it escaped from danger
		* @param type The type of piece to be checked
		* @return boolean, true if the move to protect a piece
		* would result in another piece being in danger,
		* false otherwise
		
	***************************************************************************************************************/
	private boolean otherPieceInDanger(String type)
	{

		if(escapeDanger == null)
		{
			return false;
		}

		boolean check = false;

		ChessPiece escapeLocation = board[escapeDanger.toRow][escapeDanger.toColumn];

		setPiece(escapeDanger.toRow, escapeDanger.toColumn, pieceInCheck);
		board[escapeDanger.fromRow][escapeDanger.fromColumn] = null;

		for(int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{
				if(pieceAt(x, y) != null && pieceAt(x, y).type() == type)
				{
					if(inDanger(x, y))
					{
						return true;
					}
					else
					{/** nothing */}
				}
			}
		}

		setPiece(escapeDanger.fromRow, escapeDanger.fromColumn, pieceInCheck);
		board[escapeDanger.toRow][escapeDanger.toColumn] = escapeLocation;

		if(protectMove == null)
		{
			return false;
		}

		ChessPiece protectLocation = board[protectMove.toRow][protectMove.toColumn];

		setPiece(protectMove.toRow, protectMove.toColumn, pieceInCheck);
		board[protectMove.fromRow][protectMove.fromColumn] = null;

		for(int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{
				if(pieceAt(x, y) != null && pieceAt(x, y).type() == type)
				{
					if(inDanger(x, y))
					{
						return true;
					}
					else
					{/** nothing */}
				}
			}
		}

		setPiece(protectMove.fromRow, protectMove.fromColumn, pieceInCheck);
		board[protectMove.toRow][protectMove.toColumn] = protectLocation;

		
		return check;
	}


	/***************************************************************************************************************

		* This is a helper method for AI, to protect a piece from danger
		* by moving it or using another piece to protect it
		* @param type The type of piece to be checked
		
	***************************************************************************************************************/
	private void moveToProtect(String type)
	{

							
		if(escapeDanger != null)
		{
			if(isValidMove(escapeDanger))
			{
				move(escapeDanger);
			}
		}
		else if(protectMove != null)
		{
			if(isValidMove(protectMove))
			{
				move(protectMove);
			}
		}
							
	}


	/***************************************************************************************************************

		* This is a helper method for AI, if AI is in check,
		* move to escape being in check, or move to protect the king
		
	***************************************************************************************************************/
	private void avoidCheck()
	{
		if(inCheck(Player.BLACK))
		{
			// loops through all the rows in the chess board
			for (int r = 0; r < 8; r++)
			{
				// loops through all the columns in the chess board
				for (int c = 0; c < 8; c++)
				{
					if(protect != 1)
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

											ChessPiece piece = board[r][c];
											ChessPiece other = board[row][col];

											setPiece(row, col, piece);
											board[r][c] = null;

											if(!(inCheck(Player.BLACK)))
											{
												setPiece(r, c, piece);
												board[row][col] = other;
												move(m);
												protect = 1;
											}
											else
											{
												// keep checking cpu, you got this
												setPiece(r, c, piece);
												board[row][col] = other;											
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
		}
	}


	/***************************************************************************************************************

		* This is a helper method for the AI, attempts to
		* put the other player in check if it is possible
		
	***************************************************************************************************************/
	private void putInCheck()
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
								Move move = new Move(r,c,row,col);

								// checks if the move is valid for a piece
								if(isValidMove(move))
								{
									
									ChessPiece piece = pieceAt(move.fromRow, move.fromColumn);
									ChessPiece other = pieceAt(move.toRow,move.toColumn);

									setPiece(move.toRow, move.toColumn, pieceAt(move.fromRow, move.fromColumn));

									board[move.fromRow][move.fromColumn] = null;

									if(isComplete())
									{
										board[move.fromRow][move.fromColumn] = piece;
										board[move.toRow][move.toColumn] = other;
										move(move);
										protect = 1;
									
									}
									else if((inCheck(player.next())))
									{
										
										board[move.fromRow][move.fromColumn] = piece;
										board[move.toRow][move.toColumn] = other;
										move(move);
										protect = 1;
									
									}
									else
									{
										board[move.fromRow][move.fromColumn] = piece;
										board[move.toRow][move.toColumn] = other;
									}
								}
								else
								{/** the move is not valid and should not be carried out */}
							}
							
						}
					}
					else{/** the piece does not belong to the AI */}
				}
				else{/** there is no piece in the location being checked */}
			}
		}
	}






	private void queenPawn()
	{
		if(turnCounter == 1)
		{
			if(pieceAt(5, 3) != null)
			{
				queenPawnOffense();
			}
			else if(pieceAt(4,3) != null)
			{
				queenPawnDefense();
			}
		}
		if(turnCounter == 2)
		{
			if(pieceAt(5, 3) != null && pieceAt(5, 2) != null)
			{
				queenPawnOffense();
			}
			else
			{
				queenPawnDefense();
			}
		}
		if(turnCounter == 3)
		{
			if(pieceAt(5, 3) != null && pieceAt(5, 2) != null)
			{
				queenPawnOffense();
			}
			else
			{
				queenPawnDefense();
			}

		}
		if(turnCounter > 3)
		{
			generalPiece();
		}
	}

	private void queenPawnOffense()
	{
		if(turnCounter == 1)
		{
			Move open = new Move(1,3,3,3);
			if(isValidMove(open))
			{
				move(open);
				protect = 1;

			}
			else
			{
				generalPiece();
			}
		}
		if(turnCounter == 2)
		{
			Move second = new Move(1,2,2,2);
			if(isValidMove(second))
			{
				move(second);
				protect = 1;

			}
			else
			{
				generalPiece();
			}
		}
		if(turnCounter == 3)
		{
			Move third = new Move(0,2,1,3);
			if(isValidMove(third))
			{
				move(third);
				protect = 1;

			}
			else
			{
				generalPiece();
			}
		}
	}

	private void queenPawnDefense()
	{
		if(turnCounter == 1)
		{
			Move open = new Move(1,6,2,6);
			if(isValidMove(open))
			{
				move(open);
				protect = 1;

			}
			else
			{
				generalPiece();
			}
		}
		if(turnCounter == 2)
		{
			Move second = new Move(0,6,2,5);
			if(isValidMove(second))
			{
				move(second);
				protect = 1;

			}
			else
			{
				generalPiece();
			}
		}
		if(turnCounter == 3)
		{
			Move third = new Move(0,5,1,6);
			if(isValidMove(third))
			{
				move(third);
				protect = 1;

			}
			else
			{
				generalPiece();
			}
			
		}
		if(turnCounter > 4)
		{
			generalPiece();
		}
	}

	private void kingPawnStart()
	{
		if(turnCounter == 1)
		{
			Move open = new Move(1,4,3,4);
			if(isValidMove(open))
			{
				move(open);
				protect = 1;

			}
			else
			{
				generalPiece();
			}
		}
		if(turnCounter == 2)
		{
			Move second = new Move(1,3,2,3);
			if(isValidMove(second))
			{
				move(second);
				protect = 1;

			}
			else
			{
				generalPiece();
			}
		}
		if(turnCounter > 2)
		{
			generalPiece();
		}
	}

	private boolean isPossibleMove(int fr, int fc)
	{
		boolean isPossibleMove = false;
		for(int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{
				Move move = new Move(fr,fc,x,y);
				if(isValidMove(move))
				{
					return true;
				}

			}
		}
		return isPossibleMove;
	}
	
	private void generalMove(int fr, int fc)
	{
		Random r = new Random();
		Random c = new Random();

		int row = r.nextInt(8);
		int col = c.nextInt(8);

		Move move = new Move(fr,fc,row,col);
		if(isValidMove(move))
		{
			move(move);
			protect = 1;

		}
		else
		{
			generalMove(fr, fc);
		}
	}

	private void generalPiece()
	{
		Random r = new Random();
		Random c = new Random();
		
		int row = r.nextInt(8);
		int col = c.nextInt(8);

		if(pieceAt(row,col) != null && pieceAt(row,col).player() == Player.BLACK)
		{
			if(isPossibleMove(row, col))
			{
				generalMove(row,col);
			}
			else
			{
				generalPiece();
			}
		}
		else
		{
			generalPiece();
		}
	}


	public void AI() {
		
		setNextPlayer();
		turnCounter++;
		escapeDanger = null;
		protectMove = null;
		protect = 0;
		/*******************************************************************************************
		 * 
		 *  Checking if the AI is in check
		 * 	and if they are, make move to get out of check
		 * 
		 *******************************************************************************************/

		avoidCheck();


		/************************************************************************************** 
		 * 
		 *  Checking if AI can put the player in check
		 * 
		****************************************************************************************/

		putInCheck();

		/************************************************************************************************************
		 * 
		 * 			Checking if AI piece is in danger
		 * 			Prioritize important pieces
		 * 
		 ***********************************************************************************************************/


		/** 
		 * checks if the queen is in danger
		 * if true, move to protect queen
		 */
		if(protect != 1)
		{
			if(checkPiece("Queen"))
			{
				if(!(otherPieceInDanger("King")))
				{
					
					moveToProtect("Queen");
					protect = 1;

					
				}
			}
		}
		

		/** 
		 * checks if the bishop is in danger
		 * if true, checks if the move would put
		 * the queen in danger. If it would not,
		 * move to protect bishop
		 */
		if(protect != 1)
		{
			if(checkPiece("Bishop"))
			{
				if(!(otherPieceInDanger("King")))
				{
					if(!(otherPieceInDanger("Queen")))
					{
						
						moveToProtect("Bishop");
						protect = 1;

					}

				}
			}
		}


		/** 
		 * checks if rook is in danger
		 * if true, checks if the move would put
		 * the queen in danger or bishop in
		 * danger. If it would not,
		 * move to protect rook
		 */
		if(protect != 1)
		{
			if(checkPiece("Rook"))
			{
				if(!otherPieceInDanger("King"))
				{
					if(!(otherPieceInDanger("Queen")))
					{
						if(!(otherPieceInDanger("Bishop")))
						{
							
							moveToProtect("Rook");
							protect = 1;
						}
					}
				}
			}
		}


		/** 
		 * checks if knight is in danger
		 * if true, checks if the move would put
		 * the queen,bishop or rook in
		 * danger. If it would not,
		 * move to protect knight
		 */
		if(protect != 1)
		{
			if(checkPiece("Knight"))
			{
				if(!(otherPieceInDanger("King")))
				{
					if(!(otherPieceInDanger("Queen")))
					{
						if(!(otherPieceInDanger("Bishop")))
						{
							if(!(otherPieceInDanger("Rook")))
							{
								
								moveToProtect("Knight");
								protect = 1;
							}
						}
					}
				}
			}
		}



		/** 
		 * checks if pawn is in danger
		 * if true, checks if the move would put
		 * the queen,bishop, rook, or knight in
		 * danger. If it would not,
		 * move to protect pawn
		 */
		if(protect != 1)
		{
			if(checkPiece("Pawn"))
			{
				if(!(otherPieceInDanger("King")))
				{
					if(!(otherPieceInDanger("Queen")))
					{
						if(!(otherPieceInDanger("Bishop")))
						{
							if(!(otherPieceInDanger("Rook")))
							{
								if(!(otherPieceInDanger("Knight")))
								{
									
									moveToProtect("Pawn");
									protect = 1;

								}

									
							}
						}
					}
				}	
			}
		}

		String start = "";

		if(protect != 1)
		{
			if(turnCounter == 1)
			{
				if(pieceAt(6, 3) == null)
				{
					start = "Queen";
					queenPawn();
				}
				else if(pieceAt(6, 4) == null)
				{
					start = "King";
					kingPawnStart();
				}
				else
				{
					start = "Other";
					generalPiece();

				}
			}
			else if(turnCounter >= 1 && turnCounter < 4)
			{
				if(start == "Queen")
				{
					queenPawn();
				}
				else if(start == "King")
				{
					kingPawnStart();
				}
				else if(start == "Other" || start == "")
				{
					generalPiece();
				}
				else
				{
					generalPiece();
				}
			}
			else
			{
				generalPiece();
			}
		}
	

		


		
		
		
		
		/* TODO: implement this method (manually graded)

		 * Write a simple AI set of rules in the following order. 
		 * a. Check to see if you are in check.
		 * 		i. If so, get out of check by moving the king or placing a piece to block the check 
		 * 
		 * DONE
		 * 
		 * b. Attempt to put opponent into check (or checkmate). 
		 * 		i. Attempt to put opponent into check without losing your piece
		 * 
		 * 		DONE
		 * 
		 * 
		 *		ii. Perhaps you have won the game. 
		 *
		 *c. Determine if any of your pieces are in danger, 
		 *		i. Move them if you can. 
		 *		ii. Attempt to protect that piece. 

		 		Done
		 *
		 *d. Move a piece (pawns first) forward toward opponent king 
		 *		i. check to see if that piece is in danger of being removed, if so, move a different piece.
		 */

	}
}
					
