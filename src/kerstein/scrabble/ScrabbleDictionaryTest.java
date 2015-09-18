package kerstein.scrabble;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void testContains() {
		ScrabbleDictionary sd = new ScrabbleDictionary();
		Assert.assertTrue(sd.contains("aggressors"));
	}

	@Test
	public void testContains2() {
		ScrabbleDictionary sd = new ScrabbleDictionary();
		Assert.assertFalse(sd.contains("xxxxx"));
	}

	@Test
	public void testContains3() {
		ScrabbleDictionary sd = new ScrabbleDictionary();
		Assert.assertTrue(sd.contains("AGGRESSORS"));
	}
}