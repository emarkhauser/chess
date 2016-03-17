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

	@Autowired
	@Qualifier("black")
	private Colour black;

	@Autowired
	@Qualifier("white")
	private Colour white;

	private Colour currentPlayerColour = white;

	private Colour winner = null;
	private boolean isCheck = false;
	private boolean isCheckmate = false;

	public ChessStandard(Board board) {
		this.board = board;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#move(ca.markhauser.chess.space.Space,
	 * ca.markhauser.chess.space.Space)
	 */
	public void move(Integer sourceFile, Integer sourceRank, Integer destFile, Integer destRank) {
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
		changeToNextPlayer();
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
	 * @see ca.markhauser.chess.Chess#resign()
	 */
	public void resign() {
		this.winner = this.currentPlayerColour == white ? black : white;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.markhauser.chess.Chess#draw()
	 */
	public void draw() {
		// TODO Auto-generated method stub
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

}
