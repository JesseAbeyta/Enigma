
public class main {

	public static void main(String[] args) {
		char alphabet1[] = "JGDQOXUSCAMIFRVTPNEWKBLZYH".toCharArray();
		char alphabet2[] = "NTZPSFBOKMWRCJDIVLAEYUXHGQ".toCharArray();
		char alphabet3[] = "JVIUBHTCDYAKEQZPOSGXNRMWFL".toCharArray();
		char alphabet4[] = "QYHOGNECVPUZTFDJAXWMKISRBL".toCharArray();
		
		EnigmaMachine enigma = new EnigmaMachine(alphabet1, alphabet2, alphabet3, alphabet4);
		enigma.enterMessage();
		
	}

}
