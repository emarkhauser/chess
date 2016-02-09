package ca.markhauser.chess;

public interface Move {

	/**
	 * Returns coordinates of the source of the move
	 */
	Coords getSourceCoords();
	
	/**
	 * Returns coordinates of the destination of the move
	 */
	Coords getDestCoords();
	
}
