package ca.markhauser.chess.piece;

import ca.markhauser.chess.colour.Colour;
import ca.markhauser.chess.space.Space;

abstract class AbstractPiece implements Piece {
	
	private Colour colour;

	protected AbstractPiece(Colour colour) {
		this.colour = colour;
	}

	public Colour getColour() {
		return this.colour;
	}

	public abstract boolean validMovePattern(Space source, Space dest);
	
}
