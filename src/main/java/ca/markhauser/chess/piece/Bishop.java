package ca.markhauser.chess.piece;

import ca.markhauser.chess.colour.Colour;
import ca.markhauser.chess.piece.move.MoveUtil;
import ca.markhauser.chess.space.Space;

class Bishop extends AbstractPiece {

	protected Bishop(Colour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Space source, Space dest) {
		return MoveUtil.isDiagonalMove(source, dest);
	}

}
