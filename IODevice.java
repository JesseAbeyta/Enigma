public class IODevice {
	/**Constructor for IODevice when the forward and backward output are known 
	 * @param alphabet An array representing the mapping of the standard
	 * alphabet onto the cipher alphabet
	 * @param forwardOutput The device forward output is sent to
	 * @param backwardOutput The device backwards output is sent to
	 */
	IODevice(char alphabet[], IODevice forwardOutput, IODevice backwardOutput) {
		this.alphabet = alphabet;
		this.forwardOutput = forwardOutput;
		this.backwardOutput = backwardOutput;
		
		for(int i = 0; i < 26; i++) {
			map[i] = Character.getNumericValue(alphabet[i]) - Character.getNumericValue('a'); // translates the !!! document
		}
		
		for(int i = 0; i < 26; i++) {
			reverseMap[map[i]] = i;
		}
	}
	
	/**Constructor for IODevice when the forward and backward output are not
	 * yet known or initialized 
	 * @param alphabet An array representing the mapping of the standard
	 * onto the cipher alphabet
	 */
	IODevice(char alphabet[]) {
		this.alphabet = alphabet;
		for(int i = 0; i < 26; i++) {
			map[i] = Character.getNumericValue(alphabet[i]) - Character.getNumericValue('a'); // translates the !!! document
		}
		
		for(int i = 0; i < 26; i++) {
			reverseMap[map[i]] = i;
		}
		
		this.forwardOutput = null;
		this.backwardOutput = null;
	}
	
	public void setFowardConnection(IODevice forwardConnection) {
		this.forwardOutput = forwardConnection;
	}
	
	public void setBackwardConnection(IODevice backwardConnection) {
		this.backwardOutput = backwardConnection;
	}
	
	public char alphabet[] = new char[26]; // Mapping of this device's alphabet
	private int map[] = new int[26]; // Numeric representation of the device's alphabet
	// Numeric representation of inverse of device's alphabet
	private int reverseMap[] = new int[26]; 

	protected IODevice forwardOutput; // Where output signals are sent forwards
	protected IODevice backwardOutput;// Where output signals are sent backwards
	
	/**Given a signal and whether it's traveling backwards or forwards pass it
	 * to the next device with appropriate mapping
	 * @param input Integer representation of which input pin is being activated
	 * @param forward True if the signal is traveling forwards, false otherwise
	 */
	public void inputSignal(int input, boolean forward) {
		int outputPin;
		if(forward) {
			outputPin = map[input];
			forwardOutput.inputSignal(outputPin, forward);
		}
		else {
			outputPin = reverseMap[input];
			backwardOutput.inputSignal(outputPin, forward);
		}
	}
	
	/**Changes the map and reverseMap arrays to represent a rotation of the rotor 
	 */
	public void updateMaps() {
		int temp[] = new int[26];
		temp[25] = map[0];
		for(int i = 0; i < 25; i++) {
			temp[i] = map[i+1];
		}
		for(int i = 0; i < 26; i++) {
			map[i] = temp[i];
		}
		
		for(int i = 0; i < 26; i++) {
			reverseMap[map[i]] = i;
		}
	}
	public void rotate() {
		
	}
}