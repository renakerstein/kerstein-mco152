package kerstein.physics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProjectileGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel angle;
	private JTextField textAngle;
	private JLabel velocity;
	private JTextField textVelocity;
	private JLabel time;
	private JTextField textTime;
	private JButton button;
	private JLabel xy;
	private JLabel answer;

	public ProjectileGui() {
		setTitle("Projectile");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		angle = new JLabel("Angle:");
		add(angle);
		textAngle = new JTextField();
		add(textAngle);
		velocity = new JLabel("Velocity:");
		add(velocity);
		textVelocity = new JTextField();
		add(textVelocity);
		time = new JLabel("Time");
		add(time);
		textTime = new JTextField();
		add(textTime);
		button = new JButton("Calculate");
		add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Projectile p;
				double angle = Double.parseDouble(textAngle.getText());
				double velocity = Double.parseDouble(textVelocity.getText());
				double time = Double.parseDouble(textTime.getText());

				p = new Projectile(angle, velocity, time);
				StringBuilder builder = new StringBuilder();
				builder.append(p.getAnswerX());
				builder.append("  ,  ");
				builder.append(p.getAnswerY());
				xy = new JLabel("x/y=");
				add(xy);
				answer = new JLabel();
				add(answer);
				answer.setText(builder.toString());

			}
		});
	}
}