package co.org.karianov;

import co.org.karianov.crypto.CipherCreator;
import co.org.karianov.crypto.ICipher;
import co.org.karianov.crypto.ICipherCreator;

public class Main {

	public static void main(String[] args) {
		String inputMessage = "Hello World!";
		ICipherCreator cipherCreator = new CipherCreator();
		ICipher aesCipher = cipherCreator.createCipher("DESedeCipher");
		String messageEncrypted = aesCipher.encrypt(inputMessage);
		if (messageEncrypted != null) {
			System.out.println(messageEncrypted);
		}
	}

}
