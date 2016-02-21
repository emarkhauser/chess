/**
 * 
 */
package ca.markhauser.chess.piece.move;

import ca.markhauser.chess.Coords;

/**
 * @author Admin Account HP
 *
 */
public interface FileMovable {

	default boolean isFileMove(Coords source, Coords dest) {		
		return isFileBlackMove(source, dest) || isFileWhiteMove(source, dest);
	}

	default boolean isFileBlackMove(Coords source, Coords dest) {		
		return (source.getFileNumber() == dest.getFileNumber()) && (dest.getRank() > source.getRank());
	}

	default boolean isFileWhiteMove(Coords source, Coords dest) {		
		return (source.getFileNumber() == dest.getFileNumber()) && (dest.getRank() < source.getRank());
	}
	
}
