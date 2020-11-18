import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author hannaolsson This is a class representing a car
 */

public abstract class Car extends Vehicle{
	
	/**
	 * Number of doors on the car
	 */
	private int nrDoors;

	public Car(int doors, double enginePower, Color color, String modelName) {
		super(enginePower, color, modelName);
		this.nrDoors = doors; 
		
	}


	/**
	 * @return the number of doors of the car
	 */
	public int getNrDoors() {
		return nrDoors;
	}


}
