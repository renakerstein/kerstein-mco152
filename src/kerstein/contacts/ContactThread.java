package kerstein.contacts;

import java.io.IOException;

import javax.swing.JList;

public class ContactThread extends Thread {

	private JList<String> list;
	private GetConnection connection;
	private Contacts[] contacts;

	public ContactThread(JList<String> list) {
		this.list = list;
		this.connection = new GetConnection();
	}

	@Override
	public void run() {
		try {
			contacts = connection.getJSONConnection();
			addData(contacts);
		} catch (IOException e) {

		}

	}

	public Contacts[] getContacts() {
		return contacts;
	}

	public void addData(Contacts[] contacts) {
		String[] contactArray = new String[contacts.length];

		int j = 0;
		for (Contacts c : contacts) {
			String name = c.getName();

			contactArray[j] = name;
			j++;
		}

		list.setListData(contactArray);
	}

}