package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class main {

	public static void main(String[] args) throws IOException {
		String nasaURL = "http://merpublic.s3.amazonaws.com/oss/mera/images/images_sol13.json";

		URL url;
		url = new URL(nasaURL);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// read it in
		InputStream in = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();

		NasaInfo info = gson.fromJson(br, NasaInfo.class);
		br.close();
		Image[] imgs = null;

		for (int j = 0; j < info.getMi_images().length; j++) {
			imgs = info.getMi_images()[j].getImages();
			System.out.println(info.getMission());
		}
		for (int i = 0; i < imgs.length; i++) {
			System.out.println(imgs[i].getUrl());
		}
	}

}
