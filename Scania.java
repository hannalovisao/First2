import java.awt.Color;

/**
 * @author hannaolsson
 * A class that models a Scania truck 
 *
 */
public class Scania extends Car {

	/**
	 * Scania has a platform 
	 */
	private Platform platform;

	/**
	 * Creates an instance of a car, makes platform a reference to a new Platform 
	 */
	public Scania() {
		super(2, 250, Color.BLUE, "Scania");
		platform = new Platform();

	}
	
	/**
	 * @return platform 
	 */
	public Platform getPlatform() {
		return this.platform;
	}

	/**
	 * @param amount the amount you want to raise the platform with 
	 * The platform can only be raised if the truck is still 
	 */
	public void raisePlattform(double amount) {

		if (getCurrentSpeed() == 0) {
			platform.raisePlatform(amount);
		}

		else {
			System.out.println("Error in raisePlattform: You can't raise the plattform while the truck moves.");
		}

	}

	/**
	 *@param amount the amount you want to lower the platform with 
	 *The platform can only be lowered if the truck is still 
	 */
	public void lowerPlattform(double amount) {
		if (getCurrentSpeed() == 0) {
			platform.lowerPlatform(amount);

		} else {
			System.out.println("Error in lowerPlattform: You can't lower the plattform while the truck moves.");
		}
	}

	/**
	 * The truck can only move of the platform has a 0 angle 
	 */
	@Override
	public void move() {
		if (platform.getAngle() == 0) {
			super.move();
		} else {
			System.out.println("Error in move: The angel of the platform must be 0 when the truck moves");
		}

	}

	/**
	 * speedFactor of the truck 
	 */
	protected double speedFactor() {
		return enginePower * 0.01;
	}

}
