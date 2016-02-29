package ca.markhauser.chess;

import ca.markhauser.chess.board.Board;
import ca.markhauser.chess.colour.Colour;
import ca.markhauser.chess.space.Space;

public interface Chess {

	void move(Space source, Space dest);
	Colour getCurrentPlayerColour();
	Board getBoard();
	void resign();
	void draw();
	boolean isCheck();
	boolean isCheckmate();
	Colour getWinner();

}