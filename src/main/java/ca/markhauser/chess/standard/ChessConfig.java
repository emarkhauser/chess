package ca.markhauser.chess.standard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ca.markhauser.chess.Board;
import ca.markhauser.chess.BoardDataSource;
import ca.markhauser.chess.Chess;
import ca.markhauser.chess.Colour;
import ca.markhauser.chess.Move;
import ca.markhauser.chess.Piece;

@Configuration
public class ChessConfig {

	private static final int maxFiles = 8;
	private static final int maxRanks = 8;

	// Configuration of colours
	
	@Bean(name="white")
	public Colour white() {
		return new ColourStandard("white");
	}

	// Configuration of colours
	
	@Bean(name="black")
	public Colour black() {
		return new ColourStandard("black");
	}

	@Bean
	public Chess chess() {
		return new ChessStandard(board(), white(), black());
	}

	@Bean
	public Board board() {
		return new BoardStandard(maxFiles, maxRanks, boardData());
	}

	@Bean
	public BoardDataSource boardData() {
		BoardDataSource boardData = new BoardDataSourceStandard(maxFiles, maxRanks);

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

	
	
	// Configuration of moves
	
	@Bean(name="rankMove")
	@Scope("prototype")
	public Move rankMove(Boolean canJump, Boolean limitedDistance) {
		return new RankMove(canJump, limitedDistance);
	}
	
	@Bean(name="fileMove")
	@Scope("prototype")
	public Move fileMove(Boolean canJump, Boolean limitedDistance) {
		return new FileMove(canJump, limitedDistance);
	}
	
	@Bean(name="diagonalMove")
	@Scope("prototype")
	public Move diagonalMove(Boolean canJump, Boolean limitedDistance) {
		return new DiagonalMove(canJump, limitedDistance);
	}
	
	@Bean(name="knightMove")
	public Move knightMove() {
		return new KnightMove(true, false);
	}

	// Configuration of pieces

	@Bean
	@Scope("prototype")
	public Piece rook(Colour colour) {
		Piece rook = new PieceStandard("rook", colour);
		rook.addMove(rankMove(false, false));
		rook.addMove(fileMove(false, false));
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
		bishop.addMove(diagonalMove(false, false));
		return bishop;
	}

	@Bean
	@Scope("prototype")
	public Piece queen(Colour colour) {
		Piece queen = new PieceStandard("queen", colour);
		queen.addMove(diagonalMove(false, false));
		queen.addMove(rankMove(false, false));
		queen.addMove(fileMove(false, false));
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
