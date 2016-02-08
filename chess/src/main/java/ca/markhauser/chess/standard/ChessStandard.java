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

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#makeMove(ca.markhauser.chess.Move)
	 */
	@Override
	public MoveResult move(Move move) {

		Coords source = move.getDestCoords();
		Coords dest = move.getDestCoords();
		int sourceFile = source.getFileNumber();
		int sourceRank = source.getRank();
		int destFile = dest.getFileNumber();
		int destRank = dest.getRank();
		Piece piece = this.board.getPiece(source);

		if (source == dest)
			return MoveResult.SAMESOURCEANDDESTINATION; // need comparator
		if (outOfRange(sourceFile, sourceRank))
			return MoveResult.SOURCEOUTOFRANGE;
		if (outOfRange(destFile, destRank))
			return MoveResult.DESTINATIONOUTOFRANGE;
		if (piece == null)
			return MoveResult.NOPIECEONSOURCE;

		switch (piece.getType()) {
		case ROOK:
			if (isAnotherPieceInPath())
				return MoveResult.ANOTHERPIECEINPATH;
			if (isFileRankMove(sourceFile, sourceRank, destFile, destRank))
				return MoveResult.MOVED;
		case KNIGHT:
			if (isKnightMove(sourceFile, sourceRank, destFile, destRank)) {
				return MoveResult.MOVED;
			}
		case BISHOP:
			if (isAnotherPieceInPath())
				return MoveResult.ANOTHERPIECEINPATH;
			if (isDiagonalMove(sourceFile, sourceRank, destFile, destRank)) {
				return MoveResult.MOVED;
			}
		case QUEEN:
			if (isAnotherPieceInPath())
				return MoveResult.ANOTHERPIECEINPATH;
			if (isFileRankDiagonalMove(sourceFile, sourceRank, destFile, destRank)) {
				return MoveResult.MOVED;
			}			
		case KING:
			if (isAnotherPieceInPath())
				return MoveResult.ANOTHERPIECEINPATH;
			if (isFileRankDiagonalMove(sourceFile, sourceRank, destFile, destRank)) {
				return MoveResult.MOVED;
			}	
		case PAWN:

		}

		changeToNextPlayer();
		return MoveResult.MOVED;
	}
	
	private boolean isFileRankDiagonalMove(int sourceFile, int sourceRank, int destFile, int destRank) {
		return isFileRankMove(sourceFile, sourceRank, destFile, destRank)
				|| isDiagonalMove(sourceFile, sourceRank, destFile, destRank);
	}

	private boolean isFileRankMove(int sourceFile, int sourceRank, int destFile, int destRank) {
		return isFileMove(sourceFile, sourceRank, destFile, destRank)
				|| isRankMove(sourceFile, sourceRank, destFile, destRank);
	}

	private boolean isAnotherPieceInPath() {
		// TODO
		return false;
	}

	private boolean isKnightMove(int sourceFile, int sourceRank, int destFile, int destRank) {
		return ((Math.abs(sourceFile - destFile) == 2) && (Math.abs(sourceRank - destRank) == 1))
				|| ((Math.abs(sourceFile - destFile) == 1) && (Math.abs(sourceRank - destRank) == 2));
	}

	private boolean outOfRange(int file, int rank) {
		return (file > maxBoardFiles) || (file < 1) || (rank > maxBoardRanks) || (rank < 1);
	}

	private boolean isDiagonalMove(int sourceFile, int sourceRank, int destFile, int destRank) {
		return Math.abs(sourceFile - destFile) == Math.abs(sourceRank - destRank);
	}

	private boolean isFileMove(int sourceFile, int sourceRank, int destFile, int destRank) {
		return isFileBlackMove(sourceFile, sourceRank, destFile, destRank)
				|| isFileWhiteMove(sourceFile, sourceRank, destFile, destRank);
	}

	private boolean isFileBlackMove(int sourceFile, int sourceRank, int destFile, int destRank) {
		return (sourceFile == destFile) && (destRank > sourceRank);
	}

	private boolean isFileWhiteMove(int sourceFile, int sourceRank, int destFile, int destRank) {
		return (sourceFile == destFile) && (destRank < sourceRank);
	}

	private boolean isRankMove(int sourceFile, int sourceRank, int destFile, int destRank) {
		return isRankKingMove(sourceFile, sourceRank, destFile, destRank)
				|| isRankQueenMove(sourceFile, sourceRank, destFile, destRank);
	}

	private boolean isRankKingMove(int sourceFile, int sourceRank, int destFile, int destRank) {
		return (sourceRank == destRank) && (destFile > sourceFile);
	}

	private boolean isRankQueenMove(int sourceFile, int sourceRank, int destFile, int destRank) {
		return (sourceRank == destRank) && (destFile < sourceFile);
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
