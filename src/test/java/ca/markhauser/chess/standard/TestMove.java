package ca.markhauser.chess.standard;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.markhauser.chess.Move;
import ca.markhauser.chess.OutOfBoardRange;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ChessApplication.class)
public class TestMove {
	
	@Autowired
	@Qualifier("diagonalMove")
	Move diagonalMove;
	
	@Autowired
	@Qualifier("knightMove")
	Move knightMove;
	
	@Autowired
	@Qualifier("fileMove")
	Move fileMove;
	
	@Autowired
	@Qualifier("rankMove")
	Move rankMove;

	@Test
	public void testIsDiagonalMove() throws OutOfBoardRange {
		assertTrue(diagonalMove.isValidMove(1, 1, 8, 8));
	}
	
	@Test
	public void testIsNotDiagonalMove() throws OutOfBoardRange {
		assertFalse(diagonalMove.isValidMove(5, 5, 8, 1));
	}

	@Test
	public void testIsFileMove() throws OutOfBoardRange {
		assertTrue(fileMove.isValidMove(1, 1, 1, 7));
	}
	
	@Test
	public void testIsNotFileMove() throws OutOfBoardRange {
		assertFalse(fileMove.isValidMove(2, 1, 5, 7));
	}

	@Test
	public void testIsRankMove() throws OutOfBoardRange {
		assertTrue(rankMove.isValidMove(1, 3, 6, 3));
	}
	
	@Test
	public void testIsNotRankMove() throws OutOfBoardRange {
		assertFalse(rankMove.isValidMove(2, 7, 5, 2));
	}

}
