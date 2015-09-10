package kerstein.homework1;

import kerstein.homework2.InvalidDataException;

public class QuadraticEquation {
	private double a;
	private double b;
	private double c;

	public QuadraticEquation(double a, double b, double c)
			throws InvalidDataException {
		if (a == 0 || b == 0)
			throw new InvalidDataException();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getPositiveX() {
		double positiveX = (-b + (Math.sqrt((b * b) - 4 * a * c))) / (2 * a);
		return positiveX;
	}

	public double getNegativeX() {
		double negativeX = (-b - (Math.sqrt((b * b) - 4 * a * c))) / (2 * a);
		return negativeX;
	}

}