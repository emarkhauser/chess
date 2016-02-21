package ca.markhauser.chess.piece;

import ca.markhauser.chess.Coords;
import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.piece.move.MoveUtil;

public class Queen extends Piece {

	public Queen(PieceColour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Coords source, Coords dest) {
		return MoveUtil.isRankMove(source, dest) || MoveUtil.isFileMove(source, dest) || MoveUtil.isDiagonalMove(source, dest);
	}

}
