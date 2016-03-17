package ca.markhauser.chess;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Colour;
import ca.markhauser.chess.Piece;
import ca.markhauser.chess.standard.ChessApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ChessApplication.class)
public class TestBoard {
	
	@Autowired
	Board board;
	
	@Autowired
	@Qualifier("white")
	Colour white;

	@Test
	public void testGetPieceNotNull() {
		Piece piece = board.getPiece(4, 1);
		assertNotNull(piece);
	}

	@Test
	public void testGetPieceNull() {
		Piece piece = board.getPiece(5, 5);
		assertNull(piece);
	}
	
	@Test
	public void testPieceColour() {
		Piece piece = board.getPiece(4, 1);
		assertEquals(white, piece.getColour());
	}

}
