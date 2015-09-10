package kerstein.physics;

public class ProjectileMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double angle = Math.toRadians(31);
		double velocity = 20.0; // meters/second
		double seconds = 2.7;

		Projectile aProjectile = new Projectile(angle, velocity, seconds);
		for (int i=1; i<10; i++){
			aProjectile.setSeconds(i);
		System.out.println("ANSWER X " + aProjectile.getAnswerX());
		System.out.println("ANSWER Y " + aProjectile.getAnswerY());
		
	}
}
}