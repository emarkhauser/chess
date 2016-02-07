/**
 * 
 */
package ca.markhauser.chess.standard;

import ca.markhauser.chess.Coords;
import ca.markhauser.chess.Move;

/**
 * @author Admin Account HP
 *
 */
public class MoveStandard implements Move {
	
	private Coords source;
	private Coords dest;

	public MoveStandard(Coords source, Coords dest) {
		this.source = source;
		this.dest = dest;
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Move#getSourceCoords()
	 */
	@Override
	public Coords getSourceCoords() {
		return this.source;
	}

	/* (non-Javadoc)
	 * @see ca.markhauser.chess.Move#getDestCoords()
	 */
	@Override
	public Coords getDestCoords() {
		return this.dest;
	}

}
