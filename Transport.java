import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hannaolsson
 * A class that models a car transport 
 *
 */
public class Transport extends Car {

	/**
	 * A list to keep track of the cars that are on the transport
	 */
	private List<Car> carsOnTransport;
	/**
	 * A boolean to keep track of whether the platform is up or down 
	 */
	private boolean platformIsDown;
	/**
	 * the max numer of cars that can be loaded on the transport
	 */
	private int maxCars;

	/**
	 * @param maxCars he max numer of cars that can be loaded on the transport
	 * creates an instance of a car, makes carsOnTransport a reference to a new ArrayList, the platform is up 
	 */
	public Transport(int maxCars) {
		super(2, 400, Color.YELLOW, "Transport");
		this.carsOnTransport = new ArrayList<>();
		this.maxCars = maxCars;
		this.platformIsDown = false;

	}

	/**
	 * @return the List carsOnTransport 
	 */
	public List<Car> getCarsOnTransport() {
		return this.carsOnTransport;
	}

	/**
	 * @return the boolean platformIsDown 
	 */
	public boolean getPlatformIsDown() {
		return this.platformIsDown;
	}

	/**
	 * @param car the car that you want to load on the transport 
	 * A transport can not be loaded on the transport 
	 * A car can only be loaded if there is room on the transport 
	 * A car can oly be loaded of the platform is down 
	 * A car can oly be loaded if it is "near" the transport 
	 * The loaded car gets the position of the transport
	 */
	public void loadCar(Car car) {

		if (!(car.getModelName().equals("Transport"))) {

			if (carsOnTransport.size() < maxCars) {

				if (platformIsDown) {
					if (isNear(car)) {

						carsOnTransport.add(car);
						car.setPos(getPos());
					} else {
						System.out.println("Error in loadCar: the car is to far away from the transport");
					}

				} else {
					System.out.println("Error in loadCar: The transport can only load cars when the platform is down");
				}

			} else {
				System.out.println("Error in loadTransport: This Transport can only load " + maxCars + " cars");
			}
		} else {
			System.out.println("Error in loadTransport: You cant load the transport with a transport");
		}
	}

	/**
	 * The car that is unloaded is the car that was most reacently loaded 
	 * The car gets a position near the transport 
	 */
	public void unloadCar() {
		if (platformIsDown) {

			Car lastCar = carsOnTransport.get(carsOnTransport.size()-1);
			carsOnTransport.remove(lastCar);
			Point2D.Double posNearTransport = new Point2D.Double((getPos().x + 1), (getPos().y + 1));
			lastCar.setPos(posNearTransport);
		}

	}

	/**
	 * @param car the car that may or may not be near the transport 
	 * @return true if the car is within radius 1 of the transport
	 */
	public boolean isNear(Car car) {
		if ((car.getPos().x < (getPos().x + 1) && car.getPos().x > (getPos().x - 1))
				&& (car.getPos().y < (getPos().y + 1) && car.getPos().y > (getPos().y - 1))) {
			return true;
		} else
			return false;
	}

	/**
	 * The platform can only be lowered if the speed of the transport is 0 
	 */
	public void lowerPlatform() {
		if (getCurrentSpeed() == 0) {
			platformIsDown = true;
		} else {
			System.out.println("Error in lowerPlatform: you cant lower platform while the transport moves");
		}

	}

	/**
	 * The platform can only be raised if the speed of the transport is 0
	 */
	public void raisePlatform() {
		if (getCurrentSpeed() == 0) {
			platformIsDown = false;
		} else {
			System.out.println("Error in raisePlatform: you cant raise platform while the transport moves");
		}

	}

	/**
	 * Speedfactor of the transport 
	 */
	@Override
	protected double speedFactor() {
		return enginePower * 0.01;
	}

	/**
	 * The transport can only move if the platform is up 
	 */
	@Override
	public void move() {
		if (!platformIsDown) {
			super.move();
		} else {
			System.out.println("Error in move: The platform must be up when the transport moves");
		}

	}

}
