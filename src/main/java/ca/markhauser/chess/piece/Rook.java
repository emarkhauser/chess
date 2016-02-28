package ca.markhauser.chess.piece;

import ca.markhauser.chess.colour.Colour;
import ca.markhauser.chess.piece.move.MoveUtil;
import ca.markhauser.chess.space.Space;

class Rook extends AbstractPiece {

	protected Rook(Colour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Space source, Space dest) {		
		return MoveUtil.isFileMove(source, dest) || MoveUtil.isRankMove(source, dest);
	}

}
