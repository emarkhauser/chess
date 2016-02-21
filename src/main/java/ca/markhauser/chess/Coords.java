package ca.markhauser.chess;

import ca.markhauser.chess.exception.OutOfBoardRange;

public class Coords {

	private char file;
	private int rank;

	public Coords(char file, int rank) throws OutOfBoardRange {
		this.file = file;
		this.rank = rank;

		if (!inRange())
			throw new OutOfBoardRange();
	}

	private boolean inRange() {
		return getFileNumber() <= Board.maxBoardFiles && getFileNumber() >= 1 && this.rank <= Board.maxBoardRanks
				&& rank >= 1;
	}

	public char getFile() {
		return this.file;
	}

	public int getRank() {
		return this.rank;
	}

	public int getFileNumber() {
		switch (file) {
		case 'a':
			return 1;
		case 'b':
			return 2;
		case 'c':
			return 3;
		case 'd':
			return 4;
		case 'e':
			return 5;
		case 'f':
			return 6;
		case 'g':
			return 7;
		case 'h':
			return 8;
		}
		return 0;
	}

	public boolean equals(Coords coords) {
		return (coords.getFileNumber() == this.getFileNumber()) && (coords.getRank() == this.getRank());
	}

}
