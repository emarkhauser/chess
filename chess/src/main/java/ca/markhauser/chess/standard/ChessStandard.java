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

		MoveAnalyzer moveAnalyzer = new MoveAnalyzer(sourceFile, sourceRank, destFile, destRank);

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
			if (moveAnalyzer.isFileRankMove()) {
				if (isAnotherPieceInPath())
					return MoveResult.ANOTHERPIECEINPATH;
				return MoveResult.MOVED;
			}
		case KNIGHT:
			if (moveAnalyzer.isKnightMove()) {
				return MoveResult.MOVED;
			}
		case BISHOP:
			if (moveAnalyzer.isDiagonalMove()) {
				if (isAnotherPieceInPath())
					return MoveResult.ANOTHERPIECEINPATH;
				return MoveResult.MOVED;
			}
		case QUEEN:
			if (moveAnalyzer.isFileRankDiagonalMove()) {
				if (isAnotherPieceInPath())
					return MoveResult.ANOTHERPIECEINPATH;
				return MoveResult.MOVED;
			}
		case KING:
			if (moveAnalyzer.isFileRankDiagonalMove()) {
				return MoveResult.MOVED;
			}
		case PAWN:

		}

		changeToNextPlayer();
		return MoveResult.MOVED;
	}

	private class MoveAnalyzer {
		int sourceFile, sourceRank, destFile, destRank;

		public MoveAnalyzer(int sourceFile, int sourceRank, int destFile, int destRank) {
			this.sourceFile = sourceFile;
			this.sourceRank = sourceRank;
			this.destFile = destFile;
			this.destRank = destRank;
		}

		private boolean isFileRankDiagonalMove() {
			return isFileRankMove() || isDiagonalMove();
		}

		private boolean isFileRankMove() {
			return isFileMove() || isRankMove();
		}

		private boolean isKnightMove() {
			return ((Math.abs(sourceFile - destFile) == 2) && (Math.abs(sourceRank - destRank) == 1))
					|| ((Math.abs(sourceFile - destFile) == 1) && (Math.abs(sourceRank - destRank) == 2));
		}

		private boolean isDiagonalMove() {
			return Math.abs(sourceFile - destFile) == Math.abs(sourceRank - destRank);
		}

		private boolean isFileMove() {
			return isFileBlackMove() || isFileWhiteMove();
		}

		private boolean isFileBlackMove() {
			return (sourceFile == destFile) && (destRank > sourceRank);
		}

		private boolean isFileWhiteMove() {
			return (sourceFile == destFile) && (destRank < sourceRank);
		}

		private boolean isRankMove() {
			return isRankKingMove() || isRankQueenMove();
		}

		private boolean isRankKingMove() {
			return (sourceRank == destRank) && (destFile > sourceFile);
		}

		private boolean isRankQueenMove() {
			return (sourceRank == destRank) && (destFile < sourceFile);
		}

	}

	private boolean isAnotherPieceInPath() {
		// TODO
		return false;
	}
	
	private int moveDistance() {
		// TODO
		return 0;
	}

	private boolean outOfRange(int file, int rank) {
		return (file > maxBoardFiles) || (file < 1) || (rank > maxBoardRanks) || (rank < 1);
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
