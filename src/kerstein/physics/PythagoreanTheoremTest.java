package kerstein.physics;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTheoremTest {

	@Test
	public void testSetAB() throws InvalidDataException {
		PythagoreanTheorem theorem = new PythagoreanTheorem();
		theorem.setAB(9.0, 16.0);
		Assert.assertEquals(18.35, theorem.getC(), 0.1);
	}

	@Test
	public void testSetAC() throws InvalidDataException {
		PythagoreanTheorem theorem = new PythagoreanTheorem();
		theorem.setAC(9.0, 22.0);
		Assert.assertEquals(20.07, theorem.getB(), 0.1);
	}

	@Test
	public void testSetBC() throws InvalidDataException {
		PythagoreanTheorem theorem = new PythagoreanTheorem();
		theorem.setBC(16.0, 22.0);
		Assert.assertEquals(15.09, theorem.getA(), 0.1);
	}
}
