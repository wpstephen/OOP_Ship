import be.kuleuven.cs.som.annotate.*;

/**
 * A class of exceptions for signaling illegal durations with as
 * purpose to change the position of a ship. Each illegal duration
 * exception involves the illegal duration and the ship.
 * 
 * @version  2.0
 * @author   Taoufik Benyahia, Stephen Huang
 */
public class IllegalDurationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6441330422026580209L;

	/**
	 * Initialize this new illegal duration exception with given duration value.
	 * 
	 * @param  value
	 *         The value for this new illegal duration exception.
	 * @post   The value of this new illegal duration exception is equal
	 *         to the given value.
	 *       | new.getValue() == value
	 */
	public IllegalDurationException(double value) {
		this.value = value;
	}

	/**
	 * Return the value registered for this illegal duration exception.
	 */
	@Basic @Immutable
	public double getValue() {
		return this.value;
	}

	/**
	 * Variable registering the value involved in this illegal duration
	 * exception.
	 */
	private final double value;  // final???


}