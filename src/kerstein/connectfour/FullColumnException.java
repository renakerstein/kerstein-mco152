package kerstein.connectfour;

public class FullColumnException extends RuntimeException {
	public FullColumnException() {
		super("Column is full");
	}
}
