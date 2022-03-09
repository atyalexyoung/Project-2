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


	/***************************************************************************************************************

		* This method is used to undo a move.
		* Can undo multiple move until the starting position
		* is reached

	***************************************************************************************************************/
	public void undo(){
	
		/** new reference for the last element in moves ArrayList
		 * this is the move that was last made
		 */
		Move undoMove = moves.get(moves.size()-1);

		/** new reference for the last element in undoLocation ArrayList
		 * this is the piece that was at a move's to location
		 */
		ChessPiece undoPiece = undoLocation.get(undoLocation.size()-1);

		/** 
		 * creates Integer object with reference "promotion"
		 * for the last element in the promotions ArrayList
		 */
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

		// checks if the move was a promotion from pawn to queen
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

			// sets the next player
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
			
			// sets the next player
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

		// loop through every row on the board
		for(int x = 0; x < 8; x++)
		{
			
			// loop through every column on the board
			for(int y = 0; y < 8; y++)
			{

				// checks if there is a piece at the location (x,y)
				if(pieceAt(x, y) != null)
				{

					// checks if the piece at location being checked is white
					if(pieceAt(x, y).player() == Player.WHITE)
					{

						/** creates move object with referene "attack" with
						 * fromRow = x, fromColumn = y,
						 * toRow = row and toColumn = col
						 */
						Move attack = new Move(x, y, row, col);
						
						// checks if the "attack" move is valid
						if(isValidMove(attack))
						{

							// returns true
							return true;

						}
						else
						{/** the move is not valid for piece attacking queen */}
					}
				}
			}
		}

		// returns inDanger boolean variable
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

		
		// initializes boolean variable "canEscape" to false
		boolean canEscape = false;

		// loops though every row on the board
		for(int x = 0; x < 8; x++)
		{

			// loops through every column on the board
			for(int y = 0; y < 8; y++)
			{

				// creates Move "m" from piece's location to location being checked
				Move escape = new Move(fromRow,fromCol,x,y);

				// checks if the move is valid for a piece
				if(isValidMove(escape))
				{
					
					// creates new reference "piece" for the starting location
					ChessPiece piece = board[fromRow][fromCol];

					// creates new reference "other" to the move location
					ChessPiece other = board[x][y];

					// sets the piece to the move location
					setPiece(x, y, piece);

					// sets the move from location to null
					board[fromRow][fromCol] = null;

					// checks if the piece at (x,y) is in danger
					if(inDanger(x, y))
					{

						// sets the piece back to original location
						setPiece(fromRow, fromCol, piece);

						// sets move location back to original condition
						board[x][y] = other;

					}
					// the piece at (x,y) is not in danger
					else
					{
						// sets the piece back to it's original location
						setPiece(fromRow, fromCol, piece);

						// sets the move location to it's original condition
						board[x][y] = other;

						// sets "escapeDanger" move to escape move
						escapeDanger = escape;

						// returns true
						return true;
					}
				}
			}
		}

		// returns canEscape boolean variable
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
									
									/**
									 * creates a new reference for the chess piece at the
									 * location of the piece being checked
									 */
									ChessPiece piece = pieceAt(move.fromRow, move.fromColumn);


									/**
									 * creates a new reference for the chess piece at the
									 * location of the move being checked
									 */
									ChessPiece other = pieceAt(move.toRow,move.toColumn);


									// sets the piece in question the the move location in question
									setPiece(move.toRow, move.toColumn, pieceAt(move.fromRow, move.fromColumn));

									// clears the initial location of the piece
									board[move.fromRow][move.fromColumn] = null;

									// checks if the move causes the game to be over
									if(isComplete())
									{

										// sets the piece to its original location
										board[move.fromRow][move.fromColumn] = piece;

										// sets the move location back to its original condition
										board[move.toRow][move.toColumn] = other;

										// moves the piece to the location
										move(move);

										// sets protect variable to 1
										protect = 1;
									
									}

									// checks if the move causes the player to be in check
									else if((inCheck(player.next())))
									{

										// sets the piece to its original location
										board[move.fromRow][move.fromColumn] = piece;

										// sets the move location back to its original condition
										board[move.toRow][move.toColumn] = other;

										// moves the piece to the location
										move(move);

										// sets protect variable to 1
										protect = 1;
									
									}
									else
									{

										// sets the piece to its original location
										board[move.fromRow][move.fromColumn] = piece;

										// sets the move location back to its original condition
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


	/***************************************************************************************************************

		* This is a helper method for the AI,
		* uses queenPawnOffense and queenPawnDefense
		* to make the first 3 moves of a game depending
		* on the players first 3 moves. Used if the player
		* moves the pawn in front of the queen first
		
	***************************************************************************************************************/
	private void queenPawn()
	{

		// checks if it's the first turn
		if(turnCounter == 1)
		{
			
			/**
			 * checks if the piece in front of the queen was
			 * moved 2 spaces
			 */
			if(pieceAt(5, 3) != null)
			{

				// exectures the queenPawnOffense() method
				queenPawnOffense();

			}

			/**
			 * checks if the piece in front of the queen was moved
			 * 1 space
			 */
			else if(pieceAt(4,3) != null)
			{

				// executes the queenPawnDefense() method
				queenPawnDefense();

			}
		}

		// checks if it's the second turn
		if(turnCounter == 2)
		{

			// checks if the the player is using queen's gambit start
			if(pieceAt(5, 3) != null && pieceAt(5, 2) != null)
			{

				// executes queenPawnOffense() method
				queenPawnOffense();

			}
			// the player is not using the queen's gambit start
			else
			{

				// executes queenPawnDefense() method
				queenPawnDefense();

			}
		}

		// checks if it's the third turn
		if(turnCounter == 3)
		{

			// checks if the player is using the queen's gambit start
			if(pieceAt(5, 3) != null && pieceAt(5, 2) != null)
			{

				// executes the queenPawnOffense() method
				queenPawnOffense();

			}
			// the player is not using the queen's gambit start
			else
			{

				// executes queenPawnDefense() method
				queenPawnDefense();

			}

		}

		// checks if the turn is greater than 3
		if(turnCounter > 3)
		{

			// executes the generalPiece() method
			generalPiece();

		}
	}


	/***************************************************************************************************************

		* This is a helper method for the AI,
		* and for queenPawn. Used if the player is using
		* the queen gambit's start.
		
	***************************************************************************************************************/
	private void queenPawnOffense()
	{

		// checks if the turn is 1
		if(turnCounter == 1)
		{

			/**
			 * creates a new move object with
			 * fromRow = 1, fromColumn = 3,
			 * toRow = 3, toColumn = 3
			 */
			Move open = new Move(1,3,3,3);

			// checks if the "open" move object is a valid move
			if(isValidMove(open))
			{

				// executes "open" move
				move(open);

				// sets protect int variable to 1
				protect = 1;

			}
			// the move is not valid for the pawn
			else
			{

				// executes generalPiece() method
				generalPiece();

			}
		}
		// checks if it's the second turn
		if(turnCounter == 2)
		{

			/**
			 * creates a move object "second" with
			 * fromRow = 1, fromColumn = 2,
			 * toRow = 2 and toColumn = 2
			 */
			Move second = new Move(1,2,2,2);

			// checks if move "second" is valid
			if(isValidMove(second))
			{

				// executes "second" move
				move(second);

				// sets int variable protect to 1
				protect = 1;

			}
			// the move "second" is not valid
			else
			{

				// executes generalPiece() method
				generalPiece();

			}
		}
		
		// checks if it's the third turn
		if(turnCounter == 3)
		{

			/**
			 * creates move object "third" with
			 * fromRow = 0, fromColumn = 2,
			 * toRow = 1 and toColumn = 3
			 */
			Move third = new Move(0,2,1,3);

			// checks if "third" move is valid
			if(isValidMove(third))
			{

				// executes "third" move
				move(third);

				// sets int variable "protect" to 1
				protect = 1;

			}
			// the move "third" is not valid
			else
			{

				// executes generalPiece() method
				generalPiece();

			}
		}
	}


	/***************************************************************************************************************

		* This is a helper method for the AI,
		* and for queenPawn. Used if the player moves the
		* pawn in front of the queen but is not using the
		* queen gambit's start
		
	***************************************************************************************************************/
	private void queenPawnDefense()
	{

		// checks if it's the 1st turn
		if(turnCounter == 1)
		{

			/** 
			 * creates move object "open" with
			 * fromRow = 1, fromColumn = 6,
			 * toRow = 2 and toColumn = 6
			 */
			Move open = new Move(1,6,2,6);

			// checks if "open" move is valid
			if(isValidMove(open))
			{

				// executes "open" move
				move(open);

				// sets int variable "protect" to 1
				protect = 1;

			}
			// the "open" move is not valid
			else
			{

				// executes generalPiece() method
				generalPiece();

			}
		}

		// checks if it's the second turn
		if(turnCounter == 2)
		{

			/** 
			 * creates new Move object "second" with
			 * fromRow = 0, fromColumn = 6,
			 * toColumn = 2 and toColumn = 5
			 */
			Move second = new Move(0,6,2,5);

			// checks if "second" move is valid
			if(isValidMove(second))
			{

				// executes "second" move
				move(second);

				// sets int variable "protect" to 1
				protect = 1;

			}
			// the "second" move is not valid
			else
			{

				// executes generalPiece() method
				generalPiece();

			}
		}

		// checks if it's the third turn
		if(turnCounter == 3)
		{

			/** 
			 * creates move object "third" with
			 * fromRow = 0, fromColumn = 5,
			 * toRow = 1 and toColumn = 6
			 */
			Move third = new Move(0,5,1,6);

			// checks if "third" move is valid
			if(isValidMove(third))
			{

				// executes "third" move
				move(third);

				// sets int variable "protect" to 1
				protect = 1;

			}
			// the "third" move is not valid
			else
			{

				// executes generalPiece() method
				generalPiece();

			}
			
		}

		// checks if the turn is greater than 4
		if(turnCounter >= 4)
		{

			// executes generalPiece() method
			generalPiece();

		}
	}


	/***************************************************************************************************************

		* This is a helper method for the AI,
		*  Used if the player moves the pawn in front
		* of the king for the start.
		
	***************************************************************************************************************/
	private void kingPawnStart()
	{

		// checks if it's the first turn
		if(turnCounter == 1)
		{

			/** 
			 * creates move object "open" with
			 * fromRow = 1, fromColumn = 4,
			 * toRow = 3 and toColumn = 4
			 */
			Move open = new Move(1,4,3,4);

			// checks if the "open" move is valid
			if(isValidMove(open))
			{

				// executes "open" move
				move(open);

				// sets "protect" variable to 1
				protect = 1;

			}
			// the move "open" is not valid
			else
			{
				// executes generalPiece() method
				generalPiece();
			}
		}

		// checks if it's the second turn
		if(turnCounter == 2)
		{

			/** 
			 * creates move object "second" with
			 * fromRow = 1, fromColumn = 3,
			 * toRow = 2 and toColumn = 3
			 */
			Move second = new Move(1,3,2,3);

			// checks if "second" move is valid
			if(isValidMove(second))
			{

				// executes "second" move
				move(second);

				// sets protect to 1
				protect = 1;

			}
			// the "second" move is not valid
			else
			{
				// executes generalPiece() method
				generalPiece();
			}
		}

		// checks if the turn is greater than 2
		if(turnCounter > 2)
		{
			// executes generalPiece() method
			generalPiece();
		}
	}


	/***************************************************************************************************************

		* This is a helper method for the AI,
		* and for generalPiece() method. Used to check
		* if a move is possible for a selected piece
		* @param fr from row of the piece being checked
		* @param fc from column of the piece being checked
		* @return boolean, true if a move is possible for the piece,
		* false otherwise
		
	***************************************************************************************************************/
	private boolean isPossibleMove(int fr, int fc)
	{

		/** 
		 * creates isPossibleMove variable 
		 * initialized to false
		 */
		boolean isPossibleMove = false;

		// for loop to go through every row
		for(int x = 0; x < 8; x++)
		{

			// for loop to go through every column
			for(int y = 0; y < 8; y++)
			{

				/**
				 * creates move object "move" with
				 * fromRow = fr parameter, fromColumn = fc parameter,
				 * toRow = x and toColumn = y
				*/
				Move move = new Move(fr,fc,x,y);

				// checks if the "move" move is valid
				if(isValidMove(move))
				{
					// return true
					return true;
				}

			}
		}

		// returns isPossibleMove
		return isPossibleMove;
	}
	

	/***************************************************************************************************************

		* This is a helper method for the AI,
		* and for generalPiece() method. Used to generate
		* a move for the piece selected in generatePiece()
		* @param fr from row of the piece to be moved
		* @param fc from column of the piece to be moved
		
	***************************************************************************************************************/
	private void generalMove(int fr, int fc)
	{

		// creates new Random object with reference "r"
		Random r = new Random();

		// creates new Random object with reference "c"
		Random c = new Random();

		// sets int variable "row" to random integer between 0 and 8
		int row = r.nextInt(8);

		// sets int variable "col" to random integer between 0 and 8
		int col = c.nextInt(8);

		/**
		 * creates new Move object "move" with
		 * fromRow = fr parameter, fromColumn = fc parameter,
		 * toRow = row and toColumn = col
		 */
		Move move = new Move(fr,fc,row,col);

		// checks if "move" move is valid
		if(isValidMove(move))
		{
			// executes "move" move
			move(move);

			// sets "protect" variable to 1
			protect = 1;

		}
		// the "move" move is not valid
		else
		{
			/**
			 * calls itself with fr and fc as parameters
			 * to generate to move location
			 */
			generalMove(fr, fc);
		}
	}


	/***************************************************************************************************************

		* This is a helper method for the AI,
		* uses generalMove() and isPossibleMove()
		* to select a piece to be moved
		
	***************************************************************************************************************/
	private void generalPiece()
	{

		// creates random number reference r
		Random r = new Random();

		// creates random number reference c
		Random c = new Random();
		
		/**
		 * sets random number between 0 and 8 to
		 * the int varibale row
		 */
		int row = r.nextInt(8);

		/**
		 * sets random number between 0 and 8 to
		 * the int varibale row
		 */
		int col = c.nextInt(8);


		// checks if there is a piece at the random spot is a black piece
		if(pieceAt(row,col) != null && pieceAt(row,col).player() == Player.BLACK)
		{

			// checks if a move is possible for that piece
			if(isPossibleMove(row, col))
			{

				/**
				 * executes the generalMove() method with the
				 * row and col variable as parameters
				 */
				generalMove(row,col);
			}

			// the move is not possible for this piece
			else
			{	

				// calls itself to generate new random numbers
				generalPiece();

			}
		}

		/** 
		 *  there is no piece or the piece
		 *  is not black at the generated location
		 * */
		else
		{

			// calls itself to generate new position
			generalPiece();

		}
	}


	/***************************************************************************************************************

		* This is a helper method for the AI,
		* uses generalMove() and isPossibleMove()
		* to select a piece to be moved
		
	***************************************************************************************************************/
	public void AI() {
		
		/** 
		 * sets the next player to the player and then
		 * carries out the code below
		 */
		setNextPlayer();

		/** 
		 * counter variable incremented by 1,
		 * used to check if a start move or general
		 * move should be made
		 */
		turnCounter++;

		/** escape danger Move object set to null */
		escapeDanger = null;

		/** protectMove Move object set to null */
		protectMove = null;

		/**
		 *  protect int variable set to zero
		 * used to ensure that the AI only carries out
		 * one move per turn. Set to one if a move is
		 * made by the AI
		 */
		protect = 0;


		/*******************************************************************************************
		 * 
		 *  Method that checks if the AI is in check
		 * 	and if they are, make move to get out of check
		 * 
		 *******************************************************************************************/
		avoidCheck();


		/************************************************************************************** 
		 * 
		 *  Method that checks if AI can put the player in check,
		 * move to put player in check if possible
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
		 * checks if the queen is in danger.
		 * if true, checks if protecting the queen would
		 * put the king into check. If it would not,
		 * move to protect the queen
		 */
		if(protect != 1)
		{
			if(checkPiece("Queen"))
			{
				if(!(otherPieceInDanger("King")))
				{
					
					moveToProtect("Queen");

					// sets the protect int variable to 1
					protect = 1;

					
				}
			}
		}
		

		/** 
		 * checks if the bishop is in danger
		 * if true, checks if the move would put
		 * the queen or King in danger. If it would not,
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

						// sets protect int variable to 1
						protect = 1;

					}

				}
			}
		}


		/** 
		 * checks if rook is in danger
		 * if true, checks if the move would put
		 * the king, queen, or bishop in
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

							// sets the protect int variable to 1
							protect = 1;
						}
					}
				}
			}
		}


		/** 
		 * checks if knight is in danger
		 * if true, checks if the move would put
		 * the king, queen, bishop or rook in
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

								// sets the protect int variable to 1
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
		 * the king, queen, bishop, rook, or knight in
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

		// sets start String variable to empty
		String start = "";

		// checks if the protect variable is not 1
		if(protect != 1)
		{

			// checks if the turn counter is 1
			if(turnCounter == 1)
			{
				/** 
				 * checks if the piece in front of the queen
				 * has been moved
				 */
				if(pieceAt(6, 3) == null)
				{

					// sets start String variable to "Queen"
					start = "Queen";

					// carries out queenPawn method
					queenPawn();
				}

				/**
				 * checks if the piece in front of the king
				 * has been moved
				 */
				else if(pieceAt(6, 4) == null)
				{

					// sets the start String variable to "King"
					start = "King";

					// executes the kingPawnStart() method
					kingPawnStart();
				}

				/**
				 * the piece that has been moved is not
				 * the pawn in front of the king or queen
				 */
				else
				{

					// sets start String Variable to Other
					start = "Other";

					// executes the generalPiece() method
					generalPiece();

				}
			}

			// checks if the turn is between 1 and 4
			else if(turnCounter >= 1 && turnCounter < 4)
			{

				// checks if the start was a Queen start
				if(start == "Queen")
				{

					// executes the queenPawn() method
					queenPawn();

				}

				// checks if the start was a king start
				else if(start == "King")
				{

					// executes the kingPawnStart() method
					kingPawnStart();

				}

				// checks if the start varibale is "Other"
				else if(start == "Other" || start == "")
				{

					// executes generalPiece() method
					generalPiece();

				}
				
				// To catch if the string variable was not set
				else
				{

					// executes generalPiece() method
					generalPiece();

				}
			}

			// the turn counter is over 3
			else
			{

				// executes generalPiece() method
				generalPiece();
			}
		}
	

		


		
		
		
		
		/* 

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
					
