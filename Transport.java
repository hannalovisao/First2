import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;

public class Transport extends Scania {

	private List<Car> carsOnTransport;

	public Transport(int maxCars) {
		carsOnTransport = new ArrayList<>(maxCars);

	}

	public void loadTransport(Car car) {
		//Om car är transporten ska den inte kunna ladda 
		
		if (getCurrentSpeed() == 0 && isNear(car)) {
			
			carsOnTransport.add(car);
		}

	}
	
	public void unloadTransport() {
		Car lastCar = carsOnTransport.get(carsOnTransport.size());
		carsOnTransport.remove(lastCar);
		Point2D.Double posNearTransport = new Point2D.Double((getPos().x +1), (getPos().y +1));
		lastCar.setPos(posNearTransport);
		
		

	}

	public boolean isNear(Car car) {
		if ((car.getPos().x < (getPos().x + 1) && car.getPos().x> (getPos().x - 1))
				&& (car.getPos().y < (getPos().y + 1) && car.getPos().y > (getPos().y - 1))) {
			return true;
		}
		else return false;
	}

	public void lowerPlattform() {
		if (getCurrentSpeed() == 0) {
			setAngleOfPlatform(0);
		}

	}

	public void raisePlatform() {
		setAngleOfPlatform(70);

	}

}
