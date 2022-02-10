public class Queen extends ChessPiece {

	public Queen(Player player) {
		super(player);
	}

	public String type() {
		return "Queen";
	}
	
	public boolean isValidMove(Move move, ChessPiece[][] board) {
		// TODO:  implement this method
		// Think carefully about how you could do this

		/*
		
		if (super isValidMove == true)
			if (rook isValidMove == true || bishop isValidMove == true)
				return true;
			else
				return false;

		else
			return false;




		*/
		return true;
	}
}
