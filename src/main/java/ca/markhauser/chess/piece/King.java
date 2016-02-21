package ca.markhauser.chess.piece;

import ca.markhauser.chess.Coords;
import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.piece.move.DiagonalMovable;
import ca.markhauser.chess.piece.move.FileMovable;
import ca.markhauser.chess.piece.move.LimitedDistance;
import ca.markhauser.chess.piece.move.RankMovable;

public class King extends Piece implements RankMovable, FileMovable, DiagonalMovable, LimitedDistance {

	public King(PieceColour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Coords source, Coords dest) {
		return validMoveDistance(source, dest)
				&& (isRankMove(source, dest) || isFileMove(source, dest) || isDiagonalMove(source, dest));
	}

	@Override
	public boolean validMoveDistance(Coords source, Coords dest) {
		return (Math.abs(source.getFileNumber() - dest.getFileNumber()) <= 1)
				&& (Math.abs(source.getRank() - dest.getRank()) <= 1);
	}

}
