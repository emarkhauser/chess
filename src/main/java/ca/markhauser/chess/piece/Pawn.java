package ca.markhauser.chess.piece;

import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.piece.move.LimitedDistance;
import ca.markhauser.chess.space.Space;

class Pawn extends AbstractPiece implements LimitedDistance {

	protected Pawn(PieceColour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Space source, Space dest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validMoveDistance(Space source, Space dest) {
		// TODO Auto-generated method stub
		return false;
	}

}
