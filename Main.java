import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Volvo240 v = new Volvo240();
	
		
		Saab95 s = new Saab95(); 
		
		Car scania = new Scania();
		
		Transport transport = new Transport(5);
		Transport transport2 = new Transport(5);
		transport.loadTransport(s);
		transport.loadTransport(v);
		transport.loadTransport(scania);
		
		transport.move();
		transport.loadTransport(transport2);
		
		System.out.println(transport.getAngleOfPlatform());
		
		
		
	
		

	}
}
