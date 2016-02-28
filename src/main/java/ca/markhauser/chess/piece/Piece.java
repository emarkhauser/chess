/**
 * 
 */
package ca.markhauser.chess.piece;

import ca.markhauser.chess.Coords;
import ca.markhauser.chess.enums.PieceColour;

/**
 * @author Admin Account HP
 *
 */
public interface Piece {

	PieceColour getColour();
	boolean validMovePattern(Coords source, Coords dest);
	
}
