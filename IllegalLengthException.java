import be.kuleuven.cs.som.annotate.*;

/**
 * 	A class of exceptions signaling illegal lengths of ships. 
 * 	Each illegal length exception involves the illegal length and the ship.
 * 
 * @version 1.0
 * @author Taoufik Benyahia, Stephen Huang
 *
 */
public class IllegalLengthException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5890784527486061662L;

	/**
	 * Initialize this new illegal length exception with the given
	 * length and given ship.
	 * 
	 * @param 	length
	 * 			The length for this new illegal length exception
	 * @param 	ship
	 * 			The ship for this new illegal length exception
	 * @post 	The length for this new illegal length exception
	 * 			is equal to the given length
	 * 			| new.getLength() == length			// moeten dit nog schrijven (getlength())
	 * @post 	The ship of this new illegal length exception
	 * 			is the same as the given ship.
	 * 			| new.getship() == ship
	 * @effect	This new illegal length exception is further
	 * 			initialized as a new runtime exception involving
	 * 			no dianostic message and no cuase.
	 * 			| super()
	 */
	
	public IllegalLengthException (long length, Ship ship) {  // Moet die Ship ship erbij??? Ik betwijfel het???
		
		this.length = length;
		this.ship = ship;
	}
	
	/**
	 * Return the length of this illegal length exception.
	 */
	
	@Basic @Raw @Immutable
	public long getLength() {
		return length;
	}
	
	/**
	 * Variable referencing the length of this illegal length exception.
	 */
	
	private final long length;
	
	/**
	 * Return the ship of this illegal length exception.
	 */
	@Basic @Raw
	public Ship getship() {
		return ship;
	}
	
	/**
	 * Variable referencing the ship of this illegal length exception
	 */
	private final Ship ship;
	

}
