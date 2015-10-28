package kerstein.physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class ProjectileComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; // cast graphics so the drawLine() can
		// accept doubles as parameters
		Projectile p = new Projectile(31.0, 20.0, 0.0);

		// initialize variables to origin
		double x1 = p.getAnswerX();
		double y1 = getHeight() - p.getAnswerY();
		for (double i = 0.0; i < 20; i += .1) {
			p.setSeconds(i);
			double x2 = p.getAnswerX();
			double y2 = getHeight() - p.getAnswerY();
			g2.draw(new Line2D.Double(x1, y1, x2, y2));

			x1 = x2;
			y1 = y2;
		}

	}
}
