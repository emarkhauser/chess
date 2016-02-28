/**
 * 
 */
package ca.markhauser.chess.colour;

/**
 * @author Admin Account HP
 *
 */
public class ColourFactory {

	public static Colour getColour(String colour) {
		if (colour == null) {
			return null;
		}
		
		if (colour.equalsIgnoreCase("WHITE")) {
			return new White();
		} else if (colour.equalsIgnoreCase("BLACK")) {
			return new Black();
		}

		return null;

	}

}
