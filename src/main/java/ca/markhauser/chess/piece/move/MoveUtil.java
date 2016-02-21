/**
 * 
 */
package ca.markhauser.chess.piece.move;

import ca.markhauser.chess.Coords;

/**
 * @author Admin Account HP
 *
 */
public class MoveUtil {

	public static boolean isDiagonalMove(Coords source, Coords dest) {
		return Math.abs(source.getFileNumber() - dest.getFileNumber()) == Math.abs(source.getRank() - dest.getRank());
	}
	
	public static boolean isFileMove(Coords source, Coords dest) {		
		return isFileBlackMove(source, dest) || isFileWhiteMove(source, dest);
	}

	public static boolean isFileBlackMove(Coords source, Coords dest) {		
		return (source.getFileNumber() == dest.getFileNumber()) && (dest.getRank() > source.getRank());
	}

	public static boolean isFileWhiteMove(Coords source, Coords dest) {		
		return (source.getFileNumber() == dest.getFileNumber()) && (dest.getRank() < source.getRank());
	}
	
	public static boolean isRankMove(Coords source, Coords dest) {
		return isRankKingMove(source, dest) || isRankQueenMove(source, dest);
	}

	public static boolean isRankKingMove(Coords source, Coords dest) {
		return (source.getRank() == dest.getRank()) && (dest.getFileNumber() > source.getFileNumber());
	}

	public static boolean isRankQueenMove(Coords source, Coords dest) {
		return (source.getRank() == dest.getRank()) && (dest.getFileNumber() < source.getFileNumber());
	}
	
}
