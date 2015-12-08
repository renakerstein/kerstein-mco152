package kerstein.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketHttpRequestDemo {

	public static void main(String[] args) throws UnknownHostException,
	IOException {
		Socket socket = new Socket("www.google.com", 80);

		String httpRequestString = "GET /index.html\n\n";

		PrintWriter out = new PrintWriter(socket.getOutputStream());

		out.write(httpRequestString);

		out.flush();

		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String s;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
		}
		br.close();
		socket.close();
	}
}