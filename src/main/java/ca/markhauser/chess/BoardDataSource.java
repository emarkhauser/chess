package ca.markhauser.chess;

public interface BoardDataSource {

	void setPiece(Integer file, Integer rank, Piece piece);

	Piece getPiece(Integer file, Integer rank);

}