import java.awt.Color;

public class Scania extends Car {

	private double angleOfPlatform;

	public Scania() {
    super(2, 250, Color.BLUE, "Scania");
	angleOfPlatform = 0;

	}

	public double getAngleOfPlatform() {
		return angleOfPlatform;
	}
	
	public void setAngleOfPlatform(double angel) {
		angleOfPlatform = angel;
	}

	public void raisePlattform(double amount) {

		if (getCurrentSpeed() == 0) {
			if (angleOfPlatform + amount < 70) {
				angleOfPlatform = angleOfPlatform + amount;
			} else {
				angleOfPlatform = 70;
			}
		} else {
			System.out.println("Error in raisePlattform: You can't raise the plattform while the truck moves.");
		}
	}

	public void lowerPlattform(double amount) {
		if (getCurrentSpeed() == 0) {
			if (angleOfPlatform - amount > 0) {
				angleOfPlatform = angleOfPlatform - amount;
			} else {
				angleOfPlatform = 0;
			}

		} else {
			System.out.println("Error in lowerPlattform: You can't lower the plattform while the truck moves.");
		}
	}

	@Override
	public void move() {
		if (getAngleOfPlatform() == 0) {
			super.move();
		} else {
			System.out.println("The angel of the platform must be 0 when the truck moves");
		}

	}

	@Override
	protected double speedFactor() {
		// TODO Auto-generated method stub
		return 0;
	}

}
