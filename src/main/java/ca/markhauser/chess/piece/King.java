package ca.markhauser.chess.piece;

import ca.markhauser.chess.Coords;
import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.piece.move.LimitedDistance;
import ca.markhauser.chess.piece.move.MoveUtil;

public class King extends Piece implements LimitedDistance {

	public King(PieceColour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Coords source, Coords dest) {
		return validMoveDistance(source, dest)
				&& (MoveUtil.isRankMove(source, dest) || MoveUtil.isFileMove(source, dest) || MoveUtil.isDiagonalMove(source, dest));
	}

	@Override
	public boolean validMoveDistance(Coords source, Coords dest) {
		return (Math.abs(source.getFileNumber() - dest.getFileNumber()) <= 1)
				&& (Math.abs(source.getRank() - dest.getRank()) <= 1);
	}

}
