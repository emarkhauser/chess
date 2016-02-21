package ca.markhauser.chess.piece;

import ca.markhauser.chess.Coords;
import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.piece.move.FileMovable;
import ca.markhauser.chess.piece.move.RankMovable;

public class Rook extends Piece implements RankMovable, FileMovable {

	public Rook(PieceColour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Coords source, Coords dest) {		
		return isFileMove(source, dest) || isRankMove(source, dest);
	}

}
