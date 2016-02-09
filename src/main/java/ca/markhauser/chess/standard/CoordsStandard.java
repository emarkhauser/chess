package ca.markhauser.chess.standard;

import ca.markhauser.chess.Coords;

public class CoordsStandard implements Coords {

	private char file;
	private int rank;

	public CoordsStandard(char file, int rank) {
		this.file = file;
		this.rank = rank;
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
	
}
