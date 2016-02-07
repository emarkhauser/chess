package ca.markhauser.chess.standard;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Chess;
import ca.markhauser.chess.Piece;
import ca.markhauser.chess.PieceColour;
import ca.markhauser.chess.PieceType;
import ca.markhauser.chess.Winner;

public class TestChessStandard {

	@Test
	public void testNewGameAndBoard() {
		Chess chess = new ChessStandard();
		Board board = chess.getBoard();
		Piece piece = board.getPiece(new CoordsStandard('e', 8));
		assertEquals(PieceType.KING, piece.getType());
		assertEquals(PieceColour.BLACK, piece.getColour());
	}
	
	@Test
	public void testResign() {
		Chess chess = new ChessStandard();
		chess.resign();
		assertEquals(Winner.BLACK, chess.getWinner());
	}
	
}
