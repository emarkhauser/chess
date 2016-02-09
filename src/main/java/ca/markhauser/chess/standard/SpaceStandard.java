package ca.markhauser.chess.standard;

import ca.markhauser.chess.Piece;
import ca.markhauser.chess.Space;

public class SpaceStandard implements Space {
	
	private Piece piece;

	public SpaceStandard() {
	}

	@Override
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	@Override
	public Piece getPiece() {
		return this.piece;
	}

}
