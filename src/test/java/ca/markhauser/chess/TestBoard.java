package ca.markhauser.chess;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.markhauser.chess.application.ChessApplication;
import ca.markhauser.chess.board.Board;
import ca.markhauser.chess.board.BoardStandard;
import ca.markhauser.chess.exception.OutOfBoardRange;
import ca.markhauser.chess.piece.Piece;
import ca.markhauser.chess.space.Space;
import ca.markhauser.chess.space.SpaceFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ChessApplication.class)
public class TestBoard {

	@Test
	public void testGetPieceNotNull() throws OutOfBoardRange {
		Board board = new BoardStandard(8, 8);
		Piece piece = board.getPiece(SpaceFactory.getSpace(1, 1));
		assertNotNull(piece);
	}
	
	@Test
	public void testGetPieceNull() throws OutOfBoardRange {
		Board board = new BoardStandard(8, 8);
		Piece piece = board.getPiece(SpaceFactory.getSpace('d', 5));
		assertNull(piece);
	}

}
