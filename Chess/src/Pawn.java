public class Pawn extends ChessPiece {

	public Pawn(Player player) {
		super(player);
	}

	public String type() {
		return "Pawn";
	}

	// determines if the move is valid for a pawn piece
	public boolean isValidMove(Move move, ChessPiece[][] board) {
		// TODO:  implement this method

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



		*/
		return true;
	}
}
