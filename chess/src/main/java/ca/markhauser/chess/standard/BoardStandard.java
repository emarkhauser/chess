package ca.markhauser.chess.standard;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Coords;
import ca.markhauser.chess.Piece;
import ca.markhauser.chess.PieceColour;
import ca.markhauser.chess.PieceType;
import ca.markhauser.chess.Space;

public class BoardStandard implements Board {

	Space[][] board;

	public BoardStandard(int maxFiles, int maxRanks) {
		board = new SpaceStandard[maxFiles][maxRanks];
		for (int i=0; i<maxFiles; i++) {
			for (int j=0; j<maxRanks; j++) {
				board[i][j] = new SpaceStandard();
			}
		}
		setPiece(new PieceStandard(PieceType.ROOK, PieceColour.WHITE), new CoordsStandard(1,1));
	}
	
	public void setPiece(Piece piece, Coords coords) {
		int file = coords.getFile();
		int rank = coords.getRank();
		board[file-1][rank-1].setPiece(piece);
	}

	@Override
	public Piece getPiece(Coords coords) {
		int file = coords.getFile();
		int rank = coords.getRank();
		return board[file-1][rank-1].getPiece();
	}

}
