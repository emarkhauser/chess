package ca.markhauser.chess.board;

import java.util.HashMap;

import ca.markhauser.chess.piece.Piece;
import ca.markhauser.chess.space.Space;

public class BoardData {

	private HashMap<Space, Piece> boardMap = new HashMap<Space, Piece>();

	public BoardData() {
	}

	public void setPiece(Piece piece, Space space) {
		boardMap.put(space, piece);
	}

	public Piece getPiece(Space space) {
		return boardMap.get(space);
	}

}