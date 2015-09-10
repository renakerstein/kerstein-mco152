package kerstein.physics;

public class Projectile {

	private double angle;
	private double velocity;
	private double seconds;
	private double radians;

	public Projectile(double angle, double velocity, double seconds) {
		this.angle = angle;
		this.velocity = velocity;
		this.seconds = seconds;
		this.radians = Math.toRadians(angle);
	}

	public Double getAnswerX() {
		return Math.sin(radians) * velocity * seconds;

	}

	public Double getAnswerY() {
		return (Math.cos(radians) * velocity * seconds - (.5 * 9.8 * Math.pow(seconds, 2)));
	}

	public void setSeconds(double seconds) {
		this.seconds = seconds;
	}
}
