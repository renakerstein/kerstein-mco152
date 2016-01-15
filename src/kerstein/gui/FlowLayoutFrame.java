package kerstein.gui;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlowLayoutFrame extends JFrame {

	public FlowLayoutFrame() {
		setTitle("Flow Layout");
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new FlowLayout(FlowLayout.TRAILING, 50, 3));

		JLabel label1 = new JLabel("Rena");
		JLabel label2 = new JLabel("Aviva");
		JLabel label3 = new JLabel("Ayelet");
		JLabel label4 = new JLabel("Rena");
		JLabel label5 = new JLabel("Aviva");
		JLabel label6 = new JLabel("Ayelet");

		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);

	}

	public static void main(String[] args) {
		FlowLayoutFrame fl = new FlowLayoutFrame();
		fl.setVisible(true);
	}

}
