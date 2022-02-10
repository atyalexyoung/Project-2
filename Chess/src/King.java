public class King extends ChessPiece {

	public King(Player player) {
		super(player);
	}

	public String type() {
		return "King";
	}
	
	public boolean isValidMove(Move move, ChessPiece[][] board) {
		// TODO:  implement this method

		/*

		if (super isValidMove == true)
		{
			if (move is +1 any direction)
			{
				if(no allied players are in the way)
					return true;
			}
		}
		



		*/
		return true;
	}
}
