package ca.markhauser.chess;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Chess;
import ca.markhauser.chess.Coords;
import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.enums.Winner;
import ca.markhauser.chess.exception.OutOfBoardRange;
import ca.markhauser.chess.piece.King;
import ca.markhauser.chess.piece.Knight;
import ca.markhauser.chess.piece.Piece;

public class TestChess {

	@Test
	public void testNewGameAndBoard() throws OutOfBoardRange {
		Chess chess = new Chess();
		Board board = chess.getBoard();
		Piece piece = board.getPiece(new Coords('e', 8));
		assertTrue(piece instanceof King);
		assertEquals(PieceColour.BLACK, piece.getColour());
	}
	
	@Test
	public void testResign() {
		Chess chess = new Chess();
		chess.resign();
		assertEquals(Winner.BLACK, chess.getWinner());
	}
	
	@Test
	public void testCurrentPlayerColour() {
		Chess chess = new Chess();
		assertEquals(PieceColour.WHITE, chess.getCurrentPlayerColour());
	}
	
	@Test
	public void testMove() throws OutOfBoardRange {
		Chess chess = new Chess();
		Board board = chess.getBoard();
		Coords source = new Coords('b', 1);
		Coords dest = new Coords('c', 3);
		chess.move(new Coords('b', 1), dest);
		Piece piece = board.getPiece(dest);
		assertTrue(piece instanceof Knight);
		assertEquals(PieceColour.WHITE, piece.getColour());
		assertNull(board.getPiece(source));
	}
	
}
