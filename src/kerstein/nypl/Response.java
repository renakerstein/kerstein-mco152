package kerstein.nypl;

public class Response {

	private String numResults;
	private Result[] result;

	private Capture[] capture;

	public String getNumResults() {
		return numResults;
	}

	public Result[] getResults() {
		return result;
	}

	public Capture[] getCapture() {
		return capture;
	}
}
