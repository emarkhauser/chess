/**
 * 
 */
package ca.markhauser.chess.piece.move;

import ca.markhauser.chess.Coords;

/**
 * @author Admin Account HP
 *
 */
public interface RankMovable {

	default boolean isRankMove(Coords source, Coords dest) {
		return isRankKingMove(source, dest) || isRankQueenMove(source, dest);
	}

	default boolean isRankKingMove(Coords source, Coords dest) {
		return (source.getRank() == dest.getRank()) && (dest.getFileNumber() > source.getFileNumber());
	}

	default boolean isRankQueenMove(Coords source, Coords dest) {
		return (source.getRank() == dest.getRank()) && (dest.getFileNumber() < source.getFileNumber());
	}

}
