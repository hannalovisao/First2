import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class CarTest {
	
	
	Volvo240 v = new Volvo240();
	
	CarTransport t = new CarTransport(2);
	
	CarFerry cf = new CarFerry();
	
	Scania s = new Scania();
	
	
	
	@Test
	void canTheCarTurn() {
		int dir = v.getDirection(); 
 	v.turnLeft();
		assertTrue(dir != v.getDirection());
	}
	
	@Test
	void canTheCarGas() {
		double speed = v.getCurrentSpeed();
		v.gas(0.5);
		assertTrue(speed != v.getCurrentSpeed());
	}
	
	@Test
	void canTheTransportLowerPlatform() {
		boolean upOrDown = t.isThePlatformDown();
		t.lowerPlatform();
		assertTrue(upOrDown != t.isThePlatformDown());
	}
	
	
	@Test
	void canTheFarryLoadCars() {
		int firstSize = cf.nrCarsOnFerry();
		cf.load(v);
		assertTrue(firstSize != cf.nrCarsOnFerry());
	}
	
	
	@Test
	void canTheTransportLoadWhilePlatformIsUp() {
		t.loadCar(v);
		assertTrue(t.nrCarsOnTransport() != 1);
	}
	
	@Test
	void canScaniaGas () {
		double startSpeed = s.getCurrentSpeed();
		s.gas(0.8);
		assertTrue(startSpeed != s.getCurrentSpeed());
	}
	

	
	

	
	
	

	
	

}
