package kerstein.sixteendayforecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) throws IOException {

		CurrentWeather weather = getConnection();
		List[] list = weather.getList();

		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i].getTemp().getMin());
			System.out.println(list[i].getTemp().getMax());
			System.out.println(list[i].getWeather()[0].getDescription());
		}

	}

	public static CurrentWeather getConnection() throws IOException {
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

}
