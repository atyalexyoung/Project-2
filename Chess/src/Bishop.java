import static java.lang.Math.abs;
public class Bishop extends ChessPiece {

	public Bishop(Player player) {
		super(player);
	}

	public String type() {
		return "Bishop";
	}

	private boolean bishopIsValidMove(Move move, ChessPiece[][] board){
		
	
	boolean valid = false;


	int rowDiff = move.toRow - move.fromRow;
	int colDiff = move.toColumn - move.fromColumn;
	int x = move.fromRow;
	int y = move.fromColumn;
	

	if(Math.abs(rowDiff) == Math.abs(colDiff))
	{
		if(board[move.toRow][move.toColumn] == null || board[move.toRow][move.toColumn].player() == player().next()){
			if(Math.abs(rowDiff) != 1)
			{

				for(int i = Math.abs(rowDiff) - 1; i >= 1; i--)
				{
					if(rowDiff > 0)
					{
						if(colDiff > 0)
						{
							if(board[x + 1][y + 1] == null)
							{
								valid = true;
								x++;
								y++;
							}
							else
							{
								valid = false;
								break;
								
							}
						}
						else if(colDiff < 0)
						{
							if(board[x + 1][y - 1] == null)
							{
								valid = true;
								x++;
								y--;
							}
							else
							{
								valid = false;
								break;
							}
						}
					}
					else if(rowDiff < 0)
					{
						if(colDiff > 0)
						{
							if(board[x - 1][y + 1] == null)
							{
								valid = true;
								x--;
								y++;
							}
							else
							{
								valid = false;
								break;
							}
						}
						else if(colDiff < 0)
						{
							if(board[x - 1][y - 1] == null)
							{
								valid = true;
								x--;
								y--;
							}
							else
							{
								valid = false;
								break;
							}
						}
					}
				}
			}
			else
			{
				valid = true;
			}
		}
	}
	return valid;	

	}
	public boolean isValidMove(Move move, ChessPiece[][] board) {

		// checks if the move passes the parent ChessPiece class's isValidMove function
		if (super.isValidMove(move, board))
		{
			if(bishopIsValidMove(move, board))
			{
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
	
}
