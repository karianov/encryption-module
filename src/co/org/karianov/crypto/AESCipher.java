package co.org.karianov.crypto;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class AESCipher implements ICipher {

	private static final String CIPHER_TRANSFORMATION = "AES/ECB/PKCS5Padding";
	private static final byte[] KEY = new byte[] { 'S', '3', 'c', 'u', 'r', '1', 't', 'y', 'K', 'e', 'y', 'C', 'i', 'p',
			'h', 'e' };
	private Cipher cipher;

	public AESCipher() {
		try {
			cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException exception) {
			System.err.println("Something went wrong during cipher initialization. Details: " + exception.getMessage());
		}
	}

	private Key generateKey() throws NoSuchAlgorithmException {
		return new SecretKeySpec(KEY, "AES");
	}

	@Override
	public String encrypt(String data) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, generateKey());
			return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
		} catch (NullPointerException | InvalidKeyException | NoSuchAlgorithmException | IllegalBlockSizeException
				| BadPaddingException exception) {
			System.err.println("Something went wrong during data encryption. Details: " + exception.getMessage());
			return null;
		}
	}

	@Override
	public String decrypt(String data) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, generateKey());
			return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
		} catch (NullPointerException | InvalidKeyException | NoSuchAlgorithmException | IllegalBlockSizeException
				| BadPaddingException exception) {
			System.err.println("Something went wrong during data decryption. Details: " + exception.getMessage());
			return null;
		}
	}

}
