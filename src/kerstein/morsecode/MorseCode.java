package kerstein.morsecode;

import java.util.HashMap;

public class MorseCode {
	HashMap<String, String> map;

	public MorseCode() {
		String[] abc = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
				"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
				"x", "y", "z" };

		String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.",
				"--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
				".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
				"-..-", "-.--", "--.." };

		this.map = new HashMap<String, String>();
		for (int i = 0; i < abc.length; i++) {
			map.put(abc[i], morseCodes[i]);
			map.put(morseCodes[i], abc[i]);
		}
	}

	public String encode(String message) {
		message = message.toLowerCase();
		String[] words = message.split("");
		StringBuilder builder = new StringBuilder();

		for (String w : words) {
			if (map.containsKey(w)) {
				builder.append(map.get(w));
				builder.append(" ");
			} else {
				builder.append("  ");
			}

		}

		return builder.toString().trim(); // trim the extra space at the end
	}

	public String decode(String code) {
		String[] codes = code.split("   ");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < codes.length; i++) {
			String[] eachCode = codes[i].split(" ");
			for (int j = 0; j < eachCode.length; j++) {
				if (map.containsKey(eachCode[j])) {
					builder.append(map.get(eachCode[j]));

				}
			}
			builder.append(" ");
		}
		return builder.toString().trim(); // trim the extra space at the end
	}
}