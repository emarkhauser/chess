package ca.markhauser.chess;

public interface Board {

	
	/**
	 * Get the piece on the requested space.  Returns null if no piece is on the space.
	 * 
	 * @return Piece
	 */
	Piece getPiece(Coords coords);
	
	void setPiece(Piece piece, Coords coords);
	
}
