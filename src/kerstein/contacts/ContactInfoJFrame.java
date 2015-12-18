package kerstein.contacts;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ContactInfoJFrame extends JFrame {

	private JLabel phone;
	private JLabel email;

	public ContactInfoJFrame(Contacts[] contacts, int index) {
		setTitle("CONTACT'S INFO");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		Font font = new Font("Arial", Font.BOLD, 25);

		this.phone = new JLabel();
		phone.setFont(font);
		phone.setForeground(Color.GREEN);
		add(phone);

		this.email = new JLabel();
		email.setFont(font);
		email.setForeground(Color.BLUE);
		add(email);

		setText(contacts, index);
	}

	public void setText(Contacts[] contacts, int index) {
		phone.setText(contacts[index].getPhone());
		email.setText(contacts[index].getEmail());
	}
}
