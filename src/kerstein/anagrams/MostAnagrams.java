package kerstein.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostAnagrams {

	public static void main(String[] args) {

		// read dictionary file into hash set
		ArrayList<String> dictionary = new ArrayList<String>();
		try {
			Scanner file = new Scanner(new File("US.dic"));

			while (file.hasNext()) {
				dictionary.add(file.nextLine());
			}
			file.close();
		} catch (FileNotFoundException ex) {

		}
		// sort each word in the dictionary
		ArrayList<String> sortedDictionary = new ArrayList<String>();
		Sort s = new Sort();
		for (String w : dictionary) {
			String newWord = s.sortDictionary(w);
			sortedDictionary.add(newWord);
		}

		Collections.sort(sortedDictionary);

		// add the sorted words to a hash map
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (String word : sortedDictionary) {
			Integer value = map.get(word);
			if (value == null) {
				map.put(word, 1);

			} else {
				map.put(word, value + 1);

			}
		}

		// find the group with the largest value
		int largestValue = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			if (entry.getValue() > largestValue) {
				largestValue = entry.getValue();
			}

		}

		// access the words that are part of the largest anagram group
		for (int i = 0; i < dictionary.size(); i++) {
			char[] chars = dictionary.get(i).toCharArray();
			Arrays.sort(chars);
			String sortedWord = new String(chars);
			Integer value = map.get(sortedWord);

			if (value == largestValue) {
				System.out.println(dictionary.get(i));

			}

		}
	}

}