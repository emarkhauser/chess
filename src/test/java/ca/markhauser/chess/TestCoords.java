package ca.markhauser.chess;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.markhauser.chess.exception.OutOfBoardRange;
import ca.markhauser.chess.space.SpaceTwoDimensions;

public class TestCoords {

	@Test(expected = OutOfBoardRange.class)
	public void testCoordsOutOfRange() throws OutOfBoardRange {
		SpaceTwoDimensions coords = new SpaceTwoDimensions('a', 10);
	}
	
	@Test
	public void testCoordsInRange() throws OutOfBoardRange {
		SpaceTwoDimensions coords = new SpaceTwoDimensions('e', 5);
	}

	@Test
	public void testGetFileNumber() throws OutOfBoardRange {
		SpaceTwoDimensions coords = new SpaceTwoDimensions('e', 8);
		assertEquals(5, coords.getFileNumber());
	}

	@Test
	public void testEqualsCoords() throws OutOfBoardRange {
		SpaceTwoDimensions coordsFirst = new SpaceTwoDimensions('e', 8);
		SpaceTwoDimensions coordsSecond = new SpaceTwoDimensions('e', 8);
		assertTrue(coordsFirst.equals(coordsSecond));
	}
	
	@Test
	public void testNotEqualsCoords() throws OutOfBoardRange {
		SpaceTwoDimensions coordsFirst = new SpaceTwoDimensions('e', 8);
		SpaceTwoDimensions coordsSecond = new SpaceTwoDimensions('b', 2);
		assertFalse(coordsFirst.equals(coordsSecond));
	}

}
