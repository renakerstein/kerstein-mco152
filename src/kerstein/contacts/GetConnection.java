package kerstein.contacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class GetConnection {

	private Contact[] contacts;

	public GetConnection() {

	}

	public Contact[] getJSONConnection() throws IOException {
		String contactURL = "http://jsonplaceholder.typicode.com/users";

		// get Connection
		URL url = new URL(contactURL);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// read it in
		InputStream in = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();

		this.contacts = new Gson().fromJson(br, Contact[].class);
		br.close();

		return contacts;

	}

	public Contact[] getContacts() {
		return contacts;
	}
}
