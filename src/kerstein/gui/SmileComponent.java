package kerstein.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.YELLOW);
		g.fillOval(150, 20, 500, 500);
		g.setColor(Color.BLACK);
		g.fillOval(280, 110, 80, 80);
		g.fillOval(450, 110, 80, 80);
		g.fillArc(275, 250, 250, 180, 180, 180);
	}
}
