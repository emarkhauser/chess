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
	
}
