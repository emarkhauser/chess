package ca.markhauser.chess;

import ca.markhauser.chess.Coords;
import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.exception.InvalidMove;
import ca.markhauser.chess.exception.OutOfBoardRange;
import ca.markhauser.chess.exception.PieceNotMoved;
import ca.markhauser.chess.exception.NoPieceOnSpace;
import ca.markhauser.chess.piece.Bishop;
import ca.markhauser.chess.piece.King;
import ca.markhauser.chess.piece.Knight;
import ca.markhauser.chess.piece.Pawn;
import ca.markhauser.chess.piece.Piece;
import ca.markhauser.chess.piece.Queen;
import ca.markhauser.chess.piece.Rook;
import ca.markhauser.chess.piece.move.Jumpable;

public class Board {

	BoardData boardData = new BoardData(maxBoardFiles, maxBoardRanks);
	final static int maxBoardFiles = 8;
	final static int maxBoardRanks = 8;

	public Board() {
		try {
			setup();
		} catch (OutOfBoardRange e) {
			e.printStackTrace();
		}
	}

	public void setPiece(Piece piece, Coords coords) {
		boardData.setPiece(piece, coords);
	}

	public Piece getPiece(Coords coords) {
		return boardData.getPiece(coords);
	}

	private void setup() throws OutOfBoardRange {
		// Set white non-pawns
		setPiece(new Rook(PieceColour.WHITE), new Coords('a', 1));
		setPiece(new Knight(PieceColour.WHITE), new Coords('b', 1));
		setPiece(new Bishop(PieceColour.WHITE), new Coords('c', 1));
		setPiece(new Queen(PieceColour.WHITE), new Coords('d', 1));
		setPiece(new King(PieceColour.WHITE), new Coords('e', 1));
		setPiece(new Bishop(PieceColour.WHITE), new Coords('f', 1));
		setPiece(new Knight(PieceColour.WHITE), new Coords('g', 1));
		setPiece(new Rook(PieceColour.WHITE), new Coords('h', 1));

		// Set white pawns
		setPiece(new Pawn(PieceColour.WHITE), new Coords('a', 2));
		setPiece(new Pawn(PieceColour.WHITE), new Coords('b', 2));
		setPiece(new Pawn(PieceColour.WHITE), new Coords('c', 2));
		setPiece(new Pawn(PieceColour.WHITE), new Coords('d', 2));
		setPiece(new Pawn(PieceColour.WHITE), new Coords('e', 2));
		setPiece(new Pawn(PieceColour.WHITE), new Coords('f', 2));
		setPiece(new Pawn(PieceColour.WHITE), new Coords('g', 2));
		setPiece(new Pawn(PieceColour.WHITE), new Coords('h', 2));

		// Set black non-pawns
		setPiece(new Rook(PieceColour.BLACK), new Coords('a', 8));
		setPiece(new Knight(PieceColour.BLACK), new Coords('b', 8));
		setPiece(new Bishop(PieceColour.BLACK), new Coords('c', 8));
		setPiece(new Queen(PieceColour.BLACK), new Coords('d', 8));
		setPiece(new King(PieceColour.BLACK), new Coords('e', 8));
		setPiece(new Bishop(PieceColour.BLACK), new Coords('f', 8));
		setPiece(new Knight(PieceColour.BLACK), new Coords('g', 8));
		setPiece(new Rook(PieceColour.BLACK), new Coords('h', 8));

		// Set black pawns
		setPiece(new Pawn(PieceColour.BLACK), new Coords('a', 7));
		setPiece(new Pawn(PieceColour.BLACK), new Coords('b', 7));
		setPiece(new Pawn(PieceColour.BLACK), new Coords('c', 7));
		setPiece(new Pawn(PieceColour.BLACK), new Coords('d', 7));
		setPiece(new Pawn(PieceColour.BLACK), new Coords('e', 7));
		setPiece(new Pawn(PieceColour.BLACK), new Coords('f', 7));
		setPiece(new Pawn(PieceColour.BLACK), new Coords('g', 7));
		setPiece(new Pawn(PieceColour.BLACK), new Coords('h', 7));
	}
	
	public void movePiece(Coords source, Coords dest) throws InvalidMove, NoPieceOnSpace, PieceNotMoved {

		Piece piece = getPiece(source);
		if (piece == null) throw new NoPieceOnSpace();
		if (source.equals(dest)) throw new PieceNotMoved();
		if (!validMove(source, dest, piece)) throw new InvalidMove();
		setPiece(piece, dest);
		setPiece(null, source);

	}

	/**
	 * @param source
	 * @param dest
	 * @param piece
	 */
	private boolean validMove(Coords source, Coords dest, Piece piece) {
		return piece.validMovePattern(source, dest) /*&& (jumpsPieces(source, dest) == (piece instanceof Jumpable))*/;
	}

	private boolean jumpsPieces(Coords source, Coords dest) {
		// TODO Auto-generated method stub
		return false;
	}

}
