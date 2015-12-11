package kerstein.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketDemo {

	public static void main(String[] args) throws UnknownHostException,
			IOException {

		String serverIP = "192.168.117.78";
		Socket socket = new Socket(serverIP, 52746);

		// client sending message and reading one line of response
		PrintWriter out = new PrintWriter(socket.getOutputStream());

		out.write("Hello there!\n");

		out.flush();

		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		// serve read one line of message and write response

		String response = reader.readLine();

		System.out.println("Response:");
		System.out.println(response);

		socket.close();

	}
}