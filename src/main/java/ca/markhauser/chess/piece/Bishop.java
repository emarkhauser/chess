package ca.markhauser.chess.piece;

import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.piece.move.MoveUtil;
import ca.markhauser.chess.space.Space;

public class Bishop extends AbstractPiece {

	protected Bishop(PieceColour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Space source, Space dest) {
		return MoveUtil.isDiagonalMove(source, dest);
	}

}
