/**
 * 
 */
package ca.markhauser.chess.standard;

import ca.markhauser.chess.Colour;

/**
 * @author Admin Account HP
 *
 */
public class ColourStandard implements Colour {
	
	String colour;
	
	public ColourStandard(String colour) {
		this.colour = colour;
	}

	public String getColour() {
		return colour;
	}

}
