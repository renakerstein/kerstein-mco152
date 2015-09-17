package kerstein.scrabble;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void testContains() {
		ScrabbleDictionary sd = new ScrabbleDictionary();
		Assert.assertEquals(true, sd.contains("aggressors"));
	}

	@Test
	public void testContains2() {
		ScrabbleDictionary sd = new ScrabbleDictionary();
		Assert.assertEquals(false, sd.contains("xxxxx"));
	}

}