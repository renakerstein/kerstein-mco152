package kerstein.nypl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class NyplFrame extends JFrame {

	private JTextField searchField;
	private JButton searchButton;
	private JButton prev;
	private JButton next;
	private JLabel label;
	private JList<String> list;
	private JPanel panelSearch;
	private JPanel panelTitles;
	private NyplThread thread;
	private JScrollPane pane;

	public NyplFrame() {
		setTitle("NYPL Search");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		panelSearch = new JPanel();
		panelSearch.setPreferredSize(new Dimension(1, 100));
		panelSearch.setLayout(new FlowLayout(FlowLayout.CENTER));

		panelTitles = new JPanel();
		panelTitles.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 13));
		this.searchField = new JTextField(60);
		panelSearch.add(searchField);

		this.searchButton = new JButton("Search");
		searchButton.addActionListener(searchListen);
		panelSearch.add(searchButton);

		this.prev = new JButton("Previous");
		prev.addActionListener(prevListen);
		panelSearch.add(prev);

		this.next = new JButton("Next");
		next.addActionListener(nextListen);
		panelSearch.add(next);

		pane = new JScrollPane();
		this.list = new JList<String>();
		list.setVisibleRowCount(30);
		list.setMaximumSize(new Dimension(30, 100));
		list.setFixedCellHeight(50);
		panelTitles.add(list);

		label = new JLabel();

		// pane = new JScrollPane(label);
		add(panelTitles, BorderLayout.WEST);
		add(panelSearch, BorderLayout.NORTH);
		add(label, BorderLayout.CENTER);
		// add(pane);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				list = (JList) evt.getSource();
				if (evt.getClickCount() == 1) {

					int index = list.locationToIndex(evt.getPoint());
					NyplImageThread imgThread = new NyplImageThread(thread
							.getNypl(), index, label);
					imgThread.start();
				}

			}
		});

	}

	ActionListener searchListen = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			thread = new NyplThread(searchField.getText(), list);
			thread.start();
		}
	};

	ActionListener prevListen = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {

		}
	};

	ActionListener nextListen = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {

		}
	};

	public static void main(String[] args) {
		NyplFrame frame = new NyplFrame();
		frame.setVisible(true);
	}
}
