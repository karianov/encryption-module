package co.org.karianov;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import co.org.karianov.crypto.AESCipher;

public class Main {

	public static void main(String[] args) {
		String inputMessage = "Hello World!";
		try {
			AESCipher aesCipher = new AESCipher();
			String messageEncrypted = aesCipher.encrypt(inputMessage);
			System.out.println(messageEncrypted);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException exception) {
			System.err.println("Something went wrong during data encryption. Details: " + exception.getMessage());
		}
	}

}
