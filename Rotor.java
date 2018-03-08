
public class Rotor extends IODevice {

	int rotateCounter; // How many times the device before it has moved
	int numTillRotate; // How many times the preceding IODevice rotates before this one rotates
	Rotor(char[] alphabet, int numTillRotate) {
		super(alphabet, null, null);
		rotateCounter = 0;
		this.numTillRotate = numTillRotate;
	}
	
	public void rotate() {
		rotateCounter++;
		if(numTillRotate == rotateCounter) { // If it's time to rotate
			rotateCounter = 0;
			forwardOutput.rotate();
			updateMaps();
		}
	}
}