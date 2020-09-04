package co.org.karianov.crypto;

public class CipherCreator implements ICipherCreator {

	@Override
	public ICipher createCipher(String name) {
		try {
			String contextName = CipherCreator.class.getSimpleName();
			String path = CipherCreator.class.getName().replace(contextName, "");
			return (ICipher) Class.forName(path + name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
				| SecurityException exception) {
			// Default cipher
			return new AESCipher();
		}
	}

}
