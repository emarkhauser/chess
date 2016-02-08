package ca.markhauser.chess.standard;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Coords;
import ca.markhauser.chess.Piece;
import ca.markhauser.chess.Space;

public class BoardStandard implements Board {

	Space[][] board;

	public BoardStandard(int maxFiles, int maxRanks) {
		board = new SpaceStandard[maxFiles][maxRanks];
		for (int i = 0; i < maxFiles; i++) {
			for (int j = 0; j < maxRanks; j++) {
				board[i][j] = new SpaceStandard();
			}
		}
	}

	public void setPiece(Piece piece, Coords coords) {
		int file = coords.getFileNumber();
		int rank = coords.getRank();
		board[file - 1][rank - 1].setPiece(piece);
	}

	@Override
	public Piece getPiece(Coords coords) {
		int file = coords.getFileNumber();
		int rank = coords.getRank();
		return board[file - 1][rank - 1].getPiece();
	}

}
