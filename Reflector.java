/**
 * A device that sends its output back to the device that activated it
 * 
 * @author Jesse Abeyta
 *
 */
public class Reflector extends IODevice {
	Reflector(char[] alphabet, IODevice connection) {
		super(alphabet, connection, connection);
	}
	
	public void inputSignal(int input, boolean forward) {
		super.inputSignal(input, false);
	}
}
