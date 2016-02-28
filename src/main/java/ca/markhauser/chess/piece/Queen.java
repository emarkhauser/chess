package ca.markhauser.chess.piece;

import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.piece.move.MoveUtil;
import ca.markhauser.chess.space.Space;

public class Queen extends AbstractPiece {

	protected Queen(PieceColour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Space source, Space dest) {
		return MoveUtil.isRankMove(source, dest) || MoveUtil.isFileMove(source, dest) || MoveUtil.isDiagonalMove(source, dest);
	}

}
