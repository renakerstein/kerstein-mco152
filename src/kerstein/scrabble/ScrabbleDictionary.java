package kerstein.scrabble;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ScrabbleDictionary {
	HashSet<String> dictionary;

	public ScrabbleDictionary() throws IOException {
		dictionary = new HashSet<String>();
		try {
			BufferedReader file = new BufferedReader(new FileReader("./US.dic"));

			String line;
			while ((line = file.readLine()) != null) {
				dictionary.add(line);
			}
			file.close();
		} catch (FileNotFoundException ex) {

		}
	}

	/**
	 * @return true if the dictionary contains the word, otherwise false.
	 */
	public boolean contains(String word) {

		return dictionary.contains(word.toLowerCase());

	}
}