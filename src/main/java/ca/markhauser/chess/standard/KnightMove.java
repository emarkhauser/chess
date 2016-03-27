package ca.markhauser.chess.standard;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Move;

public class KnightMove implements Move {

	public Boolean isValidMove(Board board, Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return ((Math.abs(sourceFile - destFile) == 2) && (Math.abs(sourceRank - destRank) == 1))
				|| ((Math.abs(sourceFile - destFile) == 1) && (Math.abs(sourceRank - destRank) == 2));
	}

}
