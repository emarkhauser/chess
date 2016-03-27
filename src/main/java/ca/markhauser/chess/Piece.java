/**
 * 
 */
package ca.markhauser.chess;

/**
 * @author Admin Account HP
 *
 */
public interface Piece {

	String getType();
	Colour getColour();
	Boolean validMovePattern(Board board, Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank);
	void addMove(Move move);
	
}
