package kerstein.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class AccessWeather {

	public CurrentWeather getCurrentWeather(String zip) throws IOException {
		StringBuilder builder = new StringBuilder();
		builder.append("http://api.openweathermap.org/data/2.5/weather?zip=");
		builder.append(zip);
		builder.append(",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");

		// get the URL connection
		URL url = new URL(builder.toString());
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
