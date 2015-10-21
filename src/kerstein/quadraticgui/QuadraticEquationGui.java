package kerstein.quadraticgui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import kerstein.physics.InvalidDataException;
import kerstein.physics.QuadraticEquation;

public class QuadraticEquationGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel a;
	private JTextField textFieldA;
	private JLabel b;
	private JTextField textFieldB;
	private JLabel c;
	private JTextField textFieldC;
	private JButton button;
	private JLabel x;
	private JLabel answer;

	public QuadraticEquationGui() {
		setTitle("QuadraticEquation");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		a = new JLabel("a");
		add(a);
		textFieldA = new JTextField();
		add(textFieldA);
		b = new JLabel("b");
		add(b);
		textFieldB = new JTextField();
		add(textFieldB);
		c = new JLabel("c");
		add(c);
		textFieldC = new JTextField();
		add(textFieldC);
		button = new JButton("Calculate");
		add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				QuadraticEquation equation;
				double a = Double.parseDouble(textFieldA.getText());
				double b = Double.parseDouble(textFieldB.getText());
				double c = Double.parseDouble(textFieldC.getText());
				try {
					equation = new QuadraticEquation(a, b, c);
					StringBuilder builder = new StringBuilder();
					builder.append(equation.getPositiveX());
					x = new JLabel("x=");
					add(x);
					answer = new JLabel();
					add(answer);
					answer.setText(builder.toString());

				} catch (InvalidDataException e) {
					System.out.println("Invalid data");
				}

			}
		});

	}
}