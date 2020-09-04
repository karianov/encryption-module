package co.org.karianov;

import co.org.karianov.crypto.AESCipher;

public class Main {

	public static void main(String[] args) {
		String inputMessage = "Hello World!";
		AESCipher aesCipher = new AESCipher();
		String messageEncrypted = aesCipher.encrypt(inputMessage);
		if (messageEncrypted != null) {
			System.out.println(messageEncrypted);
		}
	}

}
