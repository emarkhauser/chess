/**
 * 
 */
package ca.markhauser.chess.piece;

import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.space.Space;

/**
 * @author Admin Account HP
 *
 */
public interface Piece {

	PieceColour getColour();
	boolean validMovePattern(Space source, Space dest);
	
}
