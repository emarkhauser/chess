/**
 * 
 */
package ca.markhauser.chess.piece;

import ca.markhauser.chess.colour.Colour;
import ca.markhauser.chess.space.Space;

/**
 * @author Admin Account HP
 *
 */
public interface Piece {

	Colour getColour();
	boolean validMovePattern(Space source, Space dest);
	
}
