package kerstein.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ScrabbleDictionary {
	HashSet<String> dictionary;

	public ScrabbleDictionary() {
		dictionary = new HashSet<String>();
		try {
			Scanner file = new Scanner(new File("US.dic"));

			while (file.hasNext()) {
				dictionary.add(file.nextLine());
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