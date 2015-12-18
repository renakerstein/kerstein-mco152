package kerstein.contacts;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JList;

public class ContactNameJFrame extends JFrame {

	private JList<String> list;
	private ContactThread thread;

	public ContactNameJFrame() {
		setTitle("CONTACTS");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		Font font = new Font("Arial", Font.BOLD, 25);
		this.list = new JList<String>();
		list.setFont(font);
		list.setForeground(Color.red);
		add(list);
		this.thread = new ContactThread(list);

		thread.start();

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				list = (JList) evt.getSource();
				if (evt.getClickCount() == 2) {

					// Double-click detected
					int index = list.locationToIndex(evt.getPoint());
					Contacts[] contacts = thread.getContacts();
					ContactInfoJFrame frame = new ContactInfoJFrame(contacts,
							index);
					frame.setVisible(true);
				}

			}
		});
	}

	public static void main(String[] args) {
		ContactNameJFrame frame = new ContactNameJFrame();
		frame.setVisible(true);
	}

}
