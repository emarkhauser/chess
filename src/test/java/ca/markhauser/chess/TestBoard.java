package ca.markhauser.chess;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Coords;
import ca.markhauser.chess.application.ChessApplication;
import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.exception.OutOfBoardRange;
import ca.markhauser.chess.piece.Piece;
import ca.markhauser.chess.piece.Rook;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ChessApplication.class)
public class TestBoard {

	@Test
	public void testGetPieceNotNull() throws OutOfBoardRange {
		Board board = new Board();
		Coords coords = new Coords('a', 1);
		board.setPiece(new Rook(PieceColour.WHITE), coords);
		Piece piece = board.getPiece(coords);
		assertNotNull(piece);
	}
	
	@Test
	public void testGetPieceNull() throws OutOfBoardRange {
		Board board = new Board();
		Piece piece = board.getPiece(new Coords('d', 5));
		assertNull(piece);
	}

}