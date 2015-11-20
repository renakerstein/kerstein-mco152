package kerstein.pi;

public class PiCalculator {

	public double calculate(Long iterations) {
		double pi = 0;
		double numerator = 4;
		double denominator = 1;

		boolean positive = true;
		for (int i = 0; i < iterations; i++) {
			if (positive) {
				pi += numerator / denominator;
			} else {
				pi -= numerator / denominator;
			}
			denominator += 2;
			positive = !positive;

		}

		return pi;
	}
}
