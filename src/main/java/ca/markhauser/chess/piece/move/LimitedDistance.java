/**
 * 
 */
package ca.markhauser.chess.piece.move;

import ca.markhauser.chess.space.Space;

/**
 * @author Admin Account HP
 *
 */
public interface LimitedDistance {

	boolean validMoveDistance(Space source, Space dest);
	
}
