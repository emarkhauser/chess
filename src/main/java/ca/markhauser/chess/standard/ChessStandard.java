/**
 * 
 */
package ca.markhauser.chess.standard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Chess;
import ca.markhauser.chess.Colour;
import ca.markhauser.chess.InvalidMove;
import ca.markhauser.chess.NoPieceOnSpace;
import ca.markhauser.chess.OutOfBoardRange;
import ca.markhauser.chess.PieceNotMoved;

/**
 * @author Admin Account HP
 *
 */
public class ChessStandard implements Chess {

	private Board board;
	private Colour white;
	private Colour black;
	private Colour currentPlayerColour;
	private Colour winner = null;
	private Boolean isCheck = false;
	private Boolean isCheckmate = false;
	private Boolean isDraw = false;
	private Boolean drawCalled = false;
	private Boolean isResign = false;

	public ChessStandard(Board board, Colour white, Colour black) {
		this.board = board;
		this.white = white;
		this.black = black;
		this.currentPlayerColour = white;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#getCurrentPlayerColour()
	 */
	public Colour getCurrentPlayerColour() {
		return this.currentPlayerColour;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#getBoard()
	 */
	public Board getBoard() {
		return this.board;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#move(ca.markhauser.chess.space.Space,
	 * ca.markhauser.chess.space.Space)
	 */
	public void move(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
		if (!gameOver()) {
			try {
				board.movePiece(sourceFile, sourceRank, destFile, destRank);
			} catch (InvalidMove e) {
				e.printStackTrace();
			} catch (NoPieceOnSpace e) {
				e.printStackTrace();
			} catch (PieceNotMoved e) {
				e.printStackTrace();
			} catch (OutOfBoardRange e) {
				e.printStackTrace();
			}
			this.drawCalled = false;
			changeToNextPlayer();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#resign()
	 */
	public void resign() {
		if (!gameOver()) {
			this.winner = this.currentPlayerColour == white ? black : white;
			this.isResign = true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#draw()
	 */
	public void draw() {
		if (!gameOver()) {
			if (this.drawCalled) {
				this.isDraw = true;
			} else {
				this.drawCalled = true;
				changeToNextPlayer();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#isCheck()
	 */
	public boolean isCheck() {
		return this.isCheck;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#isCheckmate()
	 */
	public boolean isCheckmate() {
		return this.isCheckmate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#getWinner()
	 */
	public Colour getWinner() {
		return this.winner;
	}

	private void changeToNextPlayer() {
		this.currentPlayerColour = this.currentPlayerColour == white ? black : white;
	}

	private Boolean gameOver() {
		return this.isCheckmate || this.isDraw || this.isResign;
	}

}
