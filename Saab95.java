import java.awt.Color;

/**
 * @author hannaolsson A subclass to Car representing a Saab95
 */
public class Saab95 extends Car {
	/**
	 * Class variable turboOn, shared by all Saab95 objects
	 */
	private boolean turboOn;

	/**
	 * sets turboOn to false, nrDoors to 2, color to red, enginePower to 125,
	 * modelName to Saab95 and calls stopEngien
	 */
	public Saab95() {
		super(2, 125, Color.red, "Saab95");
		this.turboOn = false;
	}

	/**
	 * Gets the speedFactor
	 */
	public double speedFactor() {
		double turbo = 1;
		if (turboOn)
			turbo = 1.3;
		return enginePower * 0.01 * turbo;
	}

	/**
	 * Sets currentSpeed to getCurrentSpeed() + speedFactor() * amount
	 */
}


