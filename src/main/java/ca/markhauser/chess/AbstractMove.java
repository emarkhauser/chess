package ca.markhauser.chess;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractMove {

	@Autowired
	protected Board board;
	
	protected Boolean canJump, limitedDistance;

	public AbstractMove(Boolean canJump, Boolean limitedDistance) {
		this.canJump = canJump;
		this.limitedDistance = limitedDistance;
	}
	
	public Boolean isValidMove(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		if ((!canJump) && (jumpsPieces(sourceFile, sourceRank, destFile, destRank))) {
			return false;
		}
		if ((limitedDistance) && (!shortDistance(sourceFile, sourceRank, destFile, destRank))) {
			return false;
		}
		return isValidDirection(sourceFile, sourceRank, destFile, destRank);
	}
	
	protected abstract Boolean isValidDirection(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank);

	protected abstract Boolean jumpsPieces(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank);
	
	protected abstract Boolean shortDistance(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank);

}