package kerstein.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JList;

import com.google.gson.Gson;

public class NyplThread extends Thread {

	private NyplSearch nypl;
	private String text;
	private JList<String> list;

	public NyplThread(String text, JList<String> list) {
		this.text = text;
		this.list = list;

	}

	public NyplSearch getNypl() {
		return nypl;
	}

	@Override
	public void run() {
		try {
			nypl = getConnection();
			getTitles(nypl);
		} catch (IOException e) {

		}

	}

	public NyplSearch getConnection() throws IOException {
		StringBuilder builder = new StringBuilder();
		builder.append("http://api.repo.nypl.org/api/v1/items/search?q=");
		builder.append(text);
		builder.append("&publicDomainOnly=true");
		String nyplURL = builder.toString();

		URL url;
		url = new URL(nyplURL);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Authorization",
				"Token token=2g52oxc7ul9g1s7u");

		// read it in
		InputStream in = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();

		NyplSearch nypl = gson.fromJson(br, NyplSearch.class);
		br.close();

		return nypl;

	}

	public void getTitles(NyplSearch nypl) {
		Result[] result = nypl.getNyplAPI().getResponse().getResults();
		String[] titleArray = new String[result.length];

		int j = 0;
		for (Result r : result) {
			String name = r.getTitle();

			titleArray[j] = name;
			j++;
		}

		list.setListData(titleArray);
	}

}