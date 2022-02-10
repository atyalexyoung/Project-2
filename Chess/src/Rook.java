public class Rook extends ChessPiece {

	public Rook(Player player) {
		super(player);
	}

	public String type() {
		return "Rook";
	}
	
	// determines if the move is valid for a rook piece
	public boolean isValidMove(Move move, ChessPiece[][] board) {
		// TODO:  implement this method

		/*

		if (super isValidMove == true)
		{
			if (move +n in NSEW directions)
			{	
				if( move has no allied players in the way)
				{
					if (no enemy players in the way)
						return true
					else (there are enemy players in the way)
						take their place
				}
			}
		}
		else
			return false;
		








		*/
		return true;	
	}
	
}
