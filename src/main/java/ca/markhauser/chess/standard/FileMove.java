package ca.markhauser.chess.standard;

import ca.markhauser.chess.AbstractMove;
import ca.markhauser.chess.Move;

public class FileMove extends AbstractMove implements Move {

	public FileMove(Boolean canJump, Boolean limitedDistance) {
		super(canJump, limitedDistance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean isValidDirection(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return isFileBlackMove(sourceFile, sourceRank, destFile, destRank)
				|| isFileWhiteMove(sourceFile, sourceRank, destFile, destRank);
	}

	private Boolean isFileBlackMove(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return (sourceFile == destFile) && (destRank > sourceRank);
	}

	private Boolean isFileWhiteMove(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return (sourceFile == destFile) && (destRank < sourceRank);
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
