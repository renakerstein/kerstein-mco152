package kerstein.sixteendayforecast;

public class List {

	private Weather[] weather;
	private Temp temp;
	private Long dt;

	public Long getDate() {
		return dt;
	}

	public Temp getTemp() {
		return temp;
	}

	public Weather[] getWeather() {
		return weather;
	}

}
