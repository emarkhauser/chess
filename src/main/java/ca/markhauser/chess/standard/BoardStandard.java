package ca.markhauser.chess.standard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.BoardDataSource;
import ca.markhauser.chess.InvalidMove;
import ca.markhauser.chess.Move;
import ca.markhauser.chess.NoPieceOnSpace;
import ca.markhauser.chess.OutOfBoardRange;
import ca.markhauser.chess.Piece;
import ca.markhauser.chess.PieceNotMoved;

public class BoardStandard implements Board {

	private BoardDataSource boardData;

	private int maxBoardFiles;
	private int maxBoardRanks;
	
	@Autowired
	@Qualifier("diagonalMove")
	Move diagonalMove;

	public BoardStandard(int maxBoardFiles, int maxBoardRanks, BoardDataSource boardData) {
		this.boardData = boardData;
		this.maxBoardFiles = maxBoardFiles;
		this.maxBoardRanks = maxBoardRanks;
	}

	@Override
	public void setPiece(Integer file, Integer rank, Piece piece) throws OutOfBoardRange {
		if (inRange(file, rank))
			boardData.setPiece(file, rank, piece);
		else
			throw new OutOfBoardRange();
	}

	private boolean inRange(Integer file, Integer rank) {
		return file <= this.maxBoardFiles && rank <= this.maxBoardRanks && file > 0 && rank > 0;
	}

	public Piece getPiece(Integer file, Integer rank) {
		return boardData.getPiece(file, rank);
	}
	
	private Boolean equalSourceDest(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		return (sourceFile == destFile) && (sourceRank == destRank);
	}

	public void movePiece(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) throws InvalidMove, NoPieceOnSpace, PieceNotMoved, OutOfBoardRange {

		Piece piece = getPiece(sourceFile, sourceRank);
		if (piece == null)
			throw new NoPieceOnSpace();
		if (equalSourceDest(sourceFile, sourceRank, destFile, destRank))
			throw new PieceNotMoved();
		if (!validMove(sourceFile, sourceRank, destFile, destRank, piece))
			throw new InvalidMove();
		setPiece(destFile, destRank, piece);
		setPiece(sourceFile, sourceRank, null);

	}

	/**
	 * @param source
	 * @param dest
	 * @param piece
	 * @throws OutOfBoardRange
	 */
	private boolean validMove(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank, Piece piece) throws OutOfBoardRange {
		if (inRange(sourceFile, sourceRank) && inRange(destFile, destRank))
			return piece.validMovePattern(sourceFile, sourceRank, destFile, destRank) && (!jumpsPieces(sourceFile, sourceRank, destFile, destRank));
		else
			throw new OutOfBoardRange();
	}

	private boolean jumpsPieces(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		if (diagonalMove.isValidMove(sourceFile, sourceRank, destFile, destRank)) {
			if (destRank > sourceRank) {
				int fileNum = sourceRank;
				for (int i = sourceRank + 1; i < destRank; i++) {
					if (getPiece(fileNum++, i) != null)
						return true;
				}
			}
		}
		return false;
	}

}
