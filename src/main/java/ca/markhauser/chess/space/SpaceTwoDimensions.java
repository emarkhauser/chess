package ca.markhauser.chess.space;

class SpaceTwoDimensions implements Space, Cloneable {
	
	private int file;
	private int rank;

	protected SpaceTwoDimensions(int file, int rank) {
		this.file = file;
		this.rank = rank;
	}

	public int getFile() {
		return this.file;
	}

	public int getRank() {
		return this.rank;
	}

	public boolean equals(Space space) {
		return (space.getFile() == this.getFile()) && (space.getRank() == this.getRank());
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
