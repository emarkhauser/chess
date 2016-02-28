package ca.markhauser.chess.piece;

import ca.markhauser.chess.colour.Colour;
import ca.markhauser.chess.piece.move.MoveUtil;
import ca.markhauser.chess.space.Space;

class Queen extends AbstractPiece {

	protected Queen(Colour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Space source, Space dest) {
		return MoveUtil.isRankMove(source, dest) || MoveUtil.isFileMove(source, dest) || MoveUtil.isDiagonalMove(source, dest);
	}

}
