package ca.markhauser.chess.standard;

import ca.markhauser.chess.AbstractMove;
import ca.markhauser.chess.Move;

public class RankMove extends AbstractMove implements Move {

	public RankMove(Boolean canJump, Boolean limitedDistance) {
		super(canJump, limitedDistance);
	}

	@Override
	public Boolean isValidDirection(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return isRankKingMove(sourceFile, sourceRank, destFile, destRank)
				|| isRankQueenMove(sourceFile, sourceRank, destFile, destRank);
	}

	private Boolean isRankKingMove(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return (sourceRank == destRank) && (destFile > sourceFile);
	}

	private Boolean isRankQueenMove(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return (sourceRank == destRank) && (destFile < sourceFile);
	}

	@Override
	protected Boolean jumpsPieces(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Boolean shortDistance(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		// TODO Auto-generated method stub
		return null;
	}

}
