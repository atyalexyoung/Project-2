public class Knight extends ChessPiece {

	public Knight(Player player) {
		super(player);
	}

	public String type() {
		return "Knight";
	}

	public boolean isValidMove(Move move, ChessPiece[][] board){
		// TODO:  implement this method

		/*

		if (super isValidMove == true){
			if (move is +3N/S,+2E/W)
				if (no allied player in spot)
					return true;
				else
					return false;
			else if (move is +2N/S,+3E/W)
				if (no allied player in spot)
					return true;
				else
					return false;
			else
				return false;

		}

		*/












		return true;	
	}

}
