package ca.markhauser.chess;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.markhauser.chess.ChessStandard;
import ca.markhauser.chess.board.Board;
import ca.markhauser.chess.board.BoardStandard;
import ca.markhauser.chess.exception.OutOfBoardRange;
import ca.markhauser.chess.piece.Piece;
import ca.markhauser.chess.space.SpaceFactory;

public class TestChess {

	@Test
	public void testNewGameAndBoard() throws OutOfBoardRange {
		Chess chess = new ChessStandard();
		Board board = chess.getBoard();
		Piece piece = board.getPiece(SpaceFactory.getSpace(5, 8));
		assertEquals("King", piece.getType());
		assertEquals(PieceColour.BLACK, piece.getColour());
	}
	
	@Test
	public void testResign() {
		Chess chess = new ChessStandard();
		chess.resign();
		assertEquals(Winner.BLACK, chess.getWinner());
	}
	
	@Test
	public void testCurrentPlayerColour() {
		Chess chess = new ChessStandard();
		assertEquals(PieceColour.WHITE, chess.getCurrentPlayerColour());
	}
	
	@Test
	public void testMove() throws OutOfBoardRange {
		Chess chess = new ChessStandard();
		BoardStandard board = chess.getBoard();
		SpaceTwoDimensions source = new SpaceTwoDimensions('b', 1);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('c', 3);
		chess.move(new SpaceTwoDimensions('b', 1), dest);
		Piece piece = board.getPiece(dest);
		assertTrue(piece instanceof Knight);
		assertEquals(PieceColour.WHITE, piece.getColour());
		assertNull(board.getPiece(source));
	}
	
}
