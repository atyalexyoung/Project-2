public class Pawn extends ChessPiece {

	public Pawn(Player player) {
		super(player);
	}

	public String type() {
		return "Pawn";
	}
	/*
	Private helper method that checks if move is valid for pawn piece
	returns boolean 
	*/
	
	
	private boolean pawnIsValidMove(Move move, ChessPiece[][] board)
	{

		
		
		int rowDiff = move.toRow - move.fromRow;
		int colDiff = move.toColumn - move.fromColumn;

		boolean validMove = false;


		// checks if player is black
		if(this.player() == Player.BLACK)
		{
			// checks if the move is forward
			if(rowDiff > 0)
			{



				//************************
				// checks if diagonal move
				// ************************


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




				// ************************
				// the move is not diagonal
				//*************************


				else
				{



					//****************************** */
					// checks if in starting position
					// ********************************

					if(move.fromRow == 1)
					{
						// checks if the move is less than or equal to 2 and forward
						if(rowDiff <= 2 && colDiff == 0)
						{


							// if the pawn is moving forward 2


							if(rowDiff == 2)
							{
								// checks if there is no player in the way
								if(board[move.toRow][move.toColumn] == null && board[move.toColumn - 1][move.fromColumn] == null)
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




					// ****************************************
					// the pawn is not in the starting position
					// ****************************************



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





		// *********************
		// player is white
		// *********************



		else
		{
			System.out.println("The piece is white");
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










		/*

		// checks if the player is white (bottom of the board)
		if(board[move.fromRow][move.fromColumn].player() == Player.BLACK)
		{
			// checks if pawn is trying to move diagonally
			if(board[move.toRow][move.toColumn] == board[move.toRow + 1][move.toColumn + 1] || board[move.toRow][move.toColumn] == board[move.toRow + 1][move.toColumn - 1])
			{
				// checks if the position the pawn is moving to does not have a player there
				if (board[move.toRow][move.toColumn] != null)
				{
					// checks if the player in the spot is an enemy piece
					if(board[move.toRow][move.toColumn].player() == player().next())
					{
						validMove = true;
					}
				}
			}
			// the attempted move is not diagonal
			else
			{
				// checks if piece is in the starting position
				if(move.fromRow == 1)
				{
				// checks if the move is less than 2 but greater than zero
					if((move.toRow - move.fromRow) <= 2 && (move.toRow - move.fromRow) > 0)
					{
						// checks if the move is only going forward
						if(move.toColumn == move.fromColumn)
						{
							// checks if the pawn is trying to move 2 spaces and is on the white? side
							if((move.toRow - move.fromRow) == 2)
							{
								// checks if both the position the pawn is moving to and the spot before it have no players there
								if(board[move.toRow][move.toColumn] == null && board[move.toRow - 1][move.fromColumn] == null)
								{
									validMove = true;
								}
								else{/* the position the pawn is trying to move to has a player there  }
							}
							else if((move.toRow - move.fromRow) == 1)
							{
								if(board[move.toRow][move.toColumn] == null)
								{
									validMove = true;
								}
								else{/* there is a piece where the pawn is trying to move }
							}
							else{/* move is not forward 1 or 2 }

						}
						else{/* the move is not forward }

					}
					else{/* The move the pawn is trying to make is not valid for a pawn }
				}
				// the pawn is not in the starting position
				else
				{
					// checks if the move is 1 forward
					if(move.toRow == move.fromRow + 1 && move.toColumn == move.fromColumn)
					{
						
						
						if(board[move.toRow][move.toColumn] == null)
						{
							validMove = true;
						}
						else{/* there is a piece where the pawn is trying to move }
					

					}
					else{/* the move is not forward }

				}
			}
		}
		// the player is black
		else
		{
			// checks if pawn is trying to move diagonally
			if(board[move.toRow][move.toColumn] == board[move.toRow - 1][move.toColumn + 1] || board[move.toRow][move.toColumn] == board[move.toRow - 1][move.toColumn - 1])
			{
				// checks if the position the pawn is moving to does not have a player there
				if (board[move.toRow][move.toColumn] != null)
				{
					// checks if the player in the spot is an enemy piece
					if(board[move.toRow][move.toColumn].player() == player().next())
					{
						validMove = true;
					}
				}
			}
			// the attempted move is not diagonal
			else
			{
				// checks if piece is in the starting position
				if(move.fromRow == 7)
				{
				// checks if the move is less than 2 but greater than zero
					if((move.toRow - move.fromRow) >= -2 && (move.toRow - move.fromRow) < 0)
					{
						// checks if the move is only going forward
						if(move.toColumn == move.fromColumn)
						{
							// checks if the pawn is trying to move 2 spaces
							if((move.toRow - move.fromRow) == -2)
							{
								// checks if both the position the pawn is moving to and the spot before it have no players there
								if(board[move.toRow][move.toColumn] == null && board[move.toRow + 1][move.fromColumn] == null)
								{
									validMove = true;
								}
								else{/* the position the pawn is trying to move to has a player there  }
							}
							else if((move.toRow - move.fromRow) == -1)
							{
								if(board[move.toRow][move.toColumn] == null)
								{
									validMove = true;
								}
								else{/* there is a piece where the pawn is trying to move }
							}
							else{/* move is not forward 1 or 2 }

						}
						else{/* the move is not forward }

					}
					else{/* The move the pawn is trying to make is not valid for a pawn }
				}
				// the pawn is not in the starting position
				else
				{
					// checks if the move is 1 forward
					if(move.toRow == (move.fromRow + 1) && move.toColumn == move.fromColumn)
					{
						
						if(board[move.toRow][move.toColumn] == null)
						{
							validMove = true;
						}
						else{/* there is a piece where the pawn is trying to move }
					}
					else{/* the move is not forward }

				}
			}
		}
		return validMove;
	}




		/*



		if(board[move.toRow][move.toColumn] == board[move.fromRow + 1][move.toColumn]){
			if(board[move.toRow][move.toColumn].player() == null){
				return true;
			}
			else{
				return false;
			}
		}
		//Checks to see if the pawn can attack
		if((board[move.toRow][move.toColumn] == board[move.fromRow + 1][move.fromColumn + 1]) || (board[move.toRow][move.toColumn] == board[move.fromRow + 1][move.fromColumn - 1])){
			if(board[move.toRow][move.toColumn].player() != null){
			if(board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player()){
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
		//Sees if pawn is in starting position and is able to move 2 places
		
		if(board[move.toRow][move.toColumn] == board[move.fromRow + 2][move.fromColumn]){
		if ((move.fromRow == 2) || (move.fromRow == 7)){
			return true;
		}
	
		else{
			return false;
		}
	}
	else{
		return false;
	}
		//
		}
	
	*/


		public boolean isValidMove(Move move, ChessPiece[][] board)
		{
			
			boolean isValidMove = false;
			
			
			if(super.isValidMove(move, board) == true)
			{
				System.out.println("Super passed");
				
				if(pawnIsValidMove(move, board) == true)
				{

					isValidMove = true;
				}
			}

			return isValidMove;
			
		}	
			
			
			
			
			/*
			
			if((pawnIsValidMove(move, board) == true) && (super.isValidMove(move, board) == true)){
				return true;
			}
			else{
				return false;
			}
			
	
			if (super isValidMove == true)
			{
	
				if (in starting pos){
					if (enemy player diagonal){
						if (no allied piece in the way)
							if (move is forward +1 or +2 or to the place of enemey player)
								return true
					else (no enemy player)
						if (no pieces in way)
							if(move is +1 or +2 forward)
								return true;
						
					}
					
				}
				else (not in starting pos)
					if(enemy player diagonal)
						if (no player in front)
							if (move is +1 forward or diagonal to enemy pos)
								return true
						else (player in front)
							if (move is diagonal)
								return true;
					else(no enemy player diagonal)
						if (no player in front)
							if (move is +1 forward)
								return true
	
	
	
			}
	
	
	
			
			
		}



		
	
	
	/*
	
	private boolean pawnIsValidMove(Move move, ChessPiece[][] board){
		ChessPiece board[move.toRow][move.toColumn] = board[move.toRow][move.toColumn];
		ChessPiece board[move.fromRow][move.fromColumn] = board[move.fromRow][move.toRow];
		if(board[move.toRow][move.toColumn] == board[move.fromRow + 1][move.toColumn]){
			if(board[move.toRow][move.toColumn].player() == null){
				return true;
			}
			else{
				return false;
			}
		}
		//Checks to see if the pawn can attack
		if((board[move.toRow][move.toColumn] == board[move.fromRow + 1][move.fromColumn + 1]) || (board[move.toRow][move.toColumn] == board[move.fromRow + 1][move.fromColumn - 1])){
			if(board[move.toRow][move.toColumn].player() != null){
			if(board[move.toRow][move.toColumn].player() != board[move.fromRow][move.fromColumn].player()){
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
		//Sees if pawn is in starting position and is able to move 2 places
		
		if(board[move.toRow][move.toColumn] == board[move.fromRow + 2][move.fromColumn]){
		if ((move.fromRow == 2) || (move.fromRow == 7)){
			return true;
		}
	
		else{
			return false;
		}
	}
	else{
		return false;
	}
		//
		}
	// determines if the move is valid for a pawn piece
	public boolean isValidMove(Move move, ChessPiece[][] board) {
		
		if((pawnIsValidMove(move, board) == true) && (super.isValidMove(move, board) == true)){
			return true;
		}
		else{
			return false;
		}
		/*

		if (super isValidMove == true)
		{

			if (in starting pos){
				if (enemy player diagonal){
					if (no allied piece in the way)
						if (move is forward +1 or +2 or to the place of enemey player)
							return true
				else (no enemy player)
					if (no pieces in way)
						if(move is +1 or +2 forward)
							return true;
					
				}
				
			}
			else (not in starting pos)
				if(enemy player diagonal)
					if (no player in front)
						if (move is +1 forward or diagonal to enemy pos)
							return true
					else (player in front)
						if (move is diagonal)
							return true;
				else(no enemy player diagonal)
					if (no player in front)
						if (move is +1 forward)
							return true



		}



		
		
	}
	*/
	
}
	
