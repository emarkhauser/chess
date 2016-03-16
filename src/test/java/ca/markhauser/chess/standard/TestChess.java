package ca.markhauser.chess.standard;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Chess;
import ca.markhauser.chess.Colour;
import ca.markhauser.chess.OutOfBoardRange;
import ca.markhauser.chess.Piece;
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
	public void testNewGameAndBoard() throws OutOfBoardRange {
		Board board = chess.getBoard();
		Piece piece = board.getPiece(5, 8);
		assertEquals("king", piece.getType());
		assertEquals(black, piece.getColour());
	}
	
	@Test
	public void testResign() {
		chess.resign();
		assertEquals(black, chess.getWinner());
	}
	
	@Test
	public void testCurrentPlayerColour() {
		assertEquals(white, chess.getCurrentPlayerColour());
	}
	
	@Test
	public void testMove() throws OutOfBoardRange {		
		Board board = chess.getBoard();
		chess.move(2, 1, 3, 3);
		Piece piece = board.getPiece(3, 3);
		assertEquals("knight", piece.getType());
		assertEquals(white, piece.getColour());
		assertNull(board.getPiece(2, 1));
	}
	
}
