package ca.markhauser.chess.piece;

import ca.markhauser.chess.Coords;
import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.piece.move.MoveUtil;

public class Bishop extends AbstractPiece {

	public Bishop(PieceColour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Coords source, Coords dest) {
		return MoveUtil.isDiagonalMove(source, dest);
	}

}
