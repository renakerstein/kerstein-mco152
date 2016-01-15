package Zcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.google.gson.Gson;

public class NasaInfoDownloadThread extends Thread {
	private List<URL> urlList;
	private NasaFrame frame;
	private JTextField findText;
	private JButton prev;
	private JButton next;
	private JButton findButton;

	public NasaInfoDownloadThread(List<URL> urlList, NasaFrame frame,
			JTextField findText, JButton prev, JButton next, JButton findButton) {
		this.urlList = urlList;
		this.frame = frame;
		this.findText = findText;
		this.prev = prev;
		this.next = next;
		this.findButton = findButton;
	}

	@Override
	public void run() {
		try {
			URL url = new URL(
					"http://merpublic.s3.amazonaws.com/oss/mera/images/images_sol13.json");
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			Gson gson = new Gson();
			NasaInfo info = gson.fromJson(br, NasaInfo.class);

			addImages(info.getPcam_images());
			addImages(info.getMi_images());
			addImages(info.getRcam_images());
			addImages(info.getFcam_images());
			addImages(info.getNcam_images());

			frame.changeImg();

			findText.setEnabled(true);
			prev.setEnabled(true);
			next.setEnabled(true);
			findButton.setEnabled(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addImages(Images[] theseimgs) {
		for (int i = 0; i < theseimgs.length; i++) {
			DisplayImage[] images = theseimgs[i].getImages();
			for (int j = 0; j < images.length; j++) {
				urlList.add(images[j].getUrl());
			}
		}
	}

}
