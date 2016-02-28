package ca.markhauser.chess.piece;

import ca.markhauser.chess.colour.Colour;
import ca.markhauser.chess.piece.move.LimitedDistance;
import ca.markhauser.chess.piece.move.MoveUtil;
import ca.markhauser.chess.space.Space;

class King extends AbstractPiece implements LimitedDistance {

	protected King(Colour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Space source, Space dest) {
		return validMoveDistance(source, dest)
				&& (MoveUtil.isRankMove(source, dest) || MoveUtil.isFileMove(source, dest) || MoveUtil.isDiagonalMove(source, dest));
	}

	@Override
	public boolean validMoveDistance(Space source, Space dest) {
		return (Math.abs(source.getFileNumber() - dest.getFileNumber()) <= 1)
				&& (Math.abs(source.getRank() - dest.getRank()) <= 1);
	}

}
