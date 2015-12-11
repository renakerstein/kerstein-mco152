package kerstein.weather;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
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
		container.setBackground(Color.CYAN);

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
				WeatherThread thread = new WeatherThread(temp, humidity,
						description, zipText, image);

				thread.start();
			}

		});
	}

	public static void main(String[] args) {
		WeatherJFrame weather = new WeatherJFrame();
		weather.setVisible(true);
	}

}
