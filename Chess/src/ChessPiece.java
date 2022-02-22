public abstract class ChessPiece {

	private Player owner;

	protected ChessPiece(Player player) {
		this.owner = player;
	}

	public abstract String type();

	public Player player() {
		return owner;
	}

	public boolean isValidMove(Move move, ChessPiece[][] board) {
		
		// move is set to invalid unless it meets the critera met in "if-statements" below
		boolean validMove = false;
		
		// creating new variables for the place the current player is trying to move from 
		// and the place the current player is trying to move to
		ChessPiece fromPosition = board[move.fromRow][move.fromColumn];
		ChessPiece toPosition = board[move.toRow][move.toColumn];

		// checks if the place you are trying to move is in bounds
		if(move.toColumn <= 8 && move.toColumn >=0 && move.toRow >= 0 && move.toRow <= 8 )
		{
			// checks if the place the current player is trying to move is not the place the current player is staring from
			if(fromPosition != toPosition)
			{	
				// checks if the place the current player is trying to move from has a piece that belongs to the current player
				if(fromPosition != null &&  fromPosition.owner == this.owner)
				{
					// checks if the place the current player is trying to move has a piece already there that is the current owners 
					if(fromPosition.owner != this.owner)
						validMove = true;
					else{/* the place the current player is trying to move has a piece that is the current owners already */ }
				}
				else{/* there is not a piece that is the current players at the place the current player is trying to move from */}
			}
			else{/* the place the current player is trying to move to is the place the current player is trying to move from */}
		}
		else{/* the move the current player is trying to make is out of bounds */}

		// returns boolean if the move is valid or not
		return validMove;

	
	}
}