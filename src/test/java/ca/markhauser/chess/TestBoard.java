package ca.markhauser.chess;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.markhauser.chess.application.ChessApplication;
import ca.markhauser.chess.board.StandardBoard;
import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.exception.OutOfBoardRange;
import ca.markhauser.chess.piece.Piece;
import ca.markhauser.chess.piece.Rook;
import ca.markhauser.chess.space.SpaceTwoDimensions;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ChessApplication.class)
public class TestBoard {

	@Test
	public void testGetPieceNotNull() throws OutOfBoardRange {
		StandardBoard board = new StandardBoard();
		SpaceTwoDimensions coords = new SpaceTwoDimensions('a', 1);
		board.setPiece(new Rook(PieceColour.WHITE), coords);
		Piece piece = board.getPiece(coords);
		assertNotNull(piece);
	}
	
	@Test
	public void testGetPieceNull() throws OutOfBoardRange {
		StandardBoard board = new StandardBoard();
		Piece piece = board.getPiece(new SpaceTwoDimensions('d', 5));
		assertNull(piece);
	}

}
