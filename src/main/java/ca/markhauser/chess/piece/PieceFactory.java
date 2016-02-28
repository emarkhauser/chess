/**
 * 
 */
package ca.markhauser.chess.piece;

import ca.markhauser.chess.colour.Colour;

/**
 * @author Admin Account HP
 *
 */
public class PieceFactory {

	public static Piece getPiece(String type, Colour colour) {

		if (type == null) {
			return null;
		}
		if (colour == null) {
			return null;
		}
		if (type.equalsIgnoreCase("BISHOP")) {
			return new Bishop(colour);
		} else if (type.equalsIgnoreCase("KING")) {
			return new King(colour);
		} else if (type.equalsIgnoreCase("PAWN")) {
			return new Pawn(colour);
		} else if (type.equalsIgnoreCase("QUEEN")) {
			return new Queen(colour);
		} else if (type.equalsIgnoreCase("ROOK")) {
			return new Rook(colour);
		} else if (type.equalsIgnoreCase("KNIGHT")) {
			return new Knight(colour);
		}

		return null;
	}

}
