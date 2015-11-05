package kerstein.anagrams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MostAnagrams {

	public static void main(String[] args) throws IOException {

		// best way to do it-hash map with array that holds each sorted word,
		// and an arraylist that
		// holds the words that have the same sort. then check which array list
		// has the largest size
		// and print that out

		// read dictionary file into hash set
		ArrayList<String> dictionary = new ArrayList<String>();
		try {
			BufferedReader file = new BufferedReader(new FileReader("./US.dic"));

			String line;
			while ((line = file.readLine()) != null) {
				dictionary.add(line);
			}
			file.close();
		} catch (FileNotFoundException ex) {

		}
		// create hash map
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		// add each sorted word as key, and get the arraylist at that point in
		// the hash -
		// to add the word with the same anagram into that arraylist
		for (String s : dictionary) {
			String word = s;
			char[] ch = word.toCharArray();
			Arrays.sort(ch);
			String sortedWord = new String(ch);

			ArrayList<String> anagramList = map.get(sortedWord);

			// if it hasn't been initialized yet:
			if (anagramList == null) {
				anagramList = new ArrayList<String>();
			}

			anagramList.add(word);
			map.put(sortedWord, anagramList);

		}

		// find anagram list with biggest size, and print it out
		int biggestACount = 0;
		ArrayList<String> biggestAnagramList = null;
		for (String s : map.keySet()) {

			// check for the largest size
			if (map.get(s).size() > biggestACount) {
				biggestACount = map.get(s).size();
				biggestAnagramList = new ArrayList<String>();
				biggestAnagramList.add(s);
			}

			else if (map.get(s).size() == biggestACount) {
				biggestAnagramList.add(s);
			}
		}

		for (String word : biggestAnagramList) {
			System.out.println(map.get(word));
		}

	}
}