/**
 * 
 */
package ca.markhauser.chess.piece.move;

import ca.markhauser.chess.Coords;

/**
 * @author Admin Account HP
 *
 */
public interface DiagonalMovable {

	default boolean isDiagonalMove(Coords source, Coords dest) {
		return Math.abs(source.getFileNumber() - dest.getFileNumber()) == Math.abs(source.getRank() - dest.getRank());
	}

}
