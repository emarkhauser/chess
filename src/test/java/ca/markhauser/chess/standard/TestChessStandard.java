package ca.markhauser.chess.standard;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Chess;
import ca.markhauser.chess.Coords;
import ca.markhauser.chess.MoveResult;
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
	
	@Test
	public void testMovePawn() {
		Chess chess = new ChessStandard();
		Coords source = new CoordsStandard('a', 2);
		Coords dest = new CoordsStandard('a', 3);
		chess.move(new MoveStandard(source, dest));
		assertEquals(MoveResult.MOVED, chess.getBoard().getPiece(dest));
		assertEquals(PieceType.PAWN, chess.getBoard().getPiece(dest));
		assertNull(chess.getBoard().getPiece(source));
	}
	
}
