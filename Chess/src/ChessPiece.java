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
		//TODO: implement this method
		
	try
	{	
		// Rows array for loop
		for(int i = 0; i <= 8; i++)
		{
			if (i > 8)
			{
				throw new IllegalArgumentException("Out of bounds");
			}
			else
			{

			}
			// Columns array for loop
			for(int k = 0; k <= 8; k++)
			{
				if(k > 8)
				{
					throw new IllegalArgumentException("Out of bounds");
				}
				else
				{

				}
			}
		}
	}
	catch(IndexOutOfBoundsException oof)
	{
		System.out.println("Invalid piece placement");
	}


	if(board[move.toRow][move.toColumn] == null){

	}
	

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
