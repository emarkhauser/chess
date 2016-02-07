/**
 * 
 */
package ca.markhauser.chess.standard;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Chess;
import ca.markhauser.chess.Coords;
import ca.markhauser.chess.Move;
import ca.markhauser.chess.MoveResult;
import ca.markhauser.chess.Piece;
import ca.markhauser.chess.PieceColour;
import ca.markhauser.chess.PieceType;
import ca.markhauser.chess.Winner;

/**
 * @author Admin Account HP
 *
 */
public class ChessStandard implements Chess {

	private Board board;
	private PieceColour currentPlayerColour = PieceColour.WHITE;
	private Winner winner = Winner.NOTDONE;
	private boolean isCheck = false;
	private boolean isCheckmate = false;
	final static int maxBoardFiles = 8;
	final static int maxBoardRanks = 8;

	public ChessStandard() {
		this.board = new BoardStandard(maxBoardFiles, maxBoardRanks);

		// Set white non-pawns
		this.board.setPiece(new PieceStandard(PieceType.ROOK, PieceColour.WHITE), new CoordsStandard('a', 1));
		this.board.setPiece(new PieceStandard(PieceType.KNIGHT, PieceColour.WHITE), new CoordsStandard('b', 1));
		this.board.setPiece(new PieceStandard(PieceType.BISHOP, PieceColour.WHITE), new CoordsStandard('c', 1));
		this.board.setPiece(new PieceStandard(PieceType.QUEEN, PieceColour.WHITE), new CoordsStandard('d', 1));
		this.board.setPiece(new PieceStandard(PieceType.KING, PieceColour.WHITE), new CoordsStandard('e', 1));
		this.board.setPiece(new PieceStandard(PieceType.BISHOP, PieceColour.WHITE), new CoordsStandard('f', 1));
		this.board.setPiece(new PieceStandard(PieceType.KNIGHT, PieceColour.WHITE), new CoordsStandard('g', 1));
		this.board.setPiece(new PieceStandard(PieceType.ROOK, PieceColour.WHITE), new CoordsStandard('h', 1));

		// Set white pawns
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.WHITE), new CoordsStandard('a', 2));
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.WHITE), new CoordsStandard('b', 2));
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.WHITE), new CoordsStandard('c', 2));
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.WHITE), new CoordsStandard('d', 2));
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.WHITE), new CoordsStandard('e', 2));
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.WHITE), new CoordsStandard('f', 2));
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.WHITE), new CoordsStandard('g', 2));
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.WHITE), new CoordsStandard('h', 2));

		// Set black non-pawns
		this.board.setPiece(new PieceStandard(PieceType.ROOK, PieceColour.BLACK), new CoordsStandard('a', 8));
		this.board.setPiece(new PieceStandard(PieceType.KNIGHT, PieceColour.BLACK), new CoordsStandard('b', 8));
		this.board.setPiece(new PieceStandard(PieceType.BISHOP, PieceColour.BLACK), new CoordsStandard('c', 8));
		this.board.setPiece(new PieceStandard(PieceType.QUEEN, PieceColour.BLACK), new CoordsStandard('d', 8));
		this.board.setPiece(new PieceStandard(PieceType.KING, PieceColour.BLACK), new CoordsStandard('e', 8));
		this.board.setPiece(new PieceStandard(PieceType.BISHOP, PieceColour.BLACK), new CoordsStandard('f', 8));
		this.board.setPiece(new PieceStandard(PieceType.KNIGHT, PieceColour.BLACK), new CoordsStandard('g', 8));
		this.board.setPiece(new PieceStandard(PieceType.ROOK, PieceColour.BLACK), new CoordsStandard('h', 8));

		// Set black pawns
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.BLACK), new CoordsStandard('a', 7));
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.BLACK), new CoordsStandard('b', 7));
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.BLACK), new CoordsStandard('c', 7));
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.BLACK), new CoordsStandard('d', 7));
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.BLACK), new CoordsStandard('e', 7));
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.BLACK), new CoordsStandard('f', 7));
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.BLACK), new CoordsStandard('g', 7));
		this.board.setPiece(new PieceStandard(PieceType.PAWN, PieceColour.BLACK), new CoordsStandard('h', 7));
	}

	private boolean outOfRange(Coords coords) {		
		int file = ChessUtilities.fileToNumber(coords.getFile());
		int rank = coords.getRank();
		
		if ((file > 8) || (file < 1) || (rank > 8) || (rank < 1)) {
			return true;
		}
		else return false;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#makeMove(ca.markhauser.chess.Move)
	 */
	@Override
	public MoveResult move(Move move) {
		Coords source = move.getDestCoords();
		Coords dest = move.getDestCoords();
		
		if (source == dest) return MoveResult.SAMESOURCEANDDESTINATION; // need comparator
		if (outOfRange(source)) return MoveResult.SOURCEOUTOFRANGE;
		if (outOfRange(dest)) return MoveResult.DESTINATIONOUTOFRANGE;
		
		Piece piece = this.board.getPiece(source);
		if (piece == null) return MoveResult.NOPIECEONSOURCE;
		
		MoveType moveType = getMoveType(move);
		
		int sourceFile = ChessUtilities.fileToNumber(source.getFile());
		int sourceRank = source.getRank();
		int destFile = ChessUtilities.fileToNumber(dest.getFile());
		int destRank = source.getRank();
		
		switch (piece.getType()) {
		case ROOK:

		case KNIGHT:

		case BISHOP:

		case QUEEN:

		case KING:

		case PAWN:
			if (moveType == MoveType.FILE) {
				
			}
		}

		changeToNextPlayer();
		return MoveResult.MOVED;
	}

	private MoveType getMoveType(Move move) {
		Coords source = move.getDestCoords();
		Coords dest = move.getDestCoords();
		int sourceFile = ChessUtilities.fileToNumber(source.getFile());
		int sourceRank = source.getRank();
		int destFile = ChessUtilities.fileToNumber(dest.getFile());
		int destRank = source.getRank();
		
		if (sourceFile == destFile) {
			return MoveType.FILE;
		}
		
		if (sourceRank == destRank) {
			return MoveType.RANK;
		}

		return null;
	}

	private void changeToNextPlayer() {
		this.currentPlayerColour = this.currentPlayerColour == PieceColour.WHITE ? PieceColour.BLACK
				: PieceColour.WHITE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#getCurrentPlayerColour()
	 */
	@Override
	public PieceColour getCurrentPlayerColour() {
		return this.currentPlayerColour;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#getBoard()
	 */
	@Override
	public Board getBoard() {
		return this.board;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#resign()
	 */
	@Override
	public void resign() {
		this.winner = this.currentPlayerColour == PieceColour.WHITE ? Winner.BLACK : Winner.WHITE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#draw()
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#isCheck()
	 */
	@Override
	public boolean isCheck() {
		return this.isCheck;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#isCheckmate()
	 */
	@Override
	public boolean isCheckmate() {
		return this.isCheckmate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#getWinner()
	 */
	@Override
	public Winner getWinner() {
		return this.winner;
	}

}
