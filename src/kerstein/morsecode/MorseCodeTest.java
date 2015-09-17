package kerstein.morsecode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testEncode() {
		MorseCode mc = new MorseCode();
		Assert.assertEquals(".... . .-.. .-.. ---   .-. . -. .-",
				mc.encode("HELLO RENA"));
	}

	@Test
	public void testDecode() {
		MorseCode mc = new MorseCode();
		Assert.assertEquals("hello rena",
				mc.decode(".... . .-.. .-.. ---   .-. . -. .-"));
	}
}
