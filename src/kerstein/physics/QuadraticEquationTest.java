package kerstein.physics;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testGetPositiveX() throws InvalidDataException {
		QuadraticEquation equation = new QuadraticEquation(6.0, 11.0, -35.0);
		Assert.assertEquals(1.67, equation.getPositiveX(), 0.1);
	}

	@Test
	public void testGetNegativeX() throws InvalidDataException {
		QuadraticEquation equation = new QuadraticEquation(6.0, 11.0, -35.0);
		Assert.assertEquals(-3.5, equation.getNegativeX(), 0.1);
	}

	@Test
	public void testThrowsInvalidDataException() throws InvalidDataException {
		try {
			new QuadraticEquation(0, 0, 0);
			Assert.fail("Exception has not been thrown");
		} catch (InvalidDataException e) {

		}
	}
}
