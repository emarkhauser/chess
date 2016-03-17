package ca.markhauser.chess;

public interface Chess {

	void move(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank);
	Colour getCurrentPlayerColour();
	Board getBoard();
	void resign();
	void draw();
	Boolean isCheck();
	Boolean isCheckmate();
	Boolean isDraw();
	Colour getWinner();

}