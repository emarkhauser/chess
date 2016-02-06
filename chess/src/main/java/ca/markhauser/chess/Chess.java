package ca.markhauser.chess;

public interface Chess {
	void newGame();
	MoveResult makeMove(Move move);
	void resign();
	void draw();
	boolean isCheck();
	boolean isCheckmate();
	Winner getWinner();
}
