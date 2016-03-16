package ca.markhauser.chess.standard;

import ca.markhauser.chess.Piece;

public class BoardData {

	private Piece[][] boardArray;

	public BoardData(Integer maxFiles, Integer maxRanks) {
		boardArray = new Piece[maxFiles][maxRanks];
	}

	public void setPiece(Integer file, Integer rank, Piece piece) {
		boardArray[file - 1][rank - 1] = piece;
	}

	public Piece getPiece(Integer file, Integer rank) {
		return boardArray[file - 1][rank - 1];
	}

}