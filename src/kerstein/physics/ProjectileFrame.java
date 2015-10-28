package kerstein.physics;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class ProjectileFrame extends JFrame {

	public static void main(String[] args) {
		new ProjectileFrame().setVisible(true);
	}

	public ProjectileFrame() {
		setTitle("Projectile Graph");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();

		container.setLayout(layout);
		container.add(new ProjectileComponent(), BorderLayout.CENTER);
	}
}
