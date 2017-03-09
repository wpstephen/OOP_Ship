import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;

/**
 * 	A class of exceptions signaling illegal value for the position of ships. 
 * 	Each illegal value exception involves either both or one illegal value
 * 	of x-coordinate and y-coordinaten of the ship.
 * 
 * @version 1.0
 * @author Taoufik Benyahia, Stephen Huang
 *
 */
public class IllegalValueException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5409001871550150625L;

	/**
	 * 
	 */

	/**
	 * Initialize this new illegal value exception with the given
	 * x-coordinate and given y-coordinate of the position this ship.
	 * 
	 * @param 	xposition
	 * 			The x-coordinate of the position for this new illegal value exception.
	 * @param 	yposition
	 * 			The y-coordinate of the position for this new illegal value exception.
	 * @post 	The x-coordinate of the position for this new illegal value exception
	 * 			is equal to the x-coordinate.
	 * 			| new.getPositionX() == xposition			
	 * @post 	The y-coordinate of the position for this new illegal value exception
	 * 			is equal to the y-coordinate.
	 * 			| new.getPositionY() == yposition
	 * @effect	This new illegal value exception is further
	 * 			initialized as a new runtime exception involving
	 * 			no dianostic message and no cuase.
	 * 			| super()
	 */
	
	public IllegalValueException (double xposition, double yposition) {  
		
		this.xposition = xposition;
		this.yposition = yposition;
	}
	
	/**
	 * Return the x-coordinate of the position of this illegal value exception.
	 */
	
	@Basic @Raw 
	public double getPositionX() {
		return xposition;
	}
	
	/**
	 * Variable referencing the x-coordinate of the position of this illegal value exception.
	 */
	
	private final double xposition;
	
	/**
	 * Return the y-coordinate of the position of this illegal value exception.
	 */
	@Basic @Raw
	public double getPositionY() {
		return yposition;
	}
	
	/**
	 * Variable referencing the y-coordinate of the position of this illegal value exception.
	 */
	private final double yposition;
	

}
