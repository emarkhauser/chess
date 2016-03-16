package ca.markhauser.chess.standard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.Chess;
import ca.markhauser.chess.Colour;
import ca.markhauser.chess.Move;
import ca.markhauser.chess.Piece;

@Configuration
public class ChessConfig {

	private static final int maxFiles = 8;
	private static final int maxRanks = 8;

	@Bean
	public Chess chess() {
		return new ChessStandard(board());
	}

	@Bean
	public Board board() {
		return new BoardStandard(maxFiles, maxRanks, boardData());
	}

	@Bean
	public BoardData boardData() {
		BoardData boardData = new BoardData(maxFiles, maxRanks);

		// Reset board
		for (int i = 1; i <= maxFiles; i++) {
			for (int j = 1; j <= maxRanks; j++) {
				boardData.setPiece(i, j, null);
			}
		}

		// Set white non-pawns
		boardData.setPiece(1, 1, rook(white()));
		boardData.setPiece(2, 1, knight(white()));
		boardData.setPiece(3, 1, bishop(white()));
		boardData.setPiece(4, 1, queen(white()));
		boardData.setPiece(5, 1, king(white()));
		boardData.setPiece(6, 1, bishop(white()));
		boardData.setPiece(7, 1, knight(white()));
		boardData.setPiece(8, 1, rook(white()));

		// Set white pawns
		for (int i = 1; i <= maxFiles; i++) {
			boardData.setPiece(i, 2, pawn(white()));
		}

		// Set black non-pawns
		boardData.setPiece(1, 8, rook(black()));
		boardData.setPiece(2, 8, knight(black()));
		boardData.setPiece(3, 8, bishop(black()));
		boardData.setPiece(4, 8, queen(black()));
		boardData.setPiece(5, 8, king(black()));
		boardData.setPiece(6, 8, bishop(black()));
		boardData.setPiece(7, 8, knight(black()));
		boardData.setPiece(8, 8, rook(black()));

		// Set black pawns
		for (int i = 1; i <= maxFiles; i++) {
			boardData.setPiece(i, 7, pawn(black()));
		}

		return boardData;

	}

	// Configuration of colours

	@Bean(name="white")
	public Colour white() {
		return new White();
	}

	@Bean(name="black")
	public Colour black() {
		return new Black();
	}
	
	// Configuration of moves
	
	@Bean(name="rankMove")
	public Move rankMove() {
		return new RankMove();
	}
	
	@Bean(name="fileMove")
	public Move fileMove() {
		return new FileMove();
	}
	
	@Bean(name="diagonalMove")
	public Move diagonalMove() {
		return new DiagonalMove();
	}
	
	@Bean(name="knightMove")
	public Move knightMove() {
		return new KnightMove();
	}

	// Configuration of pieces

	@Bean
	@Scope("prototype")
	public Piece rook(Colour colour) {
		Piece rook = new PieceStandard("rook", colour);
		rook.addMove(rankMove());
		rook.addMove(fileMove());
		return rook;
	}

	@Bean
	@Scope("prototype")
	public Piece knight(Colour colour) {
		Piece knight = new PieceStandard("knight", colour);
		knight.addMove(knightMove());
		return knight;
	}

	@Bean
	@Scope("prototype")
	public Piece bishop(Colour colour) {
		Piece bishop = new PieceStandard("bishop", colour);
		bishop.addMove(diagonalMove());
		return bishop;
	}

	@Bean
	@Scope("prototype")
	public Piece queen(Colour colour) {
		Piece queen = new PieceStandard("queen", colour);
		queen.addMove(diagonalMove());
		queen.addMove(rankMove());
		queen.addMove(fileMove());
		return queen;
	}

	@Bean
	@Scope("prototype")
	public Piece king(Colour colour) {
		return new PieceStandard("king", colour);
	}

	@Bean
	@Scope("prototype")
	public Piece pawn(Colour colour) {
		return new PieceStandard("pawn", colour);
	}

}
