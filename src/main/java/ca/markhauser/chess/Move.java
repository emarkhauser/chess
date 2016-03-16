package ca.markhauser.chess;

public interface Move {

	Boolean isValidMove(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank);
	
}
