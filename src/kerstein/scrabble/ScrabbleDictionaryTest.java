package kerstein.scrabble;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void testContains() throws IOException {
		ScrabbleDictionary sd = new ScrabbleDictionary();
		Assert.assertTrue(sd
				.contains("pneumonoultramicroscopicsilicovolcanoconiosis"));
	}

	@Test
	public void testContains2() throws IOException {
		ScrabbleDictionary sd = new ScrabbleDictionary();
		Assert.assertFalse(sd.contains("xxxxx"));
	}

	@Test
	public void testContains3() throws IOException {
		ScrabbleDictionary sd = new ScrabbleDictionary();
		Assert.assertTrue(sd.contains("DISINTEGRATIONS"));
	}

}
