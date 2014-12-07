package shared;

import gui.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Push {
	private static Encryption cryp = new Encryption();
	public static String push(String json) throws Exception {

		Socket clientSocket = new Socket("localhost", 8888);
		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());
		byte[] input = json.getBytes();
		byte key = (byte) 3.1470;
		byte[] encrypted = input;
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ key);

		outToServer.write(encrypted);
		outToServer.flush();
		
		byte[] b = new byte[500000];
		int count = clientSocket.getInputStream().read(b);
			ByteArrayInputStream bais = new ByteArrayInputStream(b);
		String ny = cryp.decrypt(b);
		
		clientSocket.close();
		return ny;
	}
}
