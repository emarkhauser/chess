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
public class TestBoardDataSource {
	
	@Autowired
	BoardDataSource boardData;

	@Test
	public void testBoardDataSourceStandard() {
		assertNotNull(boardData.getPiece(1,1));
	}

	@Test
	@DirtiesContext
	public void testSetPiece() {
		Piece piece = boardData.getPiece(1, 1);
		boardData.setPiece(5, 5, piece);
		assertEquals(piece, boardData.getPiece(5, 5));
	}

	@Test
	public void testGetPiece() {
		assertEquals("rook", boardData.getPiece(1, 1).getType());
	}
	
	@Test
	public void testGetPieceOnEmptySpace() {
		assertNull(boardData.getPiece(4, 4));
	}


}
