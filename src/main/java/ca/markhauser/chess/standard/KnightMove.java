package ca.markhauser.chess.standard;

import ca.markhauser.chess.AbstractMove;
import ca.markhauser.chess.Move;

public class KnightMove extends AbstractMove implements Move {

	public KnightMove(Boolean canJump, Boolean limitedDistance) {
		super(canJump, limitedDistance);
	}

	@Override
	public Boolean isValidDirection(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return ((Math.abs(sourceFile - destFile) == 2) && (Math.abs(sourceRank - destRank) == 1))
				|| ((Math.abs(sourceFile - destFile) == 1) && (Math.abs(sourceRank - destRank) == 2));
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
