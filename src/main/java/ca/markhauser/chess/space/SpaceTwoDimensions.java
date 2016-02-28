package ca.markhauser.chess.space;

import ca.markhauser.chess.board.StandardBoard;
import ca.markhauser.chess.exception.OutOfBoardRange;

class SpaceTwoDimensions implements Space, Cloneable {

	private char file;
	private int rank;

	protected SpaceTwoDimensions(char file, int rank) throws OutOfBoardRange {
		this.file = file;
		this.rank = rank;

		if (!inRange())
			throw new OutOfBoardRange();
	}

	protected SpaceTwoDimensions(int file, int rank) {
		// TODO Auto-generated constructor stub
	}

	private boolean inRange() {
		return getFileNumber() <= StandardBoard.maxBoardFiles && getFileNumber() >= 1 && this.rank <= StandardBoard.maxBoardRanks
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

	public boolean equals(SpaceTwoDimensions coords) {
		return (coords.getFileNumber() == this.getFileNumber()) && (coords.getRank() == this.getRank());
	}

	public Object clone() {
		Object clone = null;

		try {
			clone = super.clone();

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return clone;
	}

}
