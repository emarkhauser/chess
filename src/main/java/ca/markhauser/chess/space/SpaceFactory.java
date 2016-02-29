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
			if (space.getFile() == file && space.getRank() == rank) {
				return space;
			}
		}
		
		Space newSpace = new SpaceTwoDimensions(file, rank);
		
		spaceSet.add(newSpace);
		return newSpace;
		
	}
	
}
