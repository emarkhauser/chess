package ca.markhauser.chess.standard;

import ca.markhauser.chess.Move;

public class FileMove implements Move {

	@Override
	public Boolean isValidMove(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return isFileBlackMove(sourceFile, sourceRank, destFile, destRank)
				|| isFileWhiteMove(sourceFile, sourceRank, destFile, destRank);
	}

	private Boolean isFileBlackMove(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return (sourceFile == destFile) && (destRank > sourceRank);
	}

	private Boolean isFileWhiteMove(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return (sourceFile == destFile) && (destRank < sourceRank);
	}

}
