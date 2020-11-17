import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author hannaolsson This is a class representing a car
 */

public abstract class Car implements Movable {

	/**
	 * Number of doors on the car
	 */
	private int nrDoors;
	/**
	 * Engine power of the car
	 */
	protected double enginePower;

	/**
	 * The current speed of the car
	 */
	private double currentSpeed;

	/**
	 * Color of the car
	 */
	private Color color;

	/**
	 * The car model name
	 */
	private String modelName;

	/**
	 * Position of the car
	 */
	protected Point2D.Double pos;
	/**
	 * Direction of the car modeled as the unit circle. 0 = x-direction, 90 =
	 * y-direction, 180 = -x-axeln, 270 = -y-axeln
	 */
	protected int direction;

	/**
	 * @param nrDoors     number of doors of the car
	 * @param enginePower engine power of the car
	 * @param color       color of the car
	 * @param modelName   name of the model of the car
	 * 
	 *                    sets the initial position to (0,0) and directon to 0 which
	 *                    is in the x-direction
	 */
	public Car(int nrDoors, double enginePower, Color color, String modelName) {
	
		this.nrDoors = nrDoors;
		this.enginePower = enginePower;
		this.color = color;
		this.modelName = modelName;

		pos = new Point2D.Double(0, 0);
		direction = 0;
		stopEngine();

	}

	/**
	 * @return the position of the car
	 */
	public Point2D.Double getPos() {
		return pos;
	}
	
	public void setPos(Point2D.Double pos) {
		this.pos = pos;
		
	}

	/**
	 * @return the direction of the car
	 */
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * @return the number of doors of the car
	 */
	public int getNrDoors() {
		return nrDoors;
	}

	/**
	 * @return the engine power of the car
	 */
	public double getEnginePower() {
		return enginePower;
	}

	/**
	 * @return the current speed of the car
	 */
	public double getCurrentSpeed() {
		return currentSpeed;
	}

	/**
	 * @return the color of the car
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param clr desiered color of the car sets the color of the car to the
	 *            desiered color
	 */
	public void setColor(Color clr) {			color = clr;
	}
	
	public String getModelName() {
		return modelName;
	}

	/**
	 * Sets the current speed to 0.1
	 */
	public void startEngine() {
		currentSpeed = 0.1;
	}

	/**
	 * Sets the current speed to 0
	 */
	public void stopEngine() {
		currentSpeed = 0;
	}

	/**
	 * @return the speedFactor
	 */
	protected abstract double speedFactor();

	private void incrementSpeed(double amount) {
		currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
	}

	/**
	 * Sets currentSpeed to getCurrentSpeed() - speedFactor() * amount
	 */
	private void decrementSpeed(double amount) {
		currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
		}
	

	/**
	 * Makes the car move with the current speed in the direction of the car
	 */
	public void move() {
		if (direction == 0) {
			pos.x = (pos.x + getCurrentSpeed());
		} else if (direction == 90) {
			pos.y = (pos.y + getCurrentSpeed());
		} else if (direction == 180) {
			pos.x = (pos.x - getCurrentSpeed());
		} else if (direction == 270) {
			pos.y = (pos.y - getCurrentSpeed());

		}

	}

	/**
	 * makes the car left (turn 90 degrees)
	 */
	public void turnLeft() {
		if (direction < 360) {
			direction = direction + 90;
			if (direction == 360) {
				direction = 0;
			}

		}

	}

	/**
	 * makes the car turn right
	 */
	public void turnRight() {	
		if (direction > 0) {
			direction = direction - 90;
		}

		else if (direction == 0) {
			direction = 270;
		}

	}

	// TODO fix this method according to lab pm
	public void gas(double amount) {
		if (amount >= 0 && amount <= 1) {
			incrementSpeed(amount);
		} else {
			System.out.println("Error in gas: You need to enter an amount between 0 and 1");
		}
	}

	// TODO fix this method according to lab pm
	public void brake(double amount) {
		if (amount >= 0 && amount <= 1) {
			decrementSpeed(amount);
		} else {
			System.out.println("Error in gas: You need to enter an amount between 0 and 1");
		}
	}

}
