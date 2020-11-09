package railIl;

public class Station {

	private String stationName;
	private Clock leavingTime;

	public Station(String stationName, Clock leavingTime) {
		setStationName(stationName);
		setLeavingTime(leavingTime);

	}

	public Station(String stationName) {
		setStationName(stationName);
	}

	public Clock getLeavingTime() {
		return leavingTime;
	}

	public void setLeavingTime(Clock leavingTime) {
		this.leavingTime = leavingTime;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	@Override
	public String toString() {
		return stationName + ", " + leavingTime.toSring();
	}

	public void save(StringBuffer sb) {
		sb.append(stationName + ",\n" + leavingTime.toSring() + ",\n");

	}

	private boolean isTheSameName(Station station) {
		if (stationName.equalsIgnoreCase(station.getStationName()))
			return true;

		return false;
	}

	public boolean locateStartStation(Station startStation) {
		if (isTheSameName(startStation) && leavingTime.compareTime(startStation.getLeavingTime()))
			return true;

		return false;

	}

	public boolean locateEndStation(Station endStation) {
		if (isTheSameName(endStation))
			return true;

		return false;
	}
	
}
