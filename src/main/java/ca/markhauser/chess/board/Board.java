/**
 * 
 */
package ca.markhauser.chess.board;

import ca.markhauser.chess.exception.InvalidMove;
import ca.markhauser.chess.exception.NoPieceOnSpace;
import ca.markhauser.chess.exception.OutOfBoardRange;
import ca.markhauser.chess.exception.PieceNotMoved;
import ca.markhauser.chess.piece.Piece;
import ca.markhauser.chess.space.Space;

/**
 * @author Admin Account HP
 *
 */
public interface Board {

	void setPiece(Piece piece, Space space) throws OutOfBoardRange;
	Piece getPiece(Space space);
	void setup() throws OutOfBoardRange;
	void movePiece(Space source, Space dest) throws InvalidMove, NoPieceOnSpace, PieceNotMoved, OutOfBoardRange;
	
}
