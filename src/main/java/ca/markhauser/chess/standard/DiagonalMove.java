/**
 * 
 */
package ca.markhauser.chess.standard;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Move;

/**
 * @author Admin Account HP
 *
 */
public class DiagonalMove implements Move {
	
	public Boolean isValidMove(Board board, Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		if (!(Math.abs(sourceFile - destFile) == Math.abs(sourceRank - destRank)))
			return false;
		
		if (destRank > sourceRank) {
			int fileNum = sourceRank;
			for (int i = sourceRank + 1; i < destRank; i++) {
				if (board.getPiece(fileNum++, i) != null)
					return true;
			}
		}
		return false;
		
	}

}
