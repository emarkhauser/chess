/**
 * 
 */
package ca.markhauser.chess.standard;

/**
 * @author Admin Account HP
 *
 */
public class ChessUtilities {

	static int fileToNumber(char file) {
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
