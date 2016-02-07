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

	private int getFileNumber(char file) {
		switch (file) {
		case 'a':
			return 1;
		case 'b':
			return 2;
		case 'c':
			return 3;
		case 'd':
			return 4;
		case 'e':
			return 5;
		case 'f':
			return 6;
		case 'g':
			return 7;
		case 'h':
			return 8;
		}
		return 0;
	}

	public void setPiece(Piece piece, Coords coords) {
		char file = coords.getFile();
		int fileNumber = getFileNumber(file);
		int rank = coords.getRank();
		board[fileNumber - 1][rank - 1].setPiece(piece);
	}

	@Override
	public Piece getPiece(Coords coords) {
		char file = coords.getFile();
		int fileNumber = getFileNumber(file);
		int rank = coords.getRank();
		return board[fileNumber - 1][rank - 1].getPiece();
	}

}
