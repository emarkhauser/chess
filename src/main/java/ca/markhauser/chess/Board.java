package ca.markhauser.chess;

import ca.markhauser.chess.colour.Colour;
import ca.markhauser.chess.colour.ColourFactory;
import ca.markhauser.chess.exception.InvalidMove;
import ca.markhauser.chess.exception.OutOfBoardRange;
import ca.markhauser.chess.exception.PieceNotMoved;
import ca.markhauser.chess.exception.NoPieceOnSpace;
import ca.markhauser.chess.piece.Piece;
import ca.markhauser.chess.piece.PieceFactory;
import ca.markhauser.chess.piece.move.MoveUtil;
import ca.markhauser.chess.space.Space;
import ca.markhauser.chess.space.SpaceFactory;

public class Board {

	BoardData boardData = new BoardData(maxBoardFiles, maxBoardRanks);
	public final static int maxBoardFiles = 8;
	public final static int maxBoardRanks = 8;

	public Board() {
		try {
			setup();
		} catch (OutOfBoardRange e) {
			e.printStackTrace();
		}
	}

	public void setPiece(Piece piece, Space space) {
		boardData.setPiece(piece, space);
	}

	public Piece getPiece(Space coords) {
		return boardData.getPiece(coords);
	}

	private void setup() throws OutOfBoardRange {
		Colour white = ColourFactory.getColour("WHITE");
		Colour black = ColourFactory.getColour("BLACK");
		
		Piece whiteRook = PieceFactory.getPiece("ROOK", white);
		Piece whiteKnight = PieceFactory.getPiece("KNIGHT", white);
		Piece whiteBishop = PieceFactory.getPiece("BISHOP", white);
		Piece whiteQueen = PieceFactory.getPiece("QUEEN", white);
		Piece whiteKing = PieceFactory.getPiece("KING", white);		
		Piece whitePawn = PieceFactory.getPiece("PAWN", white);
		
		Piece blackRook = PieceFactory.getPiece("ROOK", black);
		Piece blackKnight = PieceFactory.getPiece("KNIGHT", black);
		Piece blackBishop = PieceFactory.getPiece("BISHOP", black);
		Piece blackQueen = PieceFactory.getPiece("QUEEN", black);
		Piece blackKing = PieceFactory.getPiece("KING", black);		
		Piece blackPawn = PieceFactory.getPiece("PAWN", black);
		
		// Set white non-pawns
		setPiece(whiteRook, SpaceFactory.getSpace(1, 1));
		setPiece(whiteKnight, SpaceFactory.getSpace(2, 1));
		setPiece(whiteBishop, SpaceFactory.getSpace(3, 1));
		setPiece(whiteQueen, SpaceFactory.getSpace(4, 1));
		setPiece(whiteKing, SpaceFactory.getSpace(5, 1));
		setPiece(whiteBishop, SpaceFactory.getSpace(6, 1));
		setPiece(whiteKnight, SpaceFactory.getSpace(7, 1));
		setPiece(whiteRook, SpaceFactory.getSpace(8, 1));

		// Set white pawns
		setPiece(whitePawn, SpaceFactory.getSpace(1, 2));
		setPiece(whitePawn, SpaceFactory.getSpace(2, 2));
		setPiece(whitePawn, SpaceFactory.getSpace(3, 2));
		setPiece(whitePawn, SpaceFactory.getSpace(4, 2));
		setPiece(whitePawn, SpaceFactory.getSpace(5, 2));
		setPiece(whitePawn, SpaceFactory.getSpace(6, 2));
		setPiece(whitePawn, SpaceFactory.getSpace(7, 2));
		setPiece(whitePawn, SpaceFactory.getSpace(8, 2));

		// Set black non-pawns
		setPiece(blackRook, SpaceFactory.getSpace(1, 8));
		setPiece(blackKnight, SpaceFactory.getSpace(2, 8));
		setPiece(blackBishop, SpaceFactory.getSpace(3, 8));
		setPiece(blackQueen, SpaceFactory.getSpace(4, 8));
		setPiece(blackKing, SpaceFactory.getSpace(5, 8));
		setPiece(blackBishop, SpaceFactory.getSpace(6, 8));
		setPiece(blackKnight, SpaceFactory.getSpace(7, 8));
		setPiece(blackRook, SpaceFactory.getSpace(8, 8));

		// Set black pawns
		setPiece(blackPawn, SpaceFactory.getSpace(1, 7));
		setPiece(blackPawn, SpaceFactory.getSpace(2, 7));
		setPiece(blackPawn, SpaceFactory.getSpace(3, 7));
		setPiece(blackPawn, SpaceFactory.getSpace(4, 7));
		setPiece(blackPawn, SpaceFactory.getSpace(5, 7));
		setPiece(blackPawn, SpaceFactory.getSpace(6, 7));
		setPiece(blackPawn, SpaceFactory.getSpace(7, 7));
		setPiece(blackPawn, SpaceFactory.getSpace(8, 7));
	}
	
	public void movePiece(Space source, Space dest) throws InvalidMove, NoPieceOnSpace, PieceNotMoved {

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
	private boolean validMove(Space source, Space dest, Piece piece) {
		return piece.validMovePattern(source, dest) && (!jumpsPieces(source, dest));
	}

	private boolean jumpsPieces(Space source, Space dest) {
		if (MoveUtil.isDiagonalMove(source, dest)) {
			if (dest.getRank() > source.getRank()) {
				int fileNum = source.getRank();
				for (int i = source.getRank() + 1; i < dest.getRank(); i++) {
					if (getPiece(new Space(fileNum++, i)) != null) return true;
				}
			}
		}
		return false;
	}

}
