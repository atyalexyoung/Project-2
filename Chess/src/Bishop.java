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
	
//checks to make sure bishop is moving diagonally
if(abs(rowDiff) == abs(colDiff)){
//checks each spot in bishops path
if(rowDiff > 1){
	if(colDiff > 0){
		int j = move.fromColumn + 1;
		for(int i = move.fromRow + 1; i != move.toRow; i++){
			
			if(board[i][j] == null){
				valid = true;
				j++;
			}
			else{
				valid = false;
				break;
			}
		}
	}
	if(colDiff < 0){
		int j = move.fromColumn - 1;
		for(int i = move.fromRow + 1; i != move.toRow; i++){
			if(board[i][j] == null){
				valid = true;
				j--;
			}
			else{
				valid = false;
				break;
			}
		}
}
}

    if(rowDiff < -1){
		if(colDiff < 0){
			int j = move.fromColumn - 1;
		for(int i = move.fromRow - 1; i != move.toRow; i--){
			if(board[i][j] == null){
				valid = true;
				j--;
			}
			else{
				valid = false;
				break;
			}
		}
		}
		if(colDiff > 0){
			int j = move.fromColumn + 1;
			for(int i = move.fromRow - 1; i != move.toRow; i--){
				
				if(board[i][j] == null){
					valid = true;
					j++;
				}
				else{
					valid = false;
					break;
				}
			}
		}
	}
if((abs(rowDiff) == 1) && abs(colDiff) == 1){
	if(board[move.toRow][move.toColumn] == null){
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
