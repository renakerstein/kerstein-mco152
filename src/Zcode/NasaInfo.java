package Zcode;

public class NasaInfo {
	private Images[] mi_images;
	private Images[] pcam_images;
	private Images[] ncam_images;
	private Images[] fcam_images;
	private Images[] rcam_images;

	public Images[] getNcam_images() {
		return ncam_images;
	}

	public Images[] getFcam_images() {
		return fcam_images;
	}

	public Images[] getRcam_images() {
		return rcam_images;
	}

	public Images[] getMi_images() {
		return mi_images;
	}

	public Images[] getPcam_images() {
		return pcam_images;
	}
}