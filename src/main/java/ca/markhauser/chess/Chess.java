package ca.markhauser.chess;

public interface Chess {

	void move(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank);
	Colour getCurrentPlayerColour();
	Board getBoard();
	void resign();
	void draw();
	boolean isCheck();
	boolean isCheckmate();
	Colour getWinner();

}