package ca.markhauser.chess.piece;

import ca.markhauser.chess.Coords;
import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.piece.move.MoveUtil;

public class Rook extends Piece {

	public Rook(PieceColour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Coords source, Coords dest) {		
		return MoveUtil.isFileMove(source, dest) || MoveUtil.isRankMove(source, dest);
	}

}
