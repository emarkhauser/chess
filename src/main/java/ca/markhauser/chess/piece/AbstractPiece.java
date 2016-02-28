package ca.markhauser.chess.piece;

import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.space.Space;

abstract class AbstractPiece implements Piece {
	
	private PieceColour colour;

	protected AbstractPiece(PieceColour colour) {
		this.colour = colour;
	}

	public PieceColour getColour() {
		return this.colour;
	}

	public abstract boolean validMovePattern(Space source, Space dest);
	
}
