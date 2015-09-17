package kerstein.morsecode;

import java.util.ArrayList;

public class MorseCode {
	String[] abc = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
			"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
			"y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };

	String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
			"....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
			"--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
			"--..", ".-----", "..---", "...--", "....-", ".....", "-....",
			"--...", "---..", "----.", "-----" };

	public MorseCode() {

	}

	public String encode(String message) {
		String[] words = message.split(" ");
		String encodedMessage = "";
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				char letter = words[i].charAt(j);
				for (int k = 0; k < abc.length; k++) {
					if (abc[k].equalsIgnoreCase(Character.toString(letter))) {
						encodedMessage += morseCodes[k] + " ";
						break;
					}
				}
			}

			// add in a space between each word
			encodedMessage += " " + " ";
		}
		return encodedMessage.trim(); // trim the extra space at the end
	}

	public String decode(String code) {
		String[] codes = code.split("   ");
		String decodedMessage = "";
		for (int i = 0; i < codes.length; i++) {
			String[] eachCode = codes[i].split(" ");
			for (int j = 0; j < eachCode.length; j++) {
				for (int k = 0; k < morseCodes.length; k++) {
					if (morseCodes[k].equals(eachCode[j])) {
						decodedMessage += abc[k];
						break;
					}
				}
			}

			// add in a space between each word/code
			decodedMessage += " ";
		}
		return decodedMessage.trim(); // trim the extra space at the end
	}
}