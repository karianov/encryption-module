package co.org.karianov.crypto;

public interface ICipher {
	
	public String encrypt(String data);
	
	public String decrypt(String data);

}
