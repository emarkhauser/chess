/**
 * 
 */
package ca.markhauser.chess.piece.move;

import ca.markhauser.chess.space.Space;

/**
 * @author Admin Account HP
 *
 */
public class MoveUtil {

	public static boolean isDiagonalMove(Space source, Space dest) {
		return Math.abs(source.getFileNumber() - dest.getFileNumber()) == Math.abs(source.getRank() - dest.getRank());
	}
	
	public static boolean isFileMove(Space source, Space dest) {		
		return isFileBlackMove(source, dest) || isFileWhiteMove(source, dest);
	}

	public static boolean isFileBlackMove(Space source, Space dest) {		
		return (source.getFileNumber() == dest.getFileNumber()) && (dest.getRank() > source.getRank());
	}

	public static boolean isFileWhiteMove(Space source, Space dest) {		
		return (source.getFileNumber() == dest.getFileNumber()) && (dest.getRank() < source.getRank());
	}
	
	public static boolean isRankMove(Space source, Space dest) {
		return isRankKingMove(source, dest) || isRankQueenMove(source, dest);
	}

	public static boolean isRankKingMove(Space source, Space dest) {
		return (source.getRank() == dest.getRank()) && (dest.getFileNumber() > source.getFileNumber());
	}

	public static boolean isRankQueenMove(Space source, Space dest) {
		return (source.getRank() == dest.getRank()) && (dest.getFileNumber() < source.getFileNumber());
	}
	
}
