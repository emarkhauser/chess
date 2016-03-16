/**
 * 
 */
package ca.markhauser.chess.standard;

import ca.markhauser.chess.Move;

/**
 * @author Admin Account HP
 *
 */
public class DiagonalMove implements Move {

	public Boolean isValidMove(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return Math.abs(sourceFile - destFile) == Math.abs(sourceRank - destRank);
	}
	
}
