package ca.markhauser.chess;

public interface Move {

	Boolean isValidMove(Board board, Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank);

}
