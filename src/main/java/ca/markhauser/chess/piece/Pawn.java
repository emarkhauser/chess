package ca.markhauser.chess.piece;

import ca.markhauser.chess.Coords;
import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.piece.move.LimitedDistance;

public class Pawn extends Piece implements LimitedDistance {

	public Pawn(PieceColour colour) {
		super(colour);
	}

	@Override
	public boolean validMovePattern(Coords source, Coords dest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validMoveDistance(Coords source, Coords dest) {
		// TODO Auto-generated method stub
		return false;
	}

}
