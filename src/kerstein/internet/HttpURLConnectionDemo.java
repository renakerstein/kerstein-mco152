package kerstein.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionDemo {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://google.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String s;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
		}
		br.close();

	}
}
