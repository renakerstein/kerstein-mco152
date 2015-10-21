package kerstein.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class TopTenUfoLocations {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(
				"./ufo_awesome.json"));
		// construct GSON class
		Gson gson = new Gson();

		UFOSightingList list = gson.fromJson(in, UFOSightingList.class);
		in.close();

		// put all the locations from the UFO list into a hash map
		// with its value being the number of times its sighted
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (UFOSighting l : list) {
			Integer value = map.get(l.getLocation());
			if (value == null) {
				map.put(l.getLocation(), 1);

			} else {
				map.put(l.getLocation(), value + 1);
			}
		}

		// initialize variables
		int largestValue = 0;
		String location = null;

		// loop through the map while i<10 so the top ten locations can be
		// accessed
		for (int i = 0; i < 10; i++) {
			largestValue = 0; // reset the largest value to 0 (so the next
			// largest value can be accessed)
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue() > largestValue) {
					largestValue = entry.getValue(); // get the largest value
					location = entry.getKey(); // get the key of that value -
					// the location

				}
			}
			System.out.println(location + " - " + largestValue + " sightings");
			// remove the largest value found and its key from the map
			// so the next greatest value can now be accessed from the map
			map.remove(largestValue);
			map.remove(location);
		}
	}
}
