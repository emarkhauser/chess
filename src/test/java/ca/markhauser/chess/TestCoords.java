package ca.markhauser.chess;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.markhauser.chess.exception.OutOfBoardRange;

public class TestCoords {

	@Test(expected = OutOfBoardRange.class)
	public void testCoordsOutOfRange() throws OutOfBoardRange {
		Coords coords = new Coords('a', 10);
	}
	
	@Test
	public void testCoordsInRange() throws OutOfBoardRange {
		Coords coords = new Coords('e', 5);
	}

	@Test
	public void testGetFileNumber() throws OutOfBoardRange {
		Coords coords = new Coords('e', 8);
		assertEquals(5, coords.getFileNumber());
	}

	@Test
	public void testEqualsCoords() throws OutOfBoardRange {
		Coords coordsFirst = new Coords('e', 8);
		Coords coordsSecond = new Coords('e', 8);
		assertTrue(coordsFirst.equals(coordsSecond));
	}
	
	@Test
	public void testNotEqualsCoords() throws OutOfBoardRange {
		Coords coordsFirst = new Coords('e', 8);
		Coords coordsSecond = new Coords('b', 2);
		assertFalse(coordsFirst.equals(coordsSecond));
	}

}
