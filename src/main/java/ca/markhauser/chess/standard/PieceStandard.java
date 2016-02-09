package ca.markhauser.chess.standard;

import ca.markhauser.chess.Piece;
import ca.markhauser.chess.PieceColour;
import ca.markhauser.chess.PieceType;

public class PieceStandard implements Piece {
	
	private PieceColour colour;
	private PieceType type;

	public PieceStandard(PieceType type, PieceColour colour) {
		this.colour = colour;
		this.type = type;
	}

	@Override
	public PieceColour getColour() {
		return this.colour;
	}

	@Override
	public PieceType getType() {
		return this.type;
	}
	
}
