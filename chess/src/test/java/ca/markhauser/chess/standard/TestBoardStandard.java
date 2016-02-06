package ca.markhauser.chess.standard;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Piece;
import ca.markhauser.chess.PieceColour;
import ca.markhauser.chess.PieceType;
import ca.markhauser.chess.application.ChessApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ChessApplication.class)
public class TestBoardStandard {

	@Test
	public void testGetPiece() {
		Board board = new BoardStandard(8,8);
		Piece piece = board.getPiece(new CoordsStandard('a',1));
		assertEquals(PieceType.ROOK, piece.getType());
		assertEquals(PieceColour.WHITE, piece.getColour());
	}

}
