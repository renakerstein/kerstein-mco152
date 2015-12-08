package kerstein.weather;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherJFrame extends JFrame {

	private JLabel zipLabel;
	private JTextField zipText;
	private JButton button;
	private JLabel temp;
	private JLabel description;
	private JLabel humidity;
	private JLabel image;
	private AccessWeather current;

	public WeatherJFrame() {
		setTitle("WEATHER");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		Font font = new Font("Arial", Font.BOLD, 25);

		zipLabel = new JLabel();
		zipLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(zipLabel);

		zipText = new JTextField("Enter zip code");
		zipText.setMaximumSize(new Dimension(300, 35));
		zipText.setFont(font);
		zipText.setBackground(Color.YELLOW);
		zipText.setForeground(Color.BLUE);
		zipText.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(zipText);

		button = new JButton("GET WEATHER");
		button.setFont(font);
		button.setBackground(Color.RED);
		button.setForeground(Color.WHITE);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(button);

		temp = new JLabel();
		temp.setFont(font);
		temp.setForeground(Color.GREEN);
		temp.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(temp);

		description = new JLabel();
		description.setFont(font);
		description.setForeground(Color.ORANGE);
		description.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(description);

		humidity = new JLabel();
		humidity.setFont(font);
		humidity.setForeground(Color.PINK);
		humidity.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(humidity);

		image = new JLabel();
		image.setSize(40, 40);
		image.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(image);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// instantiate AccessWeather class
				current = new AccessWeather();

				CurrentWeather cWeather = null;
				try {
					// call method in AccessWeatherClass to get CurrentWeather
					cWeather = current.getCurrentWeather(zipText.getText());

					// access the main
					Main main = cWeather.getMain();

					// get the temperature
					temp.setText("\n" + String.valueOf(main.getTemp())
							+ " Degrees F");

					humidity.setText("Humidity- "
							+ String.valueOf(main.getHumidity()));
				} catch (IOException e) {
				}

				// access the array of Weather
				Weather[] w = cWeather.getWeather();
				// get description
				description.setText(w[0].getDescription());

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

		});
	}

	public static void main(String[] args) {
		WeatherJFrame weather = new WeatherJFrame();
		weather.setVisible(true);
	}

}
