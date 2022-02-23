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
	
	
	private boolean pawnIsValidMove(Move move, ChessPiece[][] board){
		ChessPiece toPosition = board[move.toRow][move.toColumn];
		ChessPiece fromPosition = board[move.fromRow][move.toRow];

		boolean validMove = false;

		if(toPosition == board[move.toRow + 1][move.toColumn + 1] || toPosition == board[move.toRow + 1][move.toColumn - 1])
		{
			if (toPosition != null)
			{
				if(toPosition.player() == player().next()){
					validMove = true;
				}
			}

		}
		else
		{

			if(move.fromRow == 1 || move.fromRow == 6)
		{
			if((move.toRow - move.fromRow) <= 2)
			{
				if((move.toColumn - move.fromColumn) == 0)
				{
					if(toPosition == null)
					{
						validMove = true;
					}
					else{/* the position the pawn is trying to move to has a player there */ }
				}
				else{/* the postion the current player is trying to move to is not forward */}
			}
			else{/* the position the player is trying to move is not valid for a pawn */}
		}
		else
		{
			if(toPosition == board[move.fromRow + 1][move.fromColumn])
			{
				if(toPosition == null){
					validMove = true;
				}
				else{/* the position the current player is trying to move to has a player there */}
			}
		else{/* the position the player is trying to move to is not a valid move for a pawn */ }
		}


		}

		if(move.fromRow == 1 || move.fromRow == 6)
		{
			if((move.toRow - move.fromRow) <= 2)
			{
				if((move.toColumn - move.fromColumn) == 0)
				{
					if(toPosition == null)
					{
						validMove = true;
					}
					else{/* the position the pawn is trying to move to has a player there */ }
				}
				else{/* the postion the current player is trying to move to is not forward */}
			}
			else{/* the position the player is trying to move is not valid for a pawn */}
		}
		else
		{
			if(toPosition == board[move.fromRow + 1][move.fromColumn])
			{
				if(toPosition == null){
					validMove = true;
				}
				else{/* the position the current player is trying to move to has a player there */}
			}
		else{/* the position the player is trying to move to is not a valid move for a pawn */ }
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
			// TODO:  implement this method
			
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
