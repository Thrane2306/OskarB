package shared;

import javax.xml.bind.ParseConversionEvent;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;

import sun.misc.*;

public class Encryption {
	// Decryption path
	public String decrypt(byte[] b) {
		// Defines the decryption value of the byte
		// The 4 lines below needs to work later on, but for now, it will be
		// hardcode
		// System.out.println(CF.getFfcryptkey());
		// System.out.println(CF.getFfcryptkey());
		// String crypKey = CF.getFfcryptkey();
		// System.out.println(crypKey);
		// double gladKo = Double.parseDouble(crypKey);
		byte ff = (byte) 3.1470;
		// Generates for loop containing decryption value
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ ff);
		}
		// Generates new String without any white spaces following or leading
		String encrypted = new String(b).trim();
		// Returns decrypted String
		return encrypted;
	}

	private static String algorithm = "AES";
	private static byte[] keyValue = new byte[] { 'D', 'I', 'S', 'T', '@', 'D',
			'O', 'E', 'K', '4', 'E', 'V', 'A', 'H', '!', '!' };

	// Performs Encryption
	@SuppressWarnings("restriction")
	public static String encrypt(String plainText) throws Exception {
		Key key = generateKey();
		Cipher chiper = Cipher.getInstance(algorithm);
		chiper.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = chiper.doFinal(plainText.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encVal);
		return encryptedValue;
	}

	// Performs decryption
	@SuppressWarnings("restriction")
	public static String decrypt(String encryptedText) throws Exception {
		// generate key
		Key key = generateKey();
		Cipher chiper = Cipher.getInstance(algorithm);
		chiper.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedText);
		byte[] decValue = chiper.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	// generateKey() is used to generate a secret key for AES algorithm
	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, algorithm);
		return key;
	}
}
