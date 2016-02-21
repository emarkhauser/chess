package ca.markhauser.chess.piece;

import ca.markhauser.chess.Coords;
import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.piece.move.DiagonalMovable;

public class Bishop extends Piece implements DiagonalMovable {

	public Bishop(PieceColour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Coords source, Coords dest) {
		return isDiagonalMove(source, dest);
	}

}
