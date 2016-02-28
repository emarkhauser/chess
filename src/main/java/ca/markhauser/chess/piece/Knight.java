package ca.markhauser.chess.piece;

import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.piece.move.Jumpable;
import ca.markhauser.chess.space.Space;

class Knight extends AbstractPiece implements Jumpable {

	protected Knight(PieceColour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Space source, Space dest) {
		int sourceFile = source.getFileNumber();
		int sourceRank = source.getRank();
		int destFile = dest.getFileNumber();
		int destRank = dest.getRank();
		
		return ((Math.abs(sourceFile - destFile) == 2) && (Math.abs(sourceRank - destRank) == 1))
				|| ((Math.abs(sourceFile - destFile) == 1) && (Math.abs(sourceRank - destRank) == 2));
	}

}
