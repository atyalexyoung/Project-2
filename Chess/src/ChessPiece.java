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
		//TODO: implement this metho
		

		/*

		if (piece == starting place in move){

			if (move(newspace) != current space){

				if (rows < 8 && columns < 8){
				
					if (move(newspace) != another piece from same player){
						
						return true;

		}
		else{
			throw new exception
		}
		}
		else{
			throw new exception
		}
		}
		else{
			throw new exception
		}
		}
		else {
			throw new exception
		}



		*/
	}
}
