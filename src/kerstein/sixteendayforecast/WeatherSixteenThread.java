package kerstein.sixteendayforecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

import com.google.gson.Gson;

public class WeatherSixteenThread extends Thread {

	private JLabel[] labels;

	public WeatherSixteenThread(JLabel[] labels) {
		this.labels = labels;

	}

	@Override
	public void run() {
		try {
			CurrentWeather current = getConnection();
			getTemp(current);
		} catch (IOException e) {

		}

	}

	public CurrentWeather getConnection() throws IOException {
		String weatherURL = "http://api.openweathermap.org/data/2.5/forecast/daily?q=11230&units=imperial&cnt=16&appid=2de143494c0b295cca9337e1e96b00e0";

		// get Connection
		URL url = new URL(weatherURL);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// read it in
		InputStream in = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();

		CurrentWeather current = gson.fromJson(br, CurrentWeather.class);
		br.close();

		return current;
	}

	public void getTemp(CurrentWeather current) {

		SimpleDateFormat formatter = new SimpleDateFormat("MM:dd:yyyy");

		int counter = 0;
		for (int i = 0; i < 16; i++) {
			Date date = new Date(current.getDay(i).getDate() * 1000);
			labels[counter++].setText("DAY " + (i + 1) + " -- DATE: "
					+ formatter.format(date));
			labels[counter++].setText(" MIN TEMP: "
					+ String.valueOf(current.getDay(i).getTemp().getMin())
					+ "\n");
			labels[counter++].setText("MAX TEMP: "
					+ String.valueOf(current.getDay(i).getTemp().getMax())
					+ "\n");
			labels[counter++].setText("DESCRIPTION: "
					+ current.getDay(i).getWeather()[0].getDescription());

		}
	}
}
