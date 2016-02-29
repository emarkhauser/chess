package ca.markhauser.chess;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.markhauser.chess.exception.OutOfBoardRange;
import ca.markhauser.chess.space.Space;
import ca.markhauser.chess.space.SpaceFactory;

public class TestSpace {

	@Test
	public void testEqualsCoords() throws OutOfBoardRange {
		Space space1 = SpaceFactory.getSpace(5, 8);
		Space space2 = SpaceFactory.getSpace(5, 8);
		assertTrue(space1.equals(space2));
	}
	
	@Test
	public void testNotEqualsCoords() throws OutOfBoardRange {
		Space space1 = SpaceFactory.getSpace(5, 8);
		Space space2 = SpaceFactory.getSpace(2, 2);
		assertFalse(space1.equals(space2));
	}

}
