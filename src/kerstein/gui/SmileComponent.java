package kerstein.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	private int x = 110;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// eyes
		g.setColor(Color.YELLOW);
		g.fillOval(150, 20, 500, 500);

		g.setColor(Color.BLACK);
		g.fillOval(450, 100, 80, 80);
		g.fillOval(275, 100, 80, 80);
		g.setColor(Color.BLUE);
		g.fillOval(450, x, 40, 40);
		g.fillOval(275, x, 40, 40);

		x++;

		if (x == 200) {
			x = 110;
		}

		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		super.repaint();

		// mouth
		g.setColor(Color.BLACK);
		g.fillArc(275, 250, 250, 180, 180, 180);

	}
}
