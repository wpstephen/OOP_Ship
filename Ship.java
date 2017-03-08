import be.kuleuven.cs.som.annotate.*;

/**
 * A class of ships involving its position, velocity, orientation and radius. 
 * 
 * @invar 	The position of each ship must be a valid position.
 * 			| isValidPosition(getPositionX()) && isValidPosition(getPositionY())
 * @invar 	The velocity of each ship must be a valid velocity.
 * 			| isValidVelocity(getVelocityX()) && isValidVelocity(getVelocityY())
 * @invar	The velocity along the X-axis and Y-axis must
 * 			be less than or equal to the maximum velocity.
 * 			| getVelocityX() <= MAXIMUM_VELOCITY && getVelocityY() <= MAXIMUM_VELOCITY
 * @invar	The magnitude of velocity must always be a non-negative value.
 * 			| getMagnitudeVelocity() >= MINIMUM_VELOCITY
 * @invar 	The orientation of each ship must always be a value
 * 			in between 0 and 2*PI.
 * 			| 0 <= getOrientation() <= 2*Math.PI 
 * @invar	The orientation of each ship must always be expressed
 * 			in radians.
 * @invar	The radius of each ship must always be a value larger than the minimum radius.
 * 			| getRadius() >= MINIMUM_RADIUS
 * @invar	The minimum radius must always be positive
 * 			| MINIMUM_RADIUS >= 0
 * 
 * @version	1.1
 * 
 * @author	Taoufik Benyahia, Stephen Huang
 */
@Value
public class Ship {
	
	/**
	 * Initialize this new ship with given position, given velocity,
	 * given orientation and given radius.
	 * 
	 * @param 	xposition
	 * 			The X-coordinate of the position for this new ship.
	 * @param 	yposition
	 * 			The Y-coordinate of the position for this new ship.
	 * @param 	xvelocity
	 * 			The X-coordinate of the velocity for this new ship.
	 * @param 	yvelocity
	 * 			The Y-coordinate of the velocity for this new ship.
	 * @param 	orientation
	 * 			The orientation for this new ship.
	 * @param 	radius
	 * 			The radius for this new ship.
	 * @pre		The given orientation must be a valid
	 * 			orientation for a ship.
	 * 			| isValidOrientation(getOrientation())
	 * @post	The orientation of this ship is equal
	 * 			to the given orientation.
	 * 			| new.getOrientation() == orientation
	 * @post	The velocity along the X-axis of this ship is equal 
	 * 			to the given X-coordinate of the velocity.
	 * 			| new.getVelocityX() == xvelocity
	 * @post	The velocity along the Y-axis of this ship is equal 
	 * 			to the given Y-coordinate of the velocity.
	 * 			| new.getVelocityY() == yvelocity
	 * @post	The x-coordinate of the position of this ship is equal
	 * 			to the given x-coordinate of the position.
	 * 			| new.getPositionX() == xposition
	 * @post	The y-coordinate of the position of this ship is equal
	 * 			to the given y-coordinate of the position.
	 * 			| new.getPositionY() == yposition
	 * @post	The radius of this ship is equal
	 * 			to the given radius.
	 * 			| new.getRadius() == radius
	 * @throws 	IllegalRadiusException 
	 * 			The given radius is not a valid radius for a ship.
	 * 			| ! isValidRadius(radius)
	 */
	public Ship (double xposition, double yposition , double xvelocity, double yvelocity, double orientation, double radius) throws IllegalLengthException, IllegalRadiusException, NullPointerException {
        assert isValidOrientation(orientation);
		setOrientation(orientation);
		if (isValidVelocity(xvelocity, yvelocity))
			setVelocity(xvelocity, yvelocity);
//		if (! isValidPosition(xposition,yposition))
//			throw new IllegalLengthException(position.length, this);
//		if (! canHaveAsPosition(position))
//			throw new NullPointerException();
		setPosition(xposition,yposition);
		if (! isValidRadius(radius))
			throw new IllegalRadiusException(radius,this);
		setRadius(radius);
		
	}
	

//	/**
//	 * Check whether the given position is a valid position
//	 * for any ship.
//	 * @param 	position
//	 * 			The position to check.
//	 * @return	True if and only if the given position //? null
//	 * 			 has a X-coordinate and Y-coordinate.
//	 * 			| result == (position.length == 2)
//	 * 
//	 */
//	
//	public static boolean isValidPosition(double [] position){   	
//		return (position.length == 2);
//			
//	}
//	
//	/**
//	 * Return a boolean reflecting whether this ship can
//	 * accept the given position as position.
//	 * 
//	 * @param 	position
//	 * 			The position to be checked.
//	 * @return	True if and only if the given position is effective
//	 * 			and if the length of the position array is equal to 2.
//	 * 			| result == ( (position != null)
//	 * 			|	 && (isValidPosition(position) )
//	 */
//	@Raw
//	
//	public boolean canHaveAsPosition(double xposition, double yposition) { 
//		return ( (position != null) && isValidPosition(position) );
//		
//	}
	

	
	/**
	 * Return the X-coordinate of the current position of the ship.
	 */
	@Basic
	
	public double getPositionX() {
		return this.xposition;
	}

	
	/**
	 * Return the Y-coordinate of the current position of the ship.
	 */
	@Basic
	public double getPositionY() {
		return this.yposition;
	}
	
	/**
	 * Set the current position of this ship to the given position.
	 * 
	 * @param 	xposition
	 * 			The new X-coordinate of position for this ship.	
	 * @param 	yposition
	 * 			The new Y-coordinate of position for this ship.
	 * @post	The new X-coordinate of position for this ship is equal
	 * 			to the given X-coordinate of position.
	 * 			| new.getPositionX() == xposition
	 * @post	The new Y-coordinate of position for this ship is equal
	 * 			to the given Y-coordinate of position.
	 * 			| new.getPositionY() == yposition
	 */
	
	public void setPosition(double xposition, double yposition) {  // exceptions?

		this.xposition = xposition;
		this.yposition = yposition;
	}
	
	/**
	 * Variable registering the X-coordinate of the position for this ship.
	 */
	
	private double xposition;
	
	/**
	 * Variable registering the Y-coordinate of the position for this ship.
	 */
	
	private double yposition;
	
	
	/**
	 * Return the X-coordinate of the current velocity of this ship.
	 */
	@Basic
	
	public double getVelocityX() {
		return this.xvelocity;
	}
	
	/**
	 * Return the Y-coordinate of the current velocity of this ship.
	 */
	@Basic
	
	public double getVelocityY() {
		return this.yvelocity;
	} 
	
	/**
	 * Calculate the magnitude of the velocity of this ship using 
	 * the given X-coordinate and Y-coordinate of the velocity.
	 * 
	 * @param 	xvelocity
	 * 			The  X-coordinate of the velocity from which the magnitude will
	 * 			be calculated.
	 * @param 	yvelocity
	 * 			The  Y-coordinate of the velocity from which the magnitude will
	 * 			be calculated.
	 * @return	The magnitude of the velocity is equal to
	 * 			the square root of the sum of the power of X-coordinate of the velocity
	 * 			and the power of Y-coordinate of the velocity.
	 * 			| result == (Math.sqrt(Math.pow(xvelocity, 2.0) + 
	 * 			|	Math.pow(yvelocity,2.0)))
	 */
	public static double getMagnitudeVelocity(double xvelocity, double yvelocity) {  
	
		return (Math.sqrt(Math.pow(xvelocity, 2.0) + Math.pow(yvelocity,2.0)));
		
	}
	
	/**
	 * Variable registering the X-coordinate of the velocity for this ship.
	 */
	
	private double xvelocity;
	
	/**
	 * Variable registering the Y-coordinate of the velocity for this ship.
	 */
	
	private double yvelocity;
	
	/**
	 * Set the current velocity of this ship to the given velocity.
	 * 
	 * @param	xvelocity  
	 * 			The X-coordinate of the new velocity for this ship.
	 * @param 	yvelocity
	 * 			The Y-coordinate of the new velocity for this ship.
	 * @post	If the given velocity is valid,
	 * 			then the new X-coordinate and Y-coordinate of the velocity 
	 * 			for this ship is equal to the given X-coordinate and Y-coordinate
	 * 			of the velocity.
	 * 			| if ( isValidVelocity(velocity) )
	 * 			|	then ( new.getVelocityX() = xvelocity
	 * 					&& new.getVelocityY() = yvelocity )
	 */
	
	public void setVelocity(double xvelocity, double yvelocity) {
		if (isValidVelocity(xvelocity,yvelocity))
			this.xvelocity = xvelocity;
			this.yvelocity = yvelocity;
	}
	
	/**
	 * Check whether the given velocity is a valid velocity
	 * for any ship.
	 * 
	 * @param 	xvelocity
	 * 			The X-coordinate of the velocity to check.
	 * @param 	yvelocity
	 * 			The Y-coordinate of the velocity to check.
	 * @return	True if and only if the magnitude of the given 
	 * 			velocity is not below the minimum velocity and 
	 * 			not above the maximum velocity.
	 * 			| result == ( (getMagnitudeVelocity(xvelocity, yvelocity) >= MINIMUM_VELOCITY) 
	 * 			|	&& (getMagnitudeVelocity(xvelocity, yvelocity) <= MAXIMUM_VELOCITY) )
	 */
	
	public static boolean isValidVelocity(double xvelocity, double yvelocity) { 
		return ((getMagnitudeVelocity(xvelocity, yvelocity) >= MINIMUM_VELOCITY) 
					&& (getMagnitudeVelocity(xvelocity, yvelocity) <= MAXIMUM_VELOCITY));
	}
	

	
	/**
	 * Variable referencing the orientation of this ship
	 */
	
	private double orientation;
	
	/**
	 * Return the current orientation of this ship.
	 */
	@Basic
	
	public double getOrientation() {
		
		return this.orientation;
	}
	
	/**
	 * Set the orientation of this ship to the given orientation.
	 * 
	 * @param 	orientation
	 * 			The new orientation for this ship
	 * @pre		The given orientation must be a valid
	 * 			orientation for a ship.
	 * 			| isValidOrientation(getOrientation())
	 * @post	The orientation of this ship is equal
	 * 			to the given orientation.
	 * 			| new.getOrientation() == orientation
	 */	
	
	public void setOrientation(double orientation) {
		
		assert isValidOrientation(orientation);
		this.orientation = orientation;
	}
	
	/**
	 * Check whether the given orientation is a valid orientation 
	 * for any ship.
	 * 
	 * @param 	orientation
	 * 			The orientation to check.
	 * @return True if and only if the given orientation is not
     *         below the minimum orientation and does not exceed
     *         the maximum orientation.
     *       | result ==
     *       |   ( (orientation >= MINIMUM_ORIENTATION)
     *       |		 && (orientation <= MAXIMUM_ORIENTATION)	)
	 */
	public static boolean isValidOrientation(double orientation) {
		
		return ((MINIMUM_ORIENTATION <= orientation) && (MAXIMUM_ORIENTATION >= orientation));
	}
	
	/**
	 * Variable referencing the current radius of this ship.
	 */
	private double radius;
	
	/**
	 * Return the current radius of this ship
	 */
	@Basic
	
	public double getRadius() {
		return this.radius;
	}
	
	/**
	 * Set the current radius of this ship to the given radius.
	 * 
	 * @param 	radius
	 * 			The new radius for this ship.
	 * @post	The new radius for this ship is equal to the
	 * 			given radius.	
	 * 			| new.getRadius() == radius
	 * @throws 	IllegalRadiusException(radius,this)
	 * 			This ship cannot have the given radius as 
	 * 			its radius.
	 * 			| ! isValidRadius(radius)
	 */
	
	public void setRadius(double radius) throws IllegalRadiusException {
		if (! isValidRadius(radius))
			throw new IllegalRadiusException(radius,this);
		this.radius = radius;
	}
	
	/**
	 * Checks whether the given radius is a valid radius
	 * for any ship.
	 * @param 	radius
	 * 			The radius to check
	 * @return	True if and only if the minimum radius
	 * 			is positive and the given radius is larger than
	 * 			the minimum radius.
	 * 			| result == ( (MINIMUM_RADIUS >= 0)
	 * 			|	&& (radius > MINIMUM_RADIUS) )
	 */		
	
	public static boolean isValidRadius(double radius) {
		
		return ( (MINIMUM_RADIUS >= 0) && (radius > MINIMUM_RADIUS) );
	}
	
	/**
	 * Change the current position of this ship with the 
	 * given duration based on the current position and
	 * velocity of this ship.
	 * 
	 * @param 	duration
	 * 			The duration which will also determine the new position 
	 * 			of this ship.
	 * @effect	The new position is set using the given
	 * 			duration, the current position and velocity
	 * 			of this ship.
	 * 			| setPosition( getPositionX() + duration*getVelocityX(), 
	 * 			| 	getPositionY() + duration*getVelocityY() )
	 * @throws 	IllegalDurationException
	 * 			The given duration is not a valid duration
	 * 			to change the position of this ship
	 * 			| ! isValidDuration(duration)
	 */
	
	public void move(double duration) throws IllegalDurationException {
		
		if (! isValidDuration(duration) )
			throw new IllegalDurationException(duration);
		setPosition(this.getPositionX() + duration*this.getVelocityX(), this.getPositionY() + duration*this.getVelocityY());
		
	}
	
	/**
	 * Checks whether the given duration is a valid
	 * duration for this ship.
	 * 
	 * @param 	duration
	 * 			The duration to check.
	 * @return	True if and only if the duration is 
	 * 			greater than the minimum duration.
	 * 			| result == (duration >= MINIMUM_DURATION)
	 */
	
	public static boolean isValidDuration(double duration) {
		
		return (duration >= MINIMUM_DURATION);
	}
	
	/**
	 * Change the orientation of this ship over a given angle.
	 * 
	 * @param 	angle
	 * 			The given variation of the orientation of this ship.
	 * @pre		The given angle must be expressed in radians.
	 * @effect	The new orientation of this ship is set using the 
	 * 			current position of this ship and the given angle.
	 * 			| setOrientation(NEW_ANGLE)
	 */
	
	public void turn(double angle) {
		
		double NEW_ANGLE;
		
		if ( (angle < 0) && (Math.abs(angle) > this.getOrientation()) )
			NEW_ANGLE = 2.0*Math.PI - ((Math.abs(this.getOrientation() + angle)) % (2.0*Math.PI));  // check deze formule nog eens
		else
			NEW_ANGLE = (this.getOrientation() + angle) % (2.0*Math.PI);
		setOrientation(NEW_ANGLE);
	}
	
	/**
	 * Change the position of the ship based on the current
	 * velocity, its orientation and on a given amount a.
	 * 
	 * @param 	a
	 * 			The amount to accelerate.
	 * @post	If the given amount a is less than 0,
	 * 			then the value of a will be set to 0.
	 * 			| if (a < 0.0)
	 * 			|	then a == 0.0
	 * @post	If the new velocity exceeds the maximum
	 * 			velocity, then the x-coordinate and y-coordinate
	 * 			of the velocity will be reduced such that the 
	 * 			velocity becomes equal to the maximum velocity.
	 * 			| if (getMagnitudeVelocity(new_xvelocity, new_yvelocity) > MAXIMUM_VELOCITY)
	 *			|	new_xvelocity = MAXIMUM_VELOCITY*Math.cos(getOrientation())
	 *			|	new_yvelocity = MAXIMUM_VELOCITY*Math.sin(getOrientation())
	 * @effect	The new velocity of this ship is set using the current
	 * 			velocity, its orientation and a given amount a.
	 * 			| setVelocity(Math.abs(new_xvelocity),Math.abs(new_yvelocity))
	 */
	
	public void thrust (double a) {
		
		if (a < 0.0)
			a = 0.0;
		
		double new_xvelocity = this.getVelocityX() + a*Math.cos(this.getOrientation());
		double new_yvelocity = this.getVelocityY() + a*Math.sin(this.getOrientation());
		
		if (getMagnitudeVelocity(new_xvelocity, new_yvelocity) > MAXIMUM_VELOCITY)
			new_xvelocity = MAXIMUM_VELOCITY*Math.cos(this.getOrientation());
			new_yvelocity = MAXIMUM_VELOCITY*Math.sin(this.getOrientation());
		setVelocity(Math.abs(new_xvelocity),Math.abs(new_yvelocity) );
	}
	
	private double Distance;
	
	/**
	 * Returns the distance in between two ships. 
	 * 
	 * @param 	other
	 * 			The other ship.
	 * @post	The distance is calculated using the
	 * 			eucledian distance formula, if the
	 * 			distance is less than the sum of the
	 * 			radiuses of the two ships, then the
	 * 			distance will be set to its negative value.
	 * 			| Distance = Math.sqrt(Math.pow(getPositionX()- other.getPositionX(),2.0) 
				| + Math.pow(getPositionY()-other.getPositionY(),2.0) )
				| 	if (Distance < (getRadius() + other.getRadius()) )
				| 		Distance = -Distance
	 * @return	Return the calculated distance.
	 * 			| result == Distance
	 * @throws	NullPointerException
	 * 			The other ship is not effective.
	 * 			| other == null
	 */
	public double getDistanceBetween(Ship other) throws NullPointerException {
		
		
		Distance = Math.sqrt(Math.pow(this.getPositionX()-other.getPositionX(),2.0) 
					+ Math.pow(this.getPositionY()-other.getPositionY(),2.0) );
		if (Distance < (this.getRadius() + other.getRadius()) )
			Distance = -Math.abs(Distance);
		if (this == other)
			Distance = 0.0;
		return Distance;
		
		
	}
	
	/**
	 * Checks whether two ships overlap.
	 * @param 	other
	 * 			The other ship to compare with.
	 * @return	True if and only if the distance between the two ships
	 * 			is negative or zero in case the ship overlaps with itself.
	 * 			| result == (getDistanceBetween(other) <= 0)
	 * @throws	NullPointerException
	 * 			The other ship is not effective.
	 * 			| other == null 		
	 */
	
	public boolean overlap(Ship other) throws NullPointerException{	
		return (getDistanceBetween(other) <= 0.0);
	}
	
	/**
	 * If it is the case, this method calculates the time
	 * for a collision to happen between this ship and given ship.
	 * @param	other
	 * 			The other ship to collide with.
	 * @return 	Returns the time if the dot product of the delta of the
	 * 			velocity of the two ships and the delta of the position
	 * 			of the two ships is greater than 0 or if d is smaller than 0.
	 * 			| 
	 */
	public double getTimeToCollision(Ship other) throws NullPointerException, IllegalDenominatorException {
		if (! overlap(other)) {
			double DeltaT;
			double dotVeloPos = dotProduct(deltaVelocity(other), deltaPosition(other));
			double dotVeloVelo = dotProduct(deltaVelocity(other),deltaVelocity(other));
			double dotPosPos = dotProduct(deltaPosition(other),deltaPosition(other));
			double d = Math.pow(dotVeloPos,2.0) - dotVeloVelo*(dotPosPos-Math.pow(getDistanceBetween(other),2.0));
			if (dotVeloPos >= 0.0 || d <= 0) {
				DeltaT = Double.POSITIVE_INFINITY;
				return DeltaT;
			}
			else	{
				if (dotVeloVelo == 0.0)
					throw new IllegalDenominatorException(dotVeloVelo);
				DeltaT = -(dotVeloPos+Math.sqrt(d))/dotVeloVelo;
				return DeltaT;
			}
		}
		return 0.0;   //??????????????????????????????????????????????????????????????????????????
	}
	
	/**
	 * This method calculates the difference of the velocity
	 * of the X-coordinate and Y-coordinate of both ships.
	 * 
	 * @param	other
	 * 			Other ship to calculate difference with.
	 * @return	Returns the difference of respectively X-coordinate and
	 * 			Y-coordinate of both ships in an array.
	 * 			| result == deltaVelocity
	 * @throws	NullPointerException
	 * 			The other ship is not effective.
	 * 			| other == null
	 */
	public double [] deltaVelocity(Ship other) throws NullPointerException {
		double [] deltaVelocity = {other.getVelocityX()-this.getVelocityX(),other.getVelocityY()-this.getVelocityY()};
		return deltaVelocity;
		
	}
	
	/**
	 * This method calculates the difference of the position
	 * of the X-coordinate and Y-coordinate of both ships.
	 * 
	 * @param	other
	 * 			Other ship to calculate difference with.
	 * @return	Returns the difference of respectively X-coordinate and
	 * 			Y-coordinate of both ships in an array.
	 * 			| result == deltaPosition
	 * @throws	NullPointerException
	 * 			The other ship is not effective.
	 * 			| other == null
	 */
	
	public double [] deltaPosition (Ship other) throws NullPointerException {
		double [] deltaPosition = {other.getPositionX()-this.getPositionX(),other.getPositionY()-this.getPositionY()};
		return deltaPosition;
				
	}
	
	/**
	 * This method calculates the dot product between two
	 * given arrays.
	 * @param 	array1
	 * 			The first array to be used in calculating the dot product.
	 * @param 	array2
	 * 			The second array to be used in calculating the dot product.
	 * @return	Returns the total sum of prodcuct each corresponding element of 
	 * 			both arrays.
	 * 			| result == sum
	 * @throws	NullPointerException
	 * 			The first array1 or the second array is not effective.
	 * 			| array1 == null || array2 == null
	 */
	
	public static double dotProduct(double [] array1, double [] array2) throws NullPointerException{
		double sum = 0;
	    for (int i = 0; i < array1.length; i++) {
	      sum += (array1[i] * array2[i]);
	    }
	    return sum;
	 }
	
	/**
	 * Calculates the position of the collision happens.
	 * 
	 * @param 	other
	 * 			The other ship where this ship collides with.
	 * @return	
	 * @throws NullPointerException
	 * @throws IllegalDenominatorException
	 */
	
	
	public double getNewPositionXShip(Ship other) {
		
		double getNewPositionShipX = this.getPositionX() + this.getTimeToCollision(other)*this.getVelocityX();
		
		return getNewPositionShipX;
	}
	
	public double getNewPositionYShip(Ship other) {
		
		double getNewPositionShipY = this.getPositionY() + this.getTimeToCollision(other)*this.getVelocityY();
		
		return getNewPositionShipY;
	}
	
	
	public double [] getCollisionposition (Ship other) throws NullPointerException, IllegalDenominatorException { //exception verwijst naar de exception binnen getTimeToCollision, moet ik ook al rekening houden hiermee en in een if-statement plaatsen?
		
		double deltaX = (other.getNewPositionXShip(this) - this.getNewPositionXShip(other) );
		double deltaY = (other.getNewPositionYShip(this) - this.getNewPositionYShip(other) );
		double angle = Math.atan2(deltaY,deltaX);
		
		
		if (this.getTimeToCollision(other) == Double.POSITIVE_INFINITY)
			return null;
		
		if (! overlap(other)) {
			double x;
			double y;
			if (other.getNewPositionXShip(this) > this.getNewPositionXShip(other) )
				
				x = this.getNewPositionXShip(other) + this.getRadius()*Math.cos(angle);
				y = this.getNewPositionYShip(other) + this.getRadius()*Math.sin(angle);
				
			x = other.getNewPositionXShip(this) + other.getRadius()*Math.cos(angle);
			y = other.getNewPositionYShip(this) + other.getRadius()*Math.sin(angle);
			double [] collPos= {x,y}; 
		return collPos;
		}	
		
//		if (! overlap(other)) {
//			
////			double [] collisionPosition;
//			if (this.getPositionY() <= other.getPositionY()) {
////				collisionPosition[0] = this.getPositionX()+getTimeToCollision(other)*this.getVelocityX()+Math.cos(angle)*this.getRadius();
////				collisionPosition[1] = this.getPositionY()+getTimeToCollision(other)*this.getVelocityY()+Math.sin(angle)*this.getRadius();
////			}
//				double [] collisionPosition = {this.getPositionX()+getTimeToCollision(other)*this.getVelocityX()+Math.cos(angle)*this.getRadius()
//					, this.getPositionY()+getTimeToCollision(other)*this.getVelocityY()+Math.sin(angle)*this.getRadius()};
//				return collisionPosition;
//
//			}
//			else {
//				double [] collisionPosition = {other.getPositionX()+getTimeToCollision(other)*other.getVelocityX()+Math.cos(angle)*other.getRadius()
//							, other.getPositionY()+getTimeToCollision(other)*other.getVelocityY()+Math.sin(angle)*other.getRadius()};
//				return collisionPosition;
//				}
//			}
//		return null;
		
	}
	
//	public double getOrientationAtCollision (Ship other) {
//		double angle;
//		double [] deltaPosition = deltaPosition(other);
//		
//		if (this.getPositionY() <= other.getPositionY())
//			angle = Math.atan2(deltaPosition[0],deltaPosition[1]);
//		
//		else
//			angle = Math.atan2(-deltaPosition[0],-deltaPosition[1]);
//		
//		return angle;
		
				
		//dus eerst met if checken voor hoogste y coordinate, die ship pakken als other. Dus
		// if this.y <= other -> nprmaal geval, else other = this en this = 0, this.Y = other.this . theta = 0, this.x = other x , theta = pi/2
//	}
	
	
	private static double MAXIMUM_VELOCITY = 300000.0; 
	private static final double MINIMUM_VELOCITY = 0.0;   
	private static final double MINIMUM_ORIENTATION = 0.0;
	private static final double MAXIMUM_ORIENTATION = 2.0 *Math.PI;
	private static double MINIMUM_RADIUS = 10.0;
	private static final double MINIMUM_DURATION = 0.0;

}

