/**
 * 
 */
package ca.markhauser.chess.standard;

import ca.markhauser.chess.AbstractMove;
import ca.markhauser.chess.Move;

/**
 * @author Admin Account HP
 *
 */
public class DiagonalMove extends AbstractMove implements Move {

	public DiagonalMove(Boolean canJump, Boolean limitedDistance) {
		super(canJump, limitedDistance);
	}

	protected Boolean isValidDirection(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return Math.abs(sourceFile - destFile) == Math.abs(sourceRank - destRank);
	}

	protected Boolean jumpsPieces(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		if (destRank > sourceRank) {
			int fileNum = sourceRank;
			for (int i = sourceRank + 1; i < destRank; i++) {
				if (board.getPiece(fileNum++, i) != null)
					return true;
			}
		}
		return false;
	}

	@Override
	protected Boolean shortDistance(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		// TODO Auto-generated method stub
		return null;
	}

}
