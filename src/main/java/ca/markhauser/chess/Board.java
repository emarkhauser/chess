/**
 * 
 */
package ca.markhauser.chess;

/**
 * @author Admin Account HP
 *
 */
public interface Board {

	void setPiece(Integer file, Integer rank, Piece piece) throws OutOfBoardRange;

	Piece getPiece(Integer file, Integer rank);

	void movePiece(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank)
			throws InvalidMove, NoPieceOnSpace, PieceNotMoved, OutOfBoardRange;

}
