/**
 * 
 */
package ca.markhauser.chess;

import ca.markhauser.chess.Chess;
import ca.markhauser.chess.colour.Colour;
import ca.markhauser.chess.colour.ColourFactory;
import ca.markhauser.chess.exception.InvalidMove;
import ca.markhauser.chess.exception.NoPieceOnSpace;
import ca.markhauser.chess.exception.PieceNotMoved;
import ca.markhauser.chess.space.Space;

/**
 * @author Admin Account HP
 *
 */
public class Chess {

	private Board board;
	private Colour currentPlayerColour = ColourFactory.getColour("WHITE");
	private Colour winner = null;
	private boolean isCheck = false;
	private boolean isCheckmate = false;

	public Chess() {
		this.board = new Board();
	}

	public void move(Space source, Space dest) {
		try {
			board.movePiece(source, dest);
		} catch (InvalidMove e) {
			e.printStackTrace();
		} catch (NoPieceOnSpace e) {
			e.printStackTrace();
		} catch (PieceNotMoved e) {
			e.printStackTrace();
		}
		changeToNextPlayer();
	}

	private void changeToNextPlayer() {
		this.currentPlayerColour = this.currentPlayerColour.getColour() == "WHITE" ? ColourFactory.getColour("BLACK")
				: ColourFactory.getColour("WHITE");
	}

	public Colour getCurrentPlayerColour() {
		return this.currentPlayerColour;
	}

	public Board getBoard() {
		return this.board;
	}

	public void resign() {
		this.winner = this.currentPlayerColour.getColour() == "WHITE" ? ColourFactory.getColour("BLACK") : ColourFactory.getColour("WHITE");
	}

	public void draw() {
		// TODO Auto-generated method stub
	}

	public boolean isCheck() {
		return this.isCheck;
	}

	public boolean isCheckmate() {
		return this.isCheckmate;
	}

	public Colour getWinner() {
		return this.winner;
	}

}
