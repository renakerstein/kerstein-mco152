package kerstein.sixteendayforecast;

public class CurrentWeather {

	private List[] list;

	public List[] getList() {
		return list;
	}

	// accesses specific day in the list
	public List getDay(int day) {
		return list[day];
	}

}
