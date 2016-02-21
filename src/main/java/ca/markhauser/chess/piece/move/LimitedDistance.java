/**
 * 
 */
package ca.markhauser.chess.piece.move;

import ca.markhauser.chess.Coords;

/**
 * @author Admin Account HP
 *
 */
public interface LimitedDistance {

	boolean validMoveDistance(Coords source, Coords dest);
	
}
