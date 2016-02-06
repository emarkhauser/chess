package ca.markhauser.chess.standard;

import ca.markhauser.chess.Coords;

public class CoordsStandard implements Coords {

	private int file;
	private int rank;

	public CoordsStandard(int file, int rank) {
		this.file = file;
		this.rank = rank;
	}

	public int getFile() {
		return file;
	}

	public int getRank() {
		return rank;
	}
	
	
}
