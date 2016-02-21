package ca.markhauser.piece.move;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.markhauser.chess.Coords;
import ca.markhauser.chess.exception.OutOfBoardRange;
import ca.markhauser.chess.piece.move.MoveUtil;

public class TestMoveUtil {

	@Test
	public void testIsDiagonalMove() throws OutOfBoardRange {
		Coords source = new Coords('a', 1);
		Coords dest = new Coords('h', 8);
		assertTrue(MoveUtil.isDiagonalMove(source, dest));
	}
	
	@Test
	public void testIsNotDiagonalMove() throws OutOfBoardRange {
		Coords source = new Coords('e', 5);
		Coords dest = new Coords('h', 1);
		assertFalse(MoveUtil.isDiagonalMove(source, dest));
	}

	@Test
	public void testIsFileMove() throws OutOfBoardRange {
		Coords source = new Coords('a', 1);
		Coords dest = new Coords('a', 7);
		assertTrue(MoveUtil.isFileMove(source, dest));
	}
	
	@Test
	public void testIsNotFileMove() throws OutOfBoardRange {
		Coords source = new Coords('b', 1);
		Coords dest = new Coords('e', 7);
		assertFalse(MoveUtil.isFileMove(source, dest));
	}

	@Test
	public void testIsFileBlackMove() throws OutOfBoardRange {
		Coords source = new Coords('b', 1);
		Coords dest = new Coords('b', 7);
		assertTrue(MoveUtil.isFileBlackMove(source, dest));
	}
	
	@Test
	public void testIsNotFileBlackMove() throws OutOfBoardRange {
		Coords source = new Coords('c', 7);
		Coords dest = new Coords('c', 1);
		assertFalse(MoveUtil.isFileBlackMove(source, dest));
	}

	@Test
	public void testIsFileWhiteMove() throws OutOfBoardRange {
		Coords source = new Coords('d', 2);
		Coords dest = new Coords('d', 1);
		assertTrue(MoveUtil.isFileWhiteMove(source, dest));
	}
	
	@Test
	public void testIsNotFileWhiteMove() throws OutOfBoardRange {
		Coords source = new Coords('f', 4);
		Coords dest = new Coords('f', 7);
		assertFalse(MoveUtil.isFileWhiteMove(source, dest));
	}

	@Test
	public void testIsRankMove() throws OutOfBoardRange {
		Coords source = new Coords('a', 3);
		Coords dest = new Coords('f', 3);
		assertTrue(MoveUtil.isRankMove(source, dest));
	}
	
	@Test
	public void testIsNotRankMove() throws OutOfBoardRange {
		Coords source = new Coords('b', 7);
		Coords dest = new Coords('e', 2);
		assertFalse(MoveUtil.isRankMove(source, dest));
	}

	@Test
	public void testIsRankKingMove() throws OutOfBoardRange {
		Coords source = new Coords('a', 5);
		Coords dest = new Coords('f', 5);
		assertTrue(MoveUtil.isRankKingMove(source, dest));
	}
	
	@Test
	public void testIsNotRankKingMove() throws OutOfBoardRange {
		Coords source = new Coords('c', 6);
		Coords dest = new Coords('b', 6);
		assertFalse(MoveUtil.isRankKingMove(source, dest));
	}

	@Test
	public void testIsRankQueenMove() throws OutOfBoardRange {
		Coords source = new Coords('h', 8);
		Coords dest = new Coords('a', 8);
		assertTrue(MoveUtil.isRankQueenMove(source, dest));
	}
	
	@Test
	public void testIsNotRankQueenMove() throws OutOfBoardRange {
		Coords source = new Coords('a', 3);
		Coords dest = new Coords('b', 3);
		assertFalse(MoveUtil.isRankQueenMove(source, dest));
	}

}
