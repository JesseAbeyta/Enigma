import java.util.Scanner;
/**
 * EnigmaMachine a simulation of the 1941 German Army's Enigma Machine
 * 
 * @author Jesse Abeyta
 *
 */

public class EnigmaMachine {
	private EntryWheel entryWheel;
	private Rotor rotor1;
	private Rotor rotor2;
	private Rotor rotor3;
	private Reflector reflector;
	
	/**Constructor for the EnigmaMachine
	 * 
	 * @param rotor1Alphabet The cipher used for rotor1
	 * @param rotor2Alphabet The cipher used for rotor2
	 * @param rotor3Alphabet The cipher used for rotor3
	 * @param reflectorAlphabet The cipher used for the reflector
	 */
	EnigmaMachine(char rotor1Alphabet[], char rotor2Alphabet[], char rotor3Alphabet[], char reflectorAlphabet[]) {
		
		entryWheel = new EntryWheel();
		
		rotor1 = new Rotor(rotor1Alphabet, 1);
		entryWheel.setFowardConnection(rotor1);
		rotor1.setBackwardConnection(entryWheel);
		
		rotor2 = new Rotor(rotor2Alphabet, 26);
		rotor1.setFowardConnection(rotor2);
		rotor2.setBackwardConnection(rotor1);
		
		rotor3 = new Rotor(rotor3Alphabet, 26);
		rotor2.setFowardConnection(rotor3);
		rotor3.setBackwardConnection(rotor2);
		
		reflector = new Reflector(reflectorAlphabet, rotor3);
		rotor3.setFowardConnection(reflector);
				
	}
	
	/**Simulates entering a string into the Enigma Machine. Outputs the 
	 * Encrypted version of the string. Only lower case characters and spaces
	 * are valid input.
	 */
	public void enterMessage() {
		System.out.print("Please enter your message to be encrypted: ");
		Scanner scanner = new Scanner(System.in);
		String message = scanner.nextLine();
		for(int i = 0; i < message.length(); i++) {
			char letter = message.charAt(i);
			if(letter == ' ') {
				System.out.print(" ");
			}
			else {
				int mappedLetter = Character.getNumericValue(letter) - Character.getNumericValue('A');
				entryWheel.inputSignal(mappedLetter, true);
				entryWheel.rotate();
			}
		}
	}	
}