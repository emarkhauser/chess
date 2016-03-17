package ca.markhauser.chess.standard;

import ca.markhauser.chess.BoardDataSource;
import ca.markhauser.chess.Piece;

class BoardDataSourceStandard implements BoardDataSource {

	private Piece[][] boardArray;

	public BoardDataSourceStandard(Integer maxFiles, Integer maxRanks) {
		boardArray = new Piece[maxFiles][maxRanks];
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.standard.BoardDataSource#setPiece(java.lang.Integer, java.lang.Integer, ca.markhauser.chess.Piece)
	 */
	public void setPiece(Integer file, Integer rank, Piece piece) {
		boardArray[file - 1][rank - 1] = piece;
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.standard.BoardDataSource#getPiece(java.lang.Integer, java.lang.Integer)
	 */
	public Piece getPiece(Integer file, Integer rank) {
		return boardArray[file - 1][rank - 1];
	}

}