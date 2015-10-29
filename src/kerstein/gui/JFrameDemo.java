package kerstein.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameDemo extends JFrame {
	private JLabel label1;
	private JLabel label2;
	private JButton button1;
	private JTextField text;

	public JFrameDemo() {
		setTitle("JFrameDemo");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		label1 = new JLabel("All this text gets shown");
		add(label1);
		label2 = new JLabel("More labels");
		add(label2);
		button1 = new JButton("button 1");

		text = new JTextField();
		add(text);
		text.setSize(300, 200);

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Hello Rena");
				label2.setText("goodbye");
			}
		});
		add(button1);
	}
}
