package Zcode;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NasaFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	/*
	 * private final Container southCont; private final Container contFind;*
	 */
	private JPanel panel;
	private final JTextField findText;
	private final JButton findButton;
	private JLabel displayImage;
	// private final Container cont;
	private final JButton prev;
	private JLabel numPicDisplay;
	private final JButton next;
	private int picNum;
	private List<URL> urlList;

	public NasaFrame() throws IOException {
		setTitle("Opportunity Rover on Mars Images");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(550, 400);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		displayImage = new JLabel();
		add(displayImage, BorderLayout.CENTER);

		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 3));
		/*
		 * cont = new Container(); cont.setLayout(new
		 * FlowLayout(FlowLayout.LEFT, 10, 0));*
		 */
		prev = new JButton(" < ");
		prev.addActionListener(prevListen);
		prev.setEnabled(false);
		panel.add(prev);
		numPicDisplay = new JLabel();
		panel.add(numPicDisplay);
		next = new JButton(" > ");
		next.addActionListener(nextListen);
		next.setEnabled(false);
		panel.add(next);
		// panel.add(cont);

		/*
		 * contFind = new Container(); contFind.setLayout(new GridLayout(1,
		 * 2));*
		 */
		findButton = new JButton("FIND");
		findButton.addActionListener(findListen);
		findButton.setEnabled(false);
		panel.add(findButton);
		findText = new JTextField(8);
		findText.setMaximumSize(new Dimension(10, 40));
		findText.setEnabled(false);
		panel.add(findText);

		add(panel, BorderLayout.SOUTH);

		urlList = new ArrayList<URL>();
		picNum = 0;
		NasaInfoDownloadThread thread = new NasaInfoDownloadThread(urlList,
				this, findText, prev, next, findButton);
		thread.start();

		setVisible(true);
	}

	ActionListener prevListen = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (picNum == 0) {
				picNum = urlList.size() - 1;
			} else {
				picNum--;
			}
			changeImg();
		}
	};

	ActionListener nextListen = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (picNum == urlList.size() - 1) {
				picNum = 0;
			} else {
				picNum++;
			}
			changeImg();
		}
	};

	ActionListener findListen = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			String text = findText.getText().trim();
			int num = Integer.valueOf(text) - 1;
			if (num < 0 || num > urlList.size() - 1) {
				findText.setText("invalid #");
			} else {
				picNum = num;
				findText.setText("");
				changeImg();
			}
		}
	};

	public void changeImg() {
		ImgDownloadThread imgThread = new ImgDownloadThread(
				urlList.get(picNum), displayImage);
		imgThread.start();
		setNumPicDisplay();
	}

	public void setNumPicDisplay() {
		numPicDisplay.setText(picNum + 1 + " of " + urlList.size());
	}

	public static void main(String[] args) {
		try {
			new NasaFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}