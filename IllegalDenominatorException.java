import be.kuleuven.cs.som.annotate.*;

/**
 * A class for signaling illegal denominators for rational numbers.
 * 
 * @version  	1.0
 * @author   	Taoufik Benyahia, Stephen Huang
 * @note		This class is based on the class written during
 * 				a class of OOP of Eric Steegmans.
 */
public class IllegalDenominatorException extends Exception {
    
	
	
    /**
     * Initialize this new illegal denominator exception with given value.
     * 
     * @param   value
     *          The value for the new illegal denominator exception.
     * @post    The value of the new illegal denominator exception is set
     *          to the given value.
     *          | new.getValue() == value
     */
    public IllegalDenominatorException(double value) {
        this.value = value;
    }
    
    /**
     * Return the value registered for this illegal denominator exception.
     */
    @Basic @Immutable
    public double getValue() {
        return this.value;
    }
    
    /**
     * Variable registering the value involved in this illegal denominator
     * exception.
     */
    private final double value;

    /**
     * The Java API strongly recommends to explicitly define a version
     * number for classes that implement the interface Serializable.
     * At this stage, that aspect is of no concern to us. 
     */
    private static final long serialVersionUID = 2003001L;
    
}