package railIl;

import java.util.ArrayList;
import java.util.Scanner;

public class Travel {

	private ArrayList<Station> stations;

	public Travel(int numOfTotalStations, Scanner scan) throws Exception {

		this.stations = new ArrayList<Station>();
		for (int i = 0; i < numOfTotalStations; i++) {
			System.out.println("Please enter the name of station " + (i + 1));
			scan.nextLine();
			String station = scan.nextLine();
			System.out.println("What is station's leaving/arrival time?");
			String time = scan.next();
			stations.add(new Station(station, setTime(time)));
			stations.get(i).setStationName(station);

		}

	}

	public Travel(ArrayList<Station> stations) {
		this.stations = stations;
	}

	public Travel() {
		this.stations = new ArrayList<Station>();
	}

	public Travel(String startStation, String endStation, String time) throws Exception {
		this.stations = new ArrayList<Station>();
		stations.add(new Station(startStation, setTime(time)));
		stations.add(new Station(endStation));
	}

	public Clock setTime(String time) throws Exception {
		if (!(time.contains(":")))
			throw new Exception("Hours and minutes must be seperate with :");

		String[] parts = time.split(":");
		Clock c = new Clock(Integer.parseInt(parts[0]), Integer.parseInt(parts[1].replaceAll(",", "")));
		return c;

	}

	public ArrayList<Station> getStations() {
		return stations;
	}

	public int getNumOfStations() {
		return stations.size();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Travel details: ");
		for (int i = 0; i < stations.size() - 1; i++) {
			sb.append(stations.get(i).toString() + ", ");
		}
		sb.append(stations.get(stations.size() - 1).toString());

		return sb.toString();
	}

	public void showTravelDetails() {
		System.out.println(this.toString());
	}

	public void save(StringBuffer sb) {
		sb.append(stations.size() + "\n");
		for (int i = 0; i < stations.size(); i++) {
			stations.get(i).save(sb);
		}
		// sb.append("\n");

	}

	public int locateStartStation(Travel travel) {

		int index = 0;
		for (int i = 0; i < stations.size(); i++) {
			if (stations.get(i).locateStartStation(travel.getStations().get(0)) && i != stations.size() - 1) {
				index = (i + 1);
				return index;
			}

		}
		return index;
	}

	public void addStation(String stationName, String time) throws Exception {
		stations.add(new Station(stationName, setTime(time)));

	}

	public boolean SearchTravel(Travel travel) {
		if (locateStartStation(travel) != 0) {
			int index2 = locateStartStation(travel);
			for (int i = index2; i < stations.size(); i++) {
				if (stations.get(i).locateEndStation(travel.getStations().get(1)))
					return true;

			}
		}
		return false;

	}

	public int checkRelevantIndex(String startStation) {
		for (int i = 1; i < stations.size(); i++) {
			if (stations.get(i).getStationName().equalsIgnoreCase(startStation))
				return i;

		}
		return 0;
	}

	public void removeUnNeededStations(int index) {
		for (int i = 0; i < index; i++) {
			stations.remove(i);

		}
	}
}
