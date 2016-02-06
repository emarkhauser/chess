/**
 * 
 */
package ca.markhauser.chess.standard;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Chess;
import ca.markhauser.chess.Move;
import ca.markhauser.chess.MoveResult;
import ca.markhauser.chess.PieceColour;
import ca.markhauser.chess.Winner;

/**
 * @author Admin Account HP
 *
 */
public class ChessStandard implements Chess {
	
	private Board board;
	final static int maxBoardFiles = 8;
	final static int maxBoardRanks = 8;

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#newGame()
	 */
	@Override
	public void newGame() {
		board = new BoardStandard(maxBoardFiles, maxBoardRanks);
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#makeMove(ca.markhauser.chess.Move)
	 */
	@Override
	public MoveResult makeMove(Move move) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#getCurrentPlayerColour()
	 */
	@Override
	public PieceColour getCurrentPlayerColour() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#getBoard()
	 */
	@Override
	public Board getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#resign()
	 */
	@Override
	public void resign() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#draw()
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#isCheck()
	 */
	@Override
	public boolean isCheck() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#isCheckmate()
	 */
	@Override
	public boolean isCheckmate() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Chess#getWinner()
	 */
	@Override
	public Winner getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

}
