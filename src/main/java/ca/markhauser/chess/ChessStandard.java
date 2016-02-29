/**
 * 
 */
package ca.markhauser.chess;

import ca.markhauser.chess.ChessStandard;
import ca.markhauser.chess.board.Board;
import ca.markhauser.chess.board.BoardStandard;
import ca.markhauser.chess.colour.Colour;
import ca.markhauser.chess.colour.ColourFactory;
import ca.markhauser.chess.exception.InvalidMove;
import ca.markhauser.chess.exception.NoPieceOnSpace;
import ca.markhauser.chess.exception.OutOfBoardRange;
import ca.markhauser.chess.exception.PieceNotMoved;
import ca.markhauser.chess.space.Space;

/**
 * @author Admin Account HP
 *
 */
public class ChessStandard implements Chess {

	private Board board;
	private Colour currentPlayerColour = ColourFactory.getColour("WHITE");
	private Colour winner = null;
	private boolean isCheck = false;
	private boolean isCheckmate = false;
	private final int maxFiles = 8;
	private final int maxRanks = 8;

	public ChessStandard() {
		this.board = new BoardStandard(maxFiles, maxRanks);
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#move(ca.markhauser.chess.space.Space, ca.markhauser.chess.space.Space)
	 */
	public void move(Space source, Space dest) {
		try {
			board.movePiece(source, dest);
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

	private void changeToNextPlayer() {
		this.currentPlayerColour = this.currentPlayerColour.getColour() == "WHITE" ? ColourFactory.getColour("BLACK")
				: ColourFactory.getColour("WHITE");
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#getCurrentPlayerColour()
	 */
	public Colour getCurrentPlayerColour() {
		return this.currentPlayerColour;
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#getBoard()
	 */
	public Board getBoard() {
		return this.board;
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#resign()
	 */
	public void resign() {
		this.winner = this.currentPlayerColour.getColour() == "WHITE" ? ColourFactory.getColour("BLACK") : ColourFactory.getColour("WHITE");
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#draw()
	 */
	public void draw() {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#isCheck()
	 */
	public boolean isCheck() {
		return this.isCheck;
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#isCheckmate()
	 */
	public boolean isCheckmate() {
		return this.isCheckmate;
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#getWinner()
	 */
	public Colour getWinner() {
		return this.winner;
	}

}
