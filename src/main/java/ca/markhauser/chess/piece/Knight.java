package ca.markhauser.chess.piece;

import ca.markhauser.chess.colour.Colour;
import ca.markhauser.chess.piece.move.Jumpable;
import ca.markhauser.chess.space.Space;

class Knight extends AbstractPiece implements Jumpable {

	protected Knight(Colour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Space source, Space dest) {
		int sourceFile = source.getFile();
		int sourceRank = source.getRank();
		int destFile = dest.getFile();
		int destRank = dest.getRank();
		
		return ((Math.abs(sourceFile - destFile) == 2) && (Math.abs(sourceRank - destRank) == 1))
				|| ((Math.abs(sourceFile - destFile) == 1) && (Math.abs(sourceRank - destRank) == 2));
	}

}
