package ca.markhauser.chess.standard;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Move;

public class RankMove implements Move {

	@Override
	public Boolean isValidMove(Board board, Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return isRankKingMove(sourceFile, sourceRank, destFile, destRank)
				|| isRankQueenMove(sourceFile, sourceRank, destFile, destRank);
	}

	private Boolean isRankKingMove(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return (sourceRank == destRank) && (destFile > sourceFile);
	}

	private Boolean isRankQueenMove(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return (sourceRank == destRank) && (destFile < sourceFile);
	}
}
