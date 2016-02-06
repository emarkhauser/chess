package ca.markhauser.chess;

/**
 * @author Erik Markhauser
 *
 */
public interface Chess {
	
	/**
	 * Setup new game with board and winners refreshed.
	 */
	void newGame();
	
	/**
	 * Pass move for processing.  Returns result if legal or illegal move made.
	 */
	MoveResult makeMove(Move move);
	
	/**
	 * Get colour of the current player
	 */
	PieceColour getCurrentPlayerColour();
	
	/**
	 * Get current board layout
	 */
	Board getBoard();
	
	/**
	 * Current player resigns.
	 */
	void resign();
	
	/**
	 * Current player draws.  If other player then draws as well, the game end in a draw.
	 */
	void draw();
	
	/**
	 * Determines if player is in check
	 */
	boolean isCheck();
	
	/**
	 * Determines if there is a checkmate
	 */
	boolean isCheckmate();
	
	/**
	 * Returns the winner or a draw
	 */
	Winner getWinner();
}
