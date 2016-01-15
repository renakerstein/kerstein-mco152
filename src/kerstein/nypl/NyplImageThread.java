package kerstein.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.google.gson.Gson;

public class NyplImageThread extends Thread {

	private NyplSearch search;
	private JLabel label;
	private int index;

	public NyplImageThread(NyplSearch search, int index, JLabel label) {
		this.search = search;
		this.index = index;
		this.label = label;

	}

	@Override
	public void run() {
		try {
			NyplSearch image = getConnection();
			setImage(image, index);
		} catch (IOException e) {

		}

	}

	public NyplSearch getConnection() throws IOException {

		String nyplURL = search.getNyplAPI().getResponse().getResults()[0]
				.getApiItemURL();

		URL url;
		url = new URL(nyplURL);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Authorization",
				"Token token=2g52oxc7ul9g1s7u");

		// read it in
		InputStream in = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();

		NyplSearch search = gson.fromJson(br, NyplSearch.class);
		br.close();

		return search;
	}

	public void setImage(NyplSearch s, int index) throws MalformedURLException {
		URL url;
		url = new URL(s.getNyplAPI().getResponse().getCapture()[index]
				.getImageLinks().getImageLink()[3]);
		ImageIcon icon = new ImageIcon(url);
		label.setIcon(icon);
	}

}
