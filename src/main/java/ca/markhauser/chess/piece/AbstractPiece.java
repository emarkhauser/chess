package ca.markhauser.chess.piece;

import ca.markhauser.chess.Coords;
import ca.markhauser.chess.enums.PieceColour;

public abstract class AbstractPiece implements Piece {
	
	private PieceColour colour;

	public AbstractPiece(PieceColour colour) {
		this.colour = colour;
	}

	public PieceColour getColour() {
		return this.colour;
	}

	public abstract boolean validMovePattern(Coords source, Coords dest);
	
}
