package ca.markhauser.chess;

import ca.markhauser.chess.piece.Piece;

public class BoardData {
	private Space[][] board;
	
	private class Space {
		
		private Piece piece;

		public Space() {
		}

		public void setPiece(Piece piece) {
			this.piece = piece;
		}

		public Piece getPiece() {
			return this.piece;
		}

	}

	public BoardData(int maxBoardFiles, int maxBoardRanks) {
		board = new Space[maxBoardFiles][maxBoardRanks];
		for (int i = 0; i < maxBoardFiles; i++) {
			for (int j = 0; j < maxBoardRanks; j++) {
				board[i][j] = new Space();
			}
		}
	}
	
	/**
	 * @param piece
	 * @param coords
	 */
	public void setPiece(Piece piece, Coords coords) {
		int file = coords.getFileNumber();
		int rank = coords.getRank();
		board[file - 1][rank - 1].setPiece(piece);
	}
	
	/**
	 * @param coords
	 * @return
	 */
	public Piece getPiece(Coords coords) {
		int file = coords.getFileNumber();
		int rank = coords.getRank();
		return board[file - 1][rank - 1].getPiece();
	}
}