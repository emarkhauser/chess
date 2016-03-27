package ca.markhauser.chess;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.markhauser.chess.standard.ChessApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ChessApplication.class)
public class TestPiece {
	
	@Autowired
	Board board;

	@Test
	@DirtiesContext
	public void testValidMovePatternForKnight() throws InvalidMove, NoPieceOnSpace, PieceNotMoved, OutOfBoardRange {
		Piece knightWhite = board.getPiece(2, 1);
		board.movePiece(2, 1, 3, 3);
		assertEquals(knightWhite, board.getPiece(3, 3));
		assertNull(board.getPiece(2, 1));
	}
	
	@Test(expected=InvalidMove.class)
	@DirtiesContext
	public void testInvalidMovePatternForKnight() throws InvalidMove, NoPieceOnSpace, PieceNotMoved, OutOfBoardRange {
		Piece knightWhite = board.getPiece(2, 1);
		board.movePiece(2, 1, 4, 3);
		assertNull(board.getPiece(4, 3));
		assertEquals(knightWhite, board.getPiece(2, 1));
	}
	
	@Test(expected=InvalidMove.class)
	@DirtiesContext
	public void testInvalidMovePatternForRook() throws InvalidMove, NoPieceOnSpace, PieceNotMoved, OutOfBoardRange {
		Piece RookBlack = board.getPiece(8, 8);
		board.movePiece(8, 8, 7, 7);
		assertNull(board.getPiece(7, 7));
		assertEquals(RookBlack, board.getPiece(8, 8));
	}

	@Test
	public void testAddMove() {
		fail("Not yet implemented");
	}

}
