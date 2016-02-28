package ca.markhauser.piece.move;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.markhauser.chess.exception.OutOfBoardRange;
import ca.markhauser.chess.piece.move.MoveUtil;
import ca.markhauser.chess.space.SpaceTwoDimensions;

public class TestMoveUtil {

	@Test
	public void testIsDiagonalMove() throws OutOfBoardRange {
		SpaceTwoDimensions source = new SpaceTwoDimensions('a', 1);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('h', 8);
		assertTrue(MoveUtil.isDiagonalMove(source, dest));
	}
	
	@Test
	public void testIsNotDiagonalMove() throws OutOfBoardRange {
		SpaceTwoDimensions source = new SpaceTwoDimensions('e', 5);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('h', 1);
		assertFalse(MoveUtil.isDiagonalMove(source, dest));
	}

	@Test
	public void testIsFileMove() throws OutOfBoardRange {
		SpaceTwoDimensions source = new SpaceTwoDimensions('a', 1);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('a', 7);
		assertTrue(MoveUtil.isFileMove(source, dest));
	}
	
	@Test
	public void testIsNotFileMove() throws OutOfBoardRange {
		SpaceTwoDimensions source = new SpaceTwoDimensions('b', 1);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('e', 7);
		assertFalse(MoveUtil.isFileMove(source, dest));
	}

	@Test
	public void testIsFileBlackMove() throws OutOfBoardRange {
		SpaceTwoDimensions source = new SpaceTwoDimensions('b', 1);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('b', 7);
		assertTrue(MoveUtil.isFileBlackMove(source, dest));
	}
	
	@Test
	public void testIsNotFileBlackMove() throws OutOfBoardRange {
		SpaceTwoDimensions source = new SpaceTwoDimensions('c', 7);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('c', 1);
		assertFalse(MoveUtil.isFileBlackMove(source, dest));
	}

	@Test
	public void testIsFileWhiteMove() throws OutOfBoardRange {
		SpaceTwoDimensions source = new SpaceTwoDimensions('d', 2);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('d', 1);
		assertTrue(MoveUtil.isFileWhiteMove(source, dest));
	}
	
	@Test
	public void testIsNotFileWhiteMove() throws OutOfBoardRange {
		SpaceTwoDimensions source = new SpaceTwoDimensions('f', 4);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('f', 7);
		assertFalse(MoveUtil.isFileWhiteMove(source, dest));
	}

	@Test
	public void testIsRankMove() throws OutOfBoardRange {
		SpaceTwoDimensions source = new SpaceTwoDimensions('a', 3);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('f', 3);
		assertTrue(MoveUtil.isRankMove(source, dest));
	}
	
	@Test
	public void testIsNotRankMove() throws OutOfBoardRange {
		SpaceTwoDimensions source = new SpaceTwoDimensions('b', 7);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('e', 2);
		assertFalse(MoveUtil.isRankMove(source, dest));
	}

	@Test
	public void testIsRankKingMove() throws OutOfBoardRange {
		SpaceTwoDimensions source = new SpaceTwoDimensions('a', 5);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('f', 5);
		assertTrue(MoveUtil.isRankKingMove(source, dest));
	}
	
	@Test
	public void testIsNotRankKingMove() throws OutOfBoardRange {
		SpaceTwoDimensions source = new SpaceTwoDimensions('c', 6);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('b', 6);
		assertFalse(MoveUtil.isRankKingMove(source, dest));
	}

	@Test
	public void testIsRankQueenMove() throws OutOfBoardRange {
		SpaceTwoDimensions source = new SpaceTwoDimensions('h', 8);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('a', 8);
		assertTrue(MoveUtil.isRankQueenMove(source, dest));
	}
	
	@Test
	public void testIsNotRankQueenMove() throws OutOfBoardRange {
		SpaceTwoDimensions source = new SpaceTwoDimensions('a', 3);
		SpaceTwoDimensions dest = new SpaceTwoDimensions('b', 3);
		assertFalse(MoveUtil.isRankQueenMove(source, dest));
	}

}
