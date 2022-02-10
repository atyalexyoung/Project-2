public class Bishop extends ChessPiece {

	public Bishop(Player player) {
		super(player);
	}

	public String type() {
		return "Bishop";
	}
	
	public boolean isValidMove(Move move, ChessPiece[][] board) {
		// TODO:  implement this method


		/*

			if (super is valid move == true){
				if (move is diagonal ((NW),(NE),(SW),(SE)))
					if (no allied player in the way)
						if (enemy player in the way)
							take their place 
							return true
						else (no enemy player in the way)
							return true;
							
					else (allied player in the way)
						return false
				else (move is not diagonal)
					return false

			}
			else (super isValidMove == false)
				return false;




		*/





		return true;
	}
}
