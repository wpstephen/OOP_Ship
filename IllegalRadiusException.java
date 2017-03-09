import be.kuleuven.cs.som.annotate.*;

/**
 * A class of exceptions signaling illegal radiuss of ships. 
 * 	Each illegal radius exception involves the illegal radius and the ship.
 * 
 * @version 1.0
 * @author Taoufik Benyahia, Stephen Huang
 *
 */
public class IllegalRadiusException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2648729365340616713L;

	/**
	 * Initialize this new illegal radius exception with the given
	 * radius and given ship.
	 * 
	 * @param 	radius
	 * 			The radius for this new illegal radius exception
	 * @param 	ship
	 * 			The ship for this new illegal radius exception
	 * @post 	The radius for this new illegal radius exception
	 * 			is equal to the given radius
	 * 			| new.getRadius() == radius			// moeten dit nog schrijven (getradius())
	 * @post 	The ship of this new illegal radius exception
	 * 			is the same as the given ship.
	 * 			| new.getShip() == ship
	 * @effect	This new illegal radius exception is further
	 * 			initialized as a new runtime exception involving
	 * 			no dianostic message and no cuase.
	 * 			| super()
	 */
	
	public IllegalRadiusException (double radius, Ship ship) {  
		
		this.radius = radius;
		this.ship = ship;
	}
	
	/**
	 * Return the radius of this illegal radius exception.
	 */
	
	@Basic @Raw @Immutable
	public double getRadius() {
		return radius;
	}
	
	/**
	 * Variable referencing the radius of this illegal radius exception.
	 */
	
	private final double radius;
	
	/**
	 * Return the ship of this illegal radius exception.
	 */
	@Basic @Raw
	public Ship getShip() {
		return ship;
	}
	
	/**
	 * Variable referencing the ship of this illegal radius exception
	 */
	private final Ship ship;
	

}
