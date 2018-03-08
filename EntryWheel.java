/**
 * EntryWheel The device that initially takes input and prints output once
 * a character has been encrypted
 * @author Jesse Abeyta
 *
 */
public class EntryWheel extends IODevice {
	
	EntryWheel() {
		super(new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' }, null, null);
	}

	public void inputSignal(int outputPin, boolean forward) {
		if (forward) {
			forwardOutput.inputSignal(outputPin, forward);
		} else {
			System.out.print(alphabet[outputPin]);
		}
	}
	
	public void rotate() {
		this.forwardOutput.rotate();
	}
}
