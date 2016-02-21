package ca.markhauser.chess.piece;

import ca.markhauser.chess.Coords;
import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.piece.move.DiagonalMovable;
import ca.markhauser.chess.piece.move.FileMovable;
import ca.markhauser.chess.piece.move.RankMovable;

public class Queen extends Piece implements RankMovable, FileMovable, DiagonalMovable {

	public Queen(PieceColour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Coords source, Coords dest) {
		return isRankMove(source, dest) || isFileMove(source, dest) || isDiagonalMove(source, dest);
	}

}
