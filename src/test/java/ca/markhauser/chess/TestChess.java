package ca.markhauser.chess;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Chess;
import ca.markhauser.chess.Colour;
import ca.markhauser.chess.standard.ChessApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ChessApplication.class)
public class TestChess {
	
	@Autowired
	Chess chess;
	
	@Autowired
	@Qualifier("white")
	Colour white;
	
	@Autowired
	@Qualifier("black")
	Colour black;
	
	@Test
	public void testNewGameAndBoard() {
		Board board = chess.getBoard();
		assertEquals("king", board.getPiece(5, 8).getType());
		assertEquals(black, board.getPiece(5, 8).getColour());
		assertEquals("white", chess.getCurrentPlayerColour().getColour());
	}
	
	@Test
	@DirtiesContext
	public void testResign() {
		chess.resign();
		assertEquals(black, chess.getWinner());
	}
	
	@Test
	public void testCurrentPlayerColour() {
		assertEquals(white, chess.getCurrentPlayerColour());
	}
	
	@Test
	@DirtiesContext
	public void testMove() {
		assertEquals(white, chess.getCurrentPlayerColour());
		chess.move(2, 1, 3, 3);
		Board board = chess.getBoard();
		assertEquals("knight", board.getPiece(3, 3).getType());
		assertEquals(white, board.getPiece(3, 3).getColour());
		assertNull(board.getPiece(2, 1));
		assertEquals(black, chess.getCurrentPlayerColour());
	}
	
	@Test
	@DirtiesContext
	public void testDraw() {
		chess.draw();
		assertEquals(black, chess.getCurrentPlayerColour());
		assertFalse(chess.isDraw());
		chess.draw();
		assertTrue(chess.isDraw());
	}
	
}
