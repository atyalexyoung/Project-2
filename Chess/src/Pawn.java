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

		ChessPiece toPosition = board[move.toRow][move.toColumn];
		ChessPiece fromPosition = board[move.fromRow][move.toRow];

		boolean validMove = false;

		// checks if the player is white (bottom of the board)
		if(fromPosition.player() == Player.BLACK)
		{
			// checks if pawn is trying to move diagonally
			if(toPosition == board[move.toRow + 1][move.toColumn + 1] || toPosition == board[move.toRow + 1][move.toColumn - 1])
			{
				// checks if the position the pawn is moving to does not have a player there
				if (toPosition != null)
				{
					// checks if the player in the spot is an enemy piece
					if(toPosition.player() == player().next())
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
								if(toPosition == null && board[move.toRow - 1][move.fromColumn] == null)
								{
									validMove = true;
								}
								else{/* the position the pawn is trying to move to has a player there */ }
							}
							else if((move.toRow - move.fromRow) == 1)
							{
								if(toPosition == null)
								{
									validMove = true;
								}
								else{/* there is a piece where the pawn is trying to move */}
							}
							else{/* move is not forward 1 or 2 */}

						}
						else{/* the move is not forward */}

					}
					else{/* The move the pawn is trying to make is not valid for a pawn */}
				}
				// the pawn is not in the starting position
				else
				{
					// checks if the move is 1 forward
					if(move.toRow == move.fromRow + 1 && move.toColumn == move.fromColumn)
					{
						
						
						if(toPosition == null)
						{
							validMove = true;
						}
						else{/* there is a piece where the pawn is trying to move */}
					

					}
					else{/* the move is not forward */}

				}
			}
		}
		// the player is black
		else
		{
			// checks if pawn is trying to move diagonally
			if(toPosition == board[move.toRow - 1][move.toColumn + 1] || toPosition == board[move.toRow - 1][move.toColumn - 1])
			{
				// checks if the position the pawn is moving to does not have a player there
				if (toPosition != null)
				{
					// checks if the player in the spot is an enemy piece
					if(toPosition.player() == player().next())
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
								if(toPosition == null && board[move.toRow + 1][move.fromColumn] == null)
								{
									validMove = true;
								}
								else{/* the position the pawn is trying to move to has a player there */ }
							}
							else if((move.toRow - move.fromRow) == -1)
							{
								if(toPosition == null)
								{
									validMove = true;
								}
								else{/* there is a piece where the pawn is trying to move */}
							}
							else{/* move is not forward 1 or 2 */}

						}
						else{/* the move is not forward */}

					}
					else{/* The move the pawn is trying to make is not valid for a pawn */}
				}
				// the pawn is not in the starting position
				else
				{
					// checks if the move is 1 forward
					if(move.toRow == (move.fromRow + 1) && move.toColumn == move.fromColumn)
					{
						
						if(toPosition == null)
						{
							validMove = true;
						}
						else{/* there is a piece where the pawn is trying to move */}
					}
					else{/* the move is not forward */}

				}
			}
		}
		return validMove;
	}




		/*



		if(toPosition == board[move.fromRow + 1][move.toColumn]){
			if(toPosition.player() == null){
				return true;
			}
			else{
				return false;
			}
		}
		//Checks to see if the pawn can attack
		if((toPosition == board[move.fromRow + 1][move.fromColumn + 1]) || (toPosition == board[move.fromRow + 1][move.fromColumn - 1])){
			if(toPosition.player() != null){
			if(toPosition.player() != fromPosition.player()){
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
		
		if(toPosition == board[move.fromRow + 2][move.fromColumn]){
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


		public boolean isValidMove(Move move, ChessPiece[][] board) {
			
			boolean validMove = false;
			
			
			if(super.isValidMove(move, board) == true)
			{
				if(pawnIsValidMove(move, board) == true)
				{
					validMove = true;
				}
			}

			return validMove;
			
			
			
			
			
			
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
		ChessPiece toPosition = board[move.toRow][move.toColumn];
		ChessPiece fromPosition = board[move.fromRow][move.toRow];
		if(toPosition == board[move.fromRow + 1][move.toColumn]){
			if(toPosition.player() == null){
				return true;
			}
			else{
				return false;
			}
		}
		//Checks to see if the pawn can attack
		if((toPosition == board[move.fromRow + 1][move.fromColumn + 1]) || (toPosition == board[move.fromRow + 1][move.fromColumn - 1])){
			if(toPosition.player() != null){
			if(toPosition.player() != fromPosition.player()){
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
		
		if(toPosition == board[move.fromRow + 2][move.fromColumn]){
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
		// TODO:  implement this method
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
}
	
