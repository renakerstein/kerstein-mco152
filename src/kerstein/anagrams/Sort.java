package kerstein.anagrams;

import java.util.Arrays;

public class Sort {

	public Sort() {

	}

	public String sortDictionary(String word) {
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		String newWord = new String(chars);
		return newWord;
	}
}
