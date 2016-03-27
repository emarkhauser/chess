package ca.markhauser.chess.standard;

import java.util.HashSet;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Colour;
import ca.markhauser.chess.Move;
import ca.markhauser.chess.Piece;

public class PieceStandard implements Piece {

	private Colour colour;
	private String type;
	private HashSet<Move> moves = new HashSet<Move>();

	protected PieceStandard(String type, Colour colour) {
		this.type = type;
		this.colour = colour;
	}

	public String getType() {
		return this.type;
	}

	public Colour getColour() {
		return this.colour;
	}

	public Boolean validMovePattern(Board board, Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		for (Move move : moves) {
			if (move.isValidMove(board, sourceFile, sourceRank, destFile, destRank))
				return true;
		}
		return false;
	}

	@Override
	public void addMove(Move move) {
		moves.add(move);
	}

}
