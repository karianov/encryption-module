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

public class AESCipher {
	
	private static final String CIPHER_TRANSFORMATION = "AES/ECB/PKCS5Padding";
	private Cipher cipher;
	
	public AESCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
		cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
	}
	
	private Key generateKey() throws NoSuchAlgorithmException {
		return new SecretKeySpec(SecurityConstants.KEY_VALUE, "AES");
	}
	
	public String encrypt(String data) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException {
		cipher.init(Cipher.ENCRYPT_MODE, generateKey());
		return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
	}
	
	public String decrypt(String data) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException {
		cipher.init(Cipher.DECRYPT_MODE, generateKey());
		return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
	}

}
