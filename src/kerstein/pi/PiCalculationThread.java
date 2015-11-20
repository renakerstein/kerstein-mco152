package kerstein.pi;

import javax.swing.JLabel;

public class PiCalculationThread extends Thread {

	private JLabel label;

	public PiCalculationThread(JLabel label) {
		this.label = label;
	}

	@Override
	public void run() {
		PiCalculator calc = new PiCalculator();
		double sum = calc.calculate(1000000000L);
		label.setText(String.valueOf(sum));
	}
}
