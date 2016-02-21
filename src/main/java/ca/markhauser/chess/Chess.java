/**
 * 
 */
package ca.markhauser.chess;

import ca.markhauser.chess.Chess;
import ca.markhauser.chess.enums.PieceColour;
import ca.markhauser.chess.enums.Winner;
import ca.markhauser.chess.exception.InvalidMove;
import ca.markhauser.chess.exception.NoPieceOnSpace;
import ca.markhauser.chess.exception.PieceNotMoved;

/**
 * @author Admin Account HP
 *
 */
public class Chess {

	private Board board;
	private PieceColour currentPlayerColour = PieceColour.WHITE;
	private Winner winner = Winner.NOTDONE;
	private boolean isCheck = false;
	private boolean isCheckmate = false;

	public Chess() {
		this.board = new Board();
	}

	public void move(Coords source, Coords dest) {
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
		this.currentPlayerColour = this.currentPlayerColour == PieceColour.WHITE ? PieceColour.BLACK
				: PieceColour.WHITE;
	}

	public PieceColour getCurrentPlayerColour() {
		return this.currentPlayerColour;
	}

	public Board getBoard() {
		return this.board;
	}

	public void resign() {
		this.winner = this.currentPlayerColour == PieceColour.WHITE ? Winner.BLACK : Winner.WHITE;
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

	public Winner getWinner() {
		return this.winner;
	}

}
