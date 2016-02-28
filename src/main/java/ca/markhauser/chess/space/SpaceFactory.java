/**
 * 
 */
package ca.markhauser.chess.space;

import java.util.HashSet;

/**
 * @author Admin Account HP
 *
 */
public class SpaceFactory {
	
	private static HashSet<Space> spaceSet  = new HashSet<Space>();

	public static Space getSpace(int file, int rank) {
		if (file == 0) {
			return null;
		}
		if (rank == 0) {
			return null;
		}
		
		for (Space space: spaceSet) {
			if (space.getFileNumber() == file && space.getRank() == rank) {
				return space;
			}
		}
		
		spaceSet.add(new SpaceTwoDimensions(file, rank));
		return null;
		
	}
	
}
