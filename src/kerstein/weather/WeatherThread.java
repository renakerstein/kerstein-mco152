package kerstein.weather;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherThread extends Thread {

	private AccessWeather current;
	private JLabel temp;
	private JLabel humidity;
	private JLabel description;
	private JTextField zipText;
	private JLabel image;

	public WeatherThread(JLabel temp, JLabel humidity, JLabel description,
			JTextField zipText, JLabel image) {
		this.temp = temp;
		this.humidity = humidity;
		this.description = description;
		this.zipText = zipText;
		this.image = image;
		this.current = new AccessWeather();

	}

	public void requestWeather() {
		Weather[] w = requestWeatherData();
		requestWeatherImage(w);
	}

	public Weather[] requestWeatherData() {

		CurrentWeather cWeather = null;
		try {
			// call method in AccessWeatherClass to get CurrentWeather
			cWeather = current.getCurrentWeather(zipText.getText());

			// access the main
			Main main = cWeather.getMain();

			// get the temperature
			temp.setText("\n" + String.valueOf(main.getTemp()) + " Degrees F");

			humidity.setText("Humidity- " + String.valueOf(main.getHumidity()));
		} catch (IOException e) {
		}

		// access the array of Weather
		Weather[] w = cWeather.getWeather();
		// get description
		description.setText(w[0].getDescription());
		return w;
	}

	private void requestWeatherImage(Weather[] w) {
		// get the image
		StringBuilder builder = new StringBuilder();
		builder.append("http://openweathermap.org/img/w/");
		builder.append(w[0].getIcon());
		builder.append(".png");

		try {
			URL url = new URL(builder.toString());

			BufferedImage img = ImageIO.read(url);

			image.setIcon(new ImageIcon(new ImageIcon(img).getImage()
					.getScaledInstance(125, 125, Image.SCALE_DEFAULT)));
		} catch (IOException e) {

		}
	}

	@Override
	public void run() {
		requestWeather();
	}
}
