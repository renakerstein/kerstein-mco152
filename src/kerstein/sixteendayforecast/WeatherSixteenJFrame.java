package kerstein.sixteendayforecast;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeatherSixteenJFrame extends JFrame {

	private JLabel[] weatherLabels;
	private JPanel panel;
	private JPanel panel2;
	private JButton button;

	public WeatherSixteenJFrame() {
		setTitle("16 DAY FORESCAST IN BROOKLYN, NY -11230");
		setSize(4000, 2000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BorderLayout());

		panel = new JPanel(new GridLayout(8, 4));
		panel2 = new JPanel(new GridLayout(1, 4));
		weatherLabels = new JLabel[64];
		for (int i = 0; i < weatherLabels.length; i++) {
			weatherLabels[i] = new JLabel();
			panel.add(weatherLabels[i]);
		}
		button = new JButton("GET WEATHER");
		panel2.add(button);
		add(panel2, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				WeatherSixteenThread thread = new WeatherSixteenThread(
						weatherLabels);

				thread.start();
			}

		});

	}

	public static void main(String[] args) {
		WeatherSixteenJFrame weather = new WeatherSixteenJFrame();
		weather.setVisible(true);
	}
}
